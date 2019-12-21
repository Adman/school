import org.stringtemplate.v4.*;
import java.util.*;

public class Variable {
    public String reg;
    public String type;
    public String llvmtype;
    /* Value for non array variable */
    public String value = null;

    public boolean hasValue = false;

    public int arity = 0;
    public boolean isGlobalArray = false;
    public boolean isLocalArray = false;
    public ArrayList<Integer> levels = new ArrayList<Integer>();
    public ArrayList<String> levelregs = new ArrayList<String>();

    public Variable(String reg, String type, String llvmtype) {
        this.reg = reg;
        this.type = type;
        this.llvmtype = llvmtype;
    }

    public void setArity(int arity) {
        this.arity = arity;
    }

    public void setGlobalArray() {
        this.isGlobalArray = true;
    }

    public void setLocalArray() {
        this.isLocalArray = true;
    }

    public void addLevel(int num) {
        this.levels.add(num);
    }

    public void addLevelReg(String reg) {
        this.levelregs.add(reg);
    }

    public void setHasValue() {
        this.hasValue = true;
    }

    public void setValue(String value) {
        if (this.type.equals(Types.BOOL)) {
            if (value.equals("TRUE"))
                this.value = "1";
            else
                this.value = "0";
        } else
            this.value = value;
    }

    public String getLLVMGlobalInitializer() {
        if (this.arity == 0) {
            return (this.value == null ? "0" : this.value);
        }
        return "zeroinitializer";
    }

    public String getLLVMLocalDeclareType() {
        if (this.arity == 0)
            return this.llvmtype;

        // TODO
        return "";
    }

    public String getLLVMDeclareGlobalFromIndex(int from) {
        String result = "[" +  this.levels.get(this.levels.size() - 1) + " x " + this.llvmtype + "]";
        for (int i = arity - 2; i >= from; i--) {
            result = "[" + this.levels.get(i) + " x " + result + "]";
        }
        return result;
    }

    public String getLLVMDeclareType() {
        if (this.arity == 0)
            return this.llvmtype;
        return this.getLLVMDeclareGlobalFromIndex(0);
    }

    public String getGlobalDeclaration(ST template) {
        template.add("reg", this.reg);
        template.add("type", this.getLLVMDeclareType());

        if (this.arity > 0) {
            template.add("common", " common");
        } else if (this.value == null) {
            template.add("common", " common");
        }
        template.add("initializer", this.getLLVMGlobalInitializer());
        return template.render();
    }
}
