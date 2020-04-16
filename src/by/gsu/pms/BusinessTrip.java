package by.gsu.pms;

import static by.gsu.pms.Util.*;

public class BusinessTrip implements Comparable<BusinessTrip>{

    private static final int RATE = Runner.getRate();
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
        return this.transport;
    }

    public void setTransport(int transportExpenses) {
        this.transport = transportExpenses;
    }

    public int getDays() {
        return this.days;
    }

    public void setDays(int numberOfDays) {
        this.days = numberOfDays;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getTotal(){
        return this.transport + RATE * this.days;
    }

//    public void show(){
//        System.out.println("rate = " + convertMoney(RATE));
//        System.out.println("account = " + account);
//        System.out.println("transport = " + convertMoney(transport));
//        System.out.println("days = " + days);
//        System.out.println("total = " + convertMoney(getTotal()));
//    }

    public String toString() {
        return this.account + ";" + convertMoney(this.transport) + ";" + this.days + ";" + convertMoney(this.getTotal());
    }

    public int compareTo(BusinessTrip arg0) {
        return arg0.getTotal() - this.getTotal();
    }

}




