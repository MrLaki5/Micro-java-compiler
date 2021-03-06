package rs.ac.bg.etf.pp1;
import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.ac.bg.etf.pp1.ast.ProgName;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;

public class PrintPass extends VisitorAdaptor {

	Logger log = Logger.getLogger(getClass());
	String out="";
	
	public void visit(Program program) {		
		out=program.toString(out);
	}
	
	public String outString(){
		return out;
	}

}

