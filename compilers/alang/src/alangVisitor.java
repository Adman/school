// Generated from alang.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link alangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface alangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link alangParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(alangParser.InitContext ctx);
	/**
	 * Visit a parse tree produced by {@link alangParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(alangParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link alangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(alangParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockVarDec}
	 * labeled alternative in {@link alangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockVarDec(alangParser.BlockVarDecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockAsgn}
	 * labeled alternative in {@link alangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockAsgn(alangParser.BlockAsgnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockIf}
	 * labeled alternative in {@link alangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockIf(alangParser.BlockIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockLoop}
	 * labeled alternative in {@link alangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockLoop(alangParser.BlockLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockFuncCall}
	 * labeled alternative in {@link alangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockFuncCall(alangParser.BlockFuncCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockInputInt}
	 * labeled alternative in {@link alangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockInputInt(alangParser.BlockInputIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockInputRow}
	 * labeled alternative in {@link alangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockInputRow(alangParser.BlockInputRowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockOutputVar}
	 * labeled alternative in {@link alangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockOutputVar(alangParser.BlockOutputVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockOutputRow}
	 * labeled alternative in {@link alangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockOutputRow(alangParser.BlockOutputRowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockReturn}
	 * labeled alternative in {@link alangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockReturn(alangParser.BlockReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link alangParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(alangParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link alangParser#vypluj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVypluj(alangParser.VyplujContext ctx);
	/**
	 * Visit a parse tree produced by {@link alangParser#var_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_declaration(alangParser.Var_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link alangParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(alangParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link alangParser#if_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_block(alangParser.If_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link alangParser#loop_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop_block(alangParser.Loop_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link alangParser#func_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_call(alangParser.Func_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link alangParser#input_int}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput_int(alangParser.Input_intContext ctx);
	/**
	 * Visit a parse tree produced by {@link alangParser#input_row}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput_row(alangParser.Input_rowContext ctx);
	/**
	 * Visit a parse tree produced by {@link alangParser#output_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutput_var(alangParser.Output_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link alangParser#output_row}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutput_row(alangParser.Output_rowContext ctx);
	/**
	 * Visit a parse tree produced by {@link alangParser#index_to_array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_to_array(alangParser.Index_to_arrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link alangParser#var_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_type(alangParser.Var_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link alangParser#return_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_type(alangParser.Return_typeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CondOr}
	 * labeled alternative in {@link alangParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondOr(alangParser.CondOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CondAnd}
	 * labeled alternative in {@link alangParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondAnd(alangParser.CondAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CondPar}
	 * labeled alternative in {@link alangParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondPar(alangParser.CondParContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CondNot}
	 * labeled alternative in {@link alangParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondNot(alangParser.CondNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CondComp}
	 * labeled alternative in {@link alangParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondComp(alangParser.CondCompContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpDivMul}
	 * labeled alternative in {@link alangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpDivMul(alangParser.ExpDivMulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpFalse}
	 * labeled alternative in {@link alangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpFalse(alangParser.ExpFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpUna}
	 * labeled alternative in {@link alangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpUna(alangParser.ExpUnaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpPar}
	 * labeled alternative in {@link alangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpPar(alangParser.ExpParContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpIdArray}
	 * labeled alternative in {@link alangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpIdArray(alangParser.ExpIdArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpFuncCall}
	 * labeled alternative in {@link alangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpFuncCall(alangParser.ExpFuncCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpId}
	 * labeled alternative in {@link alangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpId(alangParser.ExpIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpString}
	 * labeled alternative in {@link alangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpString(alangParser.ExpStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpTrue}
	 * labeled alternative in {@link alangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpTrue(alangParser.ExpTrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpInt}
	 * labeled alternative in {@link alangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpInt(alangParser.ExpIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpAddSub}
	 * labeled alternative in {@link alangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpAddSub(alangParser.ExpAddSubContext ctx);
	/**
	 * Visit a parse tree produced by {@link alangParser#argtype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgtype(alangParser.ArgtypeContext ctx);
}