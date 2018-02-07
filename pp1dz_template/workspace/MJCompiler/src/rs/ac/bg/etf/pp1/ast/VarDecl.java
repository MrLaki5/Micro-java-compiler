// generated with ast extension for cup
// version 0.8
// 6/1/2018 19:50:56


package rs.ac.bg.etf.pp1.ast;

public class VarDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private VarDeclType VarDeclType;
    private String varName;
    private ArrayPart ArrayPart;
    private VarDeclList VarDeclList;

    public VarDecl (VarDeclType VarDeclType, String varName, ArrayPart ArrayPart, VarDeclList VarDeclList) {
        this.VarDeclType=VarDeclType;
        if(VarDeclType!=null) VarDeclType.setParent(this);
        this.varName=varName;
        this.ArrayPart=ArrayPart;
        if(ArrayPart!=null) ArrayPart.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
    }

    public VarDeclType getVarDeclType() {
        return VarDeclType;
    }

    public void setVarDeclType(VarDeclType VarDeclType) {
        this.VarDeclType=VarDeclType;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public ArrayPart getArrayPart() {
        return ArrayPart;
    }

    public void setArrayPart(ArrayPart ArrayPart) {
        this.ArrayPart=ArrayPart;
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
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
        if(VarDeclType!=null) VarDeclType.accept(visitor);
        if(ArrayPart!=null) ArrayPart.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclType!=null) VarDeclType.traverseTopDown(visitor);
        if(ArrayPart!=null) ArrayPart.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclType!=null) VarDeclType.traverseBottomUp(visitor);
        if(ArrayPart!=null) ArrayPart.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDecl(\n");

        if(VarDeclType!=null)
            buffer.append(VarDeclType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(ArrayPart!=null)
            buffer.append(ArrayPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDecl]");
        return buffer.toString();
    }
}
