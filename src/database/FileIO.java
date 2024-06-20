package database;

import models.Doctor;
import models.Medicine;
import models.Patient;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class FileIO {

    // save doctor data  to file text
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

    // read doctor data from file text
    public static List<Doctor> getDoctors(String fileName, List<Doctor> doctors) {
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

    // save patient data  to file text
    public static void writePatientDataToFile(String file, List<Patient> patients) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (Patient patient : patients) {
                writer.write(patient.toFile());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // read patient data from file text
    public static List<Patient> getPatients(String fileName, List<Patient> patients) {
        try {
            Files.lines(Paths.get(fileName)).forEach(line -> {
                String[] data = line.split("\\| ");
                patients.add(new Patient());
            });
        } catch (IOException e) {
            System.out.println("data is null");
        }
        return patients;
    }

    // save medicine data  to file text
    public static void writeMedicineDataToFile(String file, List<Medicine> medicines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (Medicine medicine : medicines) {
                writer.write(medicine.toFile());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // read doctor data from file text
    public static List<Medicine> getMedicines(String fileName, List<Medicine> medicines) {
        try {
            Files.lines(Paths.get(fileName)).forEach(line -> {
                String[] data = line.split("\\| ");
                medicines.add(new Medicine());
            });
        } catch (IOException e) {
            System.out.println("data is null");
        }
        return medicines;
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
