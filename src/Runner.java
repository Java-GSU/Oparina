//Задание 16. Состав класса City (город) название, население, площадь. Подсчитать общую площадь и количество городов миллионеров.

import by.gsu.pms.City;
import by.gsu.pms.SortByArea;
import by.gsu.pms.SortByName;

import java.util.Arrays;

import static by.gsu.pms.Util.convertArea;



public class Runner {

    public static void main(String[] args) {
        City[] cities = {
                new City("Minsk", 1975000, 3488),
                new City("Brest", 343985, 1461),
                //null,
                new City("Mogilev", 380440, 1185),
                new City("Gomel", 535693, 1398),
                new City("Moscow", 11920000, 25110),
                new City(),
                new City("Berlin", 3748000, 8918),
                new City("Ottawa", 994837, 27900),
                new City("Belgorod", 356426, 1531)
        };

        for (City city : cities) {
            if (city != null) {
                city.show();
            }
            System.out.println("\n");
        }

        int totalArea = 0;
        for (City city : cities) {
            if (city != null) {
                totalArea += city.getArea();
            }
        }
        System.out.println("Общая площадь: " + convertArea(totalArea));


        int count = 0;
        for (City city : cities) {
            if (city != null && city.getPopulation() > 1000000) {

                count++;
            }
        }
        System.out.println("Количество городов миллионеров: " + count);


        Arrays.sort(cities, new SortByArea());
        System.out.println("Sorted by area: " + Arrays.toString(cities));

        Arrays.sort(cities, new SortByName());
        System.out.println("Sorted by CityName: " + Arrays.toString(cities));

    }


}
