package by.gsu.pms;

public class Purchase implements Comparable<Purchase>{

    private String Name;
    private int Cost;
    private int Count;

    public Purchase(String Name, int Cost, int Count) {

        this.Name = Name;
        this.Cost = Cost;
        this.Count = Count;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int Cost) {
        this.Cost = Cost;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) { this.Count = Count; }

    public int PriceGet() {

        return Cost * Count;
    }

    public String toString(){
        return "Name:" + Name + " Cost:" + Cost + " Count:" + Count + " Price:" + PriceGet();
    }



    @Override
    public int compareTo(Purchase purchase){
        return Integer.compare(this.getCost(), purchase.getCost());
    }
}
