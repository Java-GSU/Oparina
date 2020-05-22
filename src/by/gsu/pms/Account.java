package by.gsu.pms;

public class Account {

    private String name;
    private int balance;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String toString() {
        return name + ":" + balance;
    }



}
