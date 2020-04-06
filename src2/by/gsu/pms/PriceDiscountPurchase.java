package by.gsu.pms;

public class PriceDiscountPurchase extends AbstractPurchase {
    private Byn discount;

    public PriceDiscountPurchase(){
        this(null,0,null);
    }

    public PriceDiscountPurchase(Product product, int units, Byn discount){
        super(product, units);
        this.discount = discount;
    }

    public Byn getDiscount() {
        return discount;
    }

    public void setDiscount(Byn discount) {
        this.discount = discount;
    }

    @Override
    protected String fieldsToString() {

        return super.getUnits() + ";" + discount;
    }

    @Override
    protected Byn calculateTheCost() {

        Byn result = new Byn(getProduct().getPrice());
        result.sub(discount);
        result.mul(getUnits());
        return result;
    }
}
