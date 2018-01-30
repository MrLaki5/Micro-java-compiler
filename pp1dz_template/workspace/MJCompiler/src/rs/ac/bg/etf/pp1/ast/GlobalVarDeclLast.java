// generated with ast extension for cup
// version 0.8
// 30/0/2018 18:59:17


package rs.ac.bg.etf.pp1.ast;

public class GlobalVarDeclLast extends GlobalVarDeclList {

    private GlobalVarTwo GlobalVarTwo;

    public GlobalVarDeclLast (GlobalVarTwo GlobalVarTwo) {
        this.GlobalVarTwo=GlobalVarTwo;
        if(GlobalVarTwo!=null) GlobalVarTwo.setParent(this);
    }

    public GlobalVarTwo getGlobalVarTwo() {
        return GlobalVarTwo;
    }

    public void setGlobalVarTwo(GlobalVarTwo GlobalVarTwo) {
        this.GlobalVarTwo=GlobalVarTwo;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(GlobalVarTwo!=null) GlobalVarTwo.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalVarTwo!=null) GlobalVarTwo.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalVarTwo!=null) GlobalVarTwo.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalVarDeclLast(\n");

        if(GlobalVarTwo!=null)
            buffer.append(GlobalVarTwo.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalVarDeclLast]");
        return buffer.toString();
    }
}
