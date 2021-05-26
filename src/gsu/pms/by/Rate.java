package gsu.pms.by;

public class Rate {
    private String name;
    private String currency;
    private String units;
    private String buy;
    private String sell;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }


    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }



    @Override
    public String toString() {
            return "name = " + name + ", " +
                    "currency = " + currency + ", " +
                    "units = " + units + ", " +
                    "buy = " + buy + ", " +
                    "sell = " + sell + "\n";

    }
}
