// generated with ast extension for cup
// version 0.8
// 6/1/2018 19:50:56


package rs.ac.bg.etf.pp1.ast;

public class GlobalVarTwoNoErr extends GlobalVarTwo {

    private String varName;
    private ArrayPart ArrayPart;

    public GlobalVarTwoNoErr (String varName, ArrayPart ArrayPart) {
        this.varName=varName;
        this.ArrayPart=ArrayPart;
        if(ArrayPart!=null) ArrayPart.setParent(this);
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

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ArrayPart!=null) ArrayPart.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ArrayPart!=null) ArrayPart.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ArrayPart!=null) ArrayPart.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalVarTwoNoErr(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(ArrayPart!=null)
            buffer.append(ArrayPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalVarTwoNoErr]");
        return buffer.toString();
    }
}
