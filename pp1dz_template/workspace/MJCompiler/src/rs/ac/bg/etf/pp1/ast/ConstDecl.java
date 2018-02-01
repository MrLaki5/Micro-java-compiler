// generated with ast extension for cup
// version 0.8
// 1/1/2018 8:41:40


package rs.ac.bg.etf.pp1.ast;

public class ConstDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private ConstDeclType ConstDeclType;
    private String varName;
    private ConstValue ConstValue;
    private ConstDeclList ConstDeclList;

    public ConstDecl (ConstDeclType ConstDeclType, String varName, ConstValue ConstValue, ConstDeclList ConstDeclList) {
        this.ConstDeclType=ConstDeclType;
        if(ConstDeclType!=null) ConstDeclType.setParent(this);
        this.varName=varName;
        this.ConstValue=ConstValue;
        if(ConstValue!=null) ConstValue.setParent(this);
        this.ConstDeclList=ConstDeclList;
        if(ConstDeclList!=null) ConstDeclList.setParent(this);
    }

    public ConstDeclType getConstDeclType() {
        return ConstDeclType;
    }

    public void setConstDeclType(ConstDeclType ConstDeclType) {
        this.ConstDeclType=ConstDeclType;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public ConstValue getConstValue() {
        return ConstValue;
    }

    public void setConstValue(ConstValue ConstValue) {
        this.ConstValue=ConstValue;
    }

    public ConstDeclList getConstDeclList() {
        return ConstDeclList;
    }

    public void setConstDeclList(ConstDeclList ConstDeclList) {
        this.ConstDeclList=ConstDeclList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclType!=null) ConstDeclType.accept(visitor);
        if(ConstValue!=null) ConstValue.accept(visitor);
        if(ConstDeclList!=null) ConstDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclType!=null) ConstDeclType.traverseTopDown(visitor);
        if(ConstValue!=null) ConstValue.traverseTopDown(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclType!=null) ConstDeclType.traverseBottomUp(visitor);
        if(ConstValue!=null) ConstValue.traverseBottomUp(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDecl(\n");

        if(ConstDeclType!=null)
            buffer.append(ConstDeclType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(ConstValue!=null)
            buffer.append(ConstValue.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclList!=null)
            buffer.append(ConstDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDecl]");
        return buffer.toString();
    }
}
