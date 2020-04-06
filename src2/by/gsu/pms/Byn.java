package by.gsu.pms;

import java.text.DecimalFormat;

public class Byn implements Comparable<Byn> {
    private int value;

    public Byn(int value){
        this.value = value;
    }

    Byn(Byn byn){
        this(byn.value);
    }

    Byn add(Byn byn){

        value += byn.value;
        return this;
    }

    Byn sub(Byn byn){

        value -= byn.value;
        return this;
    }

    Byn mul(int multiplier){

        value *= multiplier;
        return this;
    }

    Byn mul(double multiplier){

        value = RoundFactory.ROUND.round(value * multiplier, 0);
        return this;
    }

    Byn round(){

        value = RoundFactory.FLOOR.round(value, 2);
        return this;
    }

    public String toString(){

        double money = Double.parseDouble((value / 10000) + "." + (value % 10000)/1000 + value%1000);
        return new DecimalFormat("#0.00").format(money);

    }

    @Override
    public int compareTo(Byn that){

        return this.value - that.value;
    }
}
