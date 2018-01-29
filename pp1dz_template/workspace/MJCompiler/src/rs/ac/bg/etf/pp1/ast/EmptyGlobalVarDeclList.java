// generated with ast extension for cup
// version 0.8
// 28/0/2018 15:8:27


package rs.ac.bg.etf.pp1.ast;

public class EmptyGlobalVarDeclList extends GlobalVarDeclList {

    public EmptyGlobalVarDeclList () {
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
        buffer.append("EmptyGlobalVarDeclList(\n");

        buffer.append(tab);
        buffer.append(") [EmptyGlobalVarDeclList]");
        return buffer.toString();
    }
}
