package controller;

import exception.HandlingException;
import fileIO.FileIO;
import models.Doctor;
import models.Medicine;
import models.Patient;
import models.enums.Action;
import models.enums.Education;
import models.enums.Gender;
import models.enums.Specialization;
import validation.Validate;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorController {

    Scanner sc = new Scanner(System.in);

    private List<Doctor> doctorListOfCARDIOLOGY = new ArrayList<>();  // list of CARDIOLOGY. The list has information of doctors, patient in CARDIOLOGY.
    private List<Doctor> doctorListOfDERMATOLOGY = new ArrayList<>(); // list of DERMATOLOGY. The list has information of doctors, patient in DERMATOLOGY.
    private List<Doctor> doctorListOfENT = new ArrayList<>();         // list of ENT. The list has information of doctors, patient in ENT.
    private List<Doctor> doctorListOfNEUROLOGY = new ArrayList<>();   // list of NEUROLOGY. The list has information of doctors, patient in NEUROLOGY.
    private List<Doctor> doctorListOfGERIATRIC = new ArrayList<>();// list of GERIATRIC. The list has information of doctors, patient in GERIATRIC.

    PatientController patientController = new PatientController();
    MedicineController medicineController  = new MedicineController();

    public DoctorController() {
    }

    public List<Doctor> getDoctorListOfCARDIOLOGY() {
        return FileIO.getDoctors("doctorsCardiology.txt", doctorListOfCARDIOLOGY);
    }

    public List<Doctor> getDoctorListOfDERMATOLOGY() {
        return FileIO.getDoctors("doctorsDERMATOLOGY.txt", doctorListOfDERMATOLOGY);
    }

    public List<Doctor> getDoctorListOfENT() {
        return FileIO.getDoctors("doctorsENT.txt", doctorListOfENT);
    }

    public List<Doctor> getDoctorListOfNEUROLOGY() {
        return FileIO.getDoctors("doctorsNEUROLOGY.txt", doctorListOfNEUROLOGY);
    }

    public List<Doctor> getDoctorListOfGERIATRIC() {
        return FileIO.getDoctors("doctorsGERIATRIC.txt", doctorListOfGERIATRIC);
    }

    public void addNewDoctor(int choice) throws ParseException, IOException {
        int choiceDoctorEducation;
        Gender gender;
        Education education = null;

        String IDNumber = Validate.checkDoctorID(sc, choice, Action.CHECK);

        System.out.print("Enter Doctor's fist name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter Doctor's last name: ");
        String lastName = sc.nextLine();

        String yob = HandlingException.getBirthOfDay(sc);


        gender = HandlingException.getGender(sc);

        System.out.print("Enter doctor's address: ");
        String address = sc.nextLine();

        String telephone = Validate.getTelephoneNumber(sc);

        System.out.print("Enter doctor's years of experience: ");
        int yearOfExperience = HandlingException.getInteger(sc);

        int clinicHours = Validate.getClinicHours(sc);

        do {
            System.out.printf("Choose doctor's education:%10s", " ");
            System.out.printf("%10s|%10s|%10s|%10s", "1. DOCTOR", "2. PROFESSOR", "3. ASSOCIATE_PROFESSOR", " ");
            choiceDoctorEducation = HandlingException.getInteger(sc);
            if (choiceDoctorEducation == 1) {
                education = Education.DOCTOR;
            } else if (choiceDoctorEducation == 2) {
                education = Education.PROFESSOR;
            } else if (choiceDoctorEducation == 3) {
                education = Education.ASSOCIATE_PROFESSOR;
            } else {
                System.out.println("Invalid Education");
            }
        } while ( choiceDoctorEducation < 1 || choiceDoctorEducation > 3);

        System.out.print("Enter doctor's consultationFee: ");
        double consultationFee = HandlingException.getDouble(sc);

        switch (choice) {
            case 1:
                getDoctorListOfCARDIOLOGY().add(new Doctor(IDNumber, firstName, lastName, yob, gender,
                                            address, telephone, yearOfExperience, clinicHours, education,
                                            Specialization.CARDIOLOGY, consultationFee));
                FileIO.writeDoctorDataToFile("doctorsCardiology.txt", doctorListOfCARDIOLOGY);
                System.out.println("added new doctor.");
                break;
            case 2:

                getDoctorListOfDERMATOLOGY().add(new Doctor(IDNumber, firstName, lastName, yob, gender,
                        address, telephone, yearOfExperience, clinicHours, education,
                        Specialization.DERMATOLOGY, consultationFee));
                FileIO.writeDoctorDataToFile("doctorsDERMATOLOGY.txt", doctorListOfDERMATOLOGY);
                System.out.println("added new doctor.");

                break;
            case 3:

                getDoctorListOfENT().add(new Doctor(IDNumber, firstName, lastName, yob, gender,
                        address, telephone, yearOfExperience, clinicHours, education,
                        Specialization.ENT, consultationFee));
                FileIO.writeDoctorDataToFile("doctorsENT.txt", doctorListOfENT);
                System.out.println("added new doctor.");
                break;
            case 4:

                getDoctorListOfNEUROLOGY().add(new Doctor(IDNumber, firstName, lastName, yob, gender,
                        address, telephone, yearOfExperience, clinicHours, education,
                        Specialization.NEUROLOGY, consultationFee));
                FileIO.writeDoctorDataToFile("doctorsNEUROLOGY.txt", doctorListOfNEUROLOGY);
                System.out.println("added new doctor.");
                break;
            case 5:

                getDoctorListOfGERIATRIC().add(new Doctor(IDNumber, firstName, lastName, yob, gender,
                        address, telephone, yearOfExperience, clinicHours, education,
                        Specialization.GERIATRIC, consultationFee));
                FileIO.writeDoctorDataToFile("doctorsGERIATRIC.txt", doctorListOfGERIATRIC);
                System.out.println("added new doctor.");
                break;
        }

    }

    public void showDoctorsList(int choice) {
        switch (choice) {
            case 1:
                getDoctorListOfCARDIOLOGY().forEach(s -> System.out.println(s.toString()));
                break;
            case 2:
                getDoctorListOfDERMATOLOGY().forEach(s -> System.out.println(s.toString()));
                break;
            case 3:
                getDoctorListOfENT().forEach(s -> System.out.println(s.toString()));
                break;
            case 4:
                getDoctorListOfNEUROLOGY().forEach(s -> System.out.println(s.toString()));
                break;
            case 5:
                getDoctorListOfGERIATRIC().forEach(s -> System.out.println(s.toString()));
                break;
        }
    }

    public Doctor findDoctorByID(int choice, String IDNumber) throws IOException {
        switch (choice) {
            case 1:
                if (FileIO.checkIDInFile(IDNumber, "doctorsCardiology.txt")) {
                    return getDoctorListOfCARDIOLOGY().stream().filter(Doctor -> Doctor.getIDNumber().equals(IDNumber)).findFirst().orElse(null);
                }
            case 2:
                if (FileIO.checkIDInFile(IDNumber, "doctorsDERMATOLOGY.txt")) {
                    return getDoctorListOfDERMATOLOGY().stream().filter(Doctor -> Doctor.getIDNumber().equals(IDNumber)).findFirst().orElse(null);
                }
            case 3:
                if (FileIO.checkIDInFile(IDNumber, "doctorsENT.txt")) {
                    return getDoctorListOfENT().stream().filter(Doctor -> Doctor.getIDNumber().equals(IDNumber)).findFirst().orElse(null);
                }
            case 4:
                if (FileIO.checkIDInFile(IDNumber, "doctorsNEUROLOGY.txt")) {
                    return getDoctorListOfNEUROLOGY().stream().filter(Doctor -> Doctor.getIDNumber().equals(IDNumber)).findFirst().orElse(null);
                }
            case 5:
                if (FileIO.checkIDInFile(IDNumber, "doctorsGERIATRIC.txt")) {
                    return getDoctorListOfGERIATRIC().stream().filter(Doctor -> Doctor.getIDNumber().equals(IDNumber)).findFirst().orElse(null);
                }
        }
        return null;
    }

    public void updateDoctor(String IDNumber, int choice) throws Exception {
        int choiceGender, choiceDoctorEducation;
        Doctor doctor = findDoctorByID(choice, IDNumber);
        if (doctor == null) {
            System.out.println("Not found!!!");
        } else {
            System.out.print("Enter Doctor's fist name: ");
            doctor.setFirstName(sc.nextLine());

            System.out.print("Enter Doctor's last name: ");
            doctor.setLastName(sc.nextLine());

            doctor.setFullName();


            doctor.setYob(HandlingException.getBirthOfDay(sc));


            do {
                System.out.printf("Gender?: %10s"," ");
                System.out.printf("%10s|%10s|%10s|%10s", "1.MALE", "2.FEMALE", "Your choice:", " ");
                choiceGender = HandlingException.getInteger(sc);
                if (choiceGender == 1) {
                    doctor.setGender(Gender.MALE);
                } else if (choiceGender == 2) {
                    doctor.setGender(Gender.FEMALE);
                }
                else {
                    System.out.println("Invalid Gender");
                }
            } while ( choiceGender != 1 && choiceGender != 2);

            System.out.print("Enter doctor's address: ");
            doctor.setAddress(sc.nextLine());

            doctor.setTelephoneNumber(Validate.getTelephoneNumber(sc));

            System.out.print("Enter doctor's years of experience: ");
            doctor.setYearsOfExperience(HandlingException.getInteger(sc));

            doctor.setClinicHours(Validate.getClinicHours(sc));

            do {
                System.out.printf("Choose doctor's education:%10s", " ");
                System.out.printf("%10s|%10s|%10s|%10s", "1. DOCTOR", "2. PROFESSOR", "3. ASSOCIATE_PROFESSOR", " ");
                choiceDoctorEducation = HandlingException.getInteger(sc);
                if (choiceDoctorEducation == 1) {
                    doctor.setEducation(Education.DOCTOR);
                } else if (choiceDoctorEducation == 2) {
                    doctor.setEducation(Education.PROFESSOR);
                } else if (choiceDoctorEducation == 3) {
                    doctor.setEducation(Education.ASSOCIATE_PROFESSOR);
                } else {
                    System.out.println("Invalid Education");
                }
            } while ( choiceDoctorEducation < 1 || choiceDoctorEducation > 3);

            System.out.print("Enter doctor's consultationFee: ");
            doctor.setConsultationFee(HandlingException.getDouble(sc));

            switch (choice) {
                case 1:
                    FileIO.writeDoctorDataToFile("doctorsCardiology.txt", doctorListOfCARDIOLOGY);
                    System.out.println("Updated Doctors cardiology data");
                    break;
                case 2:
                    FileIO.writeDoctorDataToFile("doctorsDERMATOLOGY.txt", doctorListOfDERMATOLOGY);
                    System.out.println("Updated Doctors DERMATOLOGY data");
                    break;
                case 3:
                    FileIO.writeDoctorDataToFile("doctorsENT.txt", doctorListOfENT);
                    System.out.println("Updated Doctors ENT data");
                    break;
                case 4:
                    FileIO.writeDoctorDataToFile("doctorsNEUROLOGY.txt", doctorListOfNEUROLOGY);
                    System.out.println("Updated Doctors NEUROLOGY data");
                    break;
                case 5:
                    FileIO.writeDoctorDataToFile("doctorsGERIATRIC.txt", doctorListOfGERIATRIC);
                    System.out.println("Updated Doctors GERIATRIC data");
                    break;
            }
        }
    }

    public void removeDoctor(String IDNumber, int choice) throws IOException {
        if (findDoctorByID(choice, IDNumber) == null) {
            System.out.println("Not found!!!");
        } else {
            switch (choice) {
                case 1:
                    doctorListOfCARDIOLOGY.remove(findDoctorByID(choice, IDNumber));
                    FileIO.writeDoctorDataToFile("doctorsCardiology.txt", doctorListOfCARDIOLOGY);
                    System.out.println("Remove is successful");
                    break;
                case 2:
                    doctorListOfDERMATOLOGY.remove(findDoctorByID(choice, IDNumber));
                    FileIO.writeDoctorDataToFile("doctorsDERMATOLOGY.txt", doctorListOfDERMATOLOGY);
                    System.out.println("Remove is successful");
                    break;
                case 3:
                    doctorListOfENT.remove(findDoctorByID(choice, IDNumber));
                    FileIO.writeDoctorDataToFile("doctorsENT.txt", doctorListOfENT);
                    System.out.println("Remove is successful");
                    break;
                case 4:
                    doctorListOfNEUROLOGY.remove(findDoctorByID(choice, IDNumber));
                    FileIO.writeDoctorDataToFile("doctorsNEUROLOGY.txt", doctorListOfNEUROLOGY);
                    System.out.println("Remove is successful");
                    break;
                case 5:
                    doctorListOfGERIATRIC.remove(findDoctorByID(choice, IDNumber));
                    FileIO.writeDoctorDataToFile("doctorsGERIATRIC.txt", doctorListOfGERIATRIC);
                    System.out.println("Remove is successful");
                    break;
            }
        }
    }


    public void addMedicineToPatient(String IDNumber, int choice) throws IOException {
        Scanner sc = new Scanner(System.in);
        switch (choice){
            case 1:
                if(patientController.getPatientListOfCARDIOLOGY().containsKey(IDNumber)){
                    Patient patient = patientController.getPatientListOfCARDIOLOGY().get(IDNumber);
                    System.out.println("Enter new medicine ID: ");
                    String medicineID = sc.nextLine();
                    Medicine medicine = medicineController.findMedicine(medicineID, choice);
                    if(medicine != null){
                        patient.addMedicine(medicine);
                        System.out.println("Add Medicine Successfully.");
                    }else{
                        System.out.println("Medicine not found.");
                    }

                }else{
                    System.out.println("Medicine not found.");
                }
                break;
            case 2:
                if(patientController.getPatientListOfDERMATOLOGY().containsKey(IDNumber)){
                    Patient patient = patientController.getPatientListOfDERMATOLOGY().get(IDNumber);
                    System.out.println("Enter new medicine ID: ");
                    String medicineID = sc.nextLine();
                    Medicine medicine = medicineController.findMedicine(medicineID, choice);
                    if(medicine != null){
                        patient.addMedicine(medicine);
                        System.out.println("Add Medicine Successfully.");
                    }else{
                        System.out.println("Medicine not found.");
                    }

                }else{
                    System.out.println("Medicine not found.");
                }
                break;
            case 3:
                if(patientController.getPatientListOfENT().containsKey(IDNumber)){
                    Patient patient = patientController.getPatientListOfENT().get(IDNumber);
                    System.out.println("Enter new medicine ID: ");
                    String medicineID = sc.nextLine();
                    Medicine medicine = medicineController.findMedicine(medicineID, choice);
                    if(medicine != null){
                        patient.addMedicine(medicine);
                        System.out.println("Add Medicine Successfully.");
                    }else{
                        System.out.println("Medicine not found.");
                    }

                }else{
                    System.out.println("Medicine not found.");
                }
                break;
            case 4:
                if(patientController.getPatientListOfNEUROLOGY().containsKey(IDNumber)){
                    Patient patient = patientController.getPatientListOfNEUROLOGY().get(IDNumber);
                    System.out.println("Enter new medicine ID: ");
                    String medicineID = sc.nextLine();
                    Medicine medicine = medicineController.findMedicine(medicineID, choice);
                    if(medicine != null){
                        patient.addMedicine(medicine);
                        System.out.println("Add Medicine Successfully.");
                    }else{
                        System.out.println("Medicine not found.");
                    }

                }else{
                    System.out.println("Medicine not found.");
                }
                break;
            case 5:
                if(patientController.getPatientListOfGERIATRIC().containsKey(IDNumber)){
                    Patient patient = patientController.getPatientListOfGERIATRIC().get(IDNumber);
                    System.out.println("Enter new medicine ID: ");
                    String medicineID = sc.nextLine();
                    Medicine medicine = medicineController.findMedicine(medicineID, choice);
                    if(medicine != null){
                        patient.addMedicine(medicine);
                        System.out.println("Add Medicine Successfully.");
                    }else{
                        System.out.println("Medicine not found.");
                    }

                }else{
                    System.out.println("Medicine not found.");
                }
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid department.");
                break;
        }
    }

    public void showMedicineOfPatient() {
    }
}
