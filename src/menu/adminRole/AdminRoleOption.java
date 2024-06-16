package menu.adminRole;

import container.Container;
import exception.HandlingException;

import java.text.ParseException;
import java.util.Scanner;

public class AdminRoleOption {

    Scanner sc = new Scanner(System.in);
    String userName = sc.nextLine();
    String password = sc.nextLine();
    Container container;

    public AdminRoleOption() {
    }

    public  void adminRoleOptions(int choice) throws ParseException {
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

                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        } while (choice1 >= 1 && choice1 <= 5);
    }

    // Detail option for all specialization
    public void menuDetailsSpecialization() {
        System.out.println("1. Add the new doctor.");
        System.out.println("2. Show the list of doctors.");
        System.out.println("3. Find a doctor by IDNumber");
        System.out.println("4.Update a doctor by IDNumber");
        System.out.println("5. Delete a doctor by IDNumber");
        System.out.println("6. Exit");
        System.out.print("Your choice: ");
    }
}
