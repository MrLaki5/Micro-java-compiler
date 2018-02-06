// generated with ast extension for cup
// version 0.8
// 6/1/2018 17:30:52


package rs.ac.bg.etf.pp1.ast;

public class IntegerValue extends ConstValue {

    private Integer valueType;

    public IntegerValue (Integer valueType) {
        this.valueType=valueType;
    }

    public Integer getValueType() {
        return valueType;
    }

    public void setValueType(Integer valueType) {
        this.valueType=valueType;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IntegerValue(\n");

        buffer.append(" "+tab+valueType);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IntegerValue]");
        return buffer.toString();
    }
}
