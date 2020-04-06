package by.gsu.pms;
import java.io.Serializable;

import static by.gsu.pms.Util.convertArea;
import static by.gsu.pms.Util.convertPopulation;

public class City implements Serializable {

    private String nameCity;
    private int population;
    private int area;

    public City() {
        this.nameCity = "null";
        this.population = 0;
        this.area = 0;

    }

    public City(String nameCity, int population, int area) {
        this.nameCity = nameCity;
        this.population = population;
        this.area = area;
    }


    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }



    public void show(){

        System.out.println("City = " + nameCity + ";" + "Population = " + convertPopulation(population) + " m" + ";" + "Area = " + convertArea(area) + " km²");

    }


    public String toString() {
        return nameCity + ";" + convertPopulation(population) + ";" + convertArea(area);
    }

}
