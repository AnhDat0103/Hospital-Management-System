package viewLayer;

import exception.HandlingException;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class DoctorView {
    // implement coding for doctor role options.
    Scanner sc = new Scanner(System.in);
    private ViewMain ViewMain;

    public DoctorView(ViewMain ViewMain) {
        this.ViewMain = ViewMain;
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
                    ViewMain.getAdminView().getPatientController().addNewPatient(choice);
                    break;
                case 2:
                    ViewMain.getAdminView().getPatientController().showPatientsList(choice);
                    break;
                case 3:
                    System.out.println("ENTER ID Patient want to find: ");
                    IDNumber = sc.nextLine();
                    ViewMain.getAdminView().getPatientController().findPatientByIDNumber(IDNumber, choice);
                    break;
                case 4:
                    System.out.println("ENTER ID Patient want to update: ");
                    IDNumber = sc.nextLine();
                    ViewMain.getAdminView().getPatientController().UpdatePatientByID(IDNumber, choice);
                    break;
                case 5:
                    System.out.println("ENTER ID Patient want to delete: ");
                    IDNumber = sc.nextLine();
                    ViewMain.getAdminView().getPatientController().RemovePatientByID(IDNumber, choice);
                    break;
                case 6:
                    System.out.println("ENTER ID Patient want add Medicine: ");
                    IDNumber = sc.nextLine();
                    ViewMain.getAdminView().getDoctorController().addMedicineToPatient(IDNumber, choice);
                    break;
                case 7:
                    choice3 = 0;
                    ViewMain.authenticationMenuTitle();
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

