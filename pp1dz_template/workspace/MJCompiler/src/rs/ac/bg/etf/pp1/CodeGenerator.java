package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.CounterVisitor.FormParamCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.MethodVarCounter;
import rs.ac.bg.etf.pp1.ast.AnotherExpr;
import rs.ac.bg.etf.pp1.ast.AnotherTerm;
import rs.ac.bg.etf.pp1.ast.CharConstFactor;
import rs.ac.bg.etf.pp1.ast.DesignatorNoActFactor;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementExpr;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementMM;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementPP;
import rs.ac.bg.etf.pp1.ast.DivMulop;
import rs.ac.bg.etf.pp1.ast.MethodDecl;
import rs.ac.bg.etf.pp1.ast.MethodType;
import rs.ac.bg.etf.pp1.ast.MethodTypeName;
import rs.ac.bg.etf.pp1.ast.MethodVoidType;
import rs.ac.bg.etf.pp1.ast.MulMulop;
import rs.ac.bg.etf.pp1.ast.NumberConstFactor;
import rs.ac.bg.etf.pp1.ast.PlusAddop;
import rs.ac.bg.etf.pp1.ast.PrintNoNumStmt;
import rs.ac.bg.etf.pp1.ast.ReturnExprStmt;
import rs.ac.bg.etf.pp1.ast.ReturnNoExprStmt;
import rs.ac.bg.etf.pp1.ast.SingleDesignator;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {
	
	private int varCount;
	private int paramCnt;
	private int mainPc;
	
	public int getMainPc() {
		return mainPc;
	}

	public void visit(MethodVoidType MethodTypeName) {
		if ("main".equalsIgnoreCase(MethodTypeName.obj.getName())) {
			mainPc = Code.pc;
		}
		MethodTypeName.obj.setAdr(Code.pc);
		
		// Collect arguments and local variables.
		SyntaxNode methodNode = MethodTypeName.getParent();
		MethodVarCounter varCnt = new MethodVarCounter();
		methodNode.traverseTopDown(varCnt);
		FormParamCounter fpCnt = new FormParamCounter();
		methodNode.traverseTopDown(fpCnt);
		
		// Generate the entry.
		Code.put(Code.enter);
		Code.put(fpCnt.getCount());
		Code.put(varCnt.getCount() + fpCnt.getCount());
	}
	

	public void visit(MethodType MethodTypeName) {
		if ("main".equalsIgnoreCase(MethodTypeName.obj.getName())) {
			mainPc = Code.pc;
		}
		MethodTypeName.obj.setAdr(Code.pc);
		
		// Collect arguments and local variables.
		SyntaxNode methodNode = MethodTypeName.getParent();
		MethodVarCounter varCnt = new MethodVarCounter();
		methodNode.traverseTopDown(varCnt);
		FormParamCounter fpCnt = new FormParamCounter();
		methodNode.traverseTopDown(fpCnt);
		
		// Generate the entry.
		Code.put(Code.enter);
		Code.put(fpCnt.getCount());
		Code.put(varCnt.getCount() + fpCnt.getCount());
	}
	
	public void visit(MethodDecl MethodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(ReturnExprStmt ReturnExpr) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(ReturnNoExprStmt ReturnNoExpr) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(PrintNoNumStmt printStmt) {
		Struct t=printStmt.getExpr().struct;
		if(t==Tab.intType){
			Code.loadConst(5);
			Code.put(Code.print);
		}
		else{
			Code.loadConst(1);		
			Code.put(Code.bprint);
		}
		
	}
	
	public void visit(NumberConstFactor factor) {
		Code.load(new Obj(Obj.Con, "", Tab.intType, factor.getN1(), 0));		
	}
	
	public void visit(CharConstFactor factor){
		Code.load(new Obj(Obj.Con, "", Tab.charType, factor.getC1().charAt(1), 0));
	}
	
	public void visit(SingleDesignator desig) {
		Code.load(desig.obj);
	}
	
	public void visit(DesignatorStatementExpr designatorStatementExpr) {
		Code.store(designatorStatementExpr.getDesignator().obj);
	}
	
	public void visit(AnotherExpr addExpr) {
		if (addExpr.getAddop() instanceof PlusAddop){
			Code.put(Code.add);
		}
		else{
			Code.put(Code.sub);
		}
	}
	
	public void visit(AnotherTerm term){
		if (term.getMulop() instanceof MulMulop){
			Code.put(Code.mul);
		}
		else{
			if(term.getMulop() instanceof DivMulop){
				Code.put(Code.div);
			}
			else{
				Code.put(Code.rem);
			}
		}
	}
	
	public void visit(DesignatorStatementPP statement){
		Code.load(new Obj(Obj.Con, "", Tab.intType, 1, 0));
		Code.put(Code.add);
		Code.store(statement.getDesignator().obj);
	}
	
	public void visit(DesignatorStatementMM statement){
		Code.load(new Obj(Obj.Con, "", Tab.intType, 1, 0));
		Code.put(Code.sub);
		Code.store(statement.getDesignator().obj);
	}
	
	/*
	@Override
	
	
	@Override
	public void visit(VarDecl VarDecl) {
		varCount++;
	}

	@Override
	public void visit(FormalParamDecl FormalParam) {
		paramCnt++;
	}	
	
	
	@Override
	
	
	@Override
	
	
	@Override
	public void visit(FuncCall FuncCall) {
		Obj functionObj = FuncCall.getDesignator().obj;
		int offset = functionObj.getAdr() - Code.pc; 
		Code.put(Code.call);
		Code.put2(offset);
	}
	
	@Override
	
	
	@Override
	
	
	*/
}