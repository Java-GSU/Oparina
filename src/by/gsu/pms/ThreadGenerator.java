package by.gsu.pms;

public class ThreadGenerator {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_GREEN = "\u001B[32m";

    private CalculatorThread[] threads;
    private final OperationSign operationSign;

    public ThreadGenerator(int countOfThreads, OperationSign operationSign, int maxValue) {
        this.operationSign = operationSign;

        System.out.println(ANSI_PURPLE + " Count of threads: " + ANSI_GREEN + countOfThreads + ANSI_RESET +
                ANSI_PURPLE + "\n Max value: " + ANSI_GREEN + maxValue + ANSI_RESET +
                ANSI_PURPLE + "\n Operation: " + ANSI_GREEN + operationSign + ANSI_RESET);

        if (maxValue > countOfThreads) {
            CalculatorThread[] arrayThreads = new CalculatorThread[countOfThreads];

            int threadCapacity = maxValue / countOfThreads;
            for (int i = 0; i < countOfThreads; i++) {

                int startThead = i * threadCapacity + 1;
                int endThead = i * threadCapacity + threadCapacity;

                arrayThreads[i] = new CalculatorThread(startThead, endThead);
            }
            this.threads = arrayThreads;
        } else {
            System.out.println("Error maxValue must be greater than countOfThreads!");
        }
    }

    public void execute() {
        for (CalculatorThread thread: this.threads){
            thread.start();
        }
    }

    public int getResult() throws InterruptedException {
        int result = operationSign.ordinal() < 2 ? 0 : 1;
        for (CalculatorThread thread: this.threads){
            thread.join();
            switch (this.operationSign.ordinal()){
                case (0):
                    result += thread.getResult();
                    break;
                case (1):
                    result -= thread.getResult();
                    break;
                case (2):
                    result *= thread.getResult();
                    break;
                default:
                    throw new RuntimeException("Operation not exist!");
            }
        }
        return result;
    }

   // public void close() {

  //  }
}
