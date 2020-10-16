package by.gsu.pms;

public class PricePurchase extends Purchase {

    private int discount;

    public PricePurchase(String Name, int Cost, int Count, int discount) {
        super(Name, Cost, Count);
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String toString(){
        return super.toString() + " Discount: "+ discount;
    }

    public int PriceGet(){

        return (getCost() - discount) * getCount();
    }

}
