package by.gsu.pms;

public class Subject {
    private String name;
    private Materials material;
    private double volume;

    public Subject(){
        name = "";
        material = null;
        volume = 0.0;
    }

    public Subject(String nameSubject, Materials material, double volume){
        this.name = nameSubject;
        this.material = material;
        this.volume = volume;
    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Materials getMaterials(){
        return material;
    }
    public void  setMaterials(Materials material){
        this.material = material;
    }
    public double getVolume() {
        return volume;
    }
    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getMass(){

        return material.getDensity() * volume / 100;
    }

    public String toString() {

        return name + ";" + material + ";" + String.format("%.2f", volume / 100) + ";" + String.format("%.1f", getMass());
    }


}
