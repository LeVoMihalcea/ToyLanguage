import Controller.Controller;
import Model.Expressions.*;
import Model.Operations.ComparisonOperation;
import Model.PrgState;
import Model.Statements.*;
import Model.Types.BoolType;
import Model.Types.IntType;
import Model.Types.RefType;
import Model.Types.StringType;
import Model.Values.BoolValue;
import Model.Values.IntValue;
import Model.Values.StringValue;
import Model.Values.Value;
import Repository.Repository;
import Repository.IRepository;
import View.Commands.ExitCommand;
import View.Commands.RunCommand;
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
        if(logFilePath.equals(""))
            logFilePath = "log.log";
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
        IStatement newStatement = generateNewProgram();
        IStatement whileProgram = generateWhileProgram();
        IStatement garbageCollector = generateGarbageCollectorProgram();
        IStatement safeGarbageCollector = generateSafeGarbageCollector();
        IStatement fork = generateForkProgram();

        Stack<IStatement> stack1 = new Stack<>();
        HashMap<String, Value> symbolTable1 = new HashMap<>();
        ArrayList<Value> output1 = new ArrayList<>();
        HashMap<Integer, Value> heap1 = new HashMap<>();

        Stack<IStatement> stack2 = new Stack<>();
        HashMap<String, Value> symbolTable2 =new HashMap<>();
        ArrayList<Value> output2 = new ArrayList<>();
        HashMap<Integer, Value> heap2 = new HashMap<>();

        Stack<IStatement> stack3 = new Stack<>();
        HashMap<String, Value> symbolTable3 =new HashMap<>();
        ArrayList<Value> output3 = new ArrayList<>();
        HashMap<Integer, Value> heap3 = new HashMap<>();

        Stack<IStatement> stack4 = new Stack<>();
        HashMap<String, Value> symbolTable4 = new HashMap<>();
        ArrayList<Value> output4 = new ArrayList<>();
        HashMap<Integer, Value> heap4 = new HashMap<>();

        Stack<IStatement> stack5 = new Stack<>();
        HashMap<String, Value> symbolTable5 =new HashMap<>();
        ArrayList<Value> output5 = new ArrayList<>();
        HashMap<Integer, Value> heap5 = new HashMap<>();

        Stack<IStatement> stack6 = new Stack<>();
        HashMap<String, Value> symbolTable6 =new HashMap<>();
        ArrayList<Value> output6 = new ArrayList<>();
        HashMap<Integer, Value> heap6 = new HashMap<>();

        Stack<IStatement> stack7 = new Stack<>();
        HashMap<String, Value> symbolTable7 =new HashMap<>();
        ArrayList<Value> output7 = new ArrayList<>();
        HashMap<Integer, Value> heap7 = new HashMap<>();

        Stack<IStatement> stack8 = new Stack<>();
        HashMap<String, Value> symbolTable8 =new HashMap<>();
        ArrayList<Value> output8 = new ArrayList<>();
        HashMap<Integer, Value> heap8 = new HashMap<>();
        
        Stack<IStatement> stack9 = new Stack<>();
        HashMap<String, Value> symbolTable9 = new HashMap<>();
        ArrayList<Value> output9 = new ArrayList<>();
        HashMap<Integer, Value> heap9 = new HashMap<>();


        Stack<IStatement> stack10 = new Stack<>();
        HashMap<String, Value> symbolTable10 = new HashMap<>();
        ArrayList<Value> output10 = new ArrayList<>();
        HashMap<Integer, Value> heap10 = new HashMap<>();


        PrgState prgState1 = new PrgState(stack1, symbolTable1, output1, heap1, firstProgram);
        PrgState prgState2 = new PrgState(stack2, symbolTable2, output2, heap2, secondProgram);
        PrgState prgState3 = new PrgState(stack3, symbolTable3, output3, heap3, thirdProgram);
        PrgState prgState4 = new PrgState(stack4, symbolTable4, output4, heap4, file);
        PrgState prgState5 = new PrgState(stack5, symbolTable5, output5, heap5, comparison);
        PrgState prgState6 = new PrgState(stack6, symbolTable6, output6, heap6, newStatement);
        PrgState prgState7 = new PrgState(stack7, symbolTable7, output7, heap7, whileProgram);
        PrgState prgState8 = new PrgState(stack8, symbolTable8, output8, heap8, garbageCollector);
        PrgState prgState9 = new PrgState(stack9, symbolTable9, output9, heap9, safeGarbageCollector);
        PrgState prgState10 = new PrgState(stack10, symbolTable10, output10, heap10, fork);


        ArrayList<PrgState> programs1 = new ArrayList<>();
        programs1.add(prgState1);
