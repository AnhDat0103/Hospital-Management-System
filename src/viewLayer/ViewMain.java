package viewLayer;

import controller.DoctorController;
import controller.MedicineController;
import controller.PatientController;
import exception.HandlingException;

import java.text.ParseException;
import java.util.Scanner;

public class ViewMain {
    private Scanner sc = new Scanner(System.in);
    private AdminView adminView;
    private DoctorView doctorView;
    private PatientView patientView;
    private DoctorController doctorController = new DoctorController();
    private PatientController patientController = new PatientController();
    private MedicineController medicineController = new MedicineController();

    public ViewMain() {
        this.adminView = new AdminView(this);
        this.doctorView = new DoctorView(this);
        this.patientView = new PatientView(this);
    }

    public DoctorController getDoctorController() {
        return doctorController;
    }

    public PatientController getPatientController() {
        return patientController;
    }

    public MedicineController getMedicineController() {
        return medicineController;
    }

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
                            if (HandlingException.checkAdministration(userName,password)) {
                                int choice2;
                                do {
                                    menuTitleForAdministration();
                                    choice2 = HandlingException.getInteger(sc);
                                    if (choice2 == 6) authenticationMenuTitle();
                                    if (choice2 == 1 || choice2 == 2 || choice2 == 3 || choice2 == 4 || choice2 == 5)
                                        adminView.adminRoleOptions(choice2);
                                } while (choice2 < 1 || choice2 > 6);
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
                    while(true){
                        try{
                            int choice2;
                            do{
                                menuTitleForAdministration();
                                choice2 = HandlingException.getInteger(sc);
                                if (choice2 == 6) authenticationMenuTitle();
                            }while (choice2 < 1 || choice2 > 6);
                            doctorView.doctorRoleOptions(choice2);
                            break;
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                case 3:
                    while(true){
                        try{
                            int choice3;
                            do{
                                menuTitleForAdministration();
                                choice3 = HandlingException.getInteger(sc);
                                if (choice3 == 6) authenticationMenuTitle();
                                //check id tu file txt truyen id xuong  patientRoleOptions(choice3,id)
                                if (choice3 == 1 || choice3 == 2 || choice3 == 3 || choice3 == 4 || choice3 == 5) patientView.patientRoleOptions(choice3);
                            }while (choice3 < 1 || choice3 > 6);
                            break;
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 4: break;
                default: System.out.println("Invalid choice");
            }
        } while (choice < 1 || choice > 4);
    }

    // Menu for choice the specialization
    public void menuTitleForAdministration() {
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
