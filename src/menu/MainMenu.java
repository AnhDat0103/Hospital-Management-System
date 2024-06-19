package menu;

import container.Container;
import exception.HandlingException;
import menu.adminRole.AdminRoleOption;
import menu.doctorRole.DoctorRoleOptions;

import java.text.ParseException;
import java.util.Scanner;

public class MainMenu {
    static Scanner sc = new Scanner(System.in);
    static Container container = new Container();

    // Main menu
    public void authenticationMenuTitle() throws ParseException {
        int choice = 0;
        do {
            System.out.println("Welcome to the hospital management system");
            System.out.println("Please  choose one of type role: ");
            System.out.println("1. Admin role");
            System.out.println("2. Doctor role");
            System.out.println("3. Patient role.");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            choice = HandlingException.getInteger(sc);
            switch (choice) {
                case 1:
                    while (true) {
                        try {
                            System.out.print("username: ");
                            String userName = sc.nextLine();
                            System.out.print("password: ");
                            String password = sc.nextLine();
                            if (container.checkAdministration(userName,password)) {
                                int choice2;
                                do {
                                    menuTitleForAdministration();
                                    choice2 = HandlingException.getInteger(sc);
                                    if (choice2 == 6) MainMenu.authenticationMenuTitle();
                                } while (choice2 < 1 || choice2 > 6);
                                AdminRoleOption.adminRoleOptions(choice2);
                               break;
                            } else {
                                System.out.println("Invalid username or password");
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 2:
                    int choice2 = 0;
                    menuTitleForAdministration();
                    choice2 = HandlingException.getInteger(sc);
                    DoctorRoleOptions.doctorRoleOptions(choice2);
                    break;
                case 3: break;
                case 4: return;
                default: System.out.println("Invalid choice");
            }
        } while (choice < 1 || choice > 4);
    }

    // Menu for choice the specialization
    public static void menuTitleForAdministration() {
        System.out.println("Choose the specialization: ");
        System.out.println("1. CARDIOLOGY ");
        System.out.println("2. DERMATOLOGY ");
        System.out.println("3. ENT ");
        System.out.println("4. NEUROLOGY ");
        System.out.println("5. GERIATRIC ");
        System.out.println("6. Exit ");
        System.out.print("Your choice: ");
    }
}
