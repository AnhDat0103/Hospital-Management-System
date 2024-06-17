package container;

import exception.HandlingException;
import models.Doctor;
import models.Medicine;
import models.Patient;
import models.Person;
import models.enums.Education;
import models.enums.Gender;
import models.enums.Specialization;
import validation.Validate;


import java.text.ParseException;
import java.util.*;

public class Container {


     Scanner sc = new Scanner(System.in);
     private List<Person> personListOfCARDIOLOGY = new ArrayList<>();  // list of CARDIOLOGY. The list has information of doctors, patient in CARDIOLOGY.
     private List<Person> personListOfDERMATOLOGY = new ArrayList<>(); // list of DERMATOLOGY. The list has information of doctors, patient in DERMATOLOGY.
     private List<Person> personListOfENT = new ArrayList<>();         // list of ENT. The list has information of doctors, patient in ENT.
     private List<Person> personListOfNEUROLOGY = new ArrayList<>();   // list of NEUROLOGY. The list has information of doctors, patient in NEUROLOGY.
     private List<Person> personListOfGERIATRIC = new ArrayList<>();   // list of GERIATRIC. The list has information of doctors, patient in GERIATRIC.

     private HashMap<String, Patient> patientListOfCARDIOOGY = new HashMap<>();
     private HashMap<String, Patient> patientListOfDERMATOLOGY = new HashMap<>();
     private HashMap<String, Patient> patientListOfENT = new HashMap<>();
     private HashMap<String, Patient> patientListOfNEUROLOGY = new HashMap<>();
     private HashMap<String, Patient> patientListOfGERIATRIC = new HashMap<>();

     private HashMap<String, Medicine> medicineListOfCARDIOLOGY = new HashMap<>();
     private HashMap<String, Medicine> medicineListOfDERMATOLOGY = new HashMap<>();
     private HashMap<String, Medicine> medicineListOfENT = new HashMap<>();
     private HashMap<String, Medicine> medicineListOfNEUROLOGY = new HashMap<>();
     private HashMap<String, Medicine> medicineListOfGERIATRIC = new HashMap<>();

     public boolean checkAdministration(String userName, String password) throws ParseException {
          if (userName.matches("admin") && password.matches("admin")) {
               return true;
          } else {
               throw new ParseException("user name or password is incorrect", 0);
          }
     }

