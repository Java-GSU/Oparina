package by.gsu.pms;
import static by.gsu.pms.Util.*;
//Задание 16. Состав класса City (город) название, население, площадь. Подсчитать общую площадь и количество городов миллионеров.

public class City {

    private String nameCity;
    private int population;
    private int area;

    public City() {

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

        System.out.println("City = " + nameCity);
        System.out.println("Population = " + convertPopulation(population) + " m");
        System.out.println("Area = " + convertArea(area) + " km²");

    }


    public String toString() {
        return nameCity + ";" + convertPopulation(population) + ";" + convertArea(area);
    }

}
