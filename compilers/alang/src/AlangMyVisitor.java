import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.stringtemplate.v4.*;
import java.io.*;
import java.util.*;

public class AlangMyVisitor extends AlangBaseVisitor<CodeFragment> {
    private Map<String, Variable> globals = new HashMap<String, Variable>();
    private Map<String, Function> functions = new HashMap<String, Function>();
    private Map<Function, Map<String, Variable>> vars = new HashMap<Function, Map<String, Variable>>();

    private Function scope = null;

    private String labelLoopCmp = null;
    private String labelLoopEnd = null;

    private STGroup group = new STGroupDir("./templates");

    public String errors = "";
    public int errorCount = 0;

    private int labelIndex = 0;
    private int registerIndex = 0;

    private String getCharPosition(ParserRuleContext ctx) {
        return String.format("%d:%d", ctx.getStart().getLine(),
                                      ctx.getStart().getCharPositionInLine());
    }

    private void addError(ParserRuleContext ctx, String symbol, String message) {
        symbol = symbol.replaceAll("\n", " ");
        this.errors += "Error on line " + this.getCharPosition(ctx)
                    + " at '" + symbol.trim() + "': " + message + "\n";
        this.errorCount++;
    }

    private void addError(String message) {
        this.errors += "Error: " + message + "\n";
        this.errorCount++;
    }

    private String generateNewRegister(boolean global) {
        if (global)
            return String.format("@reg%d", this.registerIndex++);
        return String.format("%%reg%d", this.registerIndex++);
    }

    private String generateNewLabel() {
        return String.format("L%d", this.labelIndex++);
    }

    private CodeFragment generateNewDeclaration(String reg, String type) {
        ST template = this.group.getInstanceOf("localdeclare");
        template.add("reg", reg);
        template.add("type", type);
        return new CodeFragment(template.render() + "\n");
    }

    private String generateGlobalVariables() {
        String result = "";
        for (Map.Entry g : this.globals.entrySet()) {
            Variable v = (Variable) g.getValue();
            result += v.getGlobalDeclaration(this.group.getInstanceOf("globaldeclare")) + "\n";
        }
        return result;
    }

    private boolean checkArityAssignment(Variable v, int arity) {
        if (v.arity != arity)
            return false;
        return true;
    }

    private boolean variableExists(String name) {
        if (this.globals.containsKey(name))
            return true;
        if (this.scope != null && this.vars.get(this.scope).containsKey(name))
            return true;
        return false;
    }

    private boolean functionExists(String name) {
        if (this.functions.containsKey(name))
            return true;
        return false;
    }

    private Variable getVariable(String name) {
        if (this.globals.containsKey(name))
            return this.globals.get(name);
        return this.vars.get(this.scope).get(name);
    }

    private Function getFunction(String name) {
        return this.functions.get(name);
    }

    private CodeFragment callFunc(List<AlangParser.ExpressionContext> expressions, Function f) {
        CodeFragment result = new CodeFragment();

        ST template;
        if (f.returntype == Types.LLVMVOID) {
            template = this.group.getInstanceOf("voidfunccall");
        } else {
            template = this.group.getInstanceOf("funccall");
            result.setRegister(this.generateNewRegister(false));
            template.add("reg", result.getRegister());
            template.add("type", f.returntype);
        }

        template.add("name", f.name);

        for (int i = 0; i < expressions.size(); i++) {
            CodeFragment expr = visit(expressions.get(i));
            result.addCode(expr);
            if (i == 0)
                template.add("args", f.args.get(i) + " " + expr.getRegister());
            else
                template.add("args", ", " + f.args.get(i) + " " + expr.getRegister());
        }

        result.addCode(template.render() + "\n");
        return result;
    }

