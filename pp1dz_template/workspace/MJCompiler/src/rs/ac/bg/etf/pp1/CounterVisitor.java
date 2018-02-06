package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.AnotherVarDecl;
import rs.ac.bg.etf.pp1.ast.FormalParamDecl;
import rs.ac.bg.etf.pp1.ast.VarDecl;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;

public class CounterVisitor extends VisitorAdaptor {
	
	protected int count;
	
	public int getCount() {
		return count;
	}
	
	public static class FormParamCounter extends CounterVisitor {

		public void visit(FormalParamDecl formParamDecl1) {
			count++;
		}		
	}
	
	public static class MethodVarCounter extends CounterVisitor {		

		public void visit(VarDecl VarDecl) {
			count++;
		}
		
		public void visit(AnotherVarDecl varDecl){
			count++;
		}
	}
}
