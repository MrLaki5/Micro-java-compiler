// generated with ast extension for cup
// version 0.8
// 1/1/2018 8:41:40


package rs.ac.bg.etf.pp1.ast;

public class BooleanValue extends ConstValue {

    private String valueType;

    public BooleanValue (String valueType) {
        this.valueType=valueType;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
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
        buffer.append("BooleanValue(\n");

        buffer.append(" "+tab+valueType);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BooleanValue]");
        return buffer.toString();
    }
}
