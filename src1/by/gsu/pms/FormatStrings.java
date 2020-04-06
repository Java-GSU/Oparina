package by.gsu.pms;

import java.text.DecimalFormat;

public class FormatStrings {

    public static String Money(int value) {

        double money = Double.parseDouble((value / 10000) + "." + (value % 10000)/1000 + value%1000);
        return new DecimalFormat("#0.00").format(money);
    }

}
