package menu.patientRole;
import container.Container;
import exception.HandlingException;
import java.text.ParseException;
import java.util.Scanner;

public class PatientRoleOptions {
    // implement coding for patient role options.
    static Scanner sc = new Scanner(System.in);
    static Container container = new Container();

    public static void patientRoleOptions(int choice) throws ParseException {
        int choice3;
        do{
            menuDetails();
            System.out.println("Your choice: ");
            choice3 = HandlingException.getInteger(sc);
            switch (choice3){
                case 1:
                    System.out.println("ENTER ID Patient want to find: ");
                    String IDNumber = sc.nextLine();
                    container.findPatientByIDNumber(IDNumber ,choice);
                    break;
                case 2:
                    container.showDoctorsList(choice);
                    break;
                case 3:
                    System.out.println("ENTER ID Patient want to find: ");
                    IDNumber = sc.nextLine();
                    container.showMedicineOfPatient();

            }
        }while (choice3 >= 1 && choice3 <= 4);
    }
    public static void menuDetails(){
        System.out.println("1. Find a patient by IDNumber.");
        System.out.println("2. Show the list of doctors.");
        System.out.println("3. Show the patient's prescription.");
        System.out.println("4. Exit.");
    }
}
