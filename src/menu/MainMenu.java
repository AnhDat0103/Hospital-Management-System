package menu;

import container.Container;
import exception.HandlingException;
import menu.adminRole.AdminRoleOption;

import java.text.ParseException;
import java.util.Scanner;

public class MainMenu {
    Scanner sc = new Scanner(System.in);
    Container container = new Container();

    // Main menu
    public void authenticationMenuTitle() {
        int choice = 0;
        System.out.println("Welcome to the hospital management system");
        System.out.println("Please  choose one of type role: ");
        System.out.println("1. Admin role");
        System.out.println("2. Doctor role");
        System.out.println("3. Patient role.");
        System.out.println("4. Exit");

        do {
            System.out.print("Your choice: ");
            choice = HandlingException.getInteger(sc);
            switch (choice) {
                case 1:
                    try {
                        System.out.print("username: ");
                        String userName = sc.nextLine();
                        System.out.print("password: ");
                        String password = sc.nextLine();
                        if (container.checkAdministration(userName,password)) {
                            int choice2 = 0;
                            menuTitleForAdministration();
                            choice2 = HandlingException.getInteger(sc);
                            AdminRoleOption.adminRoleOptions(choice2);
                        }
                    } catch (
                            ParseException e) {
                        System.out.println("username or password is incorrect");;
                    }
                    break;
                case 2: break;
                case 3: break;
                default: break;

            }
        } while (choice >= 1 && choice <= 3);
    }

    // Menu for choice the specialization
    public void menuTitleForAdministration() {
        System.out.println("Choose the specialization: ");
        System.out.println("1. CARDIOLOGY ");
        System.out.println("2. DERMATOLOGY ");
        System.out.println("3. ENT ");
        System.out.println("4. NEUROLOGY ");
        System.out.println("5. GERIATRIC ");
        System.out.println("6 .Exit");
        System.out.print("Your choice: ");
    }
}
