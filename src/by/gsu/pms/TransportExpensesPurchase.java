package by.gsu.pms;

public class TransportExpensesPurchase extends AbstractPurchase {
    private Byn transportExpenses;

    public TransportExpensesPurchase(){
        this(null,0,null);
    }

    public TransportExpensesPurchase(Product product, int units, Byn transportExpenses){
        super(product, units);
        this.transportExpenses = transportExpenses;
    }


    public Byn getTransportExpenses() {
        return transportExpenses;
    }


    @Override
    protected String fieldsToString() {

        return super.getUnits() + ";" + transportExpenses;
    }

    @Override
    protected Byn calculateTheCost() {

        Byn result = new Byn(getProduct().getPrice());
        result.mul(getUnits());
        result.add(transportExpenses);
        return result;
    }
}
