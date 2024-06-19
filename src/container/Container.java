package container;

import exception.HandlingException;
import models.Doctor;
import models.Medicine;
import models.Patient;
import models.enums.DosageForm;
import models.enums.Education;
import models.enums.Gender;
import models.enums.Specialization;
import validation.Validate;

import java.text.ParseException;
import java.util.*;

public class Container {

     Scanner sc = new Scanner(System.in);

     private final List<Doctor> doctorListOfCARDIOLOGY = new ArrayList<>();  // list of CARDIOLOGY. The list has information of doctors, patient in CARDIOLOGY.
     private final List<Doctor> doctorListOfDERMATOLOGY = new ArrayList<>(); // list of DERMATOLOGY. The list has information of doctors, patient in DERMATOLOGY.
     private final List<Doctor> doctorListOfENT = new ArrayList<>();         // list of ENT. The list has information of doctors, patient in ENT.
     private final List<Doctor> doctorListOfNEUROLOGY = new ArrayList<>();   // list of NEUROLOGY. The list has information of doctors, patient in NEUROLOGY.
     private final List<Doctor> doctorListOfGERIATRIC = new ArrayList<>();   // list of GERIATRIC. The list has information of doctors, patient in GERIATRIC.

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

     //METHOD TO TAKE GENDER
     public Gender getGender(Scanner sc) {
          Gender gender = null;
          int choiceGender;
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
          return gender;
     }

