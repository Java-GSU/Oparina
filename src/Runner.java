import by.gsu.pms.*;

import java.util.Scanner;

public class Runner {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLACK_BACKGROUND = "\033[1;30m";

    public static void main(String[] args) throws InterruptedException {


        Scanner scanner = new Scanner(System.in);
        System.out.println(ANSI_CYAN + "Count of threads: ");

        int countOfThreads = scanner.nextInt();
        System.out.println("Max value: ");

        int maxValue = scanner.nextInt();
        System.out.println("Choose operation '+', '-' or '*'" + ANSI_RESET);

        String operationType = scanner.next();

        OperationSign operation = OperationSign.ADDITION;

        switch (operationType){
            case "+":
                operation = OperationSign.ADDITION;
                break;
            case "-":
                operation = OperationSign.SUBTRACTION;
                break;
            case "*":
                operation = OperationSign.MULTIPLICATION;
                break;
            default:
                throw new RuntimeException("FAIL! Operation not defined!");
        }

        ThreadGenerator calculator;
        calculator = new ThreadGenerator(countOfThreads, operation, maxValue);
        calculator.execute();
        System.out.println( ANSI_BLACK_BACKGROUND + "RESULT: " + calculator.getResult() + ANSI_RESET);
        calculator.stop();
    }
}
