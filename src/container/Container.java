package container;

import exception.HandlingException;
import models.Doctor;
import models.Medicine;
import models.Patient;
import models.Person;
import models.enums.Gender;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import validation.Validate;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Container {

//     private List<Patient> patients = new ArrayList<>();
     Scanner sc = new Scanner(System.in);
     private List<Person> personListOfCARDIOLOGY;  // list of CARDIOLOGY. The list has information of doctors, patient in CARDIOLOGY.
     private List<Person> personListOfDERMATOLOGY; // list of DERMATOLOGY. The list has information of doctors, patient in DERMATOLOGY.
     private List<Person> personListOfENT;         // list of ENT. The list has information of doctors, patient in ENT.
     private List<Person> personListOfNEUROLOGY;   // list of NEUROLOGY. The list has information of doctors, patient in NEUROLOGY.
     private List<Person> personListOfGERIATRIC;   // list of GERIATRIC. The list has information of doctors, patient in GERIATRIC.

     private List<Person> persons;
     private HashMap<String, Patient> patientListOfCARDIOLOGY;
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
          switch (choice) {
               case 1:
                    System.out.print("Enter Doctor's ID((CDL/DML/ENT/NRL/GIT)XXXX): ");
                    String IDNumber = HandlingException.checkID(sc);
                    System.out.print("Enter Doctor's fist name: ");
                    String firstName = sc.nextLine();
                    System.out.print("Enter Doctor's last name: ");
                    String lastName = sc.nextLine();
                    System.out.println("Enter doctor's birth date(DD/MM/YYYY): ");
                    String yob = HandlingException.getBirthOfDay(sc);
                    System.out.printf("Gender?: %10s"," ");
                    System.out.printf("%10s|%10s", "1.MALE", "2.FEMALE");
                    int choiceGender = HandlingException.getInteger(sc);
                    if (choiceGender == 1) {
                         Gender gender = Gender.MALE;
                    }
                    if (choiceGender == 2) {
                         Gender gender = Gender.FEMALE;
                    }
                    System.out.print("Enter doctor's address: ");
                    String address = sc.nextLine();
                    System.out.print("Enter doctor's phone number(+XXX-XXXXXXXX): ");
                    String telephone = Validate.getTelephoneNumber(sc);
                    System.out.print("Enter doctor's years of experience: ");
                    int yearOfExperience = HandlingException.getInteger(sc);
                    System.out.print("Enter doctor's clinic hours: ");
                    int clinicHours = Validate.getClinicHours(HandlingException.getInteger(sc));



                    personListOfCARDIOLOGY.add(new Doctor());
                    break;
               case 2:
                    personListOfDERMATOLOGY.add(new Doctor());
                    break;
               case 3:
                    personListOfENT.add(new Doctor());
                    break;
               case 4:
                    personListOfNEUROLOGY.add(new Doctor());
                    break;
               case 5:
                    personListOfGERIATRIC.add(new Doctor());
                    break;
          }
     }

     public void showDoctorsList(int choice) throws ParseException {
          switch (choice) {
               case 1:
                    personListOfCARDIOLOGY.stream().forEach(Doctor -> System.out.println(Doctor.toString()));
                    break;
               case 2:
                    personListOfDERMATOLOGY.add(new Doctor());
                    break;
               case 3:
                    personListOfENT.add(new Doctor());
                    break;
               case 4:
                    personListOfNEUROLOGY.add(new Doctor());
                    break;
               case 5:
                    personListOfGERIATRIC.add(new Doctor());
                    break;
          }
     }


     // Phương thức thêm bệnh nhân

//     public void addPatient(Patient patient) {
//          patients.add(patient);
//          System.out.println("Patient " + patient.getIDNumber() + " add patient completed ");
//
//     }

     // Phương thức lấy danh sách bệnh nhân
//     public List<Patient> getListPatients() {
//          return patients;
//     }

     // Phương thức tìm kiếm ID theo bệnh nhân

//     public Patient findPatientByID(String id){
//
//          for(int i = 0 ; i < patients.size() ; i++){
//               if(patients.get(i).getIDNumber().equals(id)){  // kểm tra bệnh nhân rồi equals xem co trung voi id  nhap voi tim kiem khong
//                    return patients.get(i);
//               }
//          }
//          return null;
//     }





}
