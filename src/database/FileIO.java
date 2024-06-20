package database;

import models.Doctor;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class FileIO {

    // save data to file text
    public static void writeDoctorDataToFile(String file, List<Doctor> doctors) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (Doctor doctor : doctors) {
                writer.write(doctor.toFile());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // read data from file text
    public static List<Doctor> getDoctors(String fileName) {
        List<Doctor> doctors = new ArrayList<>();
        try {
            Files.lines(Paths.get(fileName)).forEach(line -> {
                String[] data = line.split("\\| ");
                doctors.add(new Doctor());
            });
        } catch (IOException e) {
            System.out.println("data is null");
        }
        return doctors;
    }

    public static boolean checkIDInFile(String id, String fileName) throws IOException {
        AtomicBoolean flag = new AtomicBoolean(false);
        Files.lines(Paths.get(fileName)).forEach(line -> {
            String[] data = line.split("\\| ");
            if (id.equals(data[0])) flag.set(true);
        });
        return flag.get();
    }
}
