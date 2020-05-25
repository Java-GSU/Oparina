package by.gsu.pms;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.NoSuchFileException;

public class Serialization {

    public void serialise(City[] cities) throws EmptyException {

        ObjectOutputStream objectOutputStream = null;

        if (cities.length == 0) throw new EmptyException("City is empty");

        try {
            System.out.println("Serialization");
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("in.txt"));
            objectOutputStream.writeObject(cities);
            objectOutputStream.close();
        }
        catch (NoSuchFileException ex){
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