    @Override
    public CodeFragment visitStatements(AlangParser.StatementsContext ctx) {
        /* add library functions */
        Function f1 = new Function("citajcislo", Types.LLVMCISLO);
        Function f2 = new Function("vypiscislo", Types.LLVMVOID);
        f2.addArgumentLLVMType(Types.LLVMCISLO);
        Function f3 = new Function("vypiscisloln", Types.LLVMVOID);
        f3.addArgumentLLVMType(Types.LLVMCISLO);
        Function f4 = new Function("citajznak", Types.LLVMZNAK);

        this.functions.put("citajcislo", f1);
        this.functions.put("vypiscislo", f2);
        this.functions.put("vypiscisloln", f3);
        this.functions.put("citajznak", f4);

        ST template = this.group.getInstanceOf("statements");

        int n = ctx.statement().size();
        for (int i = 0; i < n; i++) {
            CodeFragment statCodeFragment = visit(ctx.statement(i));
            String code = statCodeFragment.toString();
            if (!code.equals(""))
                template.add("code", code);
        }
        template.add("globals", this.generateGlobalVariables());

        /* MAIN function errors */
        if (!this.functions.containsKey("MAIN")) {
            this.addError("MAIN function not found");
            return new CodeFragment("");
        } else if (this.functions.get("MAIN").args.size() != 0) {
            this.addError("MAIN function takes no arguments");
            return new CodeFragment("");
        }

        return new CodeFragment(template.render());
    }

    @Override
    public CodeFragment visitFuncStat(AlangParser.FuncStatContext ctx) {
        ST template = this.group.getInstanceOf("function");
        String fname = ctx.ID().getText();
        if (fname.equals("MAIN")) {
            template.add("name", "main");
        } else {
            template.add("name", fname);
        }

        if (this.functions.containsKey(fname)) {
            this.addError(ctx, fname, "Function already defined");
            return new CodeFragment("");
        }

        String returntype = Types.getLLVMReturntype(ctx.return_type().getText());
        template.add("returntype", returntype);

        Function f = new Function(fname, returntype);

        this.functions.put(fname, f);

        this.scope = f;
        this.vars.put(f, new HashMap<String, Variable>());

        try {
            /* visit all indices and store the result */
            for (int i = 0; i < ctx.arguments().ID().size(); i++) {
                AlangParser.ArgumentsContext argctx = ctx.arguments();
                String id = argctx.ID(i).getText();
                String llvmtype = Types.getLLVMDefineVartype(argctx.argtype(i).getText().replaceAll("\\[\\]", ""));
                String argtype = Types.getLLVMArgtype(argctx.argtype(i).getText());

                Variable v = new Variable(this.generateNewRegister(false), argctx.argtype(i).getText(), llvmtype);

                v.setHasValue();
                v.setArity(argctx.argtype(i).LSQUARE().size());

                this.vars.get(f).put(id, v);

                f.addArgumentLLVMType(argtype);

                if (i > 0)
                    template.add("args", ", ");

                template.add("args", argtype + " %" + id);

                ST alloca = this.group.getInstanceOf("localdeclare");
                alloca.add("reg", v.reg);
                alloca.add("type", argtype);
                template.add("allocaargs", alloca.render() + "\n");

                ST store = this.group.getInstanceOf("store");
                store.add("type", argtype);
                store.add("reg", "%" + id);
                store.add("where", v.reg);
                template.add("storeargs", store.render() + "\n");
            }
        } catch (Exception e) {}

        for (int i = 0; i < ctx.block().size(); i++) {
            CodeFragment blockcode = visit(ctx.block(i));
            template.add("code", blockcode);
        }

        if (ctx.return_type().getText().equals(Types.VOID)) {
            template.add("returndefault", "ret void");
        } else {
            template.add("returndefault", String.format("ret %s 0", f.returntype));
        }

        this.scope = null;

        return new CodeFragment(template.render() + "\n");
    }

    @Override
    public CodeFragment visitVarDecStat(AlangParser.VarDecStatContext ctx) {
        /* this is global variable */
        String name = ctx.ID().getText();
        if (this.variableExists(name)) {
            this.addError(ctx, name, "Variable already declared");
            return new CodeFragment("");
        }

        String alangvartype = ctx.var_type().getText();
        String llvmvartype = Types.getLLVMDefineVartype(alangvartype);

        String reg = this.generateNewRegister(true);
        Variable v = new Variable(reg, alangvartype, llvmvartype);

        int arity = ctx.index_to_global_array().size();
        v.setArity(arity);
        if (arity > 0) {
            v.setGlobalArray();
        }

        for (int i = 0; i < arity; i++) {
            v.addLevel(Integer.valueOf(ctx.index_to_global_array(i).INT().getText()));
        }

        this.globals.put(name, v);

        return new CodeFragment("");
    }

