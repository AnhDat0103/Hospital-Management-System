package menu.doctorRole;

import container.Container;
import exception.HandlingException;

import java.text.ParseException;
import java.util.Scanner;

public class DoctorRoleOptions {
    // implement coding for doctor role options.
    static Scanner sc = new Scanner(System.in);
    static Container container = new Container();

    public static void doctorRoleOptions(int choice) throws ParseException {
        int choice2;
        do {
            menuDetailsSpecialization();
            System.out.print("Your choice: ");
            choice2 = HandlingException.getInteger(sc);
            switch (choice2) {
                case 1:
                    container.addNewPatient(choice);
                    break;
                case 2:
                    container.showPatientsList(choice);
                    break;
                case 3:
                    String IDNumber = new String();
                    container.findPatientByIDNumber(IDNumber ,choice);
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        } while (choice2 >= 1 && choice2 <= 5);
    }
    // Detail option for all specialization
    public static void menuDetailsSpecialization() {
        System.out.println("1. Add the new Patient.");
        System.out.println("2. Show the list of Patient.");
        System.out.println("3. Find a Patient by IDNumber.");
        System.out.println("4. Update a Patient by IDNumber.");
        System.out.println("5. Delete a Patient by IDNumber.");
        System.out.println("6. Exit.");
    }
}
