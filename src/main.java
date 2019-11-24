import Controller.Controller;
import Model.Expressions.*;
import Model.Operations.ComparisonOperation;
import Model.PrgState;
import Model.Statements.*;
import Model.Types.BoolType;
import Model.Types.IntType;
import Model.Types.StringType;
import Model.Values.BoolValue;
import Model.Values.IntValue;
import Model.Values.StringValue;
import Model.Values.Value;
import Repository.Repository;
import Repository.IRepository;
import View.Commands.ExitCommand;
import View.Commands.RunCommand;
import View.View;
import View.TextMenu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please provide a path for the log: ");
        String logFilePath = scanner.nextLine();
        PrintWriter logFile = null;
        try {
            logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
        }
        catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }

        IStatement firstProgram = generateFirstProgram();
        IStatement secondProgram = generateSecondProgram();
        IStatement thirdProgram = generateThirdProgram();
        IStatement file = generateFileProgram();
        IStatement comparison = generateComparisonProgram();

        Stack<IStatement> stack1 = new Stack<>();
        Hashtable<String, Value> symbolTable1 = new Hashtable<String, Value>();
        ArrayList<Value> output1 = new ArrayList<>();

        Stack<IStatement> stack2 = new Stack<>();
        Hashtable<String, Value> symbolTable2 = new Hashtable<String, Value>();
        ArrayList<Value> output2 = new ArrayList<>();

        Stack<IStatement> stack3 = new Stack<>();
        Hashtable<String, Value> symbolTable3 = new Hashtable<String, Value>();
        ArrayList<Value> output3 = new ArrayList<>();

        Stack<IStatement> stack4 = new Stack<>();
        Hashtable<String, Value> symbolTable4 = new Hashtable<String, Value>();
        ArrayList<Value> output4 = new ArrayList<>();

        Stack<IStatement> stack5 = new Stack<>();
        Hashtable<String, Value> symbolTable5 = new Hashtable<String, Value>();
        ArrayList<Value> output5 = new ArrayList<>();



        PrgState prgState1 = new PrgState(stack1, symbolTable1, output1, firstProgram);
        PrgState prgState2 = new PrgState(stack2, symbolTable2, output2, secondProgram);
        PrgState prgState3 = new PrgState(stack3, symbolTable3, output3, thirdProgram);
        PrgState prgState4 = new PrgState(stack4, symbolTable4, output4, file);
        PrgState prgState5 = new PrgState(stack5, symbolTable5, output5, comparison);


        ArrayList<PrgState> programs1 = new ArrayList<PrgState>();
        programs1.add(prgState1);
        programs1.add(prgState1);


        ArrayList<PrgState> programs2 = new ArrayList<PrgState>();
        programs2.add(prgState2);
        programs2.add(prgState2);


        ArrayList<PrgState> programs3 = new ArrayList<PrgState>();
        programs3.add(prgState3);
        programs3.add(prgState3);


        ArrayList<PrgState> programs4 = new ArrayList<PrgState>();
        programs4.add(prgState4);
        programs4.add(prgState4);

        ArrayList<PrgState> programs5 = new ArrayList<PrgState>();
        programs5.add(prgState5);
        programs5.add(prgState5);


        IRepository repo1 = new Repository(programs1);
        Controller ctrl1 = new Controller(repo1);
        ctrl1.setLogFile(logFile);

        IRepository repo2 = new Repository(programs2);
        Controller ctrl2 = new Controller(repo2);
        ctrl2.setLogFile(logFile);

        IRepository repo3 = new Repository(programs3);
        Controller ctrl3 = new Controller(repo3);
        ctrl3.setLogFile(logFile);

        IRepository repo4 = new Repository(programs4);
        Controller ctrl4 = new Controller(repo4);
        ctrl4.setLogFile(logFile);

        IRepository repo5 = new Repository(programs5);
        Controller ctrl5 = new Controller(repo5);
        ctrl5.setLogFile(logFile);

        //View view = new View(ctrl);
        //view.run();

        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit", logFile));
        menu.addCommand(new RunCommand("1", "print basic", ctrl1));
        menu.addCommand(new RunCommand("2", "aritmetica ", ctrl2));
        menu.addCommand(new RunCommand("3", "if statement", ctrl3));
        menu.addCommand(new RunCommand("4", "open, read, close", ctrl4));
        menu.addCommand(new RunCommand("5", "comparison", ctrl5));

        menu.show();
        //logFile.close();
    }

    private static IStatement generateComparisonProgram() {
        //int a, b; a = 3; b = 9; bool c = a <= b;
        VariableExpression variableExpressionA = new VariableExpression("a");
        IntValue intValueA = new IntValue(3);
        ValueExpression valueExpressionA = new ValueExpression(intValueA);
        AssignmentStatement assignmentStatementA = new AssignmentStatement("a", valueExpressionA);
        IntType intType = new IntType();
        VariableDeclarationStatement variableDeclarationStatementA = new VariableDeclarationStatement(intType, "a");
        CompoundStatement declareA = new CompoundStatement(variableDeclarationStatementA, assignmentStatementA);

        VariableExpression variableExpressionB = new VariableExpression("b");
        IntValue intValueB = new IntValue(9);
        ValueExpression valueExpressionB = new ValueExpression(intValueB);
        AssignmentStatement assignmentStatementB = new AssignmentStatement("b", valueExpressionB);
        VariableDeclarationStatement variableDeclarationStatementB = new VariableDeclarationStatement(intType, "b");
        CompoundStatement declareB = new CompoundStatement(variableDeclarationStatementB, assignmentStatementB);

        CompoundStatement declarationsAndB = new CompoundStatement(declareA, declareB);

        RelationalExpression relationalExpression = new RelationalExpression(variableExpressionA, ComparisonOperation.SmallerOrEqual, variableExpressionB);

        VariableExpression variableExpressionC = new VariableExpression("c");

        BoolType boolType = new BoolType();
        //ValueExpression valueExpressionC = new ValueExpression(boolValueC);
        AssignmentStatement assignmentStatementC = new AssignmentStatement("c", relationalExpression);
        VariableDeclarationStatement variableDeclarationStatementC = new VariableDeclarationStatement(boolType, "c");
        CompoundStatement declareC = new CompoundStatement(variableDeclarationStatementC, assignmentStatementC);

        CompoundStatement declarationsAandBandC = new CompoundStatement(declarationsAndB, declareC);

        return declarationsAandBandC;
    }

    private static IStatement generateFileProgram() {
        VariableExpression variableExpressionA = new VariableExpression("a");
        IntValue intValueA = new IntValue(2);
        ValueExpression valueExpressionA = new ValueExpression(intValueA);
        AssignmentStatement assignmentStatementA = new AssignmentStatement("a", valueExpressionA);
        IntType intTypeA = new IntType();
        VariableDeclarationStatement variableDeclarationStatementA = new VariableDeclarationStatement(intTypeA, "a");
        CompoundStatement declareA = new CompoundStatement(variableDeclarationStatementA, assignmentStatementA);


        VariableExpression myString = new VariableExpression("newString");
        StringValue stringValue = new StringValue("merge.txt");
        StringType stringType = new StringType();
        ValueExpression stringExpression = new ValueExpression(stringValue);
        VariableDeclarationStatement declareString = new VariableDeclarationStatement(stringType, "newString");
        AssignmentStatement assignmentStatement = new AssignmentStatement("newString", stringExpression);

        OpenReadFileStatement openFile = new OpenReadFileStatement(myString);

        CompoundStatement assignAndOpen = new CompoundStatement(assignmentStatement, openFile);
        CompoundStatement declareAndAssignAndOpen = new CompoundStatement(declareString, assignAndOpen);
        CompoundStatement declareAdeclareString = new CompoundStatement(declareA, declareAndAssignAndOpen);

        ReadFileStatement readFile = new ReadFileStatement(myString, "a");
        PrintStatement printFirstNumber = new PrintStatement(variableExpressionA);
        CompoundStatement printAfterRead = new CompoundStatement(readFile, printFirstNumber);

        ReadFileStatement readFile2 = new ReadFileStatement(myString, "a");
        PrintStatement printSecondNumber = new PrintStatement(variableExpressionA);
        CompoundStatement printAfterRead2 = new CompoundStatement(readFile2, printSecondNumber);

        CompoundStatement reads = new CompoundStatement(printAfterRead, printAfterRead2);


        CloseFileStatement closeFile = new CloseFileStatement(myString);

        CompoundStatement readAndClose = new CompoundStatement(reads, closeFile);



        return new CompoundStatement(declareAdeclareString, readAndClose);
    }

    private static IStatement generateFirstProgram(){
        //int a; a = 2;  print(a);

        VariableExpression variableExpressionA = new VariableExpression("a");
        IntValue intValueA = new IntValue(2);
        ValueExpression valueExpressionA = new ValueExpression(intValueA);
        AssignmentStatement assignmentStatementA = new AssignmentStatement("a", valueExpressionA);
        PrintStatement printA = new PrintStatement(variableExpressionA);
        CompoundStatement compoundStatementA = new CompoundStatement(assignmentStatementA, printA);
        IntType intTypeA = new IntType();
        VariableDeclarationStatement variableDeclarationStatementA = new VariableDeclarationStatement(intTypeA, "a");

//        VariableExpression myString = new VariableExpression("newString");
//        StringValue stringValue = new StringValue("merge.txt");
//        ValueExpression stringValueExpression = new ValueExpression(stringValue);
//        AssignmentStatement stringAssignmentStatement = new AssignmentStatement("newString", stringValueExpression);
//        PrintStatement printString = new PrintStatement(stringValueExpression);
//        StringType stringType = new StringType();
//        VariableDeclarationStatement stringDeclaration = new VariableDeclarationStatement(stringType, "newString");
//        CompoundStatement assignAndPrint = new CompoundStatement(stringAssignmentStatement, printString);
//
//
//
//        return new CompoundStatement(stringDeclaration, assignAndPrint);
        return new CompoundStatement(variableDeclarationStatementA, compoundStatementA);
    }


    private static IStatement generateThirdProgram() {
        //bool a; int v; a=true;(If a Then v=2 Else v=3);Print(v)
        BoolType boolType = new BoolType();
        IntType intType = new IntType();
        VariableDeclarationStatement variableDeclarationStatementA = new VariableDeclarationStatement(boolType, "a");
        VariableDeclarationStatement variableDeclarationStatementB = new VariableDeclarationStatement(intType, "v");

        CompoundStatement declaration = new CompoundStatement(variableDeclarationStatementA, variableDeclarationStatementB);

        BoolValue trueValue = new BoolValue(true);
        BoolValue falseValue = new BoolValue(false);
        IntValue intValue2 = new IntValue(2);
        IntValue intValue3 = new IntValue(3);

        ValueExpression valueExpressionTrue = new ValueExpression(trueValue);
        ValueExpression valueExpressionFalse = new ValueExpression(falseValue);
        ValueExpression valueExpression2 = new ValueExpression(intValue2);
        ValueExpression valueExpression3 = new ValueExpression(intValue3);

        AssignmentStatement assignmentStatementA = new AssignmentStatement("a", valueExpressionTrue);

        CompoundStatement initializing = new CompoundStatement(declaration, assignmentStatementA);

        AssignmentStatement ifTrue = new AssignmentStatement("v", valueExpression2);
        AssignmentStatement ifFalse = new AssignmentStatement("v", valueExpression3);

        LogicExpression condition = new LogicExpression(new VariableExpression("a"), valueExpressionTrue, 2);

        IfStatement ifStatement = new IfStatement(condition, ifTrue, ifFalse);

        CompoundStatement afterIf = new CompoundStatement(initializing, ifStatement);

        PrintStatement printStatement = new PrintStatement(new VariableExpression("v"));

        return new CompoundStatement(afterIf, printStatement);
    }

    private static IStatement generateSecondProgram() {
        //int a;int b; a=2+3*5;b=a+1;Print(b)
        IntType intType = new IntType();
        VariableDeclarationStatement variableDeclarationStatementA = new VariableDeclarationStatement(intType, "a");
        VariableDeclarationStatement variableDeclarationStatementB = new VariableDeclarationStatement(intType, "b");

        IntValue intValue1 = new IntValue(1);
        IntValue intValue2 = new IntValue(2);
        IntValue intValue3 = new IntValue(3);
        IntValue intValue5 = new IntValue(5);

        ValueExpression valueExpression1 = new ValueExpression(intValue1);
        ValueExpression valueExpression2 = new ValueExpression(intValue2);
        ValueExpression valueExpression3 = new ValueExpression(intValue3);
        ValueExpression valueExpression5 = new ValueExpression(intValue5);

        ArithmeticExpression inmultire = new ArithmeticExpression(valueExpression3, valueExpression5, 3);
        ArithmeticExpression adunare = new ArithmeticExpression(inmultire, valueExpression2, 1);

        CompoundStatement declaratie = new CompoundStatement(variableDeclarationStatementA, variableDeclarationStatementB);

        AssignmentStatement assignmentStatementA = new AssignmentStatement("a", adunare);

        ArithmeticExpression adunareAsiB = new ArithmeticExpression(adunare, valueExpression1, 1);

        AssignmentStatement assignmentStatementB = new AssignmentStatement("b", adunareAsiB);

        CompoundStatement afterDoingTheFancyMath = new CompoundStatement(declaratie, new CompoundStatement(assignmentStatementA, assignmentStatementB));

        VariableExpression variableExpressionB = new VariableExpression("b");
        PrintStatement printStatementB = new PrintStatement(variableExpressionB);

        return new CompoundStatement(afterDoingTheFancyMath, printStatementB);
    }
}
