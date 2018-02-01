// generated with ast extension for cup
// version 0.8
// 1/1/2018 8:41:41


package rs.ac.bg.etf.pp1.ast;

public class GlobalVarOneErr extends GlobalVarOne {

    public GlobalVarOneErr () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalVarOneErr(\n");

        buffer.append(tab);
        buffer.append(") [GlobalVarOneErr]");
        return buffer.toString();
    }
}
