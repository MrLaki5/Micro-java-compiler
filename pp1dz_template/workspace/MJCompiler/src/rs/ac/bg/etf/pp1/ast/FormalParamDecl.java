// generated with ast extension for cup
// version 0.8
// 6/1/2018 17:30:52


package rs.ac.bg.etf.pp1.ast;

public class FormalParamDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private String parName;
    private ArrayPart ArrayPart;

    public FormalParamDecl (Type Type, String parName, ArrayPart ArrayPart) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.parName=parName;
        this.ArrayPart=ArrayPart;
        if(ArrayPart!=null) ArrayPart.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getParName() {
        return parName;
    }

    public void setParName(String parName) {
        this.parName=parName;
    }

    public ArrayPart getArrayPart() {
        return ArrayPart;
    }

    public void setArrayPart(ArrayPart ArrayPart) {
        this.ArrayPart=ArrayPart;
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
        if(Type!=null) Type.accept(visitor);
        if(ArrayPart!=null) ArrayPart.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ArrayPart!=null) ArrayPart.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ArrayPart!=null) ArrayPart.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormalParamDecl(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+parName);
        buffer.append("\n");

        if(ArrayPart!=null)
            buffer.append(ArrayPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormalParamDecl]");
        return buffer.toString();
    }
}
