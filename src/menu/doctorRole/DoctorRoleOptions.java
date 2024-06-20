package menu.doctorRole;

import container.Container;
import exception.HandlingException;
import menu.MainMenu;

import java.text.ParseException;
import java.util.Scanner;

public class DoctorRoleOptions {
    // implement coding for doctor role options.
    static Scanner sc = new Scanner(System.in);
    static Container container = new Container();

    public static void doctorRoleOptions(int choice) throws ParseException {
        int choice3;
        do {
            mainTitle();
            System.out.print("Your choice: ");
            choice3 = HandlingException.getInteger(sc);
            switch (choice3) {
                case 1:
                    container.addNewPatient(choice);
                    break;
                case 2:
                    container.showPatientsList(choice);
                    break;
                case 3:
                    System.out.println("ENTER ID Patient want to find: ");
                    String IDNumber = sc.nextLine();
                    container.findPatientByIDNumber(IDNumber, choice);
                    break;
                case 4:
                    System.out.println("ENTER ID Patient want to update: ");
                    IDNumber = sc.nextLine();
                    container.UpdatePatientByID(IDNumber, choice);
                    break;
                case 5:
                    System.out.println("ENTER ID Patient want to delete: ");
                    IDNumber = sc.nextLine();
                    container.RemovePatientByID(IDNumber, choice);
                    break;
                case 6:
                    System.out.println("ENTER ID Patient want add Medicine: ");
                    String numberID = sc.nextLine();
                    container.addMedicineToPatient(choice, numberID);
                    break;
                case 7:
                    choice3 = 0;
                    MainMenu.authenticationMenuTitle();
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

