package by.gsu.pms;

public class LoanAccount extends Account {

    private String name;
    private int balance;

    LoanAccount() {
        this(null,0);
    }

    LoanAccount(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

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

    @Override
    public String toString() {
        return name + ":" + balance;
    }

}
