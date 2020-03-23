package by.gsu.pms;
import java.util.Comparator;

public class SortByArea  implements Comparator<City> {
    public int compare(City o1, City o2){
        return o1.getArea() - o2.getArea();
    }

}