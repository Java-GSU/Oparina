import by.gsu.pms.City;
import by.gsu.pms.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

import static by.gsu.pms.Util.convertArea;

public class Runner {

    public static void main(String[] args) {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("in.txt"))) {

             City[] cities = (City[]) ois.readObject();

            for (City city : cities) {
            if (city != null) {
                city.show();
            }
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


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


}
