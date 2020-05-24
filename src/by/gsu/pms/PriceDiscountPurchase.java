package by.gsu.pms;

public class PriceDiscountPurchase extends Purchase {
    private int discount;

    public PriceDiscountPurchase(){
        this(null,0,0,0);
    }

    public PriceDiscountPurchase(String name, int price, int units, int discount){
        super(name, price, units);
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }


    @Override
    public int getCost() {
        return getPrice() * getNumberUnits() * (100- discount) / 100;
    }

    @Override
    public String toString(){
        return super.toString() + ";" + discount;
    }
}
