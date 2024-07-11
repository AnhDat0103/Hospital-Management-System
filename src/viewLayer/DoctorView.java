package viewLayer;

import exception.HandlingException;
import models.Doctor;
import models.Patient;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Scanner;

public class DoctorView {
    // implement coding for doctor role options.
    Scanner sc = new Scanner(System.in);
    private ViewMain viewMain;

    public DoctorView(ViewMain viewMain) {
        this.viewMain = viewMain;
    }

    public void doctorRoleOptions(int choice, String doctorID) throws ParseException, IOException {
        int choice3;
        do {
            Doctor doctor = viewMain.getDoctorController().findDoctorByID(choice, doctorID);
            if (doctor == null) {
                System.out.println("Doctor not found");
                break;
            } else{
                mainTitle();
                System.out.print("Your choice: ");
                choice3 = HandlingException.getInteger(sc);
                switch (choice3) {
                    case 1:
                        viewMain.getPatientController().addNewPatient(choice, doctor);
                        break;
                    case 2:
                        viewMain.getPatientController().showPatientsList(doctor);
                        break;
                    case 3:
                        viewMain.getPatientController().findPatientByIDNumber(choice, doctor);
                        break;
                    case 4:
                        viewMain.getPatientController().UpdatePatientByID(choice, doctor);
                        break;
                    case 5:
                        viewMain.getPatientController().RemovePatientByID(choice, doctor);
                        break;
                    case 6:
                        viewMain.getPatientController().addMedicineToPatient(choice, doctor);
                        break;
                    case 7:
                        choice3 = 0;
                        viewMain.authenticationMenuTitle();
                        break;
                }
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

