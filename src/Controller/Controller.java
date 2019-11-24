package Controller;

import Model.Exceptions.SuperCoolException;
import Model.PrgState;
import Model.Statements.CompoundStatement;
import Model.Statements.IStatement;
import Repository.IRepository;

import java.io.PrintWriter;
import java.util.Stack;

public class Controller {
    private IRepository repo;
    private PrintWriter logFile;

    public Controller(IRepository repo) {
        this.repo = repo;
    }

    private PrgState oneStepExecution(PrgState state){
        Stack<IStatement> exeStack = state.getExecutionStack();

        if(exeStack.empty()) throw new SuperCoolException("Nothing to execute!");

        IStatement toExecute = exeStack.pop();

        return toExecute.execute(state);
    }

    public void executeEverything(){
        try {
            PrgState program = repo.getCurrentProgram();
            System.out.println(program.toString());
            if(logFile != null)  repo.logProgramStateExecution(logFile, program);
            while (!program.getExecutionStack().empty()) {
                oneStepExecution(program);
                System.out.println(program.toString());
                if(logFile != null) repo.logProgramStateExecution(logFile, program);
            }
        }
        catch(SuperCoolException sce){
            System.out.println(sce.getMessage());
        }
    }

    public PrintWriter getLogFile() {
        return logFile;
    }

    public void setLogFile(PrintWriter logFile) {
        this.logFile = logFile;
    }
}
