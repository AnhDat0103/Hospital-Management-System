package controller;

import exception.HandlingException;
import fileIO.FileIO;
import models.Doctor;
import models.Medicine;
import models.Patient;
import models.enums.Action;
import models.enums.Gender;
import models.enums.Specialization;
import validation.Validate;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PatientController {

    private  HashMap<String, Medicine> medicineListOfCARDIOLOGY = new HashMap<>();
    private  HashMap<String, Medicine> medicineListOfDERMATOLOGY = new HashMap<>();
    private  HashMap<String, Medicine> medicineListOfENT = new HashMap<>();
    private  HashMap<String, Medicine> medicineListOfNEUROLOGY = new HashMap<>();
    private  HashMap<String, Medicine> medicineListOfGERIATRIC = new HashMap<>();

    Scanner sc = new Scanner(System.in);

    private  HashMap<String, Patient> patientListOfCARDIOLOGY = new HashMap<>(); //list of CARDIOLOGY. The list has information of patients, medicine of patients in CARDIOLOGY.
    private  HashMap<String, Patient> patientListOfDERMATOLOGY = new HashMap<>(); //list of CARDIOLOGY. The list has information of patients, medicine of patients in DERMATOLOGY.
    private  HashMap<String, Patient> patientListOfENT = new HashMap<>(); //list of CARDIOLOGY. The list has information of patients, medicine of patients in ENT.
    private  HashMap<String, Patient> patientListOfNEUROLOGY = new HashMap<>(); //list of CARDIOLOGY. The list has information of patients, medicine of patients in NEUROLOGY.
    private  HashMap<String, Patient> patientListOfGERIATRIC = new HashMap<>(); //list of CARDIOLOGY. The list has information of patients, medicine of patients in GERIATRIC.

    HashMap<String, Patient> subHashMap = new HashMap<>(); // list patient for each doctor

    public HashMap<String, Medicine> getMedicineListOfCARDIOLOGY() {
        return medicineListOfCARDIOLOGY;
    }

    public HashMap<String, Medicine> getMedicineListOfDERMATOLOGY() {
        return medicineListOfDERMATOLOGY;
    }

    public HashMap<String, Medicine> getMedicineListOfENT() {
        return medicineListOfENT;
    }

    public HashMap<String, Medicine> getMedicineListOfNEUROLOGY() {
        return medicineListOfNEUROLOGY;
    }

    public HashMap<String, Medicine> getMedicineListOfGERIATRIC() {
        return medicineListOfGERIATRIC;
    }

    public HashMap<String, Patient> getPatientListOfCARDIOLOGY() {
        return FileIO.getPatients("patientsCARDIOLOGY.txt", patientListOfCARDIOLOGY);
    }

    public HashMap<String, Patient> getPatientListOfDERMATOLOGY() {
        return FileIO.getPatients("patientsDERMATOLOGY.txt", patientListOfDERMATOLOGY);
    }

    public HashMap<String, Patient> getPatientListOfENT() {
        return FileIO.getPatients("patientsENT.txt", patientListOfENT);
    }

    public HashMap<String, Patient> getPatientListOfNEUROLOGY() {
        return FileIO.getPatients("patientsNEUROLOGY.txt", patientListOfNEUROLOGY);
    }

    public HashMap<String, Patient> getPatientListOfGERIATRIC() {
        return FileIO.getPatients("patientsGERIATRIC.txt", patientListOfGERIATRIC);
    }

    public HashMap<String, Patient> getSubHashMap(String fileName) {
        return null;
    }

    public void addNewPatient(int choice, Doctor doctor) throws ParseException, IOException {
        String allergyDetails = " ";
        int allergiesInt = 0;
        boolean allergies = false;

        Gender gender;

        String IDNumber = Validate.checkPatientID(sc, choice, Action.CHECK);

        System.out.print("Enter Patient's fist name: ");
        String firstName = sc.nextLine();


        System.out.print("Enter Patient's last name: ");
        String lastName = sc.nextLine();

        String yob = HandlingException.getBirthOfDay(sc);

        gender = HandlingException.getGender(sc);

        System.out.print("Enter Patient's address: ");
        String address = sc.nextLine();

        String telephone = Validate.getTelephoneNumber(sc);

        System.out.print("Enter Height of Patient(DV: Centime): ");
        double height = HandlingException.getDouble(sc);


        System.out.print("Enter Weight of Patient(DV: Kilogram): ");
        double weight = HandlingException.getDouble(sc);

        System.out.print("Enter the BloodType of Patient: ");
        String bloodType = sc.nextLine();

        do{
            System.out.printf("Allergies?: %10s"," ");
            System.out.printf("%10s|%10s|%10s|%10s","1.YES","2.NO","YOU CHOICE:"," ");
            allergiesInt = HandlingException.getInteger(sc);
            if (allergiesInt == 1) {
                allergies = true;
                System.out.print("Show the allergies: ");
                allergyDetails = sc.nextLine();
                System.out.println("Allergy details: " + allergyDetails);
            } else if (allergiesInt == 2) {
                allergyDetails = " ";
                System.out.println("The patient has no allergies!!!");
            } else {
                System.out.println("Invalid choice, please enter YES or NO.");
            }
        } while ( allergiesInt != 1 && allergiesInt != 2);
        switch (choice) {
            case 1:
                // ngoài add vào khoa cần add vào list của bác sĩ riêng là sublist của khoa.
                // list này chỉ cần lưu id của bệnh nhân tương tự với each case
                Patient patient = new Patient(IDNumber, firstName, lastName, yob, gender, address, telephone,
                        height, weight, bloodType, allergies, allergyDetails, Specialization.CARDIOLOGY);
                getPatientListOfCARDIOLOGY().put(IDNumber, patient);
                FileIO.writePatientDataToFile("patientsCARDIOLOGY.txt", patientListOfCARDIOLOGY);
                subHashMap.put(IDNumber,patientListOfCARDIOLOGY.get(IDNumber));
                String doctorNameFile = doctor.getLastName() + ".txt"; // tạo tên file riêng cho từng doctor
                FileIO.writePatientDataToFile(doctorNameFile, subHashMap);
                System.out.println("Add New Patient Successfully to Cardiology.");
                break;
            case 2:
                getPatientListOfDERMATOLOGY().put(IDNumber, new Patient(IDNumber, firstName, lastName, yob, gender, address, telephone,
                        height, weight, bloodType, allergies, allergyDetails, Specialization.DERMATOLOGY));
                FileIO.writePatientDataToFile("patientsDERMATOLOGY.txt", patientListOfDERMATOLOGY);
                System.out.println("Add New Patient Successfully to Dermatology.");
                break;
            case 3:
                getPatientListOfENT().put(IDNumber, new Patient(IDNumber, firstName, lastName, yob, gender, address, telephone,
                        height, weight, bloodType, allergies, allergyDetails, Specialization.ENT));
                FileIO.writePatientDataToFile("patientsENT.txt", patientListOfENT);
                System.out.println("Add New Patient Successfully to Entrepreneur.");
                break;
            case 4:
                getPatientListOfNEUROLOGY().put(IDNumber, new Patient(IDNumber, firstName, lastName, yob, gender, address, telephone,
                        height, weight, bloodType, allergies, allergyDetails, Specialization.NEUROLOGY));
                FileIO.writePatientDataToFile("patientsNEUROLOGY.txt", patientListOfNEUROLOGY);

                System.out.println("Add New Patient Successfully to Neurology.");
                break;
            case 5:
                getPatientListOfGERIATRIC().put(IDNumber, new Patient(IDNumber, firstName, lastName, yob, gender, address, telephone,
                        height, weight, bloodType, allergies, allergyDetails, Specialization.GERIATRIC));
                FileIO.writePatientDataToFile("patientsGERIATRIC.txt", patientListOfGERIATRIC);

                System.out.println("Add New Patient Successfully to Geriatric.");
                break;
        }
    }

    public void showPatientsList(int choice) {
        // show sublist bệnh nhân
        switch (choice) {
            case 1:
                if (patientListOfCARDIOLOGY.isEmpty()) {
                    System.out.println("No patients in CARDIOLOGY.");
                } else {
                    for (Map.Entry<String , Patient> entry : patientListOfCARDIOLOGY.entrySet()){
                        System.out.println(entry.getValue());
                    }
                }
                break;
            case 2:
                if(patientListOfDERMATOLOGY.isEmpty()) {
                    System.out.println("No patients in DERMATOLOGY.");
                } else{
                    for (Map.Entry<String , Patient> entry : patientListOfDERMATOLOGY.entrySet()){
                        System.out.println(entry.getValue());
                    }
                }
                break;
            case 3:
                if(patientListOfENT.isEmpty()) {
                    System.out.println("No patients in ENT.");
                } else{
                    for (Map.Entry<String , Patient> entry : patientListOfENT.entrySet()){
                        System.out.println(entry.getValue());
                    }
                }
                break;
            case 4:
                if(patientListOfNEUROLOGY.isEmpty()) {
                    System.out.println("No patients in NEUROLOGY.");
                } else{
                    for (Map.Entry<String , Patient> entry : patientListOfNEUROLOGY.entrySet()){
                        System.out.println(entry.getValue());
                    }
                }
                break;
            case 5:
                if(patientListOfGERIATRIC.isEmpty()) {
                    System.out.println("No patients in GERIATRIC.");
                } else{
                    for (Map.Entry<String , Patient> entry : patientListOfGERIATRIC.entrySet()){
                        System.out.println(entry.getValue());
                    }
                }
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

    }

    public void findPatientByIDNumber(String IDNumber, int choice) {
        String result = "Patient not found in the selected department.";
        switch (choice) {
            case 1:
                if (patientListOfCARDIOLOGY.containsKey(IDNumber)) {
                    result = patientListOfCARDIOLOGY.get(IDNumber).toString();
                    System.out.println("Patient: "+ result);
                }else{
                    System.out.println("Patient not found in the CARDIOLOGY list.");
                }
                break;
            case 2:
                if (patientListOfDERMATOLOGY.containsKey(IDNumber)) {
                    result = patientListOfDERMATOLOGY.get(IDNumber).toString();
                    System.out.println("Patient: "+ result);
                }else{
                    System.out.println("Patient not found in the Dermatology list.");
                }
                break;
            case 3:
                if (patientListOfENT.containsKey(IDNumber)) {
                    result = patientListOfENT.get(IDNumber).toString();
                    System.out.println("Patient: " + result);
                }else{
                    System.out.println("Patient not found in the Entrepreneur list.");
                }
                break;
            case 4:
                if (patientListOfNEUROLOGY.containsKey(IDNumber)) {
                    result = patientListOfNEUROLOGY.get(IDNumber).toString();
                    System.out.println("Patient: "+ result);
                }else{
                    System.out.println("Patient not found in the Neurology list.");
                }
                break;
            case 5:
                if (patientListOfGERIATRIC.containsKey(IDNumber)) {
                    result = patientListOfGERIATRIC.get(IDNumber).toString();
                    System.out.println("Patient: "+ result);
                }else{
                    System.out.println("Patient not found in the Geriatric list.");
                }
                break;
            default:
                result = "Invalid choice. Please choose a valid department.";
                break;
        }
    }
    public void UpdatePatientByID(String IDNumber, int choice) {
        boolean patientFound = false;
        String allergyDetails = " ";
        switch (choice){
            case 1:
                for (Map.Entry<String, Patient> entry : patientListOfCARDIOLOGY.entrySet()) {
                    if (entry.getValue().getIDNumber().equals(IDNumber)){
                        System.out.println("Enter new allergies: ");
                        allergyDetails = sc.nextLine();
                        entry.getValue().setAllergyDetails(allergyDetails);
                        System.out.println("Update Patient Successfully.");
                        patientFound = true; //danh dau la da tim thay benh nhan qua ID va update thong tin
                        break;
                    }
                }
                break;
            case 2:
                for (Map.Entry<String, Patient> entry : patientListOfDERMATOLOGY.entrySet()) {
                    if (entry.getValue().getIDNumber().equals(IDNumber)){
                        System.out.println("Enter new allergies: ");
                        allergyDetails = sc.nextLine();
                        entry.getValue().setAllergyDetails(allergyDetails);
                        System.out.println("Update Patient Successfully.");
                        patientFound = true; //danh dau la da tim thay benh nhan qua ID va update thong tin
                        break;
                    }
                }
                break;
            case 3:
                for (Map.Entry<String, Patient> entry : patientListOfENT.entrySet()) {
                    if (entry.getValue().getIDNumber().equals(IDNumber)){
                        System.out.println("Enter new allergies: ");
                        allergyDetails = sc.nextLine();
                        entry.getValue().setAllergyDetails(allergyDetails);
                        System.out.println("Update Patient Successfully.");
                        patientFound = true; //danh dau la da tim thay benh nhan qua ID va update thong tin
                        break;
                    }
                }
                break;
            case 4:
                for (Map.Entry<String, Patient> entry : patientListOfNEUROLOGY.entrySet()) {
                    if (entry.getValue().getIDNumber().equals(IDNumber)){
                        System.out.println("Enter new allergies: ");
                        allergyDetails = sc.nextLine();
                        entry.getValue().setAllergyDetails(allergyDetails);
                        System.out.println("Update Patient Successfully.");
                        patientFound = true; //danh dau la da tim thay benh nhan qua ID va update thong tin
                        break;
                    }
                }
                break;
            case 5:
                for (Map.Entry<String, Patient> entry : patientListOfGERIATRIC.entrySet()) {
                    if (entry.getValue().getIDNumber().equals(IDNumber)){
                        System.out.println("Enter new allergies: ");
                        allergyDetails = sc.nextLine();
                        entry.getValue().setAllergyDetails(allergyDetails);
                        System.out.println("Update Patient Successfully.");
                        patientFound = true; //danh dau la da tim thay benh nhan qua ID va update thong tin
                        break;
                    }
                }
                break;
            default:
                if (!patientFound && choice == 1) {
                    System.out.println("Patient not found.");  // Thông báo nếu không tìm thấy bệnh nhân
                }
                break;
        }
    }
    public void RemovePatientByID(String IDNumber, int choice){
        switch(choice){
            case 1:
                if(patientListOfCARDIOLOGY.containsKey(IDNumber)){
                    patientListOfCARDIOLOGY.remove(IDNumber);
                    System.out.println("Remove Patient Successfully.");
                }
                break;
            case 2:

                if(patientListOfDERMATOLOGY.containsKey(IDNumber)){
                    patientListOfDERMATOLOGY.remove(IDNumber);
                    System.out.println("Remove Patient Successfully.");
                }
                break;
            case 3:

                if(patientListOfENT.containsKey(IDNumber)){
                    patientListOfENT.remove(IDNumber);
                    System.out.println("Remove Patient Successfully.");
                }
                break;
            case 4:

                if(patientListOfNEUROLOGY.containsKey(IDNumber)){
                    patientListOfNEUROLOGY.remove(IDNumber);
                    System.out.println("Remove Patient Successfully.");
                }
                break;
            case 5:

                if(patientListOfGERIATRIC.containsKey(IDNumber)){
                    patientListOfGERIATRIC.remove(IDNumber);
                    System.out.println("Remove Patient Successfully.");
                }
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid department.");
                break;
        }
    }
}
