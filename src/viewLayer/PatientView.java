package viewLayer;
import exception.HandlingException;
import controller.DoctorController;

import java.text.ParseException;
import java.util.Scanner;

public class PatientView {
    // implement coding for patient role options.
    Scanner sc = new Scanner(System.in);
    ViewMain controllerMain;

    private DoctorController doctorController = new DoctorController();

    public PatientView(ViewMain controllerMain) {
        this.controllerMain = controllerMain;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public ViewMain getControllerMain() {
        return controllerMain;
    }

    public void setControllerMain(ViewMain controllerMain) {
        this.controllerMain = controllerMain;
    }

    public DoctorController getDoctorController() {
        return doctorController;
    }

    public void setDoctorController(DoctorController doctorController) {
        this.doctorController = doctorController;
    }

    public  void patientRoleOptions(int choice) throws ParseException {
        int choice3;
        do{
            menuDetails();
            String IDNumber = "";
            System.out.println("Your choice: ");
            choice3 = HandlingException.getInteger(sc);
            switch (choice3){
                case 1:
                    System.out.println("ENTER ID Patient want to find: ");
                    IDNumber = sc.nextLine();
                    controllerMain.getAdminView().getPatientController().findPatientByIDNumber(IDNumber ,choice);
                    break;
                case 2:
                    controllerMain.getAdminView().getDoctorController().showDoctorsList(choice).forEach(s -> System.out.println(s.toString()));
                    break;
                case 3:
                    System.out.println("ENTER ID Patient want to find: ");
                    IDNumber = sc.nextLine();
                    controllerMain.getAdminView().getDoctorController().showMedicineOfPatient(IDNumber , choice);
                    break;
                case 4:
                    choice3 = 0;
                    controllerMain.authenticationMenuTitle();
                    break;
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
