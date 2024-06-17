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
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Container {


     Scanner sc = new Scanner(System.in);
     private List<Person> personListOfCARDIOLOGY;  // list of CARDIOLOGY. The list has information of doctors, patient in CARDIOLOGY.
     private List<Person> personListOfDERMATOLOGY; // list of DERMATOLOGY. The list has information of doctors, patient in DERMATOLOGY.
     private List<Person> personListOfENT;         // list of ENT. The list has information of doctors, patient in ENT.
     private List<Person> personListOfNEUROLOGY;   // list of NEUROLOGY. The list has information of doctors, patient in NEUROLOGY.
     private List<Person> personListOfGERIATRIC;   // list of GERIATRIC. The list has information of doctors, patient in GERIATRIC.

     private List<Person> persons;
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

          System.out.print("Enter doctor's address: ");
          String address = sc.nextLine();

          String telephone = Validate.getTelephoneNumber(sc);

          System.out.print("Enter doctor's years of experience: ");
          int yearOfExperience = HandlingException.getInteger(sc);

          System.out.print("Enter doctor's clinic hours: ");
          int clinicHours = Validate.getClinicHours(HandlingException.getInteger(sc));


          do {
               System.out.printf("Choose doctor's education:%10s", " ");
               System.out.printf("%10s|%10s|%10s", "1. DOCTOR", "2. PROFESSOR", "3. ASSOCIATE_PROFESSOR" );
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
                                                          consultationFee,patientListOfCARDIOLOGY));
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


     // method hiện information của patient
    public void showPatientsList(int choice) {
         switch (choice) {
              case 1:
                   for (Patient patient : patientListOfCARDIOLOGY.values()) {
                        System.out.println(patient.tostring());
                   }
                   break;
              case 2:
                   for (Patient patient : patientListOfDERMATOLOGY.values()) {
                        System.out.println(patient.toString());
                   }
                   break;
              case 3:
                   for (Patient patient : patientListOfENT.values()) {
                        System.out.println(patient.toString());
                   }
                   break;
              case 4:
                   for (Patient patient : patientListOfNEUROLOGY.values()) {
                        System.out.println(patient.toString());
                   }
                   break;
              case 5:
                   for (Patient patient : patientListOfGERIATRIC.values()) {
                        System.out.println(patient.toString());
                   }
                   break;


         }
    }






















}
