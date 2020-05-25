package by.gsu.pms;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserialisation {

    public City[] deserialize() throws EmptyException{

        City[] cities = null;

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("in.txt"));

            cities = (City[])objectInputStream.readObject();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        if (cities.length == 0) throw new EmptyException("City is empty");
        return cities;
    }
}
