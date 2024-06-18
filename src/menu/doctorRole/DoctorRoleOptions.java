package menu.doctorRole;

import container.Container;
import exception.HandlingException;

import javax.imageio.stream.ImageInputStream;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.util.Scanner;

public class DoctorRoleOptions {
    // implement coding for doctor role options.
    static Scanner sc = new Scanner(System.in);
    static Container container = new Container();

    public static void doctorRoleOptions(int choice) throws ParseException {
        int choice2;
        do {
            mainTitle();
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
                    System.out.println("ENTER ID you want to find: ");
                    String IDNumber = sc.nextLine();
                    container.findPatientByIDNumber(IDNumber ,choice);
                    break;
                case 4:
                    System.out.println("ENTER ID Patient: ");
                    IDNumber = sc.nextLine();
                    container.UpdatePatientByID(IDNumber ,choice);
                    break;
                case 5:
                    IDNumber = sc.nextLine();
                    container.RemovePatientByID(IDNumber ,choice);
                    break;
                case 6:
                    break;
            }
        } while (choice2 >= 1 && choice2 <= 5);
    }

    public static void mainTitle() {
        System.out.println("1. Add the new Patient.");
        System.out.println("2. Show the list of Patient.");
        System.out.println("3. Find a Patient by IDNumber.");
        System.out.println("4. Update a Patient by IDNumber.");
        System.out.println("5. Delete a Patient by IDNumber.");
        System.out.println("6. Add a Medicine to the Patient.");
        System.out.println("6. Exit.");
    }

}
