package database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileIO {

    // save data to file text
    public static void writeData(String filename) {
        // Writing to a file using PrintWriter
        try (PrintWriter writer3 = new PrintWriter(filename)) {
            writer3.println("Writing to a file using PrintWriter.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // read data from file text
    public static void readData(String filename) {
        // 3. Using Files.lines() (Java 8 and above):
        try {
            Files.lines(Paths.get(filename)).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