    @Override
    public CodeFragment visitAssignmentStat(AlangParser.AssignmentStatContext ctx) {
        /* assignment to global variable */
        String name = ctx.ID().getText();
        if (!variableExists(name)) {
            this.addError(ctx, name, "Assignment to undeclared variable");
            return new CodeFragment("");
        }

        Variable v = this.globals.get(name);
        v.setValue(ctx.global_expression().getText());
        v.setHasValue();

        return new CodeFragment("");
    }


    @Override
    public CodeFragment visitBlockVarDec(AlangParser.BlockVarDecContext ctx) {
        String name = ctx.ID().getText();

        if (this.variableExists(name)) {
            this.addError(ctx, name, "Variable already declared");
            return new CodeFragment("");
        }

        int arity = ctx.index_to_array().size();

        String alangvartype = ctx.var_type().getText();
        String llvmvartype = Types.getLLVMDefineVartype(alangvartype);
        String reg = this.generateNewRegister(false);

        Variable v = new Variable(reg, alangvartype, llvmvartype);
        v.setArity(arity);
        this.vars.get(this.scope).put(name, v);

        CodeFragment result = new CodeFragment();
        result.setRegister(reg);

        if (arity > 0) {
            /* alloca n-dimensional array */
            v.setLocalArray();
            String prevreg = this.generateNewRegister(false);
            String newreg;
            result.addCode(String.format("%s = add i32 0, 1\n", prevreg));
            for (int i = 0; i < arity; i++) {
                CodeFragment exp = visit(ctx.index_to_array(i).expression());
                result.addCode(exp);

                newreg = this.generateNewRegister(false);
                result.addCode(String.format("%s = mul i32 %s, %s\n", newreg, prevreg, exp.getRegister()));
                prevreg = newreg;
            }
            result.addCode(String.format("%s = alloca %s, i32 %s\n", reg, llvmvartype, prevreg));
            return result;
        }

        return this.generateNewDeclaration(reg, v.getLLVMDeclareType());
    }

    /* finds pointer to the element at position array[a][b]... */
    private CodeFragment getPointerToArray(Variable v, ArrayList<String> registers) {
        CodeFragment result = new CodeFragment();
        String prevLoadRegister = v.reg;
        if (v.isGlobalArray) {
            /* assignment to global array */
            for (int i = 0; i < registers.size(); i++) {
                ST template = this.group.getInstanceOf("indextoglobalarray");
                String ptrRegister = this.generateNewRegister(false);

                template.add("ptrregister", ptrRegister);
                template.add("type", v.getLLVMDeclareGlobalFromIndex(i));
                template.add("loadregister", prevLoadRegister);
                template.add("exprreg", registers.get(i));

                result.addCode(template.render() + "\n");
                prevLoadRegister = ptrRegister;
            }
        } /*else {
            String prevreg = "1";
            for (int muls = 0; muls < registers.size(); muls++) {
                String reg = this.generateNewRegister(false);
                result.addCode(String.format("%s = mul i32 %s, %s\n", reg, prevreg, registers.get(muls)));
                prevreg = reg;
            }

            if (!v.isLocalArray) {
                prevLoadRegister = this.generateNewRegister(false);
                result.addCode(String.format("%s = load %s*, %s** %s\n", prevLoadRegister, v.llvmtype, v.llvmtype, v.reg));
            }

            String ptrRegister = this.generateNewRegister(false);

            ST template = this.group.getInstanceOf("indextolocalarray");
            template.add("ptrregister", ptrRegister);
            template.add("type", v.llvmtype);
            template.add("loadregister", prevLoadRegister);
            template.add("exprreg", prevreg);

            result.addCode(template.render() + "\n");

            prevLoadRegister = ptrRegister;
        }*/

        //else if (!v.isLocalArray) {
            /* array coming as argument to function */
            /*for (int i = 0; i < registers.size(); i++) {
                String loadRegister = this.generateNewRegister(false);
                String ptrRegister = this.generateNewRegister(false);

                String loadPointers = Types.pointers(registers.size() - i);
                String ptrPointers = Types.pointers(registers.size() - (i + 1));

                ST template = this.group.getInstanceOf("indextoarray");
                template.add("loadregister", loadRegister);
                template.add("type", v.llvmtype);
                template.add("loadpointers", loadPointers);
                template.add("prevloadregister", prevLoadRegister);
                template.add("ptrregister", ptrRegister);
                template.add("ptrpointers", ptrPointers);
                template.add("exprreg", registers.get(i));

                result.addCode(template.render() + "\n");

                prevLoadRegister = ptrRegister;
            }
        }*/ else {
            /* array defined in this function */
            for (int i = 0; i < registers.size(); i++) {
                String prevreg = "1";
                for (int muls = i; muls < registers.size(); muls++) {
                    String reg = this.generateNewRegister(false);
                    result.addCode(String.format("%s = mul i32 %s, %s\n", reg, prevreg, registers.get(muls)));
                    prevreg = reg;
                }

                String ptrRegister = this.generateNewRegister(false);

                ST template = this.group.getInstanceOf("indextolocalarray");
                template.add("ptrregister", ptrRegister);
                template.add("type", v.llvmtype);
                template.add("loadregister", prevLoadRegister);
                template.add("exprreg", prevreg);

                result.addCode(template.render() + "\n");

                prevLoadRegister = ptrRegister;
            }
        }
        result.setRegister(prevLoadRegister);
        return result;
    }

