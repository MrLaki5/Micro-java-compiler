// generated with ast extension for cup
// version 0.8
// 6/1/2018 19:50:56


package rs.ac.bg.etf.pp1.ast;

public class IfStmtNoElse extends Statement {

    private IfStart IfStart;
    private Condition Condition;
    private IfStartThis IfStartThis;
    private Statement Statement;

    public IfStmtNoElse (IfStart IfStart, Condition Condition, IfStartThis IfStartThis, Statement Statement) {
        this.IfStart=IfStart;
        if(IfStart!=null) IfStart.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.IfStartThis=IfStartThis;
        if(IfStartThis!=null) IfStartThis.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public IfStart getIfStart() {
        return IfStart;
    }

    public void setIfStart(IfStart IfStart) {
        this.IfStart=IfStart;
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public IfStartThis getIfStartThis() {
        return IfStartThis;
    }

    public void setIfStartThis(IfStartThis IfStartThis) {
        this.IfStartThis=IfStartThis;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IfStart!=null) IfStart.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
        if(IfStartThis!=null) IfStartThis.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfStart!=null) IfStart.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(IfStartThis!=null) IfStartThis.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfStart!=null) IfStart.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(IfStartThis!=null) IfStartThis.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IfStmtNoElse(\n");

        if(IfStart!=null)
            buffer.append(IfStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IfStartThis!=null)
            buffer.append(IfStartThis.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IfStmtNoElse]");
        return buffer.toString();
    }
}
