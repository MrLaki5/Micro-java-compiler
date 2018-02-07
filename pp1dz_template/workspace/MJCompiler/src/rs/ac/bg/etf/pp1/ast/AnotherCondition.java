// generated with ast extension for cup
// version 0.8
// 6/1/2018 19:50:57


package rs.ac.bg.etf.pp1.ast;

public class AnotherCondition extends Condition {

    private Condition Condition;
    private LogorNT LogorNT;
    private CondTerm CondTerm;

    public AnotherCondition (Condition Condition, LogorNT LogorNT, CondTerm CondTerm) {
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.LogorNT=LogorNT;
        if(LogorNT!=null) LogorNT.setParent(this);
        this.CondTerm=CondTerm;
        if(CondTerm!=null) CondTerm.setParent(this);
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public LogorNT getLogorNT() {
        return LogorNT;
    }

    public void setLogorNT(LogorNT LogorNT) {
        this.LogorNT=LogorNT;
    }

    public CondTerm getCondTerm() {
        return CondTerm;
    }

    public void setCondTerm(CondTerm CondTerm) {
        this.CondTerm=CondTerm;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Condition!=null) Condition.accept(visitor);
        if(LogorNT!=null) LogorNT.accept(visitor);
        if(CondTerm!=null) CondTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(LogorNT!=null) LogorNT.traverseTopDown(visitor);
        if(CondTerm!=null) CondTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(LogorNT!=null) LogorNT.traverseBottomUp(visitor);
        if(CondTerm!=null) CondTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AnotherCondition(\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(LogorNT!=null)
            buffer.append(LogorNT.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondTerm!=null)
            buffer.append(CondTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AnotherCondition]");
        return buffer.toString();
    }
}
