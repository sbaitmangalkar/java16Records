package com.sbaitman.record;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Serialization of Movie Object
        var movie = new Movie("Mission Impossible - Ghost Protocol", "Action",
                Arrays.asList(new Actor("Tom Cruise", "tomcruise@abc.com"),
                        new Actor("Jeremy Renner", "jeremyrenner@abc.com")));

        try (var objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/main/resources/movie.data"))) {
            objectOutputStream.writeObject(movie);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Deserialization of Movie Object
        try (var objectInputStream = new ObjectInputStream(new FileInputStream("src/main/resources/movie.data"))) {
            Movie deserMovie = (Movie) objectInputStream.readObject();
            System.out.println("Deserialized Movie Object: " + deserMovie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
