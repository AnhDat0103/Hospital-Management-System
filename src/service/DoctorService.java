package service;

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

public class DoctorService {

    Scanner sc = new Scanner(System.in);

    private List<Doctor> doctorListOfCARDIOLOGY = new ArrayList<>();  // list of CARDIOLOGY. The list has information of doctors, patient in CARDIOLOGY.
    private List<Doctor> doctorListOfDERMATOLOGY = new ArrayList<>(); // list of DERMATOLOGY. The list has information of doctors, patient in DERMATOLOGY.
    private List<Doctor> doctorListOfENT = new ArrayList<>();         // list of ENT. The list has information of doctors, patient in ENT.
    private List<Doctor> doctorListOfNEUROLOGY = new ArrayList<>();   // list of NEUROLOGY. The list has information of doctors, patient in NEUROLOGY.
    private List<Doctor> doctorListOfGERIATRIC = new ArrayList<>();// list of GERIATRIC. The list has information of doctors, patient in GERIATRIC.

    PatientService patientService = new PatientService();
    MedicineService medicineService  = new MedicineService();

    public List<Doctor> getDoctorListOfCARDIOLOGY() {
        return doctorListOfCARDIOLOGY;
    }

    public void setDoctorListOfCARDIOLOGY(List<Doctor> doctorListOfCARDIOLOGY) {
        this.doctorListOfCARDIOLOGY = doctorListOfCARDIOLOGY;
    }

    public List<Doctor> getDoctorListOfDERMATOLOGY() {
        return doctorListOfDERMATOLOGY;
    }

    public void setDoctorListOfDERMATOLOGY(List<Doctor> doctorListOfDERMATOLOGY) {
        this.doctorListOfDERMATOLOGY = doctorListOfDERMATOLOGY;
    }

    public List<Doctor> getDoctorListOfENT() {
        return doctorListOfENT;
    }

    public void setDoctorListOfENT(List<Doctor> doctorListOfENT) {
        this.doctorListOfENT = doctorListOfENT;
    }

    public List<Doctor> getDoctorListOfNEUROLOGY() {
        return doctorListOfNEUROLOGY;
    }

    public void setDoctorListOfNEUROLOGY(List<Doctor> doctorListOfNEUROLOGY) {
        this.doctorListOfNEUROLOGY = doctorListOfNEUROLOGY;
    }

    public List<Doctor> getDoctorListOfGERIATRIC() {
        return doctorListOfGERIATRIC;
    }

    public void setDoctorListOfGERIATRIC(List<Doctor> doctorListOfGERIATRIC) {
        this.doctorListOfGERIATRIC = doctorListOfGERIATRIC;
    }

