package by.gsu.pms;
import java.util.Comparator;

public class SortByName implements Comparator<City> {
    public int compare(City o1, City o2){
        return o1.getNameCity().compareToIgnoreCase(o2.getNameCity());
    }

}

