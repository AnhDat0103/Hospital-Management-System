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
import viewLayer.ViewMain;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class PatientController {

    private  List<Medicine> medicineListOfCARDIOLOGY = new ArrayList<>();
    private  List<Medicine> medicineListOfDERMATOLOGY = new ArrayList<>();
    private  List<Medicine> medicineListOfENT = new ArrayList<>();
    private  List<Medicine> medicineListOfNEUROLOGY = new ArrayList<>();
    private  List<Medicine> medicineListOfGERIATRIC = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    private  HashMap<String, Patient> patientListOfCARDIOLOGY = new HashMap<>(); //list of CARDIOLOGY. The list has information of patients, medicine of patients in CARDIOLOGY.
    private  HashMap<String, Patient> patientListOfDERMATOLOGY = new HashMap<>(); //list of CARDIOLOGY. The list has information of patients, medicine of patients in DERMATOLOGY.
    private  HashMap<String, Patient> patientListOfENT = new HashMap<>(); //list of CARDIOLOGY. The list has information of patients, medicine of patients in ENT.
    private  HashMap<String, Patient> patientListOfNEUROLOGY = new HashMap<>(); //list of CARDIOLOGY. The list has information of patients, medicine of patients in NEUROLOGY.
    private  HashMap<String, Patient> patientListOfGERIATRIC = new HashMap<>(); //list of CARDIOLOGY. The list has information of patients, medicine of patients in GERIATRIC.

    HashMap<String, Patient> subHashMap = new HashMap<>(); // list patient for each doctor
    List<Medicine> subMedicine = new ArrayList<>();

    public List<Medicine> getMedicineListOfCARDIOLOGY() {
        return FileIO.getMedicines("medicinesOfCARDIOLOGY.txt", medicineListOfCARDIOLOGY);
    }

    public List<Medicine> getMedicineListOfDERMATOLOGY() {
        return FileIO.getMedicines("medicinesOfDERMATOLOGY.txt", medicineListOfDERMATOLOGY);
    }

    public List<Medicine> getMedicineListOfENT() {
        return FileIO.getMedicines("medicinesOfENT.txt", medicineListOfENT);
    }

    public List<Medicine> getMedicineListOfNEUROLOGY() {
        return FileIO.getMedicines("medicinesOfNEUROLOGY.txt", medicineListOfNEUROLOGY);
    }

    public List<Medicine> getMedicineListOfGERIATRIC() {
        return FileIO.getMedicines("medicinesOfGERIATRIC.txt", medicineListOfGERIATRIC);
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

    public HashMap<String, Patient> getSubHashMap(Doctor doctor) {
        String doctorNameFile = doctor.getFullName() + ".txt";
        return FileIO.getPatients(doctorNameFile, subHashMap);
    }

    public List<Medicine> getSubMedicine(String fileName) {
        return FileIO.getMedicines(fileName, subMedicine);
    }

    public void addNewPatient(int choice, Doctor doctor) throws ParseException, IOException {
        String doctorNameFile = doctor.getFullName() + ".txt"; // tạo tên file riêng cho từng doctor
        String allergyDetails = " ";
        int allergiesInt = 0;
        boolean allergies = false;
        String IDNumber = Validate.checkPatientID(sc, choice, Action.CHECK);

        System.out.print("Enter Patient's fist name: ");
        String firstName = sc.nextLine();


        System.out.print("Enter Patient's last name: ");
        String lastName = sc.nextLine();

        String yob = HandlingException.getBirthOfDay(sc);

        Gender gender = HandlingException.getGender(sc);

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
                System.out.print("Input the allergies: ");
                allergyDetails = sc.nextLine();
                System.out.println("Allergy details: " + allergyDetails);
            } else if (allergiesInt == 2) {
                allergyDetails = " ";
                System.out.println("The patient has no allergies!!!");
            } else {
                System.out.println("Invalid choice, please enter YES or NO.");
            }
        } while ( allergiesInt != 1 && allergiesInt != 2);

        Patient patient = new Patient(IDNumber, firstName, lastName, yob, gender, address, telephone,
                height, weight, bloodType, allergies, allergyDetails, Specialization.CARDIOLOGY);

        switch (choice) {
            case 1:
                getPatientListOfCARDIOLOGY().put(IDNumber, patient);
                FileIO.writePatientDataToFile("patientsCARDIOLOGY.txt", patientListOfCARDIOLOGY);
                getSubHashMap(doctor).put(IDNumber,patientListOfCARDIOLOGY.get(IDNumber));
                FileIO.writePatientDataToFile(doctorNameFile, subHashMap);
                System.out.println("Add New Patient Successfully to Cardiology.");
                break;
            case 2:
                getPatientListOfDERMATOLOGY().put(IDNumber, patient);
                FileIO.writePatientDataToFile("patientsDERMATOLOGY.txt", patientListOfDERMATOLOGY);
                getSubHashMap(doctor).put(IDNumber,patientListOfDERMATOLOGY.get(IDNumber));
                FileIO.writePatientDataToFile(doctorNameFile, subHashMap);
                System.out.println("Add New Patient Successfully to Dermatology.");
                break;
            case 3:
                getPatientListOfENT().put(IDNumber, patient);
                FileIO.writePatientDataToFile("patientsENT.txt", patientListOfENT);
                getSubHashMap(doctor).put(IDNumber,patientListOfENT.get(IDNumber));
                FileIO.writePatientDataToFile(doctorNameFile, subHashMap);
                System.out.println("Add New Patient Successfully to Entrepreneur.");
                break;
            case 4:
                getPatientListOfNEUROLOGY().put(IDNumber, patient);
                FileIO.writePatientDataToFile("patientsNEUROLOGY.txt", patientListOfNEUROLOGY);
                getSubHashMap(doctor).put(IDNumber,patientListOfNEUROLOGY.get(IDNumber));
                FileIO.writePatientDataToFile(doctorNameFile, subHashMap);
                System.out.println("Add New Patient Successfully to Neurology.");
                break;
            case 5:
                getPatientListOfGERIATRIC().put(IDNumber, patient);
                FileIO.writePatientDataToFile("patientsGERIATRIC.txt", patientListOfGERIATRIC);
                getSubHashMap(doctor).put(IDNumber,patientListOfGERIATRIC.get(IDNumber));
                FileIO.writePatientDataToFile(doctorNameFile, subHashMap);
                System.out.println("Add New Patient Successfully to Geriatric.");
                break;
        }
    }

    public void showPatientsList(Doctor doctor) {
        // show sublist bệnh nhân
        Patient.getHead();
        for (Patient patient : getSubHashMap(doctor).values()) {
            patient.generateTable();
        }
    }

    public void findPatientByIDNumber(int choice, Doctor doctor) throws IOException {
        HashMap<String, Patient> patientHashMap = getSubHashMap(doctor);
        System.out.print("Enter the IDNumber of patient you want to search for: ");
        String id = Validate.checkPatientID(sc, choice, Action.FIND);
        if (patientHashMap.isEmpty()) System.out.println("No one in patient list.");
        if (patientHashMap.containsKey(id)) {
            Patient.getHead();
            patientHashMap.get(id).generateTable();
        } else {
            System.out.println("Patient not found.");
        }
    }
    public void UpdatePatientByID(int choice, Doctor  doctor) throws IOException, ParseException {
        HashMap<String, Patient> patientHashMap = getSubHashMap(doctor);
        String fileName = doctor.getFullName() + ".txt";
        boolean allergies = false;
        String allergyDetails = " ";
        int allergiesInt;
        System.out.print("Enter the IDNumber of patient you want to update for: ");
        String id = Validate.checkPatientID(sc, choice, Action.FIND);
        if (patientHashMap.isEmpty()) System.out.println("No one in patient list.");
        if (patientHashMap.containsKey(id)) {
            System.out.print("Enter Patient's fist name: ");
            patientHashMap.get(id).setFirstName(sc.nextLine());

            System.out.print("Enter Patient's last name: ");
            patientHashMap.get(id).setLastName(sc.nextLine());

            patientHashMap.get(id).setYob(HandlingException.getBirthOfDay(sc));
            patientHashMap.get(id).setGender(HandlingException.getGender(sc));

            System.out.print("Enter Height of Patient(DV: Centime): ");
            patientHashMap.get(id).setHeight(HandlingException.getDouble(sc));

            System.out.print("Enter Weight of Patient(DV: Kilogram): ");
            patientHashMap.get(id).setWeight(HandlingException.getDouble(sc));

            System.out.print("Enter the BloodType of Patient: ");
            patientHashMap.get(id).setBloodType(sc.nextLine());

            do{
                System.out.printf("Allergies?: %10s"," ");
                System.out.printf("%10s|%10s|%10s|%10s","1.YES","2.NO","YOU CHOICE:"," ");
                allergiesInt = HandlingException.getInteger(sc);
                if (allergiesInt == 1) {
                    patientHashMap.get(id).setAllergies(true);
                    System.out.print("Show the allergies: ");
                    patientHashMap.get(id).setAllergyDetails(sc.nextLine());
                } else if (allergiesInt == 2) {
                    patientHashMap.get(id).setAllergies(allergies);
                    patientHashMap.get(id).setAllergyDetails(allergyDetails);
                    System.out.println("The patient has no allergies!!!");
                } else {
                    System.out.println("Invalid choice, please enter YES or NO.");
                }
            } while ( allergiesInt != 1 && allergiesInt != 2);

            Patient updatedPatient = patientHashMap.get(id);
            switch (choice) {
                case 1:
                    getPatientListOfCARDIOLOGY().put(id, updatedPatient);
                    FileIO.writePatientDataToFile(fileName, getSubHashMap(doctor));
                    FileIO.writePatientDataToFile("patientsCARDIOLOGY.txt", patientListOfCARDIOLOGY);
                    break;
                case 2:
                    getPatientListOfDERMATOLOGY().put(id, updatedPatient);
                    FileIO.writePatientDataToFile(fileName, getSubHashMap(doctor));
                    FileIO.writePatientDataToFile("patientsDERMATOLOGY.txt", patientListOfDERMATOLOGY);
                    break;
                case 3:
                    getPatientListOfENT().put(id, updatedPatient);
                    FileIO.writePatientDataToFile(fileName, getSubHashMap(doctor));
                    FileIO.writePatientDataToFile("patientsENT.txt", patientListOfENT);
                    break;
                case 4:
                    getPatientListOfNEUROLOGY().put(id, updatedPatient);
                    FileIO.writePatientDataToFile(fileName, getSubHashMap(doctor));
                    FileIO.writePatientDataToFile("patientsNEUROLOGY.txt", patientListOfNEUROLOGY);
                    break;
                case 5:
                    getPatientListOfGERIATRIC().put(id, updatedPatient);
                    FileIO.writePatientDataToFile(fileName, getSubHashMap(doctor));
                    FileIO.writePatientDataToFile("patientsGERIATRIC.txt", patientListOfGERIATRIC);
                    break;
                default: break;
            }
        } else {
            System.out.println("Patient not found.");
        }
    }

    public void RemovePatientByID(int choice, Doctor doctor) throws IOException {
        HashMap<String, Patient> patientHashMap = getSubHashMap(doctor);
        System.out.print("Enter the IDNumber of patient you want to search for: ");
        String id = Validate.checkPatientID(sc, choice, Action.FIND);
        String fileName = doctor.getFullName() + ".txt";
        if (patientHashMap.isEmpty()) System.out.println("No one in patient list.");
        if (patientHashMap.containsKey(id)) {
            patientHashMap.remove(id);
            System.out.println("Remove is successful");
            FileIO.writePatientDataToFile(fileName, patientHashMap);
            switch (choice) {
                case 1:
                    getPatientListOfCARDIOLOGY().remove(id);
                    FileIO.writePatientDataToFile("patientsCARDIOLOGY.txt", patientListOfCARDIOLOGY);
                    break;
                case 2:
                    getPatientListOfDERMATOLOGY().remove(id);
                    FileIO.writePatientDataToFile("patientsDERMATOLOGY.txt", patientListOfDERMATOLOGY);
                    break;
                case 3:
                    getPatientListOfENT().remove(id);
                    FileIO.writePatientDataToFile("patientsENT.txt", patientListOfENT);
                    break;
                case 4:
                    getPatientListOfNEUROLOGY().remove(id);
                    FileIO.writePatientDataToFile("patientsNEUROLOGY.txt", patientListOfNEUROLOGY);
                    break;
                case 5:
                    getPatientListOfGERIATRIC().remove(id);
                    FileIO.writePatientDataToFile("patientsGERIATRIC.txt", patientListOfGERIATRIC);
                    break;
                default: break;
            }
        } else {
            System.out.println("Patient not found.");
        }
    }

    public void addMedicineToPatient(int choice, Doctor doctor) throws IOException {
        System.out.print("Enter the IDNumber of patient you want to search for: ");
        String id = Validate.checkPatientID(sc, choice, Action.FIND);
        String fileName = getSubHashMap(doctor).get(id).getFullName() + ".pnt.txt";
        FileIO.writeMedicineDataToFile(fileName, subMedicine);
        String medicineID;
        if (getSubHashMap(doctor).isEmpty()) System.out.println("No one in patient list.");
        if (getSubHashMap(doctor).containsKey(id)) {
            switch (choice) {
                case 1:
                    if (getMedicineListOfCARDIOLOGY().isEmpty()) System.out.println("No one in medicine list.");
                    do {
                        Medicine.getHead();
                        getMedicineListOfCARDIOLOGY().forEach(Medicine::generateTable);
                        System.out.print("Enter ID of medicine you want to add( Enter 0 to finish addition): ");
                        medicineID = sc.nextLine();
                        Medicine medicine = findMedicineByID(getMedicineListOfCARDIOLOGY(), medicineID);
                        if (medicine != null) {
                            getSubMedicine(fileName).add(medicine);
                        }
                    } while (!medicineID.equals("0"));
                    getSubHashMap(doctor).get(id).addMedicine(getSubMedicine(fileName));
                    FileIO.writeMedicineDataToFile(fileName, getSubMedicine(fileName));
                    System.out.println("Medicine added successfully.");
                    break;
                case 2:
                     if (getMedicineListOfDERMATOLOGY().isEmpty()) System.out.println("No one in medicine list.");
                    do {
                        Medicine.getHead();
                        getMedicineListOfENT().forEach(Medicine::generateTable);
                        System.out.print("Enter ID of medicine you want to add( Enter 0 to finish addition): ");
                        medicineID = sc.nextLine();
                        Medicine medicine = findMedicineByID(getMedicineListOfDERMATOLOGY(), medicineID);
                        if (medicine != null) {
                            getSubMedicine(fileName).add(medicine);
                        }
                    } while (!medicineID.equals("0"));
                    getSubHashMap(doctor).get(id).addMedicine(getSubMedicine(fileName));
                    FileIO.writeMedicineDataToFile(fileName, getSubMedicine(fileName));
                    System.out.println("Medicine added successfully.");
                    break;
                case 3:
                     if (getMedicineListOfENT().isEmpty()) System.out.println("No one in medicine list.");
                    do {
                        Medicine.getHead();
                        getMedicineListOfENT().forEach(Medicine::generateTable);
                        System.out.print("Enter ID of medicine you want to add( Enter 0 to finish addition): ");
                        medicineID = sc.nextLine();
                        Medicine medicine = findMedicineByID(getMedicineListOfENT(), medicineID);
                        if (medicine != null) {
                            getSubMedicine(fileName).add(medicine);
                        }
                    } while (!medicineID.equals("0"));
                    getSubHashMap(doctor).get(id).addMedicine(getSubMedicine(fileName));
                    FileIO.writeMedicineDataToFile(fileName, getSubMedicine(fileName));
                    System.out.println("Medicine added successfully.");
                    break;
                case 4:
                     if (getMedicineListOfNEUROLOGY().isEmpty()) System.out.println("No one in medicine list.");
                    do {
                        Medicine.getHead();
                        getMedicineListOfNEUROLOGY().forEach(Medicine::generateTable);
                        System.out.print("Enter ID of medicine you want to add( Enter 0 to finish addition): ");
                        medicineID = sc.nextLine();
                        Medicine medicine = findMedicineByID(getMedicineListOfNEUROLOGY(), medicineID);
                        if (medicine != null) {
                            getSubMedicine(fileName).add(medicine);
                        }
                    } while (!medicineID.equals("0"));
                    getSubHashMap(doctor).get(id).addMedicine(getSubMedicine(fileName));
                    FileIO.writeMedicineDataToFile(fileName, getSubMedicine(fileName));
                    System.out.println("Medicine added successfully.");
                    break;
                case 5:
                     if (getMedicineListOfGERIATRIC().isEmpty()) System.out.println("No one in medicine list.");
                    do {
                        Medicine.getHead();
                        getMedicineListOfGERIATRIC().forEach(Medicine::generateTable);
                        System.out.print("Enter ID of medicine you want to add( Enter 0 to finish addition): ");
                        medicineID = sc.nextLine();
                        Medicine medicine = findMedicineByID(getMedicineListOfGERIATRIC(), medicineID);
                        if (medicine != null) {
                            getSubMedicine(fileName).add(medicine);
                        }
                    } while (!medicineID.equals("0"));
                    getSubHashMap(doctor).get(id).addMedicine(getSubMedicine(fileName));
                    FileIO.writeMedicineDataToFile(fileName, getSubMedicine(fileName));
                    System.out.println("Medicine added successfully.");
                    break;
                default: break;
            }
        } else {
            System.out.println("Patient not found.");
        }
    }

    public Medicine findMedicineByID(List<Medicine> medicines, String id){
        if (medicines.isEmpty()) return null;
        else {
            return medicines.stream().filter(i -> i.getMedicineID().matches(id)).findFirst().orElse(null);
        }
    }
}
