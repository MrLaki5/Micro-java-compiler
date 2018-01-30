package rs.ac.bg.etf.pp1;
import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.BooleanValue;
import rs.ac.bg.etf.pp1.ast.ConstDecl;
import rs.ac.bg.etf.pp1.ast.GlobalVarDeclElem;
import rs.ac.bg.etf.pp1.ast.GlobalVarOneNoErr;
import rs.ac.bg.etf.pp1.ast.GlobalVarTwoNoErr;
import rs.ac.bg.etf.pp1.ast.GlobalVarType;
import rs.ac.bg.etf.pp1.ast.IntegerValue;
import rs.ac.bg.etf.pp1.ast.MethodDecl;
import rs.ac.bg.etf.pp1.ast.MethodType;
import rs.ac.bg.etf.pp1.ast.MethodTypeName;
import rs.ac.bg.etf.pp1.ast.MethodVoidType;
import rs.ac.bg.etf.pp1.ast.ProgName;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.ast.StringValue;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.Type;
import rs.ac.bg.etf.pp1.ast.VarDecl;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class SemanticPass extends VisitorAdaptor {

	boolean errorDetected = false;
	int printCallCount = 0;
	Obj currentMethod = null;
	Struct tempGlobVarType=null;
	boolean returnFound = false;
	int nVars;

	Logger log = Logger.getLogger(getClass());

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (": linija ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (": linija ").append(line);
		log.info(msg.toString());
	}
	
	public void visit(Program program) {		
		nVars = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
	}

	public void visit(ProgName progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getPName(), Tab.noType);
		Tab.openScope();     	
	}

	public void visit(VarDecl varDecl) {
		Obj temp=Tab.find(varDecl.getVarName());
		//provera da li postoji ime prom u tabeli simbola
		if(temp!=Tab.noObj){
			//provera da li je nadjeni node iz tabele sa istim imenom tipa Type
			if (temp.getKind()==Obj.Type){
				report_error("Promenljiva "+ varDecl.getVarName() +" ne moze imati naziv tipa", varDecl);
				return;
			}
			//provera da li je nadjeni node iz tabele simbola istog scopa kao nova promenljiva
			if (Tab.currentScope.findSymbol(varDecl.getVarName())!=null){
				report_error("Promenljiva "+ varDecl.getVarName() +" vec postoji", varDecl);
				return;
			}
		}
		Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(), varDecl.getType().struct);
		report_info("Deklarisana promenljiva "+ varDecl.getVarName()+", objekat u tabeli simbola "+varNode.toString(), varDecl);
	}
	
	public void visit(GlobalVarType globalVarType){
		tempGlobVarType=globalVarType.getType().struct;
	}
	
	public void visit(GlobalVarOneNoErr globalVarNoErr){
		Obj temp=Tab.find(globalVarNoErr.getVarName());
		//provera da li postoji ime prom u tabeli simbola
		if(temp!=Tab.noObj){
			//provera da li je nadjeni node iz tabele sa istim imenom tipa Type
			if (temp.getKind()==Obj.Type){
				report_error("Promenljiva "+ globalVarNoErr.getVarName() +" ne moze imati naziv tipa", globalVarNoErr);
				return;
			}
			//provera da li je nadjeni node iz tabele simbola istog scopa kao nova promenljiva
			if (Tab.currentScope.findSymbol(globalVarNoErr.getVarName())!=null){
				report_error("Promenljiva "+ globalVarNoErr.getVarName() +" vec postoji", globalVarNoErr);
				return;
			}
		}
		Obj varNode = Tab.insert(Obj.Var, globalVarNoErr.getVarName(), tempGlobVarType);
		report_info("Deklarisana promenljiva "+ globalVarNoErr.getVarName()+", objekat u tabeli simbola "+varNode.toString(), globalVarNoErr);
	}
	
	public void visit(GlobalVarTwoNoErr globalVarNoErr){
		Obj temp=Tab.find(globalVarNoErr.getVarName());
		//provera da li postoji ime prom u tabeli simbola
		if(temp!=Tab.noObj){
			//provera da li je nadjeni node iz tabele sa istim imenom tipa Type
			if (temp.getKind()==Obj.Type){
				report_error("Promenljiva "+ globalVarNoErr.getVarName() +" ne moze imati naziv tipa", globalVarNoErr);
				return;
			}
			//provera da li je nadjeni node iz tabele simbola istog scopa kao nova promenljiva
			if (Tab.currentScope.findSymbol(globalVarNoErr.getVarName())!=null){
				report_error("Promenljiva "+ globalVarNoErr.getVarName() +" vec postoji", globalVarNoErr);
				return;
			}
		}
		Obj varNode = Tab.insert(Obj.Var, globalVarNoErr.getVarName(), tempGlobVarType);
		report_info("Deklarisana promenljiva "+ globalVarNoErr.getVarName()+", objekat u tabeli simbola "+varNode.toString(), globalVarNoErr);
		tempGlobVarType=null;
	}
	
	public void visit(ConstDecl constDecl){
		Obj temp=Tab.find(constDecl.getVarName());
		//provera da li postoji ime prom u tabeli simbola
		if(temp!=Tab.noObj){
			//provera da li je nadjeni node iz tabele sa istim imenom tipa Type
			if (temp.getKind()==Obj.Type){
				report_error("Konstanta "+ constDecl.getVarName() +" ne moze imati naziv tipa", constDecl);
				return;
			}
			//provera da li je nadjeni node iz tabele simbola istog scopa kao nova promenljiva
			if (Tab.currentScope.findSymbol(constDecl.getVarName())!=null){
				report_error("Konstanta "+ constDecl.getVarName() +" vec postoji", constDecl);
				return;
			}
		}
		if(constDecl.getConstValue().struct.assignableTo(constDecl.getType().struct)){
			Obj varNode = Tab.insert(Obj.Con, constDecl.getVarName(), tempGlobVarType);
			report_info("Deklarisana konstanta "+ constDecl.getVarName()+", objekat u tabeli simbola "+varNode.toString(), constDecl);
		}
		else{
			report_error("Konstanti "+constDecl.getVarName()+" nije dodeljen ispravan tip", constDecl);
		}
	}

	public void visit(BooleanValue boolVal){
		boolVal.struct=Tab.intType;
	}
	
	public void visit(StringValue charVal){
		charVal.struct=Tab.charType;
	}
	
	public void visit(IntegerValue intVal){
		intVal.struct=Tab.intType;
	}
	
	public void visit(Type type) {
		Obj typeNode = Tab.find(type.getTypeName());
		if (typeNode == Tab.noObj) {
			report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola", null);
			type.struct = Tab.noType;
		} 
		else {
			if (Obj.Type == typeNode.getKind()) {
				type.struct = typeNode.getType();
			} 
			else {
				report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip ", type);
				type.struct = Tab.noType;
			}
		}  
	}
	
	public void visit(MethodDecl methodDecl) {
		if (!returnFound && currentMethod.getType() != Tab.noType) {
			report_error("Semanticka greska na liniji " + methodDecl.getLine() + ": funcija " + currentMethod.getName() + " nema return iskaz!", null);
		}
		
		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		
		returnFound = false;
		currentMethod = null;
	}

	public void visit(MethodType methodType) {
		currentMethod = Tab.insert(Obj.Meth, methodType.getMethName(), methodType.getType().struct);
		methodType.obj = currentMethod;
		Tab.openScope();
		report_info("Obrada funkcije " + methodType.getMethName()+", objekat u tabeli simbola "+currentMethod.toString(), methodType);
	}
	
	public void visit(MethodVoidType methodVoidType){
		currentMethod = Tab.insert(Obj.Meth, methodVoidType.getMethName(), Tab.noType);
		methodVoidType.obj = currentMethod;
		Tab.openScope();
		report_info("Obrada funkcije " + methodVoidType.getMethName()+", objekat u tabeli simbola "+currentMethod.toString(), methodVoidType);
	}
