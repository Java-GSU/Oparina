package gsu.pms.by;

public class RateWithCurrency {
    private Rates rates = new Rates();

    public static class Rates {
        private String value;
        private String currency;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }

    public Rates getRates() {
        return rates;
    }

    @Override
    public String toString() {
        return "Обмен валют = " + rates.getCurrency().toUpperCase() + " (" + rates.getValue() + ")\n";

    }
}
