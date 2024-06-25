package controller;

import exception.HandlingException;
import models.Doctor;
import models.Medicine;
import models.enums.Action;
import service.DoctorService;
import service.MedicineService;
import service.PatientService;
import validation.Validate;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class AdminController {

    Scanner sc = new Scanner(System.in);
    private DoctorService doctorService = new DoctorService();
    private PatientService patientService = new PatientService();
    private MedicineService medicineService = new MedicineService();
    private ControllerMain controllerMain;

    public AdminController(ControllerMain controllerMain) {
        this.controllerMain = controllerMain;
    }

    public DoctorService getDoctorService() {
        return doctorService;
    }

    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    public PatientService getPatientService() {
        return patientService;
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    public MedicineService getMedicineService() {
        return medicineService;
    }

    public void setMedicineService(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public ControllerMain getControllerMain() {
        return controllerMain;
    }

    public void setControllerMain(ControllerMain controllerMain) {
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
                    doctorService.addNewDoctor(choice);
                    break;
                case 2:
                    doctorService.showDoctorsList(choice).forEach(s -> System.out.println(s.toString()));
                    break;
                case 3:
                    String IDNumber = Validate.checkDoctorID(sc, choice, Action.FIND);
                    Doctor findDoctorByID = doctorService.findDoctorByID(choice, IDNumber);
                    if (findDoctorByID == null) {
                        System.out.println("Doctor not found");
                    } else {
                        System.out.println(findDoctorByID);
                    }
                    break;
                case 4: //Update a doctor by IDNumber
                    String IDNumberFind2 = Validate.checkDoctorID(sc, choice, Action.FIND);
                    try {
                        doctorService.updateDoctor(IDNumberFind2, choice);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 5:
                    String IDNumberFindToRemove = Validate.checkDoctorID(sc, choice, Action.FIND);
                    Doctor findDoctorByIDToRemove = doctorService.findDoctorByID(choice, IDNumberFindToRemove);
                    if (findDoctorByIDToRemove == null) {
                        System.out.println("Doctor not found");
                    } else {
                        doctorService.removeDoctor(IDNumberFindToRemove, choice);
                    }
                    break;
                case 6:
                    patientService.showPatientsList(choice);
                    break;
                case 7:
                    String IDNumberFindToFind = Validate.checkPatientID(sc, choice, Action.FIND);
                    patientService.findPatientByIDNumber(IDNumberFindToFind, choice);
                    break;
                case 8:
                     medicineService.addNewMedicine(choice);
                    break;
                case 9:
                    System.out.println("The list medicine: ");
                    medicineService.showMedicineList(choice);
                    break;
                case 10:
                    System.out.println("Enter medicine ID: ");
                    String medicineID = sc.nextLine();
                    if (medicineService.findMedicine(medicineID, choice) == null) {
                        System.out.println("Medicine not found");
                    } else {
                        System.out.println(medicineService.findMedicine(medicineID, choice).toString());
                    }
                    break;
                case 11:
                    System.out.println("Enter medicine ID: ");
                    String medicineID2 = sc.nextLine();
                    if (medicineService.findMedicine(medicineID2, choice) == null) {
                        System.out.println("Medicine not found");
                    } else {
                        Medicine medicineUpdate = medicineService.updateMedicine(medicineID2, choice);
                        System.out.println("Medicine information after update: " + medicineUpdate.toString());
                    }
                    break;
                case 12:
                    System.out.println("Enter medicine ID: ");
                    String medicineID3 = sc.nextLine();
                    if (medicineService.findMedicine(medicineID3, choice) == null) {
                        System.out.println("Medicine not found");
                    } else {
                        medicineService.removeMedicine(medicineID3, choice);
                    }
                    break;
                case 13:
                    choice1 = 0;
                    controllerMain.authenticationMenuTitle();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice1 >= 1 && choice1 <= 13);
    }

    // Detail option for all specialization
    public static void menuDetailsSpecialization() {
        System.out.println("1.  Add the new doctor.");
        System.out.println("2.  Show the list of doctors.");
        System.out.println("3.  Find a doctor by IDNumber");
        System.out.println("4.  Update a doctor by IDNumber");
        System.out.println("5.  Remove doctor by IDNumber");
        System.out.println("6.  Show the list of Patients.");
        System.out.println("7.  Find a patient by IDNumber");
        System.out.println("8.  Add the new medicine.");
        System.out.println("9.  show list medicines.");
        System.out.println("10. Find a medicine by IDNumber.");
        System.out.println("11. Update a medicine by IDNumber.");
        System.out.println("12. Remove a medicine by IDNumber.");
        System.out.println("13. Exit");
    }
}
