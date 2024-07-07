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
                String IDNumber;
                mainTitle();
                System.out.print("Your choice: ");
                choice3 = HandlingException.getInteger(sc);
                switch (choice3) {
                    case 1:
                        viewMain.getPatientController().addNewPatient(choice, doctor); // add bệnh nhân vào khoa  --> ok
                        // cần một danh sách lưu riêng bệnh nhân của bác sĩ ấy để show bên dưới case 2
                        break;
                    case 2:
                        viewMain.getPatientController().showPatientsList(choice); // tại đây cần danh sách bệnh nhân của bác sĩ đã chỉ định
                        // không show tất cả bệnh nhân của khoa
                        break;
                    case 3:
                        System.out.println("ENTER ID Patient want to find: ");
                        IDNumber = sc.nextLine(); // lay ID ben nhan tu fileIO, dung mehthod Validate.checkPatientID()
                        viewMain.getPatientController().findPatientByIDNumber(IDNumber, choice); //
                        break;
                    case 4:
                        System.out.println("ENTER ID Patient want to update: ");
                        IDNumber = sc.nextLine(); // lay ID ben nhan tu fileIO, dung mehthod Validate.checkPatientID()
                        viewMain.getPatientController().UpdatePatientByID(IDNumber, choice);
                        break;
                    case 5:
                        System.out.println("ENTER ID Patient want to delete: ");
                        IDNumber = sc.nextLine();  // lay ID ben nhan tu fileIO, dung mehthod Validate.checkPatientID()
                        viewMain.getPatientController().RemovePatientByID(IDNumber, choice);
                        break;
                    case 6:
                        System.out.println("ENTER ID Patient want add Medicine: ");
                        IDNumber = sc.nextLine(); // lay ID ben nhan tu fileIO, dung mehthod Validate.checkPatientID()
                        viewMain.getDoctorController().addMedicineToPatient(IDNumber, choice); //nếu bệnh nhân xác định thì ta gọi đến method
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