	@Override
    public CodeFragment visitBlockAsgn(AlangParser.BlockAsgnContext ctx) {
        String name = ctx.ID().getText();
        if (!variableExists(name)) {
            this.addError(ctx, name, "Assignment to undeclared variable");
            return new CodeFragment("");
        }

        CodeFragment result = new CodeFragment();
        CodeFragment expr = visit(ctx.expression());

        result.addCode(expr);

        Variable v = this.getVariable(name);
        v.setHasValue();

        int arity = ctx.index_to_array().size();
        if (arity == 0) {
            result.addCode(String.format("store %s %s, %s* %s\n", v.llvmtype, expr.getRegister(), v.llvmtype, v.reg));
        } else {
            if (!checkArityAssignment(v, arity)) {
                this.addError(ctx, name, "Bad assignment to array");
                return new CodeFragment("");
            }

            int pointers = ctx.index_to_array().size();
            ArrayList<String> registers = new ArrayList<String>();
            for (int i = 0; i < arity; i++) {
                CodeFragment index = visit(ctx.index_to_array(i).expression());
                result.addCode(index);
                registers.add(index.getRegister());
            }

            CodeFragment ptr = this.getPointerToArray(v, registers);
            result.addCode(ptr);

            ST store = this.group.getInstanceOf("store");
            store.add("type", v.llvmtype);
            store.add("reg", expr.getRegister());
            store.add("where", ptr.getRegister());
            result.addCode(store.render() + "\n");
        }

        return result;
    }

    @Override
    public CodeFragment visitBlockIf(AlangParser.BlockIfContext ctx) {
        CodeFragment expr = visit(ctx.expression());
        CodeFragment result = new CodeFragment();
        result.addCode(expr);

        ST template = this.group.getInstanceOf("ifblock");
        template.add("cmpreg", this.generateNewRegister(false));
        template.add("condreg", expr.getRegister());
        template.add("labeltrue", this.generateNewLabel());
        template.add("labelfalse", this.generateNewLabel());
        template.add("labelend", this.generateNewLabel());
        result.setRegister(this.generateNewRegister(false));
        template.add("reg", result.getRegister());

        for (int i = 0; i < ctx.block().size(); i++) {
            CodeFragment truecode = visit(ctx.block(i));
            template.add("truecode", truecode.toString());
        }

        for (int i = 0; i < ctx.else_block().size(); i++) {
            CodeFragment falsecode = visit(ctx.else_block(i).block());
            template.add("falsecode", falsecode.toString());
        }

        result.addCode(template.render() + "\n");

        return result;
    }

