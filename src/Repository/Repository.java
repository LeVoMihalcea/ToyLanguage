package Repository;

import Model.Exceptions.SuperCoolException;
import Model.PrgState;
import Model.Statements.IStatement;
import Model.Values.Value;

import java.io.PrintWriter;
import java.util.*;

public class Repository implements  IRepository {
    private List<PrgState> programs;
    private PrintWriter logFile;

    public PrintWriter getLogFile() {
        return logFile;
    }

    public void setLogFile(PrintWriter logFile) {
        this.logFile = logFile;
    }

    public Repository(List<PrgState> programs) {
        this.programs = programs;
    }

    @Override
    public void logProgramStateExecution(PrintWriter logFile, PrgState program)  {
        this.logFile = logFile;
        if(programs.isEmpty())
            throw new SuperCoolException("Repository is empty!");
        else {
            logFile.println("===================================");

            //EXECUTION STACK
            logFile.println("Execution Stack");
            Stack<IStatement> shallowCopy = (Stack<IStatement>) program.getExecutionStack().clone();
            StringBuilder statements = new StringBuilder();

            while(!shallowCopy.empty()){
                statements.append(shallowCopy.pop().toString()).append("\n");
            }
            logFile.println(statements);


            /*Collections.reverse(statements);
            StringBuilder stringBuilderStatements = new StringBuilder();
            for(Object var : statements){
                logFile.println(var);
            }
            logFile.println();
*/
            //SYMBOL TABLE
            logFile.println("Symbol Table");
            StringBuilder symbols = new StringBuilder();

            Dictionary<String, Value> symbolTable = program.getSymbolTable();
            Enumeration keys = program.getSymbolTable().keys();
            String current;
            while (keys.hasMoreElements()) {
                current = (String) keys.nextElement();
                symbols.append(current).append(" --> ").append(symbolTable.get(current)).append("\n");
            }
            logFile.println(symbols);

            //OUTPUT
            logFile.println("Output");
            logFile.println(program.getOutput());
        }
    }

    @Override
    public PrgState getCurrentProgram() {
        if(programs.isEmpty())
            throw new SuperCoolException("Repository is empty!");
        else{
            return programs.remove(0);
        }
    }
}
