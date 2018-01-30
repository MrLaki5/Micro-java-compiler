// generated with ast extension for cup
// version 0.8
// 30/0/2018 17:14:48


package rs.ac.bg.etf.pp1.ast;

public class GlobalVarDeclAnother extends GlobalVarDeclList {

    private GlobalVarOne GlobalVarOne;
    private GlobalVarDeclList GlobalVarDeclList;

    public GlobalVarDeclAnother (GlobalVarOne GlobalVarOne, GlobalVarDeclList GlobalVarDeclList) {
        this.GlobalVarOne=GlobalVarOne;
        if(GlobalVarOne!=null) GlobalVarOne.setParent(this);
        this.GlobalVarDeclList=GlobalVarDeclList;
        if(GlobalVarDeclList!=null) GlobalVarDeclList.setParent(this);
    }

    public GlobalVarOne getGlobalVarOne() {
        return GlobalVarOne;
    }

    public void setGlobalVarOne(GlobalVarOne GlobalVarOne) {
        this.GlobalVarOne=GlobalVarOne;
    }

    public GlobalVarDeclList getGlobalVarDeclList() {
        return GlobalVarDeclList;
    }

    public void setGlobalVarDeclList(GlobalVarDeclList GlobalVarDeclList) {
        this.GlobalVarDeclList=GlobalVarDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(GlobalVarOne!=null) GlobalVarOne.accept(visitor);
        if(GlobalVarDeclList!=null) GlobalVarDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalVarOne!=null) GlobalVarOne.traverseTopDown(visitor);
        if(GlobalVarDeclList!=null) GlobalVarDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalVarOne!=null) GlobalVarOne.traverseBottomUp(visitor);
        if(GlobalVarDeclList!=null) GlobalVarDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalVarDeclAnother(\n");

        if(GlobalVarOne!=null)
            buffer.append(GlobalVarOne.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(GlobalVarDeclList!=null)
            buffer.append(GlobalVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalVarDeclAnother]");
        return buffer.toString();
    }
}
