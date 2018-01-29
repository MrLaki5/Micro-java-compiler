// generated with ast extension for cup
// version 0.8
// 29/0/2018 11:12:58


package rs.ac.bg.etf.pp1.ast;

public class ClassDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String className;
    private ExtendsPart ExtendsPart;
    private DeclVarOnlyList DeclVarOnlyList;
    private ClassMethodDecl ClassMethodDecl;

    public ClassDecl (String className, ExtendsPart ExtendsPart, DeclVarOnlyList DeclVarOnlyList, ClassMethodDecl ClassMethodDecl) {
        this.className=className;
        this.ExtendsPart=ExtendsPart;
        if(ExtendsPart!=null) ExtendsPart.setParent(this);
        this.DeclVarOnlyList=DeclVarOnlyList;
        if(DeclVarOnlyList!=null) DeclVarOnlyList.setParent(this);
        this.ClassMethodDecl=ClassMethodDecl;
        if(ClassMethodDecl!=null) ClassMethodDecl.setParent(this);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className=className;
    }

    public ExtendsPart getExtendsPart() {
        return ExtendsPart;
    }

    public void setExtendsPart(ExtendsPart ExtendsPart) {
        this.ExtendsPart=ExtendsPart;
    }

    public DeclVarOnlyList getDeclVarOnlyList() {
        return DeclVarOnlyList;
    }

    public void setDeclVarOnlyList(DeclVarOnlyList DeclVarOnlyList) {
        this.DeclVarOnlyList=DeclVarOnlyList;
    }

    public ClassMethodDecl getClassMethodDecl() {
        return ClassMethodDecl;
    }

    public void setClassMethodDecl(ClassMethodDecl ClassMethodDecl) {
        this.ClassMethodDecl=ClassMethodDecl;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExtendsPart!=null) ExtendsPart.accept(visitor);
        if(DeclVarOnlyList!=null) DeclVarOnlyList.accept(visitor);
        if(ClassMethodDecl!=null) ClassMethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExtendsPart!=null) ExtendsPart.traverseTopDown(visitor);
        if(DeclVarOnlyList!=null) DeclVarOnlyList.traverseTopDown(visitor);
        if(ClassMethodDecl!=null) ClassMethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExtendsPart!=null) ExtendsPart.traverseBottomUp(visitor);
        if(DeclVarOnlyList!=null) DeclVarOnlyList.traverseBottomUp(visitor);
        if(ClassMethodDecl!=null) ClassMethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDecl(\n");

        buffer.append(" "+tab+className);
        buffer.append("\n");

        if(ExtendsPart!=null)
            buffer.append(ExtendsPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DeclVarOnlyList!=null)
            buffer.append(DeclVarOnlyList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassMethodDecl!=null)
            buffer.append(ClassMethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDecl]");
        return buffer.toString();
    }
}
