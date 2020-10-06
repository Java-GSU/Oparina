package by.gsu.pms;

public class CalculatorThread extends Thread {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[33m";
    public static final String ANSI_BLUE = "\033[1;94m";

    private long result = 0;
    private final int minValue;
    private final int maxValue;

    public long getResult() {
        return this.result;
    }

    public CalculatorThread(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public void run() {

        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " starting...");

        for (int i = this.minValue; i <= this.maxValue; i++) {

            if (isPrime(i)) {
                this.result += i;
            }
        }
        System.out.println(ANSI_BLUE + threadName + " is result " + ANSI_GREEN + this.result + ANSI_RESET);
    }


    public static boolean isPrime(int n){

        for(int i = 2; i <= n / 2; i++)
        {
            if(n % i == 0) return false;
        }
        return true;
    }

}
