package validation;

import fileIO.FileIO;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Validate {

    // Get valid telephone number
    public static String getTelephoneNumber(Scanner scanner) {
        while (true) {
            System.out.print("Enter phone number(+XXX-XXXXXXXX): ");
            String telephone = scanner.nextLine();
            if (checkTelephone(telephone)) {
                return telephone;
            } else {
                System.out.println("Invalid telephone number. Please enter a valid telephone number in the format +XXX-XXXXXXXX.");
            }
        }
    }

    // Check if telephone number is valid
    private static boolean checkTelephone(String telephone) {
        String pattern = "\\+\\d{3}-\\d{8}";
        return telephone != null && telephone.matches(pattern);
    }

    // Format name properly
    public static String formatName(String name) {
        String[] words = name.toLowerCase().trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                sb.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }
        return sb.toString().trim();
    }

    // Calculate age from birthdate
    public static int toAge(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        formatter.setLenient(false);
        long diff = new Date().getTime() - formatter.parse(date).getTime();
        return (int) (TimeUnit.MILLISECONDS.toDays(diff) / 365.25);
    }

    // clinic Hours
    public static int getClinicHours(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter doctor's clinic hours: ");
                int clinicHours = Integer.parseInt(scanner.nextLine());
                if (clinicHours > 0 && clinicHours <= 24) {
                    return clinicHours;
                } else {
                    System.out.println("Invalid clinic hours. Please enter a valid clinic hours between 1 and 24.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }

    // Check condition to find ID or check ID

    public static boolean checkCondition(String id, String pattern, String fileName) throws IOException {
       if (FileIO.checkIDInFile(id, fileName)) {
           System.out.println("ID is already in use. Please choose another ID.");
           return false;
       } else {
           if (!id.matches(pattern)) {
               System.out.println("Invalid ID. Please enter a valid ID.");
               return false;
           }
       }
       return true;
    }

    // Checking ID for Doctor's IDNumber
    public static String checkDoctorID (Scanner scanner, int choice) throws IOException {
        if (choice == 1) {
            while (true) {
                System.out.print("Enter ID((CDL/cdl) + XXXX): ");
                String id = scanner.nextLine();
                String pattern = "^(?:CDL|cdl)\\d{4}$";
                if (checkCondition(id, pattern, "doctorsCardiology.txt" )) {
                    return id;
                }
            }
        } else if (choice == 2) {
            while (true) {
                System.out.print("Enter ID((DML/dml) + XXXX): ");
                String id = scanner.nextLine();
                String pattern = "^(?:DML|dml)\\d{4}$";
                if (checkCondition(id, pattern, "doctorsDERMATOLOGY.txt")) return id;
            }
        } else if (choice == 3) {
            while (true) {
                System.out.print("Enter ID((ENT/ent) + XXXX): ");
                String id = scanner.nextLine();
                String pattern = "^(?:ENT|ent)\\d{4}$";
                if (checkCondition(id, pattern, "doctorsENT.txt")) return id;
            }
        } else if (choice == 4) {
            while (true) {
                System.out.print("Enter ID((NRL/nrl) + XXXX): ");
                String id = scanner.nextLine();
                String pattern = "^(?:NRL|nrl)\\d{4}$";
                if (checkCondition(id, pattern, "doctorsNEUROLOGY.txt")) return id;
            }
        } else if (choice == 5) {
            while (true) {
                System.out.print("Enter ID((GIT/git) + XXXX): ");
                String id = scanner.nextLine();
                String pattern = "^(?:GIT|git)\\d{4}$";
                if (checkCondition(id, pattern, "doctorsGERIATRIC.txt")) return id;
            }
        }
        return "";
    }

    // Checking ID for Patient's IDNumber
    public static String checkPatientID (Scanner scanner, int choice) throws IOException {
        if (choice == 1) {
            while (true) {
                System.out.print("Enter ID((PCDL/pcdl) + XXXX): ");
                String id = scanner.nextLine();
                String pattern = "^(?:PCDL|pcdl)\\d{4}$";
                if (checkCondition(id, pattern, "patientsCARDIOLOGY.txt")) return id;
            }
        } else if (choice == 2) {
            while (true) {
                System.out.print("Enter ID((PDML/pdml) + XXXX): ");
                String id = scanner.nextLine();
                String pattern = "^(?:PDML|pdml)\\d{4}$";
               if (checkCondition(id, pattern, "patientsDERMATOLOGY.txt")) return id;
            }
        } else if (choice == 3) {
            while (true) {
                System.out.print("Enter ID((PENT/pent) + XXXX): ");
                String id = scanner.nextLine();
                String pattern = "^(?:PENT|pent)\\d{4}$";
               if (checkCondition(id, pattern, "patientsENT.txt")) return id;
            }
        } else if (choice == 4) {
            while (true) {
                System.out.print("Enter ID((PNRL/pnrl) + XXXX): ");
                String id = scanner.nextLine();
                String pattern = "^(?:pNRL|pnrl)\\d{4}$";
                if (checkCondition(id, pattern, "patientsNEUROLOGY.txt")) return id;
            }
        } else if (choice == 5) {
            while (true) {
                System.out.print("Enter ID((PGIT/pgit) + XXXX): ");
                String id = scanner.nextLine();
                String pattern = "^(?:PGIT|pgit)\\d{4}$";
                if (checkCondition(id, pattern, "patientsGERIATRIC.txt")) return id;
            }
        }
        return "";
    }
}
