package Model.Statements;

import Model.Expressions.Expression;
import Model.PrgState;
import Model.Values.IntValue;
import Model.Values.Value;

import java.util.Dictionary;
import java.util.List;

public class PrintStatement implements IStatement {
    private Expression expression;

    public PrintStatement(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public PrgState execute(PrgState state) {
        Dictionary<String, Value> symbolTable = state.getSymbolTable();
        List<Value> output = state.getOutput();

        Value value = expression.evaluate(symbolTable);
        System.out.println(value.toString());
        output.add(new IntValue(Integer.parseInt(value.toString())));
        state.setOutput(output);

        return state;
    }

    @Override
    public String toString() {
        return "print(" + expression + ')';
    }
}
