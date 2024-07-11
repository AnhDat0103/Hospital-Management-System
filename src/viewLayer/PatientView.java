package viewLayer;
import exception.HandlingException;
import fileIO.FileIO;
import models.Patient;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class PatientView {
    // implement coding for patient role options.
    Scanner sc = new Scanner(System.in);
    ViewMain viewMain;

    public PatientView(ViewMain viewMain) {
        this.viewMain = viewMain;
    }

    public  void patientRoleOptions(int choice, String IDPatient) throws ParseException, IOException {
        int choice3;
        Patient patient = viewMain.getPatientController().findPatientByID(choice, IDPatient);
        if (patient == null) {
            System.out.println("Patient not found");
        } else {
            do {
                menuDetails();
                System.out.print("Your choice: ");
                choice3 = HandlingException.getInteger(sc);

                switch (choice3) {
                    case 1:
                        Patient.getHead();
                        patient.generateTable();
                        break;
                    case 2:
                        viewMain.getPatientController().showMedicineOfPatient(IDPatient, choice);
                        break;
                    case 3:
                        choice3 = 0;
                        viewMain.authenticationMenuTitle();
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } while (choice3 != 0);
        }

    }
    public static void menuDetails(){
        System.out.println("1. Show your information.");
        System.out.println("2. Show your prescription.");
        System.out.println("3. Back to main menu.");
        System.out.println("0. Exit");
    }
}
