import by.gsu.pms.FormatStrings;
import by.gsu.pms.Purchase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static by.gsu.pms.FormatStrings.Money;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException {

        Purchase[] purchases = new Purchase[6];
        FileReader file = new FileReader("src/in.txt");

        Scanner scan = new Scanner(file);

        double maxCost = 0;
        Purchase maxPurchase = new Purchase();

        for (int i = 0; i < purchases.length; i++) {
            Purchase purchase = purchases[i];
            String st = scan.nextLine();

            purchases[i] = new FormatStrings().Factory(st);


            System.out.println(purchases[i]);


            if (purchases[i].getCost() > maxCost) {
                maxCost = purchases[i].getCost();
                maxPurchase = purchases[i];
            }


            for (int j = 0; j < i; j++) {
                if (purchases[i] == purchases[j]) {
                    System.out.println(purchases[i]);
                }
            }
        }


        System.out.println("Max cost: " + maxPurchase);
    }

}