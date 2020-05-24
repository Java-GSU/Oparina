package by.gsu.pms;

import java.util.Scanner;

import static by.gsu.pms.FormatStrings.*;

public class Purchase {

    private String name;
    private int price;
    private int numberUnits;

    public Purchase(){
        super();
    }

    public Purchase(String name, int price, int numberUnits) {
        this.name = name;
        this.price = price;
        this.numberUnits = numberUnits;

    }

    public  Purchase(Scanner sc, String name){
        this.name = sc.next();
        this.price = sc.nextInt();
        this.numberUnits = sc.nextInt();

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getNumberUnits() {
        return numberUnits;
    }
    public void setNumberUnits(int numberUnits) {
        this.numberUnits = numberUnits;
    }


    public int getCost(){
        return price * numberUnits;
    }


    @Override
    public String toString() {

        return name + "; " + price + "; "+ numberUnits + "; " + Money(getCost());
    }

    public boolean equals(Purchase purchase) {

        return (this.name.equals(purchase.name) || (this.price == purchase.price));
    }


}