	@Override
    public CodeFragment visitBlockLoop(AlangParser.BlockLoopContext ctx) {
        CodeFragment expr = visit(ctx.expression());
        CodeFragment result = new CodeFragment();

        ST template = this.group.getInstanceOf("whileloop");
        String labelcmp = this.generateNewLabel();
        String labeltrue = this.generateNewLabel();
        String labelend = this.generateNewLabel();

        template.add("labelcmp", labelcmp);
        template.add("exprcode", expr.toString());
        template.add("cmpreg", this.generateNewRegister(false));
        template.add("exprreg", expr.getRegister());
        template.add("labeltrue", labeltrue);
        template.add("labelend", labelend);

        for (int i = 0; i < ctx.block().size(); i++) {
            this.labelLoopCmp = labelcmp;
            this.labelLoopEnd = labelend;
            CodeFragment truecode = visit(ctx.block(i));
            template.add("truecode", truecode.toString());
        }

        this.labelLoopCmp = null;
        this.labelLoopEnd = null;

        result.setRegister(this.generateNewRegister(false));
        template.add("reg", result.getRegister());
        result.addCode(template.render() + "\n");

        return result;
    }

    @Override
    public CodeFragment visitBlockBreak(AlangParser.BlockBreakContext ctx) {
        CodeFragment result = new CodeFragment();
        result.addCode(String.format("br label %%%s\n", this.labelLoopEnd));
        return result;
    }

	@Override
    public CodeFragment visitBlockContinue(AlangParser.BlockContinueContext ctx) {
        CodeFragment result = new CodeFragment();
        result.addCode(String.format("br label %%%s\n", this.labelLoopCmp));
        return result;
    }

	@Override
    public CodeFragment visitBlockFuncCall(AlangParser.BlockFuncCallContext ctx) {
        String name = ctx.ID().getText();

        if (!functionExists(name)) {
            this.addError(ctx, name, "Use of undeclared function");
            return new CodeFragment("");
        }

        Function f = getFunction(name);

        int numargsgiven = ctx.expression().size();
        if (f.args.size() != numargsgiven) {
            this.addError(ctx, name, String.format("Function takes %d arguments, %d given", f.args.size(), numargsgiven));
            return new CodeFragment("");
        }

        return this.callFunc(ctx.expression(), f);
    }

    //@Override public T visitBlockInputRow(AlangParser.BlockInputRowContext ctx) { return visitChildren(ctx); }

	//@Override public T visitBlockOutputString(AlangParser.BlockOutputStringContext ctx) { return visitChildren(ctx); }

	//@Override public T visitBlockOutputStringLn(AlangParser.BlockOutputStringLnContext ctx) { return visitChildren(ctx); }

	@Override
    public CodeFragment visitBlockReturn(AlangParser.BlockReturnContext ctx) {
        CodeFragment result = new CodeFragment("");
        if (this.scope.returntype.equals(Types.LLVMVOID)) {
            if (ctx.expression() != null) {
                this.addError(ctx, "VYPLUJ", "Cannot return value from void function");
                return new CodeFragment("");
            }
            result.addCode("ret void\n");
        } else {
            if (ctx.expression() == null) {
                this.addError(ctx, "VYPLUJ", "Need return value");
                return new CodeFragment("");
            }
            CodeFragment expr = visit(ctx.expression());
            result.addCode(expr);
            result.addCode(String.format("ret %s %s\n", this.scope.returntype, expr.getRegister()));
        }

        return result;
    }

    /* generate binary operator instruction like add, sub, div, mul, mod */
    private CodeFragment generateBinOPinstruction(String op, String type, CodeFragment exprL, CodeFragment exprR) {
        CodeFragment result = new CodeFragment();
        result.addCode(exprL);
        result.addCode(exprR);
        result.setRegister(this.generateNewRegister(false));

        result.addCode(String.format("%s = %s %s %s, %s\n", result.getRegister(), op, type,
                                                            exprL.getRegister(), exprR.getRegister()));

        return result;
    }

