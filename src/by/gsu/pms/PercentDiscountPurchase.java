package by.gsu.pms;

public class PercentDiscountPurchase extends Purchase {

    private double percent;

    private int unitsDiscount;
    private int discount ;

    public PercentDiscountPurchase(String name, int price, int units, int unitsForDiscount, int discount) {
        super(name, price, units);
        this.unitsDiscount = unitsForDiscount;
        this.discount = discount;
    }

    public int getUnitsForDiscount() {
        return unitsDiscount;
    }
    public void setUnitsForDiscount(int unitsForDiscount) {
        this.unitsDiscount = unitsForDiscount;
    }
    public int getDiscount() {
        return discount;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public int getCost() {
        if (getNumberUnits() > unitsDiscount){
            return getPrice() * getNumberUnits() * (100- discount) / 100;
        } else {
            return getPrice() * getNumberUnits();
        }
    }

    @Override
    public String toString(){
        return super.toString() + ";" + unitsDiscount + ";" + discount;
    }
}
