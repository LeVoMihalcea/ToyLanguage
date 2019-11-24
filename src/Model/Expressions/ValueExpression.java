package Model.Expressions;

import Model.Values.Value;

import java.util.Dictionary;

public class ValueExpression implements Expression {
    private Value value;

    public ValueExpression(Value value) {
        this.value = value;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public Value evaluate(Dictionary<String, Value> table) {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
