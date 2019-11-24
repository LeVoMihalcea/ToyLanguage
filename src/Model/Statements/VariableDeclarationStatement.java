package Model.Statements;

import Model.Exceptions.SuperCoolException;
import Model.PrgState;
import Model.Types.BoolType;
import Model.Types.IntType;
import Model.Types.StringType;
import Model.Types.Type;
import Model.Values.BoolValue;
import Model.Values.IntValue;
import Model.Values.StringValue;
import Model.Values.Value;

import java.util.Dictionary;
import java.util.Objects;

public class VariableDeclarationStatement implements IStatement {
    private Type type;
    private String name;
    private Value value;

    public VariableDeclarationStatement(Type type, String name, Value value) {
        this.type = type;
        this.name = name;
        this.value = value;
    }

    public VariableDeclarationStatement(Type type, String name) {
        this.type = type;
        this.name = name;
        this.value = null;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return type + " " + name;
    }

    @Override
    public PrgState execute(PrgState state) {
        Dictionary<String, Value> symbolTable = state.getSymbolTable();

        if(symbolTable.get(name)==null){
            if(type.equals(new IntType())){
                symbolTable.put(name, Objects.requireNonNullElseGet(this.value, IntValue::defaultValue));
            }
            if(type.equals(new StringType())){
                symbolTable.put(name, Objects.requireNonNullElseGet(this.value, StringValue::defaultValue));
            }
            if(type.equals(new BoolType())){
                symbolTable.put(name, Objects.requireNonNullElseGet(this.value, BoolValue::defaultValue));
            }

        }
        else {
            throw new SuperCoolException("Variable already defined!");
        }
        return state;
    }
}
