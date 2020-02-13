package by.gsu.pms;

public class BusinessTrip {

    private static final int RATE = 25000;
    private String account;
    private int transport;
    private int days;

    public BusinessTrip(){

    }

    public BusinessTrip(String account, int transport, int days){
        this.account = account;
        this.transport = transport;
        this.days = days;
    }

    public int getTransport() {
        return transport;
    }
    public void setTransport(int transport) {
        this.transport = transport;
    }
    public int getDays() {
        return days;
    }
    public void setDays(int days) {
        this.days = days;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }

    private int getTotal(){
        return (transport + RATE * days);
    }

    public void show(){
        System.out.println("rate = " + convertMoney(RATE));
        System.out.println("account = " + account);
        System.out.println("transport = " + convertMoney(transport));
        System.out.println("days = " + days);
        System.out.println("total = " + convertMoney(getTotal()));
    }

    public String toString() {
        return account + ";" + convertMoney(transport) + ";" + days + ";" + convertMoney(getTotal());
    }

    private static String convertMoney(int value) {
        return (value / 100) + "." + (value % 100)/10 + value%10;
    }
}