/*
	public void visit(Assignment assignment) {
		if (!assignment.getExpr().struct.assignableTo(assignment.getDesignator().obj.getType()))
			report_error("Greska na liniji " + assignment.getLine() + " : " + " nekompatibilni tipovi u dodeli vrednosti ", null);
	}

	public void visit(PrintStmt printStmt){
		printCallCount++;    	
	}

	public void visit(ReturnExpr returnExpr){
		returnFound = true;
		Struct currMethType = currentMethod.getType();
		if (!currMethType.compatibleWith(returnExpr.getExpr().struct)) {
			report_error("Greska na liniji " + returnExpr.getLine() + " : " + "tip izraza u return naredbi ne slaze se sa tipom povratne vrednosti funkcije " + currentMethod.getName(), null);
		}			  	     	
	}

	public void visit(ProcCall procCall){
		Obj func = procCall.getDesignator().obj;
		if (Obj.Meth == func.getKind()) { 
			report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + procCall.getLine(), null);
			//RESULT = func.getType();
		} 
		else {
			report_error("Greska na liniji " + procCall.getLine()+" : ime " + func.getName() + " nije funkcija!", null);
			//RESULT = Tab.noType;
		}     	
	}    

	public void visit(AddExpr addExpr) {
		Struct te = addExpr.getExpr().struct;
		Struct t = addExpr.getTerm().struct;
		if (te.equals(t) && te == Tab.intType)
			addExpr.struct = te;
		else {
			report_error("Greska na liniji "+ addExpr.getLine()+" : nekompatibilni tipovi u izrazu za sabiranje.", null);
			addExpr.struct = Tab.noType;
		} 
	}

	public void visit(TermExpr termExpr) {
		termExpr.struct = termExpr.getTerm().struct;
	}

	public void visit(Term term) {
		term.struct = term.getFactor().struct;    	
	}

	public void visit(Const cnst){
		cnst.struct = Tab.intType;    	
	}
	
	public void visit(Var var) {
		var.struct = var.getDesignator().obj.getType();
	}

	public void visit(FuncCall funcCall){
		Obj func = funcCall.getDesignator().obj;
		if (Obj.Meth == func.getKind()) { 
			report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + funcCall.getLine(), null);
			funcCall.struct = func.getType();
		} 
		else {
			report_error("Greska na liniji " + funcCall.getLine()+" : ime " + func.getName() + " nije funkcija!", null);
			funcCall.struct = Tab.noType;
		}

	}

	public void visit(Designator designator){
		Obj obj = Tab.find(designator.getName());
		if (obj == Tab.noObj) { 
			report_error("Greska na liniji " + designator.getLine()+ " : ime "+designator.getName()+" nije deklarisano! ", null);
		}
		designator.obj = obj;
	}
	*/
	public boolean passed() {
		return !errorDetected;
	}
	
}
