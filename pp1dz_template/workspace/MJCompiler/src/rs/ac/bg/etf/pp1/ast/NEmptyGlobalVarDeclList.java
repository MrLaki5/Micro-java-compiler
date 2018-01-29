// generated with ast extension for cup
// version 0.8
// 28/0/2018 15:8:27


package rs.ac.bg.etf.pp1.ast;

public class NEmptyGlobalVarDeclList extends GlobalVarDeclList {

    private GlobalVarDeclList GlobalVarDeclList;
    private String VarName;
    private ArrayPart ArrayPart;

    public NEmptyGlobalVarDeclList (GlobalVarDeclList GlobalVarDeclList, String VarName, ArrayPart ArrayPart) {
        this.GlobalVarDeclList=GlobalVarDeclList;
        if(GlobalVarDeclList!=null) GlobalVarDeclList.setParent(this);
        this.VarName=VarName;
        this.ArrayPart=ArrayPart;
        if(ArrayPart!=null) ArrayPart.setParent(this);
    }

    public GlobalVarDeclList getGlobalVarDeclList() {
        return GlobalVarDeclList;
    }

    public void setGlobalVarDeclList(GlobalVarDeclList GlobalVarDeclList) {
        this.GlobalVarDeclList=GlobalVarDeclList;
    }

    public String getVarName() {
        return VarName;
    }

    public void setVarName(String VarName) {
        this.VarName=VarName;
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
        if(GlobalVarDeclList!=null) GlobalVarDeclList.accept(visitor);
        if(ArrayPart!=null) ArrayPart.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalVarDeclList!=null) GlobalVarDeclList.traverseTopDown(visitor);
        if(ArrayPart!=null) ArrayPart.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalVarDeclList!=null) GlobalVarDeclList.traverseBottomUp(visitor);
        if(ArrayPart!=null) ArrayPart.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NEmptyGlobalVarDeclList(\n");

        if(GlobalVarDeclList!=null)
            buffer.append(GlobalVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+VarName);
        buffer.append("\n");

        if(ArrayPart!=null)
            buffer.append(ArrayPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NEmptyGlobalVarDeclList]");
        return buffer.toString();
    }
}
