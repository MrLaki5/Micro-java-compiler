// generated with ast extension for cup
// version 0.8
// 30/0/2018 18:59:17


package rs.ac.bg.etf.pp1.ast;

public class AnotherVarDecl extends VarDeclList {

    private VarDeclList VarDeclList;
    private VarDeclPTwo VarDeclPTwo;

    public AnotherVarDecl (VarDeclList VarDeclList, VarDeclPTwo VarDeclPTwo) {
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.VarDeclPTwo=VarDeclPTwo;
        if(VarDeclPTwo!=null) VarDeclPTwo.setParent(this);
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public VarDeclPTwo getVarDeclPTwo() {
        return VarDeclPTwo;
    }

    public void setVarDeclPTwo(VarDeclPTwo VarDeclPTwo) {
        this.VarDeclPTwo=VarDeclPTwo;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(VarDeclPTwo!=null) VarDeclPTwo.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(VarDeclPTwo!=null) VarDeclPTwo.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(VarDeclPTwo!=null) VarDeclPTwo.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AnotherVarDecl(\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclPTwo!=null)
            buffer.append(VarDeclPTwo.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AnotherVarDecl]");
        return buffer.toString();
    }
}
