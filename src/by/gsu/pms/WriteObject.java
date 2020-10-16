package by.gsu.pms;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) {

        City[] cities = {
                new City("Minsk", 1975000, 3488),
                new City("Brest", 343985, 1461),
                new City("Mogilev", 380440, 1185),
                new City("Gomel", 535693, 1398),
                new City("Moscow", 11920000, 25110),
                new City(),
                new City("Berlin", 3748000, 8918),
                new City("Ottawa", 994837, 27900),
                new City("Belgorod", 356426, 1531),
                new City("X", 0, 15),
        };

        try {
            FileOutputStream fos = new FileOutputStream("in.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(cities);

            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