     // METHOD OF DOCTOR
     public void addNewDoctor(int choice) throws ParseException {
          int choiceDoctorEducation;
          Gender gender;
          Education education = null;

          String IDNumber = Validate.checkDoctorID(sc,choice);

          System.out.print("Enter Doctor's fist name: ");
          String firstName = sc.nextLine();

          System.out.print("Enter Doctor's last name: ");
          String lastName = sc.nextLine();

          String yob = HandlingException.getBirthOfDay(sc);


          gender = getGender(sc);

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
                    doctorListOfCARDIOLOGY.add(new Doctor(IDNumber, firstName, lastName, yob, gender, address, telephone,
                                               yearOfExperience, clinicHours, education, Specialization.CARDIOLOGY ,
                                               consultationFee, patientListOfCARDIOLOGY));
                    System.out.println("added new doctor.");
                    break;
               case 2:
                    doctorListOfDERMATOLOGY.add(new Doctor(IDNumber, firstName, lastName, yob,
                                                           gender, address, telephone, yearOfExperience,
                                                           clinicHours, education, Specialization.DERMATOLOGY,
                                                           consultationFee,patientListOfDERMATOLOGY));
                    System.out.println("added new doctor.");
                    break;
               case 3:
                    doctorListOfENT.add(new Doctor(IDNumber, firstName, lastName, yob,
                                                        gender, address, telephone, yearOfExperience,
                                                        clinicHours, education, Specialization.ENT,
                                                        consultationFee,patientListOfENT));
                    System.out.println("added new doctor.");
                    break;
               case 4:
                    doctorListOfNEUROLOGY.add(new Doctor(IDNumber, firstName, lastName, yob,
                                                        gender, address, telephone, yearOfExperience,
                                                        clinicHours, education, Specialization.NEUROLOGY,
                                                        consultationFee,patientListOfNEUROLOGY));
                    System.out.println("added new doctor.");
                    break;
               case 5:
                    doctorListOfGERIATRIC.add(new Doctor(IDNumber, firstName, lastName, yob,
                                                   gender, address, telephone, yearOfExperience,
                                                   clinicHours, education, Specialization.GERIATRIC,
                                                   consultationFee,patientListOfGERIATRIC));
                    System.out.println("added new doctor.");
                    break;
          }
     }

     public void showDoctorsList(int choice) {
          switch (choice) {
               case 1:
                    doctorListOfCARDIOLOGY.forEach(Doctor -> System.out.println(Doctor.toString()));
                    break;
               case 2:
                    doctorListOfDERMATOLOGY.forEach(Doctor -> System.out.println(Doctor.toString()));
                    break;
               case 3:
                    doctorListOfENT.forEach(Doctor -> System.out.println(Doctor.toString()));
                    break;
               case 4:
                    doctorListOfNEUROLOGY.forEach(Doctor -> System.out.println(Doctor.toString()));
                    break;
               case 5:
                    doctorListOfGERIATRIC.forEach(Doctor -> System.out.println(Doctor.toString()));
                    break;
          }
     }

     public Doctor findDoctorByID(String IDNumber, int choice) {
          switch (choice) {
               case 1:
                    return doctorListOfCARDIOLOGY.stream().filter(Doctor -> Doctor.getIDNumber().equals(IDNumber)).findFirst().orElse(null);
               case 2:
                     return doctorListOfDERMATOLOGY.stream().filter(Doctor -> Doctor.getIDNumber().equals(IDNumber)).findFirst().orElse(null);
               case 3:
                    return doctorListOfENT.stream().filter(Doctor -> Doctor.getIDNumber().equals(IDNumber)).findFirst().orElse(null);
               case 4:
                    return doctorListOfNEUROLOGY.stream().filter(Doctor -> Doctor.getIDNumber().equals(IDNumber)).findFirst().orElse(null);
               case 5:
                    return doctorListOfGERIATRIC.stream().filter(Doctor -> Doctor.getIDNumber().equals(IDNumber)).findFirst().orElse(null);
          }
          return null;
     }

     public Doctor updateDoctor(String IDNumber, int choice) throws Exception {
          int choiceGender, choiceDoctorEducation;
          if (findDoctorByID(IDNumber, choice) == null) {
               System.out.println("Not found!!!");
          } else {
               System.out.print("Enter Doctor's fist name: ");
               findDoctorByID(IDNumber, choice).setFirstName(sc.nextLine());

               System.out.print("Enter Doctor's last name: ");
               findDoctorByID(IDNumber, choice).setLastName(sc.nextLine());

               findDoctorByID(IDNumber,choice).setFullName();


               findDoctorByID(IDNumber, choice).setYob(HandlingException.getBirthOfDay(sc));


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
          if (findDoctorByID(IDNumber, choice) == null) {
               System.out.println("Not found!!!");
          } else {
               switch (choice) {
                    case 1:
                         doctorListOfCARDIOLOGY.remove(findDoctorByID(IDNumber, choice));
                         System.out.println("Remove is successful");
                         break;
                    case 2:
                         doctorListOfDERMATOLOGY.remove(findDoctorByID(IDNumber, choice));
                         System.out.println("Remove is successful");
                         break;
                    case 3:
                         doctorListOfENT.remove(findDoctorByID(IDNumber, choice));
                         System.out.println("Remove is successful");
                         break;
                    case 4:
                         doctorListOfNEUROLOGY.remove(findDoctorByID(IDNumber, choice));
                         System.out.println("Remove is successful");
                         break;
                    case 5:
                         doctorListOfGERIATRIC.remove(findDoctorByID(IDNumber, choice));
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
          } while (choice2 < 1 || choice2 > 4);

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
                    medicinesOfCARDIOLOGY.forEach(Medicine ->System.out.println(Medicine.toString()));
                    break;
               case 2:
                    medicinesOfDERMATOLOGY.forEach(Medicine ->System.out.println(Medicine.toString()));
                    break;
               case 3:
                    medicinesOfENT.forEach(Medicine ->System.out.println(Medicine.toString()));
                    break;
               case 4:
                    medicinesOfNEUROLOGY.forEach(Medicine ->System.out.println(Medicine.toString()));
                    break;
               case 5:
                    medicinesOfGERIATRIC.forEach(Medicine ->System.out.println(Medicine.toString()));
                    break;
          }
     }

     public Medicine findMedicine(String IDNumber, int choice) {
          switch (choice) {
               case 1:
                    return medicinesOfCARDIOLOGY.stream().filter(medicine ->  medicine.getMedicineID().equals(IDNumber)).findFirst().orElse(null);
               case 2:
                    return medicinesOfDERMATOLOGY.stream().filter(medicine ->  medicine.getMedicineID().equals(IDNumber)).findFirst().orElse(null);
               case 3:
                    return medicinesOfENT.stream().filter(medicine ->  medicine.getMedicineID().equals(IDNumber)).findFirst().orElse(null);
               case 4:
                    return medicinesOfNEUROLOGY.stream().filter(medicine ->  medicine.getMedicineID().equals(IDNumber)).findFirst().orElse(null);
               case 5:
                    return medicinesOfGERIATRIC.stream().filter(medicine ->  medicine.getMedicineID().equals(IDNumber)).findFirst().orElse(null);
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
               } while (choice2 < 1 || choice2 > 4);

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


     public void addNewPatient(int choice) throws ParseException {
          int choiceGender;
          String allergies = "";
          String allergyDetails = " ";
          int allergiesInt = 0;

          Gender gender;

          String IDNumber = Validate.checkPatientID(sc, choice);

          System.out.print("Enter Patient's fist name: ");
          String firstName = sc.nextLine();


          System.out.print("Enter Patient's last name: ");
          String lastName = sc.nextLine();

          String yob = HandlingException.getBirthOfDay(sc);

          gender = getGender(sc);

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
               allergies = sc.nextLine();
               try {
                    allergiesInt = Integer.parseInt(allergies);
                    if (allergiesInt == 1) {
                         System.out.print("Show the allergies: ");
                         allergyDetails = sc.nextLine();
                         System.out.println("Allergy details: " + allergyDetails);
                    } else if (allergiesInt == 2) {
                         System.out.println("The patient has no allergies!!!");
                    } else {
                         System.out.println("Invalid choice, please enter YES or NO.");
                    }
               } catch (NumberFormatException e) {
                    System.out.println("Invalid input, please enter a valid number.");
               }
          } while ( allergiesInt != 1 && allergiesInt != 2);
          switch (choice) {
               case 1:
                    patientListOfCARDIOLOGY.put(IDNumber, new Patient(IDNumber, firstName, lastName, yob, gender, address, telephone,
                            height,weight,bloodType,allergyDetails, Specialization.CARDIOLOGY));
                    System.out.println("Add New Patient Successfully to Cardiology.");
                    break;
               case 2:
                    patientListOfDERMATOLOGY.put(IDNumber, new Patient(IDNumber, firstName, lastName, yob, gender, address, telephone,
                            height,weight,bloodType,allergyDetails, Specialization.DERMATOLOGY));
                    System.out.println("Add New Patient Successfully to Dermatology.");
                    break;
               case 3:
                    patientListOfENT.put(IDNumber, new Patient(IDNumber, firstName, lastName, yob, gender, address, telephone,
                            height,weight,bloodType,allergyDetails, Specialization.ENT));
                    System.out.println("Add New Patient Successfully to Entrepreneur.");
                    break;
               case 4:
                    patientListOfNEUROLOGY.put(IDNumber, new Patient(IDNumber, firstName, lastName, yob, gender, address, telephone,
                            height,weight,bloodType,allergyDetails, Specialization.NEUROLOGY));
                    System.out.println("Add New Patient Successfully to Neurology.");
                    break;
               case 5:
                    patientListOfGERIATRIC.put(IDNumber, new Patient(IDNumber, firstName, lastName, yob, gender, address, telephone,
                            height,weight,bloodType,allergyDetails, Specialization.GERIATRIC));
                    System.out.println("Add New Patient Successfully to Geriatric.");
                    break;
          }
     }
     public String showPatientsList(int choice) {
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
         return "";
     }

     public String findPatientByIDNumber(String IDNumber, int choice) {
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
          return result;
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
