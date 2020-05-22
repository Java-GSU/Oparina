package by.gsu.pms;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase> {
    private final Product PRODUCT;
    private final int UNITS;

    protected AbstractPurchase(){
        this(null,0);
    }

    AbstractPurchase(Product product, int units){
        this.PRODUCT = product;
        this.UNITS = units;
    }

    Product getProduct() {
        return PRODUCT;
    }
    int getUnits() {
        return UNITS;
    }

    protected abstract Byn calculateTheCost();

    public Byn getCost(){

        return calculateTheCost().round();
    }

    protected abstract String fieldsToString();

    public String toString(){

        return fieldsToString() + ";" + getCost();
    }

    @Override
    public int compareTo(AbstractPurchase that){

        return that.getCost().compareTo(this.getCost());
    }


}
