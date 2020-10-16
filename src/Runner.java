import by.gsu.pms.PricePurchase;
import by.gsu.pms.Purchase;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Collections;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ArrayList;

public class Runner {

    public static final String BLUE_UNDERLINED = "\033[4;34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String CYAN = "\033[0;36m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static void main(String[] args) throws IOException {

        String lineCsv;
        ArrayList<Purchase> purchases = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/collection.csv"));

        while ((lineCsv = bufferedReader.readLine()) != null) {

            String[] paramsCsv = lineCsv.split("-");

            switch (paramsCsv.length){
                case 3:
                    purchases.add(new Purchase(paramsCsv[0], Integer.parseInt(paramsCsv[1]), Integer.parseInt(paramsCsv[2])));
                    break;
                case 4:
                    purchases.add(new PricePurchase(paramsCsv[0], Integer.parseInt(paramsCsv[1]), Integer.parseInt(paramsCsv[2]),
                            Integer.parseInt(paramsCsv[3])));
                    break;
            }
        }
        bufferedReader.close();



        for (Purchase purchase: purchases){

            System.out.println( CYAN + purchase.toString() );
        }

        System.out.println(ANSI_GREEN + "Index 6:  " + purchases.get(6).toString());


        purchases.removeIf(purchase -> purchase.PriceGet() < 10000);

        Collections.sort(purchases);


        for (Purchase purchase: purchases){
            System.out.println(ANSI_PURPLE + purchase.toString());
        }

        Comparator<Purchase> compare = Comparator.comparingInt(Purchase::getCost);

        int index = Collections.binarySearch(purchases, new Purchase("", 58000, 0), compare);

        System.out.println(BLUE_UNDERLINED + "Index: " + index);
    }
}