    @Override
    public CodeFragment visitExpAndOr(AlangParser.ExpAndOrContext ctx) {
        CodeFragment exprL = visit(ctx.expression(0));
        CodeFragment exprR = visit(ctx.expression(1));
        CodeFragment result = new CodeFragment();
        result.addCode(exprL);
        result.addCode(exprR);

        String op = "";
        if (ctx.op.getType() == AlangParser.AND) {
            op = "and";
        } else if (ctx.op.getType() == AlangParser.OR) {
            op = "or";
        }

        ST template = this.group.getInstanceOf("andorcondition");
        template.add("reg1", this.generateNewRegister(false));
        template.add("reg2", this.generateNewRegister(false));
        template.add("leftexp", exprL.getRegister());
        template.add("rightexp", exprR.getRegister());
        template.add("opreg", this.generateNewRegister(false));
        template.add("op", op);

        result.setRegister(this.generateNewRegister(false));
        template.add("register", result.getRegister());

        result.addCode(template.render() + "\n");
        return result;
    }

	@Override
    public CodeFragment visitExpComp(AlangParser.ExpCompContext ctx) {
        CodeFragment exprL = visit(ctx.expression(0));
        CodeFragment exprR = visit(ctx.expression(1));
        CodeFragment result = new CodeFragment();
        result.addCode(exprL);
        result.addCode(exprR);

        String op = "";
        switch (ctx.op.getType()) {
            case AlangParser.EQ: op = "eq"; break;
            case AlangParser.LT: op = "slt"; break;
            case AlangParser.GT: op = "sgt"; break;
            case AlangParser.LEQ: op = "sle"; break;
            case AlangParser.GEQ: op = "sge"; break;
            case AlangParser.NEQ: op = "ne"; break;
        }

        ST template = this.group.getInstanceOf("compare");
        template.add("opreg", this.generateNewRegister(false));
        result.setRegister(this.generateNewRegister(false));
        template.add("op", op);
        template.add("leftexp", exprL.getRegister());
        template.add("rightexp", exprR.getRegister());
        template.add("register", result.getRegister());

        result.addCode(template.render() + "\n");
        return result;
    }

    @Override
    public CodeFragment visitExpUna(AlangParser.ExpUnaContext ctx) {
        CodeFragment expr = visit(ctx.expression());

        if (ctx.op.getType() == AlangParser.ADD) {
            return expr;
        }

        CodeFragment result = new CodeFragment();
        result.addCode(expr);

        if (ctx.op.getType() == AlangParser.SUB) {
            result.setRegister(this.generateNewRegister(false));
            result.addCode(String.format("%s = sub i32 0, %s\n", result.getRegister(), expr.getRegister()));
        } else if (ctx.op.getType() == AlangParser.NOT) {
            String opreg = this.generateNewRegister(false);
            result.addCode(String.format("%s = icmp eq i32 %s, 0\n", opreg, expr.getRegister()));
            result.setRegister(this.generateNewRegister(false));
            result.addCode(String.format("%s = zext i1 %s to i32\n", result.getRegister(), opreg));
        }
        return result;
    }

    @Override
    public CodeFragment visitExpDivMulMod(AlangParser.ExpDivMulModContext ctx) {
        CodeFragment exprL = visit(ctx.expression(0));
        CodeFragment exprR = visit(ctx.expression(1));

        String inst = "";
        if (ctx.op.getType() == AlangParser.MUL)
            inst = "mul";
        else if (ctx.op.getType() == AlangParser.DIV)
            inst = "sdiv";
        else if (ctx.op.getType() == AlangParser.MOD)
            inst = "srem";

        return this.generateBinOPinstruction(inst, "i32", exprL, exprR);
    }

    @Override
    public CodeFragment visitExpAddSub(AlangParser.ExpAddSubContext ctx) {
        CodeFragment exprL = visit(ctx.expression(0));
        CodeFragment exprR = visit(ctx.expression(1));

        String inst = "";
        if (ctx.op.getType() == AlangParser.ADD)
            inst = "add";
        else if (ctx.op.getType() == AlangParser.SUB)
            inst = "sub";

        return this.generateBinOPinstruction(inst, "i32", exprL, exprR);
    }

	@Override
    public CodeFragment visitExpFalse(AlangParser.ExpFalseContext ctx) {
        CodeFragment result = new CodeFragment();
        result.setRegister(this.generateNewRegister(false));
        result.addCode(String.format("%s = add i8 0, 0\n", result.getRegister()));
        return result;
    }

    @Override
    public CodeFragment visitExpTrue(AlangParser.ExpTrueContext ctx) {
        CodeFragment result = new CodeFragment();
        result.setRegister(this.generateNewRegister(false));
        result.addCode(String.format("%s = add i8 0, 1\n", result.getRegister()));
        return result;
    }

