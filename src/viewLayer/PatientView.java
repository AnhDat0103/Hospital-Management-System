package viewLayer;
import exception.HandlingException;
import controller.DoctorController;

import java.text.ParseException;
import java.util.Scanner;

public class PatientView {
    // implement coding for patient role options.
    Scanner sc = new Scanner(System.in);
    ViewMain viewMain;

    public PatientView(ViewMain viewMain) {
        this.viewMain = viewMain;
    }

    public  void patientRoleOptions(int choice) throws ParseException {
        int choice3;
        do{
            menuDetails();
            String IDNumber;
            System.out.println("Your choice: ");
            choice3 = HandlingException.getInteger(sc);
            switch (choice3){
                case 1:
                    System.out.println("ENTER ID Patient want to find: ");
                    IDNumber = sc.nextLine();
                    viewMain.getPatientController().findPatientByIDNumber(IDNumber ,choice);
                    break;
                case 2:
                    viewMain.getDoctorController().showMedicineOfPatient();
                case 3:
                    choice3 = 0;
                    viewMain.authenticationMenuTitle();
                    break;
            }
        }while (choice3 >= 1 && choice3 <= 3);
    }
    public static void menuDetails(){
        System.out.println("1. Find a patient by IDNumber.");
        System.out.println("3. Show the patient's prescription.");
        System.out.println("3. Exit.");
    }
}
