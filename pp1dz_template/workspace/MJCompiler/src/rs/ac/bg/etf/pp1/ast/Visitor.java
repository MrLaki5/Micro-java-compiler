// generated with ast extension for cup
// version 0.8
// 6/1/2018 17:30:53


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(ArrayPart ArrayPart);
    public void visit(Mulop Mulop);
    public void visit(Relop Relop);
    public void visit(StatementList StatementList);
    public void visit(Addop Addop);
    public void visit(Factor Factor);
    public void visit(CondTerm CondTerm);
    public void visit(GlobalVarDecl GlobalVarDecl);
    public void visit(DeclList DeclList);
    public void visit(Designator Designator);
    public void visit(Term Term);
    public void visit(Condition Condition);
    public void visit(ConstValue ConstValue);
    public void visit(VarDeclPTwo VarDeclPTwo);
    public void visit(DeclVarOnlyList DeclVarOnlyList);
    public void visit(ConstDeclList ConstDeclList);
    public void visit(GlobalVarOne GlobalVarOne);
    public void visit(VarDeclList VarDeclList);
    public void visit(FormalParamList FormalParamList);
    public void visit(Expr Expr);
    public void visit(ActPars ActPars);
    public void visit(MethodTypeName MethodTypeName);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(ActList ActList);
    public void visit(Statement Statement);
    public void visit(CondFact CondFact);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(FormPars FormPars);
    public void visit(GlobalVarDeclList GlobalVarDeclList);
    public void visit(ExtendsPart ExtendsPart);
    public void visit(ClassMethodDecl ClassMethodDecl);
    public void visit(GlobalVarTwo GlobalVarTwo);
    public void visit(ModMulop ModMulop);
    public void visit(DivMulop DivMulop);
    public void visit(MulMulop MulMulop);
    public void visit(MinusAddopt MinusAddopt);
    public void visit(PlusAddop PlusAddop);
    public void visit(LowerEqualRelop LowerEqualRelop);
    public void visit(LowerRelop LowerRelop);
    public void visit(GreaterEqualRelop GreaterEqualRelop);
    public void visit(GreaterRelop GreaterRelop);
    public void visit(NotEqualsRelop NotEqualsRelop);
    public void visit(EqualsRelop EqualsRelop);
    public void visit(SingleDesignator SingleDesignator);
    public void visit(AnotherExprDesignator AnotherExprDesignator);
    public void visit(AnotherIdentDesignator AnotherIdentDesignator);
    public void visit(ExprFactor ExprFactor);
    public void visit(NewExprFactor NewExprFactor);
    public void visit(NewNoExprFactor NewNoExprFactor);
    public void visit(BoolConstFactor BoolConstFactor);
    public void visit(CharConstFactor CharConstFactor);
    public void visit(NumberConstFactor NumberConstFactor);
    public void visit(DesignatorActFactor DesignatorActFactor);
    public void visit(DesignatorNoActFactor DesignatorNoActFactor);
    public void visit(SingleTerm SingleTerm);
    public void visit(AnotherTerm AnotherTerm);
    public void visit(SingleNegExpr SingleNegExpr);
    public void visit(SinglePosExpr SinglePosExpr);
    public void visit(AnotherExpr AnotherExpr);
    public void visit(CondFactRelop CondFactRelop);
    public void visit(CondFactNoRelop CondFactNoRelop);
    public void visit(SingleCondTerm SingleCondTerm);
    public void visit(AnotherCondTerm AnotherCondTerm);
    public void visit(SingleCondition SingleCondition);
    public void visit(AnotherCondition AnotherCondition);
    public void visit(PomProcCallOne PomProcCallOne);
    public void visit(SingleActPars SingleActPars);
    public void visit(AnotherActPars AnotherActPars);
    public void visit(NoActList NoActList);
    public void visit(ActListPar ActListPar);
    public void visit(DesignatorStatementExprErr DesignatorStatementExprErr);
    public void visit(DesignatorStatementMM DesignatorStatementMM);
    public void visit(DesignatorStatementPP DesignatorStatementPP);
    public void visit(DesignatorStatementActP DesignatorStatementActP);
    public void visit(DesignatorStatementExpr DesignatorStatementExpr);
    public void visit(DoWhileStart DoWhileStart);
    public void visit(BraceStmt BraceStmt);
    public void visit(PrintNumStmt PrintNumStmt);
    public void visit(PrintNoNumStmt PrintNoNumStmt);
    public void visit(ReadStmt ReadStmt);
    public void visit(ReturnNoExprStmt ReturnNoExprStmt);
    public void visit(ReturnExprStmt ReturnExprStmt);
    public void visit(ContinueStmt ContinueStmt);
    public void visit(BreakStmt BreakStmt);
    public void visit(DoWhileStmt DoWhileStmt);
    public void visit(IsStmtElseError IsStmtElseError);
    public void visit(IfStmtElse IfStmtElse);
    public void visit(IfStmtNoElseError IfStmtNoElseError);
    public void visit(IfStmtNoElse IfStmtNoElse);
    public void visit(Assignment Assignment);
    public void visit(NoStmt NoStmt);
    public void visit(Statements Statements);
    public void visit(FormalParamDecl FormalParamDecl);
    public void visit(ErrorOneFormalParamDecl ErrorOneFormalParamDecl);
    public void visit(ErrorTwoFormalParamDecl ErrorTwoFormalParamDecl);
    public void visit(SingleFormalParamDecl SingleFormalParamDecl);
    public void visit(FormalParamDecls FormalParamDecls);
    public void visit(NoFormParam NoFormParam);
    public void visit(FormParams FormParams);
    public void visit(MethodVoidType MethodVoidType);
    public void visit(MethodType MethodType);
    public void visit(MethodDecl MethodDecl);
    public void visit(NoMethodDecl NoMethodDecl);
    public void visit(MethodDeclarations MethodDeclarations);
    public void visit(Type Type);
    public void visit(NoClassMethods NoClassMethods);
    public void visit(ClassMethods ClassMethods);
    public void visit(NoExtension NoExtension);
    public void visit(Extension Extension);
    public void visit(ClassDecl ClassDecl);
    public void visit(VarDeclAfterComma VarDeclAfterComma);
    public void visit(NoAnotherVarDecl NoAnotherVarDecl);
    public void visit(AnotherVarDecl AnotherVarDecl);
    public void visit(IsNotArray IsNotArray);
    public void visit(IsArray IsArray);
    public void visit(VarDeclType VarDeclType);
    public void visit(VarDecl VarDecl);
    public void visit(GlobalVarTwoErr GlobalVarTwoErr);
    public void visit(GlobalVarTwoNoErr GlobalVarTwoNoErr);
    public void visit(GlobalVarOneErr GlobalVarOneErr);
    public void visit(GlobalVarOneNoErr GlobalVarOneNoErr);
    public void visit(GlobalVarDeclLast GlobalVarDeclLast);
    public void visit(GlobalVarDeclAnother GlobalVarDeclAnother);
    public void visit(GlobalVarType GlobalVarType);
    public void visit(GlobalVarDeclElem GlobalVarDeclElem);
    public void visit(StringValue StringValue);
    public void visit(IntegerValue IntegerValue);
    public void visit(BooleanValue BooleanValue);
    public void visit(NoAnotherConstDecl NoAnotherConstDecl);
    public void visit(AnotherConstDecl AnotherConstDecl);
    public void visit(ConstDeclType ConstDeclType);
    public void visit(ConstDecl ConstDecl);
    public void visit(NoVarOnlyDeclarations NoVarOnlyDeclarations);
    public void visit(VarOnlyDeclarations VarOnlyDeclarations);
    public void visit(NoDecl NoDecl);
    public void visit(ClassDeclarations ClassDeclarations);
    public void visit(ConstDeclarations ConstDeclarations);
    public void visit(VarDeclarations VarDeclarations);
    public void visit(ProgName ProgName);
    public void visit(Program Program);

}
