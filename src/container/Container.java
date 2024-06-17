package container;

import exception.HandlingException;
import models.Doctor;
import models.Medicine;
import models.Patient;
import models.Person;
import models.enums.DosageForm;
import models.enums.Education;
import models.enums.Gender;
import models.enums.Specialization;
import validation.Validate;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Container {


     Scanner sc = new Scanner(System.in);
     private final List<Person> personListOfCARDIOLOGY = new ArrayList<>();  // list of CARDIOLOGY. The list has information of doctors, patient in CARDIOLOGY.
     private final List<Person> personListOfDERMATOLOGY = new ArrayList<>(); // list of DERMATOLOGY. The list has information of doctors, patient in DERMATOLOGY.
     private final List<Person> personListOfENT = new ArrayList<>();         // list of ENT. The list has information of doctors, patient in ENT.
     private final List<Person> personListOfNEUROLOGY = new ArrayList<>();   // list of NEUROLOGY. The list has information of doctors, patient in NEUROLOGY.
     private final List<Person> personListOfGERIATRIC = new ArrayList<>();   // list of GERIATRIC. The list has information of doctors, patient in GERIATRIC.

     private final List<Medicine> medicinesOfCARDIOLOGY = new ArrayList<>();    // list of CARDIOLOGY. The list has information of medicines in CARDIOLOGY.
     private final List<Medicine> medicinesOfDERMATOLOGY = new ArrayList<>();   // list of DERMATOLOGY. The list has information of medicines in DERMATOLOGY.
     private final List<Medicine> medicinesOfENT = new ArrayList<>();           // list of ENT. The list has information of medicines in ENT.
     private final List<Medicine> medicinesOfNEUROLOGY = new ArrayList<>();     // list of NEUROLOGY. The list has information of medicines in NEUROLOGY.
     private final List<Medicine> medicinesOfGERIATRIC = new ArrayList<>();     // list of GERIATRIC. The list has information of medicines in GERIATRIC.

     private final HashMap<String, Patient> patientListOfCARDIOLOGY = new HashMap<>();
     private final HashMap<String, Patient> patientListOfDERMATOLOGY = new HashMap<>();
     private final HashMap<String, Patient> patientListOfENT = new HashMap<>();
     private final HashMap<String, Patient> patientListOfNEUROLOGY = new HashMap<>();
     private final HashMap<String, Patient> patientListOfGERIATRIC = new HashMap<>();

     private final HashMap<String, Medicine> medicineListOfCARDIOLOGY = new HashMap<>();
     private final HashMap<String, Medicine> medicineListOfDERMATOLOGY = new HashMap<>();
     private final HashMap<String, Medicine> medicineListOfENT = new HashMap<>();
     private final HashMap<String, Medicine> medicineListOfNEUROLOGY = new HashMap<>();
     private final HashMap<String, Medicine> medicineListOfGERIATRIC = new HashMap<>();

     // METHOD OF ADMIN
     public boolean checkAdministration(String userName, String password) throws ParseException {
          if (userName.matches("admin") && password.matches("admin")) {
               return true;
          } else {
               throw new ParseException("user name or password is incorrect", 0);
          }
     }

     // METHOD OF DOCTOR
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
               System.out.printf("%10s|%10s|%10s|%10s", "1.MALE", "2.FEMALE", "Your choice:", " ");
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
                                               consultationFee, patientListOfCARDIOLOGY));
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

     public Doctor findDoctorByID(String IDNumber, int choice) {
          switch (choice) {
               case 1:
                    personListOfCARDIOLOGY.stream().filter(d -> d.getIDNumber().equals(IDNumber)).forEach(System.out::println);
                    break;
               case 2:
                    personListOfDERMATOLOGY.stream().filter(d -> d.getIDNumber().equals(IDNumber)).forEach(System.out::println);
                    break;
               case 3:
                    personListOfENT.stream().filter(d -> d.getIDNumber().equals(IDNumber)).forEach(System.out::println);
                    break;
               case 4:
                    personListOfNEUROLOGY.stream().filter(d -> d.getIDNumber().equals(IDNumber)).forEach(System.out::println);
                    break;
               case 5:
                    personListOfGERIATRIC.stream().filter(d -> d.getIDNumber().equals(IDNumber)).forEach(System.out::println);
                    break;
          }
          return null;
     }

     public Doctor updateDoctor(String IDNumber, int choice) {
          int choiceGender, choiceDoctorEducation;
          if (findDoctorByID(IDNumber, choice) != null) {
               System.out.println("Not found!!!");
          } else {
               System.out.print("Enter Doctor's fist name: ");
               findDoctorByID(IDNumber, choice).setFirstName(sc.nextLine());

               System.out.print("Enter Doctor's last name: ");
               findDoctorByID(IDNumber, choice).setLastName(sc.nextLine());


               findDoctorByID(IDNumber, choice).setLastName(HandlingException.getBirthOfDay(sc));


               do {
                    System.out.printf("Gender?: %10s"," ");
                    System.out.printf("%10s|%10s|%10s|%10s", "1.MALE", "2.FEMALE", "Your choice:", " ");
                    choiceGender = HandlingException.getInteger(sc);
                    if (choiceGender == 1) {
                         findDoctorByID(IDNumber, choice).setGender(Gender.MALE);
                    } else if (choiceGender == 2) {
                         findDoctorByID(IDNumber, choice).setGender(Gender.FEMALE);
                    }
                    else {
                         System.out.println("Invalid Gender");
                    }
               } while ( choiceGender != 1 && choiceGender != 2);

               System.out.print("Enter doctor's address: ");
               findDoctorByID(IDNumber, choice).setAddress(sc.nextLine());

               findDoctorByID(IDNumber, choice).setTelephoneNumber(Validate.getTelephoneNumber(sc));

               System.out.print("Enter doctor's years of experience: ");
               findDoctorByID(IDNumber, choice).setYearsOfExperience(HandlingException.getInteger(sc));

               findDoctorByID(IDNumber, choice).setClinicHours(Validate.getClinicHours(sc));

               do {
                    System.out.printf("Choose doctor's education:%10s", " ");
                    System.out.printf("%10s|%10s|%10s|%10s", "1. DOCTOR", "2. PROFESSOR", "3. ASSOCIATE_PROFESSOR", " ");
                    choiceDoctorEducation = HandlingException.getInteger(sc);
                    if (choiceDoctorEducation == 1) {
                         findDoctorByID(IDNumber, choice).setEducation(Education.DOCTOR);
                    } else if (choiceDoctorEducation == 2) {
                         findDoctorByID(IDNumber, choice).setEducation(Education.PROFESSOR);
                    } else if (choiceDoctorEducation == 3) {
                         findDoctorByID(IDNumber, choice).setEducation(Education.ASSOCIATE_PROFESSOR);
                    } else {
                         System.out.println("Invalid Education");
                    }
               } while ( choiceDoctorEducation < 1 || choiceDoctorEducation > 3);

               System.out.print("Enter doctor's consultationFee: ");
               findDoctorByID(IDNumber, choice).setConsultationFee(HandlingException.getDouble(sc));
               return findDoctorByID(IDNumber, choice);
          }
          return null;
     }

     public void removeDoctor(String IDNumber, int choice) {
          if (findDoctorByID(IDNumber, choice) != null) {
               System.out.println("Not found!!!");
          } else {
               switch (choice) {
                    case 1:
                         personListOfCARDIOLOGY.remove(findDoctorByID(IDNumber, choice));
                         System.out.println("Remove is successful");
                         break;
                    case 2:
                         personListOfDERMATOLOGY.remove(findDoctorByID(IDNumber, choice));
                         System.out.println("Remove is successful");
                         break;
                    case 3:
                         personListOfENT.remove(findDoctorByID(IDNumber, choice));
                         System.out.println("Remove is successful");
                         break;
                    case 4:
                         personListOfNEUROLOGY.remove(findDoctorByID(IDNumber, choice));
                         System.out.println("Remove is successful");
                         break;
                    case 5:
                         personListOfGERIATRIC.remove(findDoctorByID(IDNumber, choice));
                         System.out.println("Remove is successful");
                         break;
               }
          }
     }

     // METHOD OF MEDICINE
     public void addNewMedicine(int choice) {

          System.out.print("Medicine's name: ");
          String medicineName = sc.nextLine();

          int choice2;
          DosageForm dosageForm = null;
          do {
               System.out.printf("Choose the type of medicine:%10s", " ");
               System.out.printf("%s10s|%10s|%10s|%10s|", "1. TABLETS", "2. LIQUIDS", "3. TOPICAL", "4. LOZENGES");
               System.out.print("Your choice: ");
               choice2 = HandlingException.getInteger(sc);
               switch (choice2) {
                    case 1:
                         dosageForm = DosageForm.TABLETS;
                         break;
                    case 2:
                         dosageForm = DosageForm.LIQUIDS;
                         break;
                    case 3:
                         dosageForm = DosageForm.TOPICAL;
                         break;
                    case 4:
                         dosageForm = DosageForm.LOZENGES;
                         break;
                    default:
                         System.out.println("Invalid choice");
               }
          } while (choice2 <= 1 || choice2 >= 4);

          System.out.print("Medicine's strength: ");
          String strength = sc.nextLine();

          switch (choice) {
               case 1:
                    medicinesOfCARDIOLOGY.add( new Medicine(medicineName, dosageForm, strength ));
                    System.out.println("added new medicine.");
                    break;
               case 2:
                    medicinesOfDERMATOLOGY.add( new Medicine(medicineName, dosageForm, strength ));
                    System.out.println("added new medicine.");
                    break;
               case 3:
                    medicinesOfENT.add( new Medicine(medicineName, dosageForm, strength ));
                    System.out.println("added new medicine.");
                    break;
               case 4:
                    medicinesOfNEUROLOGY.add( new Medicine(medicineName, dosageForm, strength ));
                    System.out.println("added new medicine.");
                    break;
               case 5:
                    medicinesOfGERIATRIC.add( new Medicine(medicineName, dosageForm, strength ));
                    System.out.println("added new medicine.");
                    break;
          }
     }

     public void showMedicineList(int choice) {
          switch (choice) {
               case 1:
                    medicinesOfCARDIOLOGY.forEach(Medicine::toString);
                    break;
               case 2:
                    medicinesOfDERMATOLOGY.forEach(Medicine::toString);
                    break;
               case 3:
                    medicinesOfENT.forEach(Medicine::toString);
                    break;
               case 4:
                    medicinesOfNEUROLOGY.forEach(Medicine::toString);
                    break;
               case 5:
                    medicinesOfGERIATRIC.forEach(Medicine::toString);
                    break;
          }
     }

     public Medicine findMedicine(String IDNumber, int choice) {
          switch (choice) {
               case 1:
                    medicinesOfCARDIOLOGY.stream().filter(medicine ->  medicine.getMedicineID().equals(IDNumber)).findFirst().get();
                    break;
               case 2:
                    medicinesOfDERMATOLOGY.stream().filter(medicine ->  medicine.getMedicineID().equals(IDNumber)).findFirst().get();
                    break;
               case 3:
                    medicinesOfENT.stream().filter(medicine ->  medicine.getMedicineID().equals(IDNumber)).findFirst().get();
                    break;
               case 4:
                    medicinesOfNEUROLOGY.stream().filter(medicine ->  medicine.getMedicineID().equals(IDNumber)).findFirst().get();
                    break;
               case 5:
                    medicinesOfGERIATRIC.stream().filter(medicine ->  medicine.getMedicineID().equals(IDNumber)).findFirst().get();
                    break;
          }
          return null;
     }

     public Medicine updateMedicine(String IDNumber, int choice) {

          if (findMedicine(IDNumber, choice) == null) {
               return null;
          } else {
               System.out.print("Medicine's name: ");
               findMedicine(IDNumber, choice).setName(sc.nextLine());

               int choice2;
               do {
                    System.out.printf("Choose the type of medicine:%10s", " ");
                    System.out.printf("%s10s|%10s|%10s|%10s|", "1. TABLETS", "2. LIQUIDS", "3. TOPICAL", "4. LOZENGES");
                    System.out.print("Your choice: ");
                    choice2 = HandlingException.getInteger(sc);
                    switch (choice2) {
                         case 1:
                              findMedicine(IDNumber, choice).setDosageForm(DosageForm.TABLETS);
                              break;
                         case 2:
                              findMedicine(IDNumber, choice).setDosageForm(DosageForm.LIQUIDS);
                              break;
                         case 3:
                              findMedicine(IDNumber, choice).setDosageForm(DosageForm.TOPICAL);
                              break;
                         case 4:
                              findMedicine(IDNumber, choice).setDosageForm(DosageForm.LOZENGES);
                              break;
                         default:
                              System.out.println("Invalid choice");
                    }
               } while (choice2 <= 1 || choice2 >= 4);

               System.out.print("Medicine's strength: ");
               findMedicine(IDNumber, choice).setStrength(sc.nextLine());

               switch (choice) {
                    case 1:
                         medicinesOfCARDIOLOGY.set(medicinesOfCARDIOLOGY.indexOf(findMedicine(IDNumber, choice)), findMedicine(IDNumber, choice));
                         System.out.println("updated information of medicine.");
                         break;
                    case 2:
                         medicinesOfDERMATOLOGY.set(medicinesOfDERMATOLOGY.indexOf(findMedicine(IDNumber, choice)), findMedicine(IDNumber, choice));
                         System.out.println("updated information of medicine.");
                         break;
                    case 3:
                         medicinesOfENT.set(medicinesOfENT.indexOf(findMedicine(IDNumber, choice)), findMedicine(IDNumber, choice));
                         System.out.println("updated information of medicine.");
                         break;
                    case 4:
                         medicinesOfNEUROLOGY.set(medicinesOfNEUROLOGY.indexOf(findMedicine(IDNumber, choice)), findMedicine(IDNumber, choice));
                         System.out.println("updated information of medicine.");
                         break;
                    case 5:
                         medicinesOfGERIATRIC.set(medicinesOfGERIATRIC.indexOf(findMedicine(IDNumber, choice)), findMedicine(IDNumber, choice));
                         System.out.println("updated information of medicine.");
                         break;
               }
               return findMedicine(IDNumber, choice);
          }
     }

     public void removeMedicine(String IDNumber, int choice) {
          if (findMedicine(IDNumber, choice) == null) {
               System.out.println("The medicine does not exist.");
          } else {
               switch (choice) {
                    case 1:
                         medicinesOfCARDIOLOGY.remove(findMedicine(IDNumber, choice));
                         System.out.println("The medicine has been removed.");
                         break;
                    case 2:
                         medicinesOfDERMATOLOGY.remove(findMedicine(IDNumber, choice));
                         System.out.println("The medicine has been removed.");
                         break;
                    case 3:
                         medicinesOfENT.remove(findMedicine(IDNumber, choice));
                         System.out.println("The medicine has been removed.");
                         break;
                    case 4:
                         medicinesOfNEUROLOGY.remove(findMedicine(IDNumber, choice));
                         System.out.println("The medicine has been removed.");
                         break;
                    case 5:
                         medicinesOfGERIATRIC.remove(findMedicine(IDNumber, choice));
                         System.out.println("The medicine has been removed.");
                         break;
               }
          }
     }




}
