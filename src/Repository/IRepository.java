package Repository;

import Model.Exceptions.SuperCoolException;
import Model.PrgState;

import java.io.PrintWriter;

public interface IRepository
{
    PrgState getCurrentProgram();
    void logProgramStateExecution(PrintWriter logFile, PrgState program) throws SuperCoolException;}
