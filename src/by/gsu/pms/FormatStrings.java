package by.gsu.pms;

import java.text.DecimalFormat;

public class FormatStrings {

    public static String Money(int value) {

        double money = Double.parseDouble((value / 10000) + "." + (value % 10000)/1000 + value%1000);
        return new DecimalFormat("#0.00").format(money);
    }

    public Purchase Factory(String str){
        String[] item = str.split(" ");
        switch (item[0]){
            case ("Purchase"):
                return new Purchase(item[1], (int) Double.parseDouble(item[2]), Integer.parseInt(item[3]));
            case ("Discount"):
                return new PriceDiscountPurchase(item[1], (int) Double.parseDouble(item[2]), Integer.parseInt(item[3]),
                        Integer.parseInt(item[4]));

        }
        return null;
    }

}