     public void addNewDoctor(int choice) throws ParseException {
          int choiceGender, choiceDoctorEducation;
          Gender gender = null;
          Education education = null;

          String IDNumber = HandlingException.checkID(sc);

          System.out.print("Enter Doctor's fist name: ");
          String firstName = sc.nextLine();

          System.out.print("Enter Doctor's last name: ");
          String lastName = sc.nextLine();

          String yob = HandlingException.getBirthOfDay(sc);


          do {
               System.out.printf("Gender?: %10s"," ");
               System.out.printf("%10s|%10s|%10s|%10s", "1.MALE", "2.FEMALE ", " Your choice:", " ");
               choiceGender = HandlingException.getInteger(sc);
               if (choiceGender == 1) {
                    gender = Gender.MALE;
               } else if (choiceGender == 2) {
                    gender = Gender.FEMALE;
               }
               else {
                    System.out.println("Invalid Gender");
               }
          } while ( choiceGender != 1 && choiceGender != 2);

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
                    personListOfCARDIOLOGY.add(new Doctor(IDNumber, firstName, lastName, yob, gender, address, telephone,
                                               yearOfExperience, clinicHours, education, Specialization.CARDIOLOGY ,
                                               consultationFee, patientListOfCARDIOOGY));
                    System.out.println("added new doctor.");
                    break;
               case 2:
                    personListOfDERMATOLOGY.add(new Doctor(IDNumber, firstName, lastName, yob,
                                                           gender, address, telephone, yearOfExperience,
                                                           clinicHours, education, Specialization.DERMATOLOGY,
                                                           consultationFee,patientListOfDERMATOLOGY));
                    break;
               case 3:
                    personListOfENT.add(new Doctor(IDNumber, firstName, lastName, yob,
                                                        gender, address, telephone, yearOfExperience,
                                                        clinicHours, education, Specialization.ENT,
                                                        consultationFee,patientListOfENT));
                    break;
               case 4:
                    personListOfNEUROLOGY.add(new Doctor(IDNumber, firstName, lastName, yob,
                                                        gender, address, telephone, yearOfExperience,
                                                        clinicHours, education, Specialization.NEUROLOGY,
                                                        consultationFee,patientListOfNEUROLOGY));
                    break;
               case 5:
                    personListOfGERIATRIC.add(new Doctor(IDNumber, firstName, lastName, yob,
                                                   gender, address, telephone, yearOfExperience,
                                                   clinicHours, education, Specialization.GERIATRIC,
                                                   consultationFee,patientListOfGERIATRIC));
                    break;
          }
     }

     public void showDoctorsList(int choice) {
          switch (choice) {
               case 1:
                    personListOfCARDIOLOGY.forEach(Doctor -> System.out.println(Doctor.toString()));
                    break;
               case 2:
                    personListOfDERMATOLOGY.forEach(Doctor -> System.out.println(Doctor.toString()));
                    break;
               case 3:
                    personListOfENT.forEach(Doctor -> System.out.println(Doctor.toString()));
                    break;
               case 4:
                    personListOfNEUROLOGY.forEach(Doctor -> System.out.println(Doctor.toString()));
                    break;
               case 5:
                    personListOfGERIATRIC.forEach(Doctor -> System.out.println(Doctor.toString()));
                    break;
          }
     }

     public Doctor FindDoctorByID(String IDNumber, int choice) {
          switch (choice) {
               case 1:
                    personListOfCARDIOLOGY.stream().filter(d -> d.getIDNumber().equals(IDNumber))
                            .findFirst().get();
                    break;
               case 2:
                    personListOfDERMATOLOGY.stream().filter(d -> d.getIDNumber().equals(IDNumber))
                            .findFirst().get();
                    break;
               case 3:
                    personListOfENT.stream().filter(d -> d.getIDNumber().equals(IDNumber))
                            .findFirst().get();
                    break;
               case 4:
                    personListOfNEUROLOGY.stream().filter(d -> d.getIDNumber().equals(IDNumber))
                            .findFirst().get();
                    break;
               case 5:
                    personListOfGERIATRIC.stream().filter(d -> d.getIDNumber().equals(IDNumber))
                            .findFirst().get();
                    break;
          }
          return null;
     }
     public void addNewPatient(int choice) throws ParseException {
          int choiceGender, allergies = 0;

          Gender gender = null;

          String IDNumber = HandlingException.checkID(sc);

          System.out.print("Enter Patient's fist name: ");
          String firstName = sc.nextLine();


          System.out.print("Enter Patient's last name: ");
          String lastName = sc.nextLine();


          String yob = HandlingException.getBirthOfDay(sc);


          do {
               System.out.printf("Gender?: %10s"," ");
               System.out.printf("%10s|%10s|%10s|%10s", "1.MALE", "2.FEMALE ", " Your choice:", " ");
               choiceGender = HandlingException.getInteger(sc);
               if (choiceGender == 1) {
                    gender = Gender.MALE;
               } else if (choiceGender == 2) {
                    gender = Gender.FEMALE;
               }
               else {
                    System.out.println("Invalid Gender");
               }
          } while ( choiceGender != 1 && choiceGender != 2);

          System.out.print("Enter Patient's address: ");
          String address = sc.nextLine();


          String telephone = Validate.getTelephoneNumber(sc);

          System.out.print("Enter Height of Patient(DV: Centimet): ");
          double height = HandlingException.getDouble(sc);


          System.out.print("Enter Weight of Patient(DV: Kilogram): ");
          double weight = HandlingException.getDouble(sc);

          System.out.print("Enter the BloodType of Patient: ");
          String bloodType = sc.nextLine();

          do{
               System.out.printf("Allergies?: %10s"," ");
               System.out.printf("%10s|%10s|%10s|%10s","1.YES","2.NO","YOU CHOICE:"," ");
               allergies = HandlingException.getInteger(sc);

               if (allergies == 1) {
                    System.out.print("Show the allergies: ");
                    sc.nextLine();
               } else if (allergies == 2) {
                    System.out.println("The patient has no allergies!!!");
               } else {
                    System.out.println("Invalid allergiesChoice");
               }
          } while ( allergies != 1 && allergies != 2);

          Patient newPatient = new Patient(IDNumber, firstName, lastName, yob,
                  gender, address, telephone, height, weight, bloodType,
                  allergies);
          switch (choice) {
               case 1:
                    patientListOfCARDIOOGY.put(IDNumber, newPatient);
                    System.out.println("Add New Patient Successfully to Cardioogy.");
                    break;
               case 2:
                    patientListOfDERMATOLOGY.put(IDNumber, newPatient);
                    System.out.println("Add New Patient Successfully to Dermatology.");
                    break;
               case 3:
                    patientListOfENT.put(IDNumber, newPatient);
                    System.out.println("Add New Patient Successfully to Entrepreneur.");
                    break;
               case 4:
                    patientListOfNEUROLOGY.put(IDNumber, newPatient);
                    System.out.println("Add New Patient Successfully to Neurology.");
                    break;
               case 5:
                    patientListOfGERIATRIC.put(IDNumber, newPatient);
                    System.out.println("Add New Patient Successfully to Geriatric.");
                    break;
          }
     }
     public void showPatientsList(int choice) {
          switch (choice) {
               case 1:
                    if (patientListOfCARDIOOGY.isEmpty()) {
                         System.out.println("No patients in CARDIOLOGY.");
                    } else {
                         for (Patient newPatien : patientListOfCARDIOOGY.values()) {
                              System.out.println(newPatien.toString());
                         }
                    }
                    break;
               case 2:
                    if(patientListOfDERMATOLOGY.isEmpty()) {
                         System.out.println("No patients in DERMATOLOGY.");
                    } else{
                         for (Patient newPatien : patientListOfCARDIOOGY.values()) {
                              System.out.println(newPatien.toString());
                         }
                    }
                    break;
               case 3:
                    if(patientListOfENT.isEmpty()) {
                         System.out.println("No patients in ENT.");
                    } else{
                         for (Patient newPatien : patientListOfCARDIOOGY.values()) {
                              System.out.println(newPatien.toString());
                         }
                    }
                    break;
               case 4:
                    if(patientListOfNEUROLOGY.isEmpty()) {
                         System.out.println("No patients in NEUROLOGY.");
                    } else{
                         for (Patient newPatien : patientListOfCARDIOOGY.values()) {
                              System.out.println(newPatien.toString());
                         }
                    }
                    break;
               case 5:
                    if(patientListOfGERIATRIC.isEmpty()) {
                         System.out.println("No patients in GERIATRIC.");
                    } else{
                         for (Patient newPatien : patientListOfCARDIOOGY.values()) {
                              System.out.println(newPatien.toString());
                         }
                    }
                    break;
               default:
                    System.out.println("Invalid choice");
                    break;
          }
     }

     public String findPatientByIDNumber(String IDNumber, int choice) {
          String result = "Patient not found in the selected department.";
          switch (choice) {
               case 1:
                    if (patientListOfCARDIOOGY.containsKey(IDNumber)) {
                         result = patientListOfCARDIOOGY.get(IDNumber).toString();
                    }
                    break;
               case 2:
                    if (patientListOfDERMATOLOGY.containsKey(IDNumber)) {
                         result = patientListOfDERMATOLOGY.get(IDNumber).toString();
                    }
                    break;
               case 3:
                    if (patientListOfENT.containsKey(IDNumber)) {
                         result = patientListOfENT.get(IDNumber).toString();
                    }
                    break;
               case 4:
                    if (patientListOfNEUROLOGY.containsKey(IDNumber)) {
                         result = patientListOfNEUROLOGY.get(IDNumber).toString();
                    }
                    break;
               case 5:
                    if (patientListOfGERIATRIC.containsKey(IDNumber)) {
                         result = patientListOfGERIATRIC.get(IDNumber).toString();
                    }
                    break;
               default:
                    result = "Invalid choice. Please choose a valid department.";
                    break;
          }
          return result;
     }
     public void UpdatePatientByID(String IDNumber, int choice) {
          switch (choice){
               case 1:
                    for (Map.Entry<String, Patient> entry : patientListOfCARDIOOGY.entrySet()) {
                         if (entry.getValue().getIDNumber().equals(IDNumber)){
                              String allergies = sc.nextLine();
                              entry.getValue().setAllergies(allergies);
                              patientListOfGERIATRIC.get(entry.setValue(entry.getValue()));

                         }
                    }
               case 2:
                    for (Map.Entry<String, Patient> entry : patientListOfDERMATOLOGY.entrySet()){
                         if (entry.getValue().getIDNumber().equals(IDNumber)){
                              String allergies = sc.nextLine();
                              entry.getValue().setAllergies(allergies);
                              patientListOfDERMATOLOGY.get(entry.setValue(entry.getValue()));
                         }
                    }
               case 3:
                    for (Map.Entry<String, Patient> entry : patientListOfENT.entrySet()){
                         if (entry.getValue().getIDNumber().equals(IDNumber)){
                              String allergies = sc.nextLine();
                              entry.getValue().setAllergies(allergies);
                              patientListOfENT.get(entry.setValue(entry.getValue()));
                         }
                    }
               case 4:
                    for (Map.Entry<String, Patient> entry : patientListOfNEUROLOGY.entrySet()){
                         if (entry.getValue().getIDNumber().equals(IDNumber)){
                              String allergies = sc.nextLine();
                              entry.getValue().setAllergies(allergies);
                              patientListOfNEUROLOGY.get(entry.setValue(entry.getValue()));
                         }
                    }
               case 5:
                    for (Map.Entry<String, Patient> entry : patientListOfGERIATRIC.entrySet()){
                         if (entry.getValue().getIDNumber().equals(IDNumber)){
                              String allergies = sc.nextLine();
                              entry.getValue().setAllergies(allergies);
                              patientListOfGERIATRIC.get(entry.setValue(entry.getValue()));
                         }
                    }
               default:
                    System.out.println("Invalid choice. Please choose a valid department.");
                    break;
          }
     }
     public void RemovePatientByID(String IDNumber, int choice){
          switch(choice){
               case 1:
                    if(patientListOfCARDIOOGY.containsKey(IDNumber)){
                         patientListOfCARDIOOGY.remove(IDNumber);
                    }
                    break;
               case 2:
                    if(patientListOfDERMATOLOGY.containsKey(IDNumber)){
                         patientListOfDERMATOLOGY.remove(IDNumber);
                    }
                    break;
               case 3:
                    if(patientListOfENT.containsKey(IDNumber)){
                         patientListOfENT.remove(IDNumber);
                    }
                    break;
               case 4:
                    if(patientListOfNEUROLOGY.containsKey(IDNumber)){
                         patientListOfNEUROLOGY.remove(IDNumber);
                    }
                    break;
               case 5:
                    if(patientListOfGERIATRIC.containsKey(IDNumber)){
                         patientListOfGERIATRIC.remove(IDNumber);
                    }
                    break;
               default:
                    System.out.println("Invalid choice. Please choose a valid department.");
                    break;
          }
     }






}