//        programs1.add(prgState1);


        ArrayList<PrgState> programs2 = new ArrayList<>();
        programs2.add(prgState2);
//        programs2.add(prgState2);


        ArrayList<PrgState> programs3 = new ArrayList<>();
        programs3.add(prgState3);
//        programs3.add(prgState3);


        ArrayList<PrgState> programs4 = new ArrayList<>();
        programs4.add(prgState4);
//        programs4.add(prgState4);

        ArrayList<PrgState> programs5 = new ArrayList<>();
        programs5.add(prgState5);
//        programs5.add(prgState5);

        ArrayList<PrgState> programs6 = new ArrayList<>();
        programs6.add(prgState6);
        //programs6.add(prgState6);

        ArrayList<PrgState> programs7 = new ArrayList<>();
        programs7.add(prgState7);
//        programs7.add(prgState7);

        ArrayList<PrgState> programs8 = new ArrayList<>();
        programs8.add(prgState8);
//        programs8.add(prgState8);

        ArrayList<PrgState> programs9 = new ArrayList<>();
        programs9.add(prgState9);
//        programs9.add(prgState9);

        ArrayList<PrgState> programs10 = new ArrayList<>();
        programs10.add(prgState10);
//        programs10.add(prgState10);


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

        IRepository repo6 = new Repository(programs6);
        Controller ctrl6 = new Controller(repo6);
        ctrl6.setLogFile(logFile);

        IRepository repo7 = new Repository(programs7);
        Controller ctrl7 = new Controller(repo7);
        ctrl7.setLogFile(logFile);

        IRepository repo8 = new Repository(programs8);
        Controller ctrl8 = new Controller(repo8);
        ctrl8.setLogFile(logFile);

        IRepository repo9 = new Repository(programs9);
        Controller ctrl9 = new Controller(repo9);
        ctrl9.setLogFile(logFile);

        IRepository repo10 = new Repository(programs10);
        Controller ctrl10 = new Controller(repo10);
        ctrl10.setLogFile(logFile);


        //View view = new View(ctrl);
        //view.run();

        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit", logFile));
        menu.addCommand(new RunCommand("1", "print basic", ctrl1));
        menu.addCommand(new RunCommand("2", "aritmetica ", ctrl2));
        menu.addCommand(new RunCommand("3", "if statement", ctrl3));
        menu.addCommand(new RunCommand("4", "open, read, close", ctrl4));
        menu.addCommand(new RunCommand("5", "comparison", ctrl5));
        menu.addCommand(new RunCommand("6", "new", ctrl6));
        menu.addCommand(new RunCommand("7", "while", ctrl7));
        menu.addCommand(new RunCommand("8", "garbage collector", ctrl8));
        menu.addCommand(new RunCommand("9", "safe garbage collector", ctrl9));
        menu.addCommand(new RunCommand("10", "fork", ctrl10));

        menu.show();
        //logFile.close();
    }

    private static IStatement generateForkProgram() {
        // int v; Ref int a; v=10;new(a,22);
        // fork(wH(a,30);v=32;print(v);print(rH(a)));
        // print(v);print(rH(a))

        // int v; Ref int a; v=10;new(a,22);
        IntValue intValue30 = new IntValue(30);
        IntValue intValue10 = new IntValue(10);
        IntValue intValue22 = new IntValue(22);
        IntValue intValue32 = new IntValue(32);
        VariableExpression variableExpressionV = new VariableExpression("v");
        VariableExpression variableExpressionA = new VariableExpression("a");
        ValueExpression valueExpression10 = new ValueExpression(intValue10);
        ValueExpression valueExpression30 = new ValueExpression(intValue30);
        ValueExpression valueExpression22 = new ValueExpression(intValue22);
        ValueExpression valueExpression32 = new ValueExpression(intValue32);
        IntType intType = new IntType();
        RefType refType = new RefType(new IntType());
        VariableDeclarationStatement variableDeclarationStatementV = new VariableDeclarationStatement(intType, "v");
        VariableDeclarationStatement variableDeclarationStatementA = new VariableDeclarationStatement(refType, "a");
        CompoundStatement declarations = new CompoundStatement(variableDeclarationStatementA, variableDeclarationStatementV);
        AssignmentStatement assignmentStatementv10 = new AssignmentStatement("v", valueExpression10);
        NewStatement newStatementA22 = new NewStatement("a", valueExpression22);
        CompoundStatement assignments = new CompoundStatement(assignmentStatementv10, newStatementA22);
        CompoundStatement firstLine = new CompoundStatement(declarations, assignments);

//        fork(wH(a,30);v=32;print(v);print(rH(a)));
        WriteHeapStatement writeHeapStatementA30 = new WriteHeapStatement("a", valueExpression30);
        AssignmentStatement assignmentStatementv32 = new AssignmentStatement("v", valueExpression32);
        PrintStatement printStatementV = new PrintStatement(variableExpressionV);
        PrintStatement printStatementrhA = new PrintStatement(new ReadHeapExpression(variableExpressionA));

        ForkStatement forkStatement = new ForkStatement(
                new CompoundStatement( writeHeapStatementA30,
                        new CompoundStatement(assignmentStatementv32,
                                new CompoundStatement(printStatementV, printStatementrhA))));

        // print(v);print(rH(a))
        PrintStatement printStatementV2 = new PrintStatement(variableExpressionV);
        PrintStatement printStatementrhA2 = new PrintStatement(new ReadHeapExpression(variableExpressionA));
        CompoundStatement thirdLine = new CompoundStatement(printStatementV2, printStatementrhA2);

        CompoundStatement firstTwoLines = new CompoundStatement(firstLine, forkStatement);
        return new CompoundStatement(firstTwoLines, thirdLine);
    }

    private static IStatement generateSafeGarbageCollector() {
        RefType refTypeV = new RefType(new IntType());
        VariableDeclarationStatement variableDeclarationStatementV =
                new VariableDeclarationStatement(refTypeV, "v");

        IntValue intValue20 = new IntValue(20);
        ValueExpression valueExpression20 = new ValueExpression(intValue20);
        VariableExpression variableExpressionV = new VariableExpression("v");
        NewStatement newStatement20 = new NewStatement("v", valueExpression20);

        CompoundStatement declareAndNewV = new CompoundStatement(variableDeclarationStatementV, newStatement20);

        RefType refTypeA = new RefType(new RefType(new IntType()));

        VariableDeclarationStatement variableDeclarationStatementA =
                new VariableDeclarationStatement(refTypeA, "a");

        CompoundStatement declareVandA = new CompoundStatement(declareAndNewV, variableDeclarationStatementA);

        NewStatement newAprimesteV = new NewStatement("a", variableExpressionV);

        IntValue intValue30 = new IntValue(30);
        ValueExpression valueExpression30 = new ValueExpression(intValue30);

        NewStatement newVprimeste30 = new NewStatement("v", valueExpression30);

        CompoundStatement celeDouaNewuri = new CompoundStatement(newAprimesteV, newVprimeste30);

        VariableExpression variableExpressionA = new VariableExpression("a");
        PrintStatement printStatement = new PrintStatement(new ReadHeapExpression(new ReadHeapExpression(variableExpressionA)));

        return new CompoundStatement(new CompoundStatement(declareVandA, celeDouaNewuri), printStatement);
    }

    private static IStatement generateGarbageCollectorProgram() {
        //ref int a; new(a, 10); new(a, 20);

        IntValue intValue10 = new IntValue(10);
        ValueExpression valueExpression10 = new ValueExpression(intValue10);
        RefType refTypeA = new RefType(new IntType());
        VariableDeclarationStatement variableDeclarationStatementA =
                new VariableDeclarationStatement(refTypeA, "a");

        IntValue intValue20 = new IntValue(20);
        ValueExpression valueExpression20 = new ValueExpression(intValue20);

        NewStatement newStatement10 = new NewStatement("a", valueExpression10);

        NewStatement newStatement20 = new NewStatement("a", valueExpression20);
        
        return new CompoundStatement(
                new CompoundStatement(variableDeclarationStatementA, newStatement10), newStatement20);
        
    }

    private static IStatement generateWhileProgram() {
        //int a = 45; while(a<=50){print(a); a=a+1;}
        IntValue intValue45 = new IntValue(45);
        ValueExpression valueExpression45 = new ValueExpression(intValue45);
        IntType intType = new IntType();
        VariableExpression variableExpressionA = new VariableExpression("a");
        VariableDeclarationStatement variableDeclarationStatementA = new VariableDeclarationStatement(intType, "a");
        AssignmentStatement assignmentStatementA = new AssignmentStatement("a", valueExpression45);
        CompoundStatement declareAndAssignA = new CompoundStatement(variableDeclarationStatementA, assignmentStatementA);

        ValueExpression valueExpression50 = new ValueExpression(new IntValue(50));

        RelationalExpression relationalExpression = new RelationalExpression(variableExpressionA, ComparisonOperation.SmallerOrEqual, valueExpression50);

        PrintStatement printStatement = new PrintStatement(variableExpressionA);
        ArithmeticExpression incrementA = new ArithmeticExpression(variableExpressionA, new ValueExpression(new IntValue(1)), 1);
        AssignmentStatement assignIncrementedA = new AssignmentStatement("a", incrementA);
        CompoundStatement toRepeat = new CompoundStatement(printStatement, assignIncrementedA);

        WhileStatement whileStatement = new WhileStatement(relationalExpression, toRepeat);

        return new CompoundStatement(declareAndAssignA, whileStatement);
    }

    private static IStatement generateNewProgram() {
        //Ref(int) b; new(b, 2); Ref(ref(int)) a; new(a, b)p
        IntValue intValueB = new IntValue(2);
        ValueExpression valueExpressionB = new ValueExpression(intValueB);
        IntType intTypeB = new IntType();
        RefType refType = new RefType(intTypeB);
        VariableDeclarationStatement variableDeclarationStatementB = new VariableDeclarationStatement(refType, "b");

        NewStatement newStatementB = new NewStatement("b", valueExpressionB);
        VariableExpression variableExpressionB = new VariableExpression("b");
        CompoundStatement gataB = new CompoundStatement(variableDeclarationStatementB, newStatementB);

        RefType refType1 = new RefType(refType);
        VariableExpression variableExpressionA = new VariableExpression("a");
        VariableDeclarationStatement variableDeclarationStatementA = new VariableDeclarationStatement(refType1, "a");
        NewStatement newStatementA = new NewStatement("a", variableExpressionB);
        CompoundStatement gataA = new CompoundStatement(variableDeclarationStatementA, newStatementA);

        VariableExpression variableExpressionC = new VariableExpression("c");
        ReadHeapExpression readHeapExpression = new ReadHeapExpression(new ReadHeapExpression(variableExpressionA));
        AssignmentStatement assignmentStatementC = new AssignmentStatement("c", readHeapExpression);
        IntType intTypeA = new IntType();
        VariableDeclarationStatement variableDeclarationStatementC = new VariableDeclarationStatement(intTypeA, "c");

        CompoundStatement declareAndReadC = new CompoundStatement(variableDeclarationStatementC, assignmentStatementC);
        CompoundStatement AandB = new CompoundStatement(gataB, gataA);


        return new CompoundStatement(AandB, declareAndReadC);
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
