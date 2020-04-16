package by.gsu.pms;

import java.text.DecimalFormat;

public class Util {
    public static String convertMoney(int value) {

        double money = Double.parseDouble((value / 10000) + "." + (value % 10000)/1000 + value%1000);
        return new DecimalFormat("#0.00").format(money);
    }

    public Util() {
    }

    public static BusinessTrip getElement(BusinessTrip trip, String str, String element) {
        return Util.Elements.valueOf(str).setElement(trip, element);
    }

    public static enum Elements {
        ACCOUNT {
            BusinessTrip setElement(BusinessTrip trip, String str) {
                trip.setAccount(str);
                return trip;
            }
        },
        TRANSPORT {
            BusinessTrip setElement(BusinessTrip trip, String str) {
                trip.setTransport(Integer.parseInt(str));
                return trip;
            }
        },
        DAYS {
            BusinessTrip setElement(BusinessTrip trip, String str) {
                trip.setDays(Integer.parseInt(str));
                return trip;
            }
        };

        private Elements() {
        }

        abstract BusinessTrip setElement(BusinessTrip var1, String var2);
    }
}
