package by.gsu.pms;

public class Product {
    private final String NAME;
    private final Byn PRICE;

    public Product(){
        this(null,null);
    }

    public Product(String name, Byn price){
        NAME = name;
        PRICE = price;
    }

    public String getName() {
        return NAME;
    }

    Byn getPrice() {
        return PRICE;
    }

    public String toString(){

        return NAME + ";" + PRICE;
    }
}
