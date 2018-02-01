// generated with ast extension for cup
// version 0.8
// 1/1/2018 8:41:41


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementActP extends DesignatorStatement {

    private Designator Designator;
    private ActList ActList;

    public DesignatorStatementActP (Designator Designator, ActList ActList) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.ActList=ActList;
        if(ActList!=null) ActList.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public ActList getActList() {
        return ActList;
    }

    public void setActList(ActList ActList) {
        this.ActList=ActList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(ActList!=null) ActList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(ActList!=null) ActList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(ActList!=null) ActList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementActP(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActList!=null)
            buffer.append(ActList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementActP]");
        return buffer.toString();
    }
}
