package by.gsu.pms;

public class Util {
    public static String convertMoney(int value) {
        return (value / 100) + "." + (value % 100)/10 + value%10;
    }
}
