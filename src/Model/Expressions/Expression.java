package Model.Expressions;

import Model.Values.Value;

import java.util.Dictionary;

public interface Expression {
    Value evaluate(Dictionary<String, Value> table);
    String toString();
}