    @Override
    public CodeFragment visitExpPar(AlangParser.ExpParContext ctx) {
        return visit(ctx.expression());
    }

	@Override
    public CodeFragment visitExpIdArray(AlangParser.ExpIdArrayContext ctx) {
        String name = ctx.ID().getText();
        if (!variableExists(name)) {
            this.addError(ctx, name, "Use of undeclared identifier");
            return new CodeFragment("");
        }

        Variable v = this.getVariable(name);
        CodeFragment result = new CodeFragment();

        int pointers = ctx.index_to_array().size();
        ArrayList<String> registers = new ArrayList<String>();
        for (int i = 0; i < pointers; i++) {
            CodeFragment expr = visit(ctx.index_to_array(i).expression());
            result.addCode(expr);
            registers.add(expr.getRegister());
        }

/*        String prevLoadRegister = v.reg;
        for (int i = 0; i < registers.size(); i++) {
            String loadRegister = this.generateNewRegister(false);
            String ptrRegister = this.generateNewRegister(false);

            String loadPointers = Types.pointers(registers.size() - i);
            String ptrPointers = Types.pointers(registers.size() - (i + 1));

            ST template = this.group.getInstanceOf("indextoarray");
            template.add("loadregister", loadRegister);
            template.add("type", v.llvmtype);
            template.add("loadpointers", loadPointers);
            template.add("prevloadregister", prevLoadRegister);
            template.add("ptrregister", ptrRegister);
            template.add("ptrpointers", ptrPointers);
            template.add("exprreg", registers.get(i));

            result.addCode(template.render() + "\n");

            prevLoadRegister = ptrRegister;
        }*/

        CodeFragment ptr = this.getPointerToArray(v, registers);
        result.addCode(ptr);

        result.setRegister(this.generateNewRegister(false));
        result.addCode(String.format("%s = load %s, %s* %s\n", result.getRegister(), v.llvmtype, v.llvmtype, ptr.getRegister()));
        return result;
    }

	@Override
    public CodeFragment visitExpFuncCall(AlangParser.ExpFuncCallContext ctx) {
        String name = ctx.ID().getText();

        if (!functionExists(name)) {
            this.addError(ctx, name, "Use of undeclared function");
            return new CodeFragment("");
        }

        Function f = getFunction(name);

        if (f.returntype == Types.LLVMVOID) {
            this.addError(ctx, name, "Use of void function as expression");
            return new CodeFragment("");
        }

        int numargsgiven = ctx.expression().size();
        if (f.args.size() != numargsgiven) {
            this.addError(ctx, name, String.format("Function takes %d arguments, %d given", f.args.size(), numargsgiven));
            return new CodeFragment("");
        }

        return this.callFunc(ctx.expression(), f);
    }

	@Override
    public CodeFragment visitExpId(AlangParser.ExpIdContext ctx) {
        String name = ctx.ID().getText();
        if (!variableExists(name)) {
            this.addError(ctx, name, "Use of undeclared identifier");
            return new CodeFragment("");
        }

        Variable v = this.getVariable(name);
        if (!v.hasValue) {
            this.addError(ctx, name, "Use of variable with no value");
            return new CodeFragment("");
        }

        CodeFragment result = new CodeFragment();
        if (v.arity > 0) {
            /* if we are accessing the array */
            result.setRegister(v.reg);
        } else {
            result.setRegister(this.generateNewRegister(false));
            result.addCode(String.format("%s = load %s, %s* %s\n", result.getRegister(), v.llvmtype, v.llvmtype, v.reg));
        }

        return result;
    }

    // TODO
	/*@Override
    public CodeFragment visitExpString(AlangParser.ExpStringContext ctx) {
        return visitChildren(ctx);
    }*/

	@Override
    public CodeFragment visitExpInt(AlangParser.ExpIntContext ctx) {
        CodeFragment result = new CodeFragment();
        result.setRegister(this.generateNewRegister(false));
        result.addCode(String.format("%s = add i32 0, %s\n", result.getRegister(), ctx.INT().getText()));
        return result;
    }
}
