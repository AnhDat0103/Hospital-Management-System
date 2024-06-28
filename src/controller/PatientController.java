package controller;
import exception.HandlingException;
import service.DoctorService;
import service.MedicineService;
import service.PatientService;

import java.text.ParseException;
import java.util.Scanner;

public class PatientController {
    // implement coding for patient role options.
    Scanner sc = new Scanner(System.in);
    ControllerMain controllerMain;

    private DoctorService doctorService = new DoctorService();
    private PatientService patientService;

    public PatientController(ControllerMain controllerMain) {
        this.controllerMain = controllerMain;
        this.patientService = new PatientService();
    }

    public DoctorService getDoctorService() {
        return doctorService;
    }
    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
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
                    patientService.findPatientByIDNumber(IDNumber, choice);
                    break;
                case 2:
                    doctorService.showDoctorsList(choice).forEach(s -> System.out.println(s.toString()));
                    break;
                case 3:
                    System.out.println("ENTER ID Patient want to find: ");
                    IDNumber = sc.nextLine();
                    controllerMain.getAdminController().getDoctorService().showMedicineOfPatient();
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
