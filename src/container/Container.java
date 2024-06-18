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

     private List<Person> persons;
     private HashMap<String, Patient> doctorListOfCARDIOLOGY ;
     private HashMap<String, Patient> doctorListOfDERMATOLOGY;
     private HashMap<String, Patient> doctorListOfENT;
     private HashMap<String, Patient> doctorListOfNEUROLOGY;
     private HashMap<String, Patient> doctorListOfGERIATRIC;

     private HashMap<String, Patient> patientListOfCARDIOLOGY ;
     private HashMap<String, Patient> patientListOfDERMATOLOGY;
     private HashMap<String, Patient> patientListOfENT;
     private HashMap<String, Patient> patientListOfNEUROLOGY;
     private HashMap<String, Patient> patientListOfGERIATRIC;

     private HashMap<String, Medicine> medicineListOfCARDIOLOGY;
     private HashMap<String, Medicine> medicineListOfDERMATOLOGY;
     private HashMap<String, Medicine> medicineListOfENT;
     private HashMap<String, Medicine> medicineListOfNEUROLOGY;
     private HashMap<String, Medicine> medicineListOfGERIATRIC;

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
                    personListOfCARDIOLOGY.add(new Doctor(IDNumber, firstName, lastName, yob,
                                                          gender, address, telephone, yearOfExperience,
                                                          clinicHours, education, Specialization.CARDIOLOGY,
                                                          consultationFee,doctorListOfCARDIOLOGY));
                    break;
               case 2:
                    personListOfDERMATOLOGY.add(new Doctor(IDNumber, firstName, lastName, yob,
                                                           gender, address, telephone, yearOfExperience,
                                                           clinicHours, education, Specialization.DERMATOLOGY,
                                                           consultationFee,doctorListOfDERMATOLOGY));
                    break;
               case 3:
                    personListOfENT.add(new Doctor(IDNumber, firstName, lastName, yob,
                                                        gender, address, telephone, yearOfExperience,
                                                        clinicHours, education, Specialization.ENT,
                                                        consultationFee,doctorListOfENT));
                    break;
               case 4:
                    personListOfNEUROLOGY.add(new Doctor(IDNumber, firstName, lastName, yob,
                                                        gender, address, telephone, yearOfExperience,
                                                        clinicHours, education, Specialization.NEUROLOGY,
                                                        consultationFee,doctorListOfNEUROLOGY));
                    break;
               case 5:
                    personListOfGERIATRIC.add(new Doctor(IDNumber, firstName, lastName, yob,
                                                   gender, address, telephone, yearOfExperience,
                                                   clinicHours, education, Specialization.GERIATRIC,
                                                   consultationFee,doctorListOfGERIATRIC));
                    break;
               default:
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
          int choiceGender, allergies;
          Gender gender = null;

          String IDNumber = HandlingException.checkID(sc);

          System.out.print("Enter Patient's fist name: ");
          String firstName = sc.nextLine();


          System.out.print("Enter Patient's last name: ");
          String lastName = sc.nextLine();


          String yob = HandlingException.getBirthOfDay(sc);


          do {
               System.out.printf("Gender?: %10s"," ");
               System.out.printf("%10s|%10s", "1.MALE", "2.FEMALE");
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

          System.out.println("Enter Height of Patient: ");
          double height = HandlingException.getDouble(sc);


          System.out.println("Enter Weight of Patient: ");
          double weight = HandlingException.getDouble(sc);

          System.out.println("Enter the BloodType of Patient: ");
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
                    patientListOfCARDIOLOGY.put(IDNumber, newPatient);
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
                    if (patientListOfCARDIOLOGY.isEmpty()) {
                         System.out.println("No patients in CARDIOLOGY.");
                    } else {
                         for (Patient newPatien : patientListOfCARDIOLOGY.values()) {
                              System.out.println(newPatien.toString());
                         }
                    }
                    break;
               case 2:
                    if(patientListOfDERMATOLOGY.isEmpty()) {
                         System.out.println("No patients in DERMATOLOGY.");
                    } else{
                         for (Patient newPatien : patientListOfCARDIOLOGY.values()) {
                              System.out.println(newPatien.toString());
                         }
                    }
                    break;
               case 3:
                    if(patientListOfENT.isEmpty()) {
                         System.out.println("No patients in ENT.");
                    } else{
                         for (Patient newPatien : patientListOfCARDIOLOGY.values()) {
                              System.out.println(newPatien.toString());
                         }
                    }
                    break;
               case 4:
                    if(patientListOfNEUROLOGY.isEmpty()) {
                         System.out.println("No patients in NEUROLOGY.");
                    } else{
                         for (Patient newPatien : patientListOfCARDIOLOGY.values()) {
                              System.out.println(newPatien.toString());
                         }
                    }
                    break;
               case 5:
                    if(patientListOfGERIATRIC.isEmpty()) {
                         System.out.println("No patients in GERIATRIC.");
                    } else{
                         for (Patient newPatien : patientListOfCARDIOLOGY.values()) {
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
                    if (patientListOfCARDIOLOGY.containsKey(IDNumber)) {
                         result = patientListOfCARDIOLOGY.get(IDNumber).toString();
                    }
                    break;
               case 2:
                    if (patientListOfDERMATOLOGY.containsKey(IDNumber)) {
                         result = patientListOfDERMATOLOGY.get(IDNumber).toString();
                         System.out.println("Patient: "+ result);
                    }
                    break;
               case 3:
                    if (patientListOfENT.containsKey(IDNumber)) {
                         result = patientListOfENT.get(IDNumber).toString();
                         System.out.println("Patient: "+ result);
                    }
                    break;
               case 4:
                    if (patientListOfNEUROLOGY.containsKey(IDNumber)) {
                         result = patientListOfNEUROLOGY.get(IDNumber).toString();
                         System.out.println("Patient: "+ result);
                    }
                    break;
               case 5:
                    if (patientListOfGERIATRIC.containsKey(IDNumber)) {
                         result = patientListOfGERIATRIC.get(IDNumber).toString();
                         System.out.println("Patient: "+ result);
                    }
                    break;
               default:
                    result = "Invalid choice. Please choose a valid department.";
                    break;
          }
          return result;
     }

     //update tình tình trạng bệnh nhân đã có sẵn theo id
     public void UpdatePatientByID(String idNumber, int choice) {
     }

     //xóa bệnh nhân theo id
     public void RemovePatientByID(String idNumber, int choice) {
     }

}
