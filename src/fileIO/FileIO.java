package fileIO;

import models.Doctor;
import models.Medicine;
import models.Patient;
import models.enums.DosageForm;
import models.enums.Education;
import models.enums.Gender;
import models.enums.Specialization;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class FileIO {

    // save doctor data  to file text
    public static void writeDoctorDataToFile(String file, List<Doctor> doctors) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
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
        Map<String, Doctor> doctorMap = new HashMap<>();
        for (Doctor doc : doctors) {
            doctorMap.put(doc.getIDNumber(), doc);
        }

        try {
            Files.lines(Paths.get(fileName)).forEach(line -> {
                String[] data = line.split("\\| ");
                String ID = data[0];
                if (!doctorMap.containsKey(ID)) {
                    String firstName = data[1];
                    String lastName = data[2];
                    Gender gender = Gender.valueOf(data[3]);
                    String dob = data[4];
                    String address = data[6];
                    String telephone = data[7];
                    int clinicTime = Integer.parseInt(data[8]);
                    int yearsOfExperience = Integer.parseInt(data[9]);
                    Education education = Education.valueOf(data[10]);
                    Specialization specialization = Specialization.valueOf(data[11]);
                    double consultationFee = Double.parseDouble(data[12]);
                    try {
                        Doctor doctor = new Doctor(ID, firstName, lastName, dob, gender,
                                address, telephone, yearsOfExperience, clinicTime,
                                education, specialization, consultationFee);
                        doctors.add(doctor);
                        doctorMap.put(ID, doctor);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        } catch (IOException e) {
        }
        return doctors;
    }

    // save patient data  to file text
    public static void writePatientDataToFile(String file, HashMap<String, Patient> patients) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
           for (Patient patient : patients.values()) {
               writer.write(patient.toFile());
               writer.newLine();
           }
        } catch (IOException e) {
        }
    }

    // read patient data from file text
    public static HashMap<String, Patient> getPatients(String fileName, HashMap<String ,Patient> patients) {
        Map<String, Patient> patientMap = new HashMap<>();
        for (Patient patient : patients.values()) {
            patientMap.put(patient.getIDNumber(), patient);
        }
        try {
            Files.lines(Paths.get(fileName)).forEach(line -> {
                String[] data = line.split("\\| ");
                String ID = data[0];
                if (!patientMap.containsKey(ID)) {
                    String firstName = data[1];
                    String lastName = data[2];
                    Gender gender = Gender.valueOf(data[3]);
                    String dob = data[4];
                    String address = data[6];
                    String telephone = data[7];
                    boolean allergies = data[8].equals("true");
                    String allergyDetails = data[9];
                    double height = Double.parseDouble(data[10]);
                    double weight = Double.parseDouble(data[11]);
                    String bloodType = data[12];
                    Specialization specialization = Specialization.valueOf(data[13]);
                    try {
                        patients.put(ID, new Patient(ID, firstName, lastName, dob, gender
                                , address, telephone, height, weight, bloodType, allergies, allergyDetails, specialization));
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        } catch (IOException e) {
        }
        return patients;
    }

    // save medicine data  to file text
    public static void writeMedicineDataToFile(String file, List<Medicine> medicines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Medicine medicine : medicines) {
                writer.write(medicine.toFile());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // read medicine data from file text
    public static List<Medicine> getMedicines(String fileName, List<Medicine> medicines) {
        Map<String, Medicine> medicineMap = new HashMap<>();
        for (Medicine m : medicines) {
            medicineMap.put(m.getMedicineID(), m);
        }
        try {
            Files.lines(Paths.get(fileName)).forEach(line -> {
                String[] data = line.split("\\| ");
                String ID = data[0];
                if (!medicineMap.containsKey(ID)) {
                    String name = data[1];
                    DosageForm dosageForm = DosageForm.valueOf(data[2]);
                    String strength = data[3];
                    medicines.add(new Medicine(ID, name, dosageForm, strength));
                }
            });
        } catch (IOException e) {
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
