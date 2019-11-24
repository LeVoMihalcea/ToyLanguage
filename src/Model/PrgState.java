package Model;

import Model.Statements.IStatement;
import Model.Values.Value;

import java.io.BufferedReader;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Stack;

public class PrgState {
    private Stack<IStatement> executionStack;
    private Dictionary<String, Value> symbolTable;
    private List<Value> output;
    private Dictionary<String, BufferedReader> fileTable;



    public PrgState(Stack<IStatement> executionStack, Dictionary<String, Value> symbolTable, List<Value> output, Dictionary<String, BufferedReader> fileTable, IStatement program) {
        this.executionStack = executionStack;
        this.symbolTable = symbolTable;
        this.fileTable = fileTable;
        this.output = output;
        executionStack.push(program);
    }

    public PrgState(Stack<IStatement> executionStack, Dictionary<String, Value> symbolTable, List<Value> output, IStatement program) {
        this.executionStack = executionStack;
        this.symbolTable = symbolTable;
        this.fileTable = new Hashtable<>();
        this.output = output;
        executionStack.push(program);
    }

    public Dictionary<String, Value> getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(Dictionary<String, Value> symbolTable) {
        this.symbolTable = symbolTable;
    }

    public Stack<IStatement> getExecutionStack() {
        return executionStack;
    }

    public void setExecutionStack(Stack<IStatement> executionStack) {
        this.executionStack = executionStack;
    }

    public List<Value> getOutput() {
        return output;
    }

    public void setOutput(List<Value> output) {
        this.output = output;
    }

    public Dictionary<String, BufferedReader> getFileTable() {
        return fileTable;
    }

    public void setFileTable(Dictionary<String, BufferedReader> fileTable) {
        this.fileTable = fileTable;
    }

    @Override
    public String toString() {
        StringBuilder stackString = new StringBuilder();
        for(IStatement iStatement : executionStack){
            stackString.append(iStatement).append(';');
        }
        return  "{" + stackString + "} - " +
                "{" + symbolTable + "} - " +
                "{" + output + "} - " +
                "{" + fileTable + "}";
    }
}
