package controller;

import exception.HandlingException;
import service.DoctorService;
import service.PatientService;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class DoctorController {
    // implement coding for doctor role options.
    Scanner sc = new Scanner(System.in);
    private ControllerMain controllerMain;

    public DoctorController(ControllerMain controllerMain) {
        this.controllerMain = controllerMain;
    }

    public void doctorRoleOptions(int choice) throws ParseException, IOException {
        int choice3;
        do {
            String IDNumber;
            mainTitle();
            System.out.print("Your choice: ");
            choice3 = HandlingException.getInteger(sc);
            switch (choice3) {
                case 1:
                    controllerMain.getAdminController().getPatientService().addNewPatient(choice);
                    break;
                case 2:
                    controllerMain.getAdminController().getPatientService().showPatientsList(choice);
                    break;
                case 3:
                    System.out.println("ENTER ID Patient want to find: ");
                    IDNumber = sc.nextLine();
                    controllerMain.getAdminController().getPatientService().findPatientByIDNumber(IDNumber, choice);
                    break;
                case 4:
                    System.out.println("ENTER ID Patient want to update: ");
                    IDNumber = sc.nextLine();
                    controllerMain.getAdminController().getPatientService().UpdatePatientByID(IDNumber, choice);
                    break;
                case 5:
                    System.out.println("ENTER ID Patient want to delete: ");
                    IDNumber = sc.nextLine();
                    controllerMain.getAdminController().getPatientService().RemovePatientByID(IDNumber, choice);
                    break;
                case 6:
                    System.out.println("ENTER ID Patient want add Medicine: ");
                    IDNumber = sc.nextLine();
                    controllerMain.getAdminController().getDoctorService().addMedicineToPatient(IDNumber, choice);
                    break;
                case 7:
                    choice3 = 0;
                    controllerMain.authenticationMenuTitle();
                    break;
            }
        } while (choice3 >= 1 && choice3 <= 7);
    }
        public static void mainTitle() {
        System.out.println("1. Add the new Patient.");
        System.out.println("2. Show the list of Patient.");
        System.out.println("3. Find a Patient by IDNumber.");
        System.out.println("4. Update a Patient by IDNumber.");
        System.out.println("5. Delete a Patient by IDNumber.");
        System.out.println("6. Add a Medicine to the Patient.");
        System.out.println("7. Exit.");
    }
}

