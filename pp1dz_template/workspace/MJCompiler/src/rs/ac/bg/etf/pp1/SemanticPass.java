package rs.ac.bg.etf.pp1;


import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.AnotherActPars;
import rs.ac.bg.etf.pp1.ast.AnotherConstDecl;
import rs.ac.bg.etf.pp1.ast.AnotherExpr;
import rs.ac.bg.etf.pp1.ast.AnotherExprDesignator;
import rs.ac.bg.etf.pp1.ast.AnotherTerm;
import rs.ac.bg.etf.pp1.ast.AnotherVarDecl;
import rs.ac.bg.etf.pp1.ast.ArrayPart;
import rs.ac.bg.etf.pp1.ast.BoolConstFactor;
import rs.ac.bg.etf.pp1.ast.BooleanValue;
import rs.ac.bg.etf.pp1.ast.CharConstFactor;
import rs.ac.bg.etf.pp1.ast.ConstDecl;
import rs.ac.bg.etf.pp1.ast.ConstDeclType;
import rs.ac.bg.etf.pp1.ast.Designator;
import rs.ac.bg.etf.pp1.ast.DesignatorActFactor;
import rs.ac.bg.etf.pp1.ast.DesignatorNoActFactor;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementActP;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementExpr;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementMM;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementPP;
import rs.ac.bg.etf.pp1.ast.ExprFactor;
import rs.ac.bg.etf.pp1.ast.FormalParamDecl;
import rs.ac.bg.etf.pp1.ast.GlobalVarDeclElem;
import rs.ac.bg.etf.pp1.ast.GlobalVarOneNoErr;
import rs.ac.bg.etf.pp1.ast.GlobalVarTwoNoErr;
import rs.ac.bg.etf.pp1.ast.GlobalVarType;
import rs.ac.bg.etf.pp1.ast.IntegerValue;
import rs.ac.bg.etf.pp1.ast.IsArray;
import rs.ac.bg.etf.pp1.ast.MethodDecl;
import rs.ac.bg.etf.pp1.ast.MethodType;
import rs.ac.bg.etf.pp1.ast.MethodTypeName;
import rs.ac.bg.etf.pp1.ast.MethodVoidType;
import rs.ac.bg.etf.pp1.ast.NewExprFactor;
import rs.ac.bg.etf.pp1.ast.NumberConstFactor;
import rs.ac.bg.etf.pp1.ast.PomProcCallOne;
import rs.ac.bg.etf.pp1.ast.PrintNoNumStmt;
import rs.ac.bg.etf.pp1.ast.PrintNumStmt;
import rs.ac.bg.etf.pp1.ast.ProgName;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.ast.ReadStmt;
import rs.ac.bg.etf.pp1.ast.ReturnExprStmt;
import rs.ac.bg.etf.pp1.ast.SingleActPars;
import rs.ac.bg.etf.pp1.ast.SingleDesignator;
import rs.ac.bg.etf.pp1.ast.SingleNegExpr;
import rs.ac.bg.etf.pp1.ast.SinglePosExpr;
import rs.ac.bg.etf.pp1.ast.SingleTerm;
import rs.ac.bg.etf.pp1.ast.StringValue;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.Type;
import rs.ac.bg.etf.pp1.ast.VarDecl;
import rs.ac.bg.etf.pp1.ast.VarDeclAfterComma;
import rs.ac.bg.etf.pp1.ast.VarDeclPTwo;
import rs.ac.bg.etf.pp1.ast.VarDeclType;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class SemanticPass extends VisitorAdaptor {
	
	public class Elem{
		public java.util.List<Struct> lista=new java.util.ArrayList<Struct>();
	}

	Struct booleanStr;
	int paramCount=0;
	boolean errorDetected = false;
	int printCallCount = 0;
	Obj currentMethod = null;
	String currentMethodName="";
	boolean mainFound=false;
	Struct tempGlobVarType=null;
	Struct tempConstType=null;
	boolean returnFound = false;
	int nVars;
	String reservedWords[]={"eol", "chr", "ord", "len"};
	java.util.List<Elem> listaParametaraGlob=new java.util.ArrayList<Elem>();
	int currElem=-1;
	

	Logger log = Logger.getLogger(getClass());
	
	public SemanticPass(Struct logStr){
		booleanStr=logStr;
	}

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
	
	public boolean isReserved(String name){
		for(int i=0; i<reservedWords.length;i++){
			if(reservedWords[i].equals(name)){
				return true;
			}
		}
		return false;
	}
	
	//PROGRAM VISITORS============================================
	
	public void visit(Program program) {		
		nVars = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
		if(!mainFound){
			report_error("Main nije pronadjen u programu", null);
		}
	}

	public void visit(ProgName progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getPName(), Tab.noType);
		Tab.openScope();     	
	}
	
	//DECLARATION VISITORS========================================
	
	public void visit(VarDeclType varDeclType){
		tempGlobVarType=varDeclType.getType().struct;
	}

	public void visit(VarDecl varDecl) {
		boolean isArray=varDecl.getArrayPart() instanceof IsArray;
		String tempName=varDecl.getVarName();		
		if(!checkIdent(tempName, varDecl, 0)){
			return;
		}		
		checkAndInitArray(isArray, tempName, varDecl);
	}
	
	public void visit(VarDeclAfterComma anotherVarDecl){
		boolean isArray=anotherVarDecl.getArrayPart() instanceof IsArray;
		String tempName=anotherVarDecl.getVarName();
		if(!checkIdent(tempName, anotherVarDecl, 0)){
			return;
		}
		checkAndInitArray(isArray, tempName, anotherVarDecl);
		
	}
	
	public void visit(GlobalVarType globalVarType){
		tempGlobVarType=globalVarType.getType().struct;
	}
	
	public void visit(GlobalVarOneNoErr globalVarNoErr){
		boolean isArray=globalVarNoErr.getArrayPart() instanceof IsArray;
		String tempName=globalVarNoErr.getVarName();
		if(!checkIdent(tempName, globalVarNoErr, 0)){
			return;
		}
		checkAndInitArray(isArray, tempName, globalVarNoErr);		
	}
	
	public void visit(GlobalVarTwoNoErr globalVarNoErr){
		boolean isArray=globalVarNoErr.getArrayPart() instanceof IsArray;
		String tempName=globalVarNoErr.getVarName();
		if(!checkIdent(tempName, globalVarNoErr, 0)){
			return;
		}
		checkAndInitArray(isArray, tempName, globalVarNoErr);		
		tempGlobVarType=null;
	}
	
	public void visit(ConstDecl constDecl){
		String tempName=constDecl.getVarName();
		if(!checkIdent(tempName, constDecl, 1)){
			return;
		}
		boolean isConstType=constDecl.getConstValue().struct.equals(tempConstType);
		Obj temp=checkAndInitConst(isConstType, tempName, constDecl);
		if(temp!=null){
			if(constDecl.getConstValue() instanceof IntegerValue){
				temp.setAdr(((IntegerValue)constDecl.getConstValue()).getValueType());
			}
			else{
				if(constDecl.getConstValue() instanceof StringValue){
					temp.setAdr(((StringValue)constDecl.getConstValue()).getValueType().charAt(1));
				}
				else{
					if(constDecl.getConstValue() instanceof BooleanValue){
						if(((BooleanValue)constDecl.getConstValue()).getValueType().equals("true")){
							temp.setAdr(1);
						}
						else{
							temp.setAdr(0);
						}
					}
				}
			}
		}
	}
	
	public void visit(AnotherConstDecl constDecl){
		String tempName=constDecl.getVarName();
		if(!checkIdent(tempName, constDecl, 1)){
			return;
		}
		boolean isConstType=constDecl.getConstValue().struct.equals(tempConstType);
		Obj temp=checkAndInitConst(isConstType, tempName, constDecl);
		if(temp!=null){
			if(constDecl.getConstValue() instanceof IntegerValue){
				temp.setAdr(((IntegerValue)constDecl.getConstValue()).getValueType());
			}
			else{
				if(constDecl.getConstValue() instanceof StringValue){
					temp.setAdr(((StringValue)constDecl.getConstValue()).getValueType().charAt(1));
				}
				else{
					if(constDecl.getConstValue() instanceof BooleanValue){
						if(((BooleanValue)constDecl.getConstValue()).getValueType().equals("true")){
							temp.setAdr(1);
						}
						else{
							temp.setAdr(0);
						}
					}
				}
			}
		}
	}

	public void visit(ConstDeclType constType){
		tempConstType=constType.getType().struct;
	}
	
	public void visit(BooleanValue boolVal){
		boolVal.struct=booleanStr;
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
				report_error("Ime " + type.getTypeName() + " ne predstavlja tip ", type);
				type.struct = Tab.noType;
			}
		}  
	}
	
	//METHOD DECLARATIONS================================================================================
	
	public void visit(MethodDecl methodDecl) {
		if (!returnFound && currentMethod.getType() != Tab.noType) {
			report_error("Funcija " + currentMethod.getName() + " nema return iskaz", methodDecl);
		}
		
		currentMethod.setLevel(paramCount);
		paramCount=0;
		
		if((currentMethodName.equals("main")) && (currentMethod.getLevel()==0)){	//TODO: dodaj da se proverava da main nema parametre
			mainFound=true;
		}
		
		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		
		returnFound = false;
		currentMethod = null;
		currentMethodName="";
		//listaParametara.clear();
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
		currentMethodName=methodVoidType.getMethName();
		Tab.openScope();
		report_info("Obrada funkcije " + methodVoidType.getMethName()+", objekat u tabeli simbola "+currentMethod.toString(), methodVoidType);
	}
	
	public void visit(FormalParamDecl paramDecl){
		paramCount++;
		tempGlobVarType=paramDecl.getType().struct;
		boolean isArray=paramDecl.getArrayPart() instanceof IsArray;
		String tempName=paramDecl.getParName();
		if(!checkIdent(tempName, paramDecl, 0)){
			return;
		}
		checkAndInitArray(isArray, tempName, paramDecl);
		tempGlobVarType=null;
	}
	
	public void visit(SingleActPars pars){
		listaParametaraGlob.get(currElem).lista.add(pars.getExpr().struct);
	}
	
	public void visit(AnotherActPars pars){
		listaParametaraGlob.get(currElem).lista.add(pars.getExpr().struct);
	}
	
	public void visit(PomProcCallOne callOne){
		listaParametaraGlob.add(new Elem());
		currElem++;
	}
	
	//STATEMENT VISITORS====================================
	
	public void visit(ReturnExprStmt returnExpr){
		returnFound = true;
		Struct currMethType = currentMethod.getType();
		if (!currMethType.compatibleWith(returnExpr.getExpr().struct)) {
			report_error("Tip izraza u return naredbi ne slaze se sa tipom povratne vrednosti funkcije " + currentMethod.getName(), returnExpr);
		}			  	     	
	}
	
	public void visit(SingleDesignator designator){
		Obj obj = Tab.find(designator.getName());
		if (obj == Tab.noObj) { 
			report_error("Ime "+designator.getName()+" nije deklarisano", designator);
		}
		designator.obj = obj;
	}
	
	public void visit(AnotherExprDesignator designator){
		if (designator.getDesignator().obj.getType().getKind()!=Struct.Array){
			report_error("Designator "+designator.obj.getName()+" nije niz", designator);
		}
		if (designator.getExpr().struct!=Tab.intType){
			report_error("Parametri niza moraju biti tipa int", designator);
		}
		designator.obj=designator.getDesignator().obj;
	}
	
	public void visit(AnotherExpr expr) {
		Struct te = expr.getExpr().struct;
		Struct t = expr.getTerm().struct;
		if (te.equals(t) && te == Tab.intType)
			expr.struct = te;
		else {
			report_error("Nekompatibilni tipovi u izrazu za sabiranje", expr);
			expr.struct = Tab.noType;
		} 
	}
	
	public void visit(SinglePosExpr expr){
		Struct t=expr.getTerm().struct;
		expr.struct=t;
	}
	
	public void visit(SingleNegExpr expr){
		Struct t=expr.getTerm().struct;
		if(t==Tab.intType){
			expr.struct=t;
		}
		else{
			report_error("Nekompatibilan tip", expr);
			expr.struct = Tab.noType;
		}
	}
	
	public void visit(AnotherTerm term){
		Struct t=term.getTerm().struct;
		Struct fac=term.getFactor().struct;
		if(t.equals(fac) && t==Tab.intType){
			term.struct=t;
		}
		else{
			report_error("Nekompatibilan tip u izrazu za mnozenje", term);
			term.struct = Tab.noType;
		}
	}
	
	public void visit(SingleTerm term){
		Struct t=term.getFactor().struct;
		term.struct=t;
	}
	
	public void visit(NumberConstFactor factor){
		factor.struct=Tab.intType;
	}
	
	public void visit(CharConstFactor factor){
		factor.struct=Tab.charType;
	}
	
	public void visit(BoolConstFactor factor){
		factor.struct=booleanStr;
	}
	
	public void visit(DesignatorNoActFactor factor){
		factor.struct=checkIfArrayIsOkInStatement(factor.getDesignator(), factor);
	}
	
	public void visit(DesignatorActFactor factor){
		Obj func = factor.getDesignator().obj;
		if (Obj.Meth == func.getKind()) { 
			report_info("Pronadjen poziv funkcije " + func.getName(), factor);
			
			factor.struct=func.getType();
			
			java.util.Collection<Obj> kolekcija=func.getLocalSymbols();
			int paramNum=func.getLevel();
			if(paramNum==listaParametaraGlob.get(currElem).lista.size()){
				int i=0;
				for (Obj obj : kolekcija) {
					if(i==paramNum){
						break;
					}
					Struct tempStr=obj.getType();
					if(tempStr.getKind()==Struct.Array){
						tempStr=tempStr.getElemType();
						String imeDesiga=factor.getDesignator().obj.getName();
						if(imeDesiga.equals("len")){
							tempStr=listaParametaraGlob.get(currElem).lista.get(i);
						}
					}
					if(!(tempStr.equals(listaParametaraGlob.get(currElem).lista.get(i)))){
						report_error("Parametri se ne poklapaju u funkciji " + func.getName(), factor);
						factor.struct=Tab.noType;
						break;
					}
					i++;
				}
			}
			else{
				report_error("Pogresan broj parametara funkcije " + func.getName(), factor);
				factor.struct=Tab.noType;
			}

			
			//RESULT = func.getType();
		} 
		else {
			report_error("Ime nije funkcija", factor);
			factor.struct=Tab.noType;
			//RESULT = Tab.noType;
		} 
		listaParametaraGlob.remove(currElem);
		currElem--;
	}
	
	public void visit(NewExprFactor factor){
		if(factor.getExpr().struct!=Tab.intType){
			report_error("Izraz za adresiranje niza nije kompatibilan", factor);
			factor.struct=Tab.noType;
		}
		else{
			factor.struct=factor.getType().struct;
		}
	}
	
	public void visit(ExprFactor factor){
		factor.struct=factor.getExpr().struct;
	}
	
	public void visit(DesignatorStatementExpr desStatement){
		if(checkIfConst(desStatement.getDesignator().obj, desStatement)){
			return;
		}
		Struct desig=checkIfArrayIsOkInStatement(desStatement.getDesignator(), desStatement);
		Struct expr=desStatement.getExpr().struct;
		if (!expr.assignableTo(desig)){
			report_error("Nekompatibilni tipovi u dodeli vrednosti", desStatement);
		}
	}
	
	public void visit(DesignatorStatementPP ppStatement){
		if(checkIfConst(ppStatement.getDesignator().obj, ppStatement)){
			return;
		}
		Struct desig=checkIfArrayIsOkInStatement(ppStatement.getDesignator(), ppStatement);
		if(desig!=Tab.intType){
			report_error("Nekompatibilni tip u ++ operaciji", ppStatement);
		}
	}
	
	public void visit(DesignatorStatementMM ppStatement){
		if(checkIfConst(ppStatement.getDesignator().obj, ppStatement)){
			return;
		}
		Struct desig=checkIfArrayIsOkInStatement(ppStatement.getDesignator(), ppStatement);
		if(desig!=Tab.intType){
			report_error("Nekompatibilni tip u -- operaciji", ppStatement);
		}
	}
	
	public void visit(PrintNoNumStmt printStatement){
		if(printStatement.getExpr().struct!=Tab.charType && printStatement.getExpr().struct!=Tab.intType &&
				printStatement.getExpr().struct!=booleanStr){
			report_error("Pogresan tip u print operaciji", printStatement);
		}
	}
	
	public void visit(PrintNumStmt printStatement){
		if(printStatement.getExpr().struct!=Tab.charType && printStatement.getExpr().struct!=Tab.intType &&
				printStatement.getExpr().struct!=booleanStr){
			report_error("Pogresan tip u print operaciji", printStatement);
		}
	}
	
	public void visit(ReadStmt readStmt){
		Struct tip=checkIfArrayIsOkInStatement(readStmt.getDesignator(), readStmt);
		if(tip!=Tab.charType && tip!=Tab.intType && tip!=booleanStr){
			report_error("Pogresan tip u read operaciji", readStmt);
		}
	}
	
	public void visit(DesignatorStatementActP procCall){
		Obj func = procCall.getDesignator().obj;
		if (Obj.Meth == func.getKind()) { 
			report_info("Pronadjen poziv funkcije " + func.getName(), procCall);
			//RESULT = func.getType();
			
			java.util.Collection<Obj> kolekcija=func.getLocalSymbols();
			int paramNum=func.getLevel();
			if(paramNum==listaParametaraGlob.get(currElem).lista.size()){
				int i=0;
				for (Obj obj : kolekcija) {
					if(i==paramNum){
						break;
					}
					Struct tempStr=obj.getType();
					if(tempStr.getKind()==Struct.Array){
						tempStr=tempStr.getElemType();
						String imeDesiga=procCall.getDesignator().obj.getName();
						if(imeDesiga.equals("len")){
							tempStr=listaParametaraGlob.get(currElem).lista.get(i);
						}
					}
					if(!(tempStr.equals(listaParametaraGlob.get(currElem).lista.get(i)))){
						report_error("Parametri se ne poklapaju u funkciji " + func.getName(), procCall);
						break;
					}
					i++;
				}
			}
			else{
				report_error("Pogresan broj parametara funkcije " + func.getName(), procCall);
			}
			
		} 
		else {
			report_error("Ime nije funkcija", procCall);
			//RESULT = Tab.noType;
		}
		listaParametaraGlob.remove(currElem);
		currElem--;
	} 
	
	public boolean passed() {
		return !errorDetected;
	}
	
	//LOGIC METHODS==========================================================================
	public void checkAndInitArray(boolean arrayCondition, String name, SyntaxNode info){
		Obj varNode=null;
		String pomS="";
		if(!arrayCondition){
			varNode = Tab.insert(Obj.Var, name, tempGlobVarType);
			pomS="Deklarisana promenljiva ";
		}
		else{
			varNode = Tab.insert(Obj.Var, name, new Struct(Struct.Array, tempGlobVarType));
			pomS="Deklarisan niz ";
		}
		report_info(pomS+ name+", objekat u tabeli simbola "+varNode.toString(), info);
	}
	
	public Obj checkAndInitConst(boolean isConstType, String name, SyntaxNode info){
		if(isConstType){
			Obj varNode = Tab.insert(Obj.Con, name, tempConstType);
			report_info("Deklarisana konstanta "+ name+", objekat u tabeli simbola "+varNode.toString(), info);
			return varNode;
		}
		else{
			report_error("Konstanti "+name+" nije dodeljen ispravan tip", info);
			return null;
		}
	}
	
	public boolean checkIdent(String name, SyntaxNode info, int varOrConst){
		Obj temp=Tab.find(name);
		String tempStr="";
		if(varOrConst==0){
			tempStr="Promenljiva ";
		}
		else{
			tempStr="Konstanta ";
		}
		//provera da li postoji ime prom u tabeli simbola
		if(temp!=Tab.noObj){
			//provera da li je nadjeni node iz tabele sa istim imenom tipa Type
			if (temp.getKind()==Obj.Type){
				report_error(tempStr+ name +" ne moze imati predeklarisani naziv", info);
				return false;
			}
			//provera za jos predeklariasnih imena
			if(isReserved(name)){
				report_error(tempStr+ name +" ne moze imati predeklarisani naziv", info);
				return false;
			}
			//provera da li je nadjeni node iz tabele simbola istog scopa kao nova promenljiva
			if (Tab.currentScope.findSymbol(name)!=null){
				report_error(tempStr+ name +" vec postoji", info);
				return false;
			}
		}
		return true;
	}
	
	public Struct checkIfArrayIsOkInStatement(Designator designator, SyntaxNode info){
		Struct ret=Tab.noType;
		if(designator.obj.getType().getKind()==Struct.Array){
			/*if (!(designator instanceof AnotherExprDesignator)){
				report_error("Mora se navesti element niza", info);
				return ret;
			}*/
			ret=designator.obj.getType().getElemType();
		}
		else{
			ret=designator.obj.getType();
		}
		return ret;
	}
	
	public boolean checkIfConst(Obj objectT, SyntaxNode info){
		if(objectT.getKind()==objectT.Con){
			report_error("Konstanti ne moze biti dodeljena vrednost", info);
			return true;
		}
		return false;
	}
	
}

