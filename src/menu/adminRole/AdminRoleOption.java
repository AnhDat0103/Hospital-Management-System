package menu.adminRole;

import container.Container;
import exception.HandlingException;
import models.Doctor;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.util.Scanner;

public class AdminRoleOption {

    static Scanner sc = new Scanner(System.in);
    static Container container = new Container();

    public static void adminRoleOptions(int choice) throws ParseException {
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
                    System.out.print("Enter ID number you want to find: ");
                    String IDNumberFind = HandlingException.checkID(sc);
                    Doctor findDoctorByID = container.FindDoctorByID(IDNumberFind, choice);
                    if ( findDoctorByID == null) {
                        System.out.println("Doctor not found");
                    } else {
                        System.out.println(findDoctorByID.toString());
                    }
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        } while (choice1 >= 1 && choice1 <= 5);
    }

    // Detail option for all specialization
    public static void menuDetailsSpecialization() {
        System.out.println("1. Add the new doctor.");
        System.out.println("2. Show the list of doctors.");
<<<<<<< HEAD
        System.out.println("3. Find a doctor by IDNumber.");
        System.out.println("4. Update a doctor by IDNumber.");
        System.out.println("5. Delete a doctor by IDNumber.");
=======
        System.out.println("3. Find a doctor by IDNumber");
        System.out.println("4. Update a doctor by IDNumber");
        System.out.println("5. Delete a doctor by IDNumber");
>>>>>>> fe4ae6e3ad230e3b8d1959c035b9427e7fad2879
        System.out.println("6. Show the list of Patients.");
        System.out.println("7. Find a patient by IDNumber.");
        System.out.println("8. Exit.");
    }
}
