// generated with ast extension for cup
// version 0.8
// 6/1/2018 13:5:45


package rs.ac.bg.etf.pp1.ast;

public class NoActList extends ActList {

    public NoActList () {
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
        buffer.append("NoActList(\n");

        buffer.append(tab);
        buffer.append(") [NoActList]");
        return buffer.toString();
    }
}
