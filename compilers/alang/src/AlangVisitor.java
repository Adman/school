// Generated from Alang.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AlangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AlangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AlangParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(AlangParser.InitContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlangParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(AlangParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FuncStat}
	 * labeled alternative in {@link AlangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncStat(AlangParser.FuncStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarDecStat}
	 * labeled alternative in {@link AlangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecStat(AlangParser.VarDecStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentStat}
	 * labeled alternative in {@link AlangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStat(AlangParser.AssignmentStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockVarDec}
	 * labeled alternative in {@link AlangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockVarDec(AlangParser.BlockVarDecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockAsgn}
	 * labeled alternative in {@link AlangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockAsgn(AlangParser.BlockAsgnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockFuncCall}
	 * labeled alternative in {@link AlangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockFuncCall(AlangParser.BlockFuncCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockOutputString}
	 * labeled alternative in {@link AlangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockOutputString(AlangParser.BlockOutputStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockReturn}
	 * labeled alternative in {@link AlangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockReturn(AlangParser.BlockReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockLoop}
	 * labeled alternative in {@link AlangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockLoop(AlangParser.BlockLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockIf}
	 * labeled alternative in {@link AlangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockIf(AlangParser.BlockIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockBreak}
	 * labeled alternative in {@link AlangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockBreak(AlangParser.BlockBreakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockContinue}
	 * labeled alternative in {@link AlangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockContinue(AlangParser.BlockContinueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlangParser#else_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_block(AlangParser.Else_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlangParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(AlangParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlangParser#index_to_array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_to_array(AlangParser.Index_to_arrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlangParser#index_to_global_array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_to_global_array(AlangParser.Index_to_global_arrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlangParser#global_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobal_expression(AlangParser.Global_expressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpFalse}
	 * labeled alternative in {@link AlangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpFalse(AlangParser.ExpFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpUna}
	 * labeled alternative in {@link AlangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpUna(AlangParser.ExpUnaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpPar}
	 * labeled alternative in {@link AlangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpPar(AlangParser.ExpParContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpFuncCall}
	 * labeled alternative in {@link AlangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpFuncCall(AlangParser.ExpFuncCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpChar}
	 * labeled alternative in {@link AlangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpChar(AlangParser.ExpCharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpTrue}
	 * labeled alternative in {@link AlangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpTrue(AlangParser.ExpTrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpAddSub}
	 * labeled alternative in {@link AlangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpAddSub(AlangParser.ExpAddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpComp}
	 * labeled alternative in {@link AlangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpComp(AlangParser.ExpCompContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpDivMulMod}
	 * labeled alternative in {@link AlangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpDivMulMod(AlangParser.ExpDivMulModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpIdArray}
	 * labeled alternative in {@link AlangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpIdArray(AlangParser.ExpIdArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpId}
	 * labeled alternative in {@link AlangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpId(AlangParser.ExpIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpAndOr}
	 * labeled alternative in {@link AlangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpAndOr(AlangParser.ExpAndOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpInt}
	 * labeled alternative in {@link AlangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpInt(AlangParser.ExpIntContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlangParser#argtype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgtype(AlangParser.ArgtypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlangParser#var_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_type(AlangParser.Var_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlangParser#return_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_type(AlangParser.Return_typeContext ctx);
}