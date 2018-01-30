// generated with ast extension for cup
// version 0.8
// 30/0/2018 18:59:17


package rs.ac.bg.etf.pp1.ast;

public class VarOnlyDeclarations extends DeclVarOnlyList {

    private DeclVarOnlyList DeclVarOnlyList;
    private VarDecl VarDecl;

    public VarOnlyDeclarations (DeclVarOnlyList DeclVarOnlyList, VarDecl VarDecl) {
        this.DeclVarOnlyList=DeclVarOnlyList;
        if(DeclVarOnlyList!=null) DeclVarOnlyList.setParent(this);
        this.VarDecl=VarDecl;
        if(VarDecl!=null) VarDecl.setParent(this);
    }

    public DeclVarOnlyList getDeclVarOnlyList() {
        return DeclVarOnlyList;
    }

    public void setDeclVarOnlyList(DeclVarOnlyList DeclVarOnlyList) {
        this.DeclVarOnlyList=DeclVarOnlyList;
    }

    public VarDecl getVarDecl() {
        return VarDecl;
    }

    public void setVarDecl(VarDecl VarDecl) {
        this.VarDecl=VarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DeclVarOnlyList!=null) DeclVarOnlyList.accept(visitor);
        if(VarDecl!=null) VarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DeclVarOnlyList!=null) DeclVarOnlyList.traverseTopDown(visitor);
        if(VarDecl!=null) VarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DeclVarOnlyList!=null) DeclVarOnlyList.traverseBottomUp(visitor);
        if(VarDecl!=null) VarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarOnlyDeclarations(\n");

        if(DeclVarOnlyList!=null)
            buffer.append(DeclVarOnlyList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDecl!=null)
            buffer.append(VarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarOnlyDeclarations]");
        return buffer.toString();
    }
}
