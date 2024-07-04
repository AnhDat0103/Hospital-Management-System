package viewLayer;

import exception.HandlingException;
import models.Doctor;
import models.enums.Action;
import validation.Validate;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class AdminView {
    Scanner sc = new Scanner(System.in);
    
    private ViewMain viewMain;

    public AdminView(ViewMain viewMain) {
        this.viewMain = viewMain;
    }
    
    
    public void adminRoleOptions(int choice) throws ParseException, IOException {
        int choice1;
        do {
            menuDetailsSpecialization();
            System.out.print("Your choice: ");
            choice1 = HandlingException.getInteger(sc);
            switch (choice1) {
                case 1:
                    viewMain.getDoctorController().addNewDoctor(choice);
                    break;
                case 2:
                    viewMain.getDoctorController().showDoctorsList(choice);
                    break;
                case 3:
                    String IDNumber = Validate.checkDoctorID(sc, choice, Action.FIND);
                    Doctor findDoctorByID = viewMain.getDoctorController().findDoctorByID(choice, IDNumber);
                    if (findDoctorByID == null) {
                        System.out.println("Doctor not found");
                    } else {
                        System.out.println(findDoctorByID);
                    }
                    break;
                case 4: //Update a doctor by IDNumber
                    String IDNumberFind2 = Validate.checkDoctorID(sc, choice, Action.FIND);
                    try {
                        viewMain.getDoctorController().updateDoctor(IDNumberFind2, choice);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 5:
                    String IDNumberFindToRemove = Validate.checkDoctorID(sc, choice, Action.FIND);
                    Doctor findDoctorByIDToRemove = viewMain.getDoctorController().findDoctorByID(choice, IDNumberFindToRemove);
                    if (findDoctorByIDToRemove == null) {
                        System.out.println("Doctor not found");
                    } else {
                        viewMain.getDoctorController().removeDoctor(IDNumberFindToRemove, choice);
                    }
                    break;
                case 6:
                    String IDNumberFindToFind = Validate.checkPatientID(sc, choice, Action.FIND);
                    viewMain.getPatientController().findPatientByIDNumber(IDNumberFindToFind, choice);
                    break;
                case 7:
                     viewMain.getMedicineController().addNewMedicine(choice);
                    break;
                case 8:
                    System.out.println("The list medicine: ");
                    viewMain.getMedicineController().showMedicineList(choice);
                    break;
                case 9:
                    System.out.println("Enter medicine ID: ");
                    String medicineID = sc.nextLine();
                    if (viewMain.getMedicineController().findMedicine(medicineID, choice) == null) {
                        System.out.println("Medicine not found");
                    } else System.out.println(viewMain.getMedicineController().findMedicine(medicineID, choice).toString());
                    break;
                case 10:
                    System.out.println("Enter medicine ID: ");
                    String medicineID2 = sc.nextLine();
                    viewMain.getMedicineController().updateMedicine(medicineID2, choice);
                    break;
                case 11:
                    System.out.println("Enter medicine ID: ");
                    String medicineID3 = sc.nextLine();
                    viewMain.getMedicineController().removeMedicine(medicineID3, choice);
                    break;
                case 12:
                    choice1 = 0;
                    viewMain.authenticationMenuTitle();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice1 >= 1 && choice1 <= 12);
    }

    // Detail option for all specialization
    public static void menuDetailsSpecialization() {
        System.out.println("1.  Add the new doctor.");
        System.out.println("2.  Show the list of doctors.");
        System.out.println("3.  Find a doctor by IDNumber");
        System.out.println("4.  Update a doctor by IDNumber");
        System.out.println("5.  Remove doctor by IDNumber");
        System.out.println("6.  Find a patient by IDNumber");
        System.out.println("7.  Add the new medicine.");
        System.out.println("8.  show list medicines.");
        System.out.println("9.  Find a medicine by IDNumber.");
        System.out.println("10. Update a medicine by IDNumber.");
        System.out.println("11. Remove a medicine by IDNumber.");
        System.out.println("12. Exit");
    }
}
