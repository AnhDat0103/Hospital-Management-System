package viewLayer;

import exception.HandlingException;
import models.Doctor;
import models.enums.Action;
import controller.DoctorController;
import controller.MedicineController;
import controller.PatientController;
import validation.Validate;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class AdminView {

    Scanner sc = new Scanner(System.in);
    private DoctorController doctorController = new DoctorController();
    private PatientController patientController = new PatientController();
    private MedicineController medicineController = new MedicineController();
    private ViewMain controllerMain;

    public AdminView(ViewMain controllerMain) {
        this.controllerMain = controllerMain;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public DoctorController getDoctorController() {
        return doctorController;
    }

    public void setDoctorController(DoctorController doctorController) {
        this.doctorController = doctorController;
    }

    public PatientController getPatientController() {
        return patientController;
    }

    public void setPatientController(PatientController patientController) {
        this.patientController = patientController;
    }

    public MedicineController getMedicineController() {
        return medicineController;
    }

    public void setMedicineController(MedicineController medicineController) {
        this.medicineController = medicineController;
    }

    public ViewMain getControllerMain() {
        return controllerMain;
    }

    public void setControllerMain(ViewMain controllerMain) {
        this.controllerMain = controllerMain;
    }

    public void adminRoleOptions(int choice) throws ParseException, IOException {
        int choice1;
        do {
            menuDetailsSpecialization();
            System.out.print("Your choice: ");
            choice1 = HandlingException.getInteger(sc);
            switch (choice1) {
                case 1:
                    doctorController.addNewDoctor(choice);
                    break;
                case 2:
                    doctorController.showDoctorsList(choice).forEach(s -> System.out.println(s.toString()));
                    break;
                case 3:
                    String IDNumber = Validate.checkDoctorID(sc, choice, Action.FIND);
                    Doctor findDoctorByID = doctorController.findDoctorByID(choice, IDNumber);
                    if (findDoctorByID == null) {
                        System.out.println("Doctor not found");
                    } else {
                        System.out.println(findDoctorByID);
                    }
                    break;
                case 4: //Update a doctor by IDNumber
                    String IDNumberFind2 = Validate.checkDoctorID(sc, choice, Action.FIND);
                    try {
                        doctorController.updateDoctor(IDNumberFind2, choice);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 5:
                    String IDNumberFindToRemove = Validate.checkDoctorID(sc, choice, Action.FIND);
                    Doctor findDoctorByIDToRemove = doctorController.findDoctorByID(choice, IDNumberFindToRemove);
                    if (findDoctorByIDToRemove == null) {
                        System.out.println("Doctor not found");
                    } else {
                        doctorController.removeDoctor(IDNumberFindToRemove, choice);
                    }
                    break;
                case 6:
                    String IDNumberFindToFind = Validate.checkPatientID(sc, choice, Action.FIND);
                    patientController.findPatientByIDNumber(IDNumberFindToFind, choice);
                    break;
                case 7:
                     medicineController.addNewMedicine(choice);
                    break;
                case 8:
                    System.out.println("The list medicine: ");
                    medicineController.showMedicineList(choice).forEach(m -> System.out.println(m.toString()));
                    break;
                case 9:
                    System.out.println("Enter medicine ID: ");
                    String medicineID = sc.nextLine();
                    if (medicineController.findMedicine(medicineID, choice) == null) {
                        System.out.println("Medicine not found");
                    } else System.out.println(medicineController.findMedicine(medicineID, choice).toString());
                    break;
                case 10:
                    System.out.println("Enter medicine ID: ");
                    String medicineID2 = sc.nextLine();
                    medicineController.updateMedicine(medicineID2, choice);
                    break;
                case 11:
                    System.out.println("Enter medicine ID: ");
                    String medicineID3 = sc.nextLine();
                    medicineController.removeMedicine(medicineID3, choice);
                    break;
                case 12:
                    choice1 = 0;
                    controllerMain.authenticationMenuTitle();
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
