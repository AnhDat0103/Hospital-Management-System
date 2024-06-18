package menu.adminRole;

import container.Container;
import exception.HandlingException;
import models.Doctor;
import models.Medicine;

import java.text.ParseException;
import java.util.Scanner;

public class AdminRoleOption {

    static Scanner sc = new Scanner(System.in);
    static Container container = new Container();

    public static void adminRoleOptions(int choice) throws ParseException {
        int choice1;
        do {
            menuDetailsSpecialization();
            System.out.print("Your choice: ");
            choice1 = HandlingException.getInteger(sc);
            switch (choice1) {
                case 1:
                    container.addNewDoctor(choice);
                    break;
                case 2:
                    container.showDoctorsList(choice);
                    break;
                case 3:
                    System.out.print("Enter ID number you want to find: ");
                    String IDNumberFind = HandlingException.checkID(sc);
                    Doctor findDoctorByID = container.findDoctorByID(IDNumberFind, choice);
                    if (findDoctorByID == null) {
                        System.out.println("Doctor not found");
                    } else {
                        System.out.println(findDoctorByID);
                    }
                    break;
                case 4: //Update a doctor by IDNumber
                    System.out.print("Enter ID number you want to find: ");
                    String IDNumberFind2 = HandlingException.checkID(sc);
                    if (container.findDoctorByID(IDNumberFind2, choice) == null) {
                        System.out.println("Doctor not found");
                    } else {
                        Doctor doctorUpdate = null;
                        try {
                            doctorUpdate = container.updateDoctor(IDNumberFind2, choice);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Doctor's information after update: " + doctorUpdate.toString());
                    }
                    break;
                case 5:
                    System.out.print("Enter ID number you want to find: ");
                    String IDNumberFindToRemove = HandlingException.checkID(sc);
                    Doctor findDoctorByIDToRemove = container.findDoctorByID(IDNumberFindToRemove, choice);
                    if (findDoctorByIDToRemove == null) {
                        System.out.println("Doctor not found");
                    } else {
                        container.removeDoctor(IDNumberFindToRemove, choice);
                    }
                    break;
                case 6: break;
                case 7: break;
                case 8:
                    container.addNewMedicine(choice);
                    break;
                case 9:
                    System.out.println("The list medicine: ");
                    container.showMedicineList(choice);
                    break;
                case 10:
                    System.out.println("Enter medicine ID: ");
                    String medicineID = sc.nextLine();
                    if (container.findMedicine(medicineID, choice) == null) {
                        System.out.println("Medicine not found");
                    } else {
                        System.out.println(container.findMedicine(medicineID, choice).toString());
                    }
                    break;
                case 11:
                    System.out.println("Enter medicine ID: ");
                    String medicineID2 = sc.nextLine();
                    if (container.findMedicine(medicineID2, choice) == null) {
                        System.out.println("Medicine not found");
                    } else {
                        Medicine medicineUpdate = container.updateMedicine(medicineID2, choice);
                        System.out.println("Medicine information after update: " + medicineUpdate.toString());
                    }
                    break;
                case 12:
                    System.out.println("Enter medicine ID: ");
                    String medicineID3 = sc.nextLine();
                    if (container.findMedicine(medicineID3, choice) == null) {
                        System.out.println("Medicine not found");
                    } else {
                        container.removeMedicine(medicineID3, choice);
                    }
                    break;
                case 13: break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice1 >= 1 && choice1 <= 12);
    }

    // Detail option for all specialization
    public static void menuDetailsSpecialization() {
        System.out.println("1. Add the new doctor.");
        System.out.println("2. Show the list of doctors.");
        System.out.println("3. Find a doctor by IDNumber");
        System.out.println("4. Update a doctor by IDNumber");
        System.out.println("5. Remove doctor by IDNumber");
        System.out.println("5. Delete a doctor by IDNumber");
        System.out.println("6. Show the list of Patients.");
        System.out.println("7. Find a patient by IDNumber");
        System.out.println("8. Add the new medicine.");
        System.out.println("9. show list medicines.");
        System.out.println("10. Find a medicine by IDNumber.");
        System.out.println("11. Update a medicine by IDNumber.");
        System.out.println("12. Remove a medicine by IDNumber.");
        System.out.println("13. Exit");
    }
}
