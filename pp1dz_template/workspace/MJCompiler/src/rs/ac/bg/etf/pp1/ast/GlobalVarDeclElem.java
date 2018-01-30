// generated with ast extension for cup
// version 0.8
// 30/0/2018 18:59:17


package rs.ac.bg.etf.pp1.ast;

public class GlobalVarDeclElem extends GlobalVarDecl {

    private GlobalVarType GlobalVarType;
    private GlobalVarDeclList GlobalVarDeclList;

    public GlobalVarDeclElem (GlobalVarType GlobalVarType, GlobalVarDeclList GlobalVarDeclList) {
        this.GlobalVarType=GlobalVarType;
        if(GlobalVarType!=null) GlobalVarType.setParent(this);
        this.GlobalVarDeclList=GlobalVarDeclList;
        if(GlobalVarDeclList!=null) GlobalVarDeclList.setParent(this);
    }

    public GlobalVarType getGlobalVarType() {
        return GlobalVarType;
    }

    public void setGlobalVarType(GlobalVarType GlobalVarType) {
        this.GlobalVarType=GlobalVarType;
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
        if(GlobalVarType!=null) GlobalVarType.accept(visitor);
        if(GlobalVarDeclList!=null) GlobalVarDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalVarType!=null) GlobalVarType.traverseTopDown(visitor);
        if(GlobalVarDeclList!=null) GlobalVarDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalVarType!=null) GlobalVarType.traverseBottomUp(visitor);
        if(GlobalVarDeclList!=null) GlobalVarDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalVarDeclElem(\n");

        if(GlobalVarType!=null)
            buffer.append(GlobalVarType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(GlobalVarDeclList!=null)
            buffer.append(GlobalVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalVarDeclElem]");
        return buffer.toString();
    }
}
