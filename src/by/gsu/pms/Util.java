package by.gsu.pms;

import java.util.Arrays;
import java.text.DecimalFormat;
import java.util.Comparator;

public class Util {

    public static String convertPopulation(int value) {

        double city = Double.parseDouble((value / 1000000) + "." + (value % 1000000)/100000 + value%100000);
        return new DecimalFormat("#0.00").format(city);
    }

    public static String convertArea(int value) {

        double area = Double.parseDouble((value / 10) + "." + value%10);
        return new DecimalFormat("#0.0").format(area);
    }

    public static City[] get_sorted_purchase_by_name(City[] array) {

        Arrays.sort(array, Comparator.comparing(City::getNameCity));
        return array;
    }

}
