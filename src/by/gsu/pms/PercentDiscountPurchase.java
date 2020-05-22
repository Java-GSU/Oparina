package by.gsu.pms;

public class PercentDiscountPurchase extends AbstractPurchase {
    private final static int MIN_UNITS_FOR_DISCOUNT = 15;
    private double percent;

    public PercentDiscountPurchase(){
        this(null,0,0.0);
    }

    public PercentDiscountPurchase(Product product, int units, double percent){
        super(product, units);
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }

    @Override
    protected String fieldsToString() {

        return super.getUnits() + ";" + percent;
    }

    @Override
    protected Byn calculateTheCost() {

        Byn result = new Byn(getProduct().getPrice());
        result.mul(getUnits());
        if(getUnits() > MIN_UNITS_FOR_DISCOUNT){
            result.mul(1 - percent / 100);
        }
        return result;
    }
}
