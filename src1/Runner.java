import by.gsu.pms.Purchase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

import static by.gsu.pms.FormatStrings.Money;

public class Runner {
    public static void main (String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader("src\\in.txt"));
            sc.useLocale(Locale.ENGLISH);
            int PURCHASES_NUMBER = sc.nextInt();
            Purchase purchase = new Purchase();
            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];

            for(int i = 0; i < PURCHASES_NUMBER; i++){
                purchases[i] = new Purchase(sc);
            }

            System.out.println("Name; Price; Units; Cost");
            printPurchases(purchases);
            System.out.println("\n");

            int totalCost = 0;
            int maxCost = 0;

            for (Purchase purch: purchases) {

                if(purch.getCost() > maxCost){
                    maxCost = purch.getCost();

                }
                totalCost += purch.getCost();
            }

            System.out.println("The total cost: " + Money(totalCost));

            Purchase purchase1 = new Purchase("Milk", 2,  5);
            for(Purchase purchas:purchases) {
                System.out.println(purchase1.equals(purchas));
            }



        }
        catch(FileNotFoundException ex) {
            System.out.println("File was not found");
        }
        finally {
            if(sc != null) {
                sc.close();
            }
        }
    }

    private static void printPurchases(Purchase[] purchases) {

        for(Purchase purchase:purchases) {
            System.out.println(purchase);
        }
    }
}