    public DoctorService() {
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
                doctorListOfCARDIOLOGY.add(new Doctor(IDNumber, firstName, lastName, yob, gender,
                                            address, telephone, yearOfExperience, clinicHours, education,
                                            Specialization.CARDIOLOGY, consultationFee));
                FileIO.writeDoctorDataToFile("doctorsCardiology.txt", doctorListOfCARDIOLOGY);
                System.out.println("added new doctor.");
                break;
            case 2:
                doctorListOfDERMATOLOGY.add(new Doctor(IDNumber, firstName, lastName, yob, gender,
                        address, telephone, yearOfExperience, clinicHours, education,
                        Specialization.DERMATOLOGY, consultationFee));
                FileIO.writeDoctorDataToFile("doctorsDERMATOLOGY.txt", doctorListOfDERMATOLOGY);
                System.out.println("added new doctor.");

                break;
            case 3:
                doctorListOfENT.add(new Doctor(IDNumber, firstName, lastName, yob, gender,
                        address, telephone, yearOfExperience, clinicHours, education,
                        Specialization.ENT, consultationFee));
                FileIO.writeDoctorDataToFile("doctorsENT.txt", doctorListOfENT);
                System.out.println("added new doctor.");
                break;
            case 4:
                doctorListOfNEUROLOGY.add(new Doctor(IDNumber, firstName, lastName, yob, gender,
                        address, telephone, yearOfExperience, clinicHours, education,
                        Specialization.NEUROLOGY, consultationFee));
                FileIO.writeDoctorDataToFile("doctorsNEUROLOGY.txt", doctorListOfNEUROLOGY);
                System.out.println("added new doctor.");
                break;
            case 5:
                doctorListOfGERIATRIC.add(new Doctor(IDNumber, firstName, lastName, yob, gender,
                        address, telephone, yearOfExperience, clinicHours, education,
                        Specialization.GERIATRIC, consultationFee));
                FileIO.writeDoctorDataToFile("doctorsGERIATRIC.txt", doctorListOfGERIATRIC);
                System.out.println("added new doctor.");
                break;
        }

    }

    public List<Doctor> showDoctorsList(int choice) {
        switch (choice) {
            case 1:
                return FileIO.getDoctors("doctorsCardiology.txt", doctorListOfCARDIOLOGY);
            case 2:
                return FileIO.getDoctors("doctorsDERMATOLOGY.txt", doctorListOfCARDIOLOGY);
            case 3:
                return FileIO.getDoctors("doctorsENT.txt", doctorListOfCARDIOLOGY);
            case 4:
                return FileIO.getDoctors("doctorsNEUROLOGY.txt", doctorListOfCARDIOLOGY);
            case 5:
                return FileIO.getDoctors("doctorsGERIATRIC.txt", doctorListOfCARDIOLOGY);
        }
        return null;
    }

    public Doctor findDoctorByID(int choice, String IDNumber) throws IOException {
        switch (choice) {
            case 1:
                if (FileIO.checkIDInFile(IDNumber, "doctorsCardiology.txt")) {
                    return doctorListOfCARDIOLOGY.stream().filter(Doctor -> Doctor.getIDNumber().equals(IDNumber)).findFirst().orElse(null);

                }
            case 2:
                if (FileIO.checkIDInFile(IDNumber, "doctorsDERMATOLOGY.txt")) {
                    return doctorListOfDERMATOLOGY.stream().filter(Doctor -> Doctor.getIDNumber().equals(IDNumber)).findFirst().orElse(null);
                }
            case 3:
                if (FileIO.checkIDInFile(IDNumber, "doctorsENT.txt")) {
                    return doctorListOfENT.stream().filter(Doctor -> Doctor.getIDNumber().equals(IDNumber)).findFirst().orElse(null);
                }
            case 4:
                if (FileIO.checkIDInFile(IDNumber, "doctorsNEUROLOGY.txt")) {
                    return doctorListOfNEUROLOGY.stream().filter(Doctor -> Doctor.getIDNumber().equals(IDNumber)).findFirst().orElse(null);
                }
            case 5:
                if (FileIO.checkIDInFile(IDNumber, "doctorsGERIATRIC.txt")) {
                    return doctorListOfGERIATRIC.stream().filter(Doctor -> Doctor.getIDNumber().equals(IDNumber)).findFirst().orElse(null);
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
                    FileIO.updateDoctorDataToFile("doctorsCardiology.txt", doctorListOfCARDIOLOGY);
                    System.out.println("Updated Doctors cardiology data");
                    break;
                case 2:
                    FileIO.updateDoctorDataToFile("doctorsDERMATOLOGY.txt", doctorListOfDERMATOLOGY);
                    System.out.println("Updated Doctors DERMATOLOGY data");
                    break;
                case 3:
                    FileIO.updateDoctorDataToFile("doctorsENT.txt", doctorListOfENT);
                    System.out.println("Updated Doctors ENT data");
                    break;
                case 4:
                    FileIO.updateDoctorDataToFile("doctorsNEUROLOGY.txt", doctorListOfNEUROLOGY);
                    System.out.println("Updated Doctors NEUROLOGY data");
                    break;
                case 5:
                    FileIO.updateDoctorDataToFile("doctorsGERIATRIC.txt", doctorListOfGERIATRIC);
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
                    FileIO.updateDoctorDataToFile("doctorsCardiology.txt", doctorListOfCARDIOLOGY);
                    System.out.println("Remove is successful");
                    break;
                case 2:
                    doctorListOfDERMATOLOGY.remove(findDoctorByID(choice, IDNumber));
                    FileIO.updateDoctorDataToFile("doctorsDERMATOLOGY.txt", doctorListOfDERMATOLOGY);
                    System.out.println("Remove is successful");
                    break;
                case 3:
                    doctorListOfENT.remove(findDoctorByID(choice, IDNumber));
                    FileIO.updateDoctorDataToFile("doctorsENT.txt", doctorListOfENT);
                    System.out.println("Remove is successful");
                    break;
                case 4:
                    doctorListOfNEUROLOGY.remove(findDoctorByID(choice, IDNumber));
                    FileIO.updateDoctorDataToFile("doctorsNEUROLOGY.txt", doctorListOfNEUROLOGY);
                    System.out.println("Remove is successful");
                    break;
                case 5:
                    doctorListOfGERIATRIC.remove(findDoctorByID(choice, IDNumber));
                    FileIO.updateDoctorDataToFile("doctorsGERIATRIC.txt", doctorListOfGERIATRIC);
                    System.out.println("Remove is successful");
                    break;
            }
        }
    }


    public void addMedicineToPatient(String IDNumber, int choice){
        Scanner sc = new Scanner(System.in);
        switch (choice){
            case 1:
                if(patientService.getPatientListOfCARDIOLOGY().containsKey(IDNumber)){
                    Patient patient = patientService.getPatientListOfCARDIOLOGY().get(IDNumber);
                    System.out.println("Enter new medicine ID: ");
                    String medicineID = sc.nextLine();
                    Medicine medicine = medicineService.findMedicine(medicineID, choice);
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
                if(patientService.getPatientListOfDERMATOLOGY().containsKey(IDNumber)){
                    Patient patient = patientService.getPatientListOfDERMATOLOGY().get(IDNumber);
                    System.out.println("Enter new medicine ID: ");
                    String medicineID = sc.nextLine();
                    Medicine medicine = medicineService.findMedicine(medicineID, choice);
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
                if(patientService.getPatientListOfENT().containsKey(IDNumber)){
                    Patient patient = patientService.getPatientListOfENT().get(IDNumber);
                    System.out.println("Enter new medicine ID: ");
                    String medicineID = sc.nextLine();
                    Medicine medicine = medicineService.findMedicine(medicineID, choice);
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
                if(patientService.getPatientListOfNEUROLOGY().containsKey(IDNumber)){
                    Patient patient = patientService.getPatientListOfNEUROLOGY().get(IDNumber);
                    System.out.println("Enter new medicine ID: ");
                    String medicineID = sc.nextLine();
                    Medicine medicine = medicineService.findMedicine(medicineID, choice);
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
                if(patientService.getPatientListOfGERIATRIC().containsKey(IDNumber)){
                    Patient patient = patientService.getPatientListOfGERIATRIC().get(IDNumber);
                    System.out.println("Enter new medicine ID: ");
                    String medicineID = sc.nextLine();
                    Medicine medicine = medicineService.findMedicine(medicineID, choice);
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

    public void showMedicineOfPatient(){
    }

}
