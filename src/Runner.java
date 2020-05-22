import by.gsu.pms.*;

import java.util.*;

public class Runner {

    public static void main(String[] args) {
        Product product = new Product("PEN", new Byn(5000));
        AbstractPurchase[] purchases = {
                new PercentDiscountPurchase(product,300,1.5),
                new PriceDiscountPurchase(product,20,new Byn(50)),
                new TransportExpensesPurchase(product,220,new Byn(250)),
                new PercentDiscountPurchase(product,500,10.5),
                new PriceDiscountPurchase(product,150,new Byn(15)),
                new TransportExpensesPurchase(product,1,new Byn(50))};
        System.out.println("Array " + product);
        System.out.println("Units;Percent;Cost");
        showPurchasesArray(purchases);

        Arrays.sort(purchases,AbstractPurchase::compareTo);
        System.out.println("Array After Sorting");

        showPurchasesArray(purchases);

        Byn minCost = purchases[0].getCost();

        for (AbstractPurchase purchase : purchases) {
            if (purchase.getCost().compareTo(minCost) < 0) {
                minCost = purchase.getCost();
            }
        }
        System.out.println("Minimum Cost is = " + minCost);

    }

    private static void showPurchasesArray(AbstractPurchase[] purchases){

        for(AbstractPurchase purchase:purchases){
            System.out.println(purchase);
        }
    }
}
