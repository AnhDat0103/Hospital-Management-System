package validation;

import exception.HandlingException;
import fileIO.FileIO;
import models.enums.Action;

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

    // check ID to create new user.
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

    // check ID to find user
    public static boolean checkIDToFind(String id, String pattern, String fileName) throws IOException {
        if (id.matches(pattern)) {
            if (FileIO.checkIDInFile(id, fileName)) {
                return true;
            }
        } else {
            System.out.println("Id is invalid. Please enter a valid ID.");
            return false;
        }
        return true;
    }
    // Checking ID for Doctor's IDNumber
    public static String checkDoctorID (Scanner scanner, int choice, Action action) throws IOException {
        if (choice == 1) {
            while (true) {
                System.out.print("Enter ID(CDL/cdl) + XXXX): ");
                String id = scanner.nextLine();
                String pattern = "^(?:CDL|cdl)\\d{4}$";
                if (action == Action.CHECK) {
                    if (checkCondition(id, pattern, "doctorsCardiology.txt" )) {
                        return id;
                    }
                } else if (action == Action.FIND) {
                    if (checkIDToFind(id, pattern, "doctorsCardiology.txt" )) {
                        return id;
                    }
                } else {
                    return null;
                }
            }
        } else if (choice == 2) {
            while (true) {
                System.out.print("Enter ID(DML/dml) + XXXX): ");
                String id = scanner.nextLine();
                String pattern = "^(?:DML|dml)\\d{4}$";
                if (action == Action.CHECK) {
                    if (checkCondition(id, pattern, "doctorsDERMATOLOGY.txt" )) {
                        return id;
                    }
                } else if (action == Action.FIND) {
                    if (checkIDToFind(id, pattern, "doctorsDERMATOLOGY.txt" )) {
                        return id;
                    }
                } else {
                    return null;
                }
            }
        } else if (choice == 3) {
            while (true) {
                System.out.print("Enter ID(ENT/ent) + XXXX): ");
                String id = scanner.nextLine();
                String pattern = "^(?:ENT|ent)\\d{4}$";
                if (action == Action.CHECK) {
                    if (checkCondition(id, pattern, "doctorsENT.txt" )) {
                        return id;
                    }
                } else if (action == Action.FIND) {
                    if (checkIDToFind(id, pattern, "doctorsENT.txt" )) {
                        return id;
                    }
                } else {
                    return null;
                }
            }
        } else if (choice == 4) {
            while (true) {
                System.out.print("Enter ID(NRL/nrl) + XXXX): ");
                String id = scanner.nextLine();
                String pattern = "^(?:NRL|nrl)\\d{4}$";
                if (action == Action.CHECK) {
                    if (checkCondition(id, pattern, "doctorsNEUROLOGY.txt" )) {
                        return id;
                    }
                } else if (action == Action.FIND) {
                    if (checkIDToFind(id, pattern, "doctorsNEUROLOGY.txt" )) {
                        return id;
                    }
                } else {
                    return null;
                }
            }
        } else if (choice == 5) {
            while (true) {
                System.out.print("Enter ID(GIT/git) + XXXX): ");
                String id = scanner.nextLine();
                String pattern = "^(?:GIT|git)\\d{4}$";
                if (action == Action.CHECK) {
                    if (checkCondition(id, pattern, "doctorsGERIATRIC.txt" )) {
                        return id;
                    }
                } else if (action == Action.FIND) {
                    if (checkIDToFind(id, pattern, "doctorsGERIATRIC.txt" )) {
                        return id;
                    }
                } else {
                    return null;
                }
            }
        }
        return "";
    }

    // Checking ID for Patient's IDNumber
    public static String checkPatientID (Scanner scanner, int choice, Action action) throws IOException {
        if (choice == 1) {
            while (true) {
                System.out.print("Enter ID(PCDL/pcdl) + XXXX): ");
                String id = scanner.nextLine();
                String pattern = "^(?:PCDL|pcdl)\\d{4}$";
                if (action == Action.CHECK) {
                    if (checkCondition(id, pattern, "patientsCARDIOLOGY.txt" )) {
                        return id;
                    }
                } else if (action == Action.FIND) {
                    if (checkIDToFind(id, pattern, "patientsCARDIOLOGY.txt" )) {
                        return id;
                    }
                } else {
                    return null;
                }
            }
        } else if (choice == 2) {
            while (true) {
                System.out.print("Enter ID((PDML/pdml) + XXXX): ");
                String id = scanner.nextLine();
                String pattern = "^(?:PDML|pdml)\\d{4}$";
                if (action == Action.CHECK) {
                    if (checkCondition(id, pattern, "patientsDERMATOLOGY.txt" )) {
                        return id;
                    }
                } else if (action == Action.FIND) {
                    if (checkIDToFind(id, pattern, "patientsDERMATOLOGY.txt" )) {
                        return id;
                    }
                } else {
                    return null;
                }
            }
        } else if (choice == 3) {
            while (true) {
                System.out.print("Enter ID((PENT/pent) + XXXX): ");
                String id = scanner.nextLine();
                String pattern = "^(?:PENT|pent)\\d{4}$";
                if (action == Action.CHECK) {
                    if (checkCondition(id, pattern, "patientsENT.txt" )) {
                        return id;
                    }
                } else if (action == Action.FIND) {
                    if (checkIDToFind(id, pattern, "patientsENT.txt" )) {
                        return id;
                    }
                } else {
                    return null;
                }
            }
        } else if (choice == 4) {
            while (true) {
                System.out.print("Enter ID((PNRL/pnrl) + XXXX): ");
                String id = scanner.nextLine();
                String pattern = "^(?:pNRL|pnrl)\\d{4}$";
                if (action == Action.CHECK) {
                    if (checkCondition(id, pattern, "patientsNEUROLOGY.txt" )) {
                        return id;
                    }
                } else if (action == Action.FIND) {
                    if (checkIDToFind(id, pattern, "patientsNEUROLOGY.txt" )) {
                        return id;
                    }
                } else {
                    return null;
                }
            }
        } else if (choice == 5) {
            while (true) {
                System.out.print("Enter ID((PGIT/pgit) + XXXX): ");
                String id = scanner.nextLine();
                String pattern = "^(?:PGIT|pgit)\\d{4}$";
                if (action == Action.CHECK) {
                    if (checkCondition(id, pattern, "patientsGERIATRIC.txt" )) {
                        return id;
                    }
                } else if (action == Action.FIND) {
                    if (checkIDToFind(id, pattern, "patientsGERIATRIC.txt" )) {
                        return id;
                    }
                } else {
                    return null;
                }
            }
        }
        return "";
    }

    private static boolean checkBloodType(String bloodType) {
        String pattern = "A|B|AB|o|O|a|b|ab" ;
        return bloodType != null && bloodType.matches(pattern);
    }
    public static String getBloodType(Scanner scanner) {
        while (true) {
            System.out.print("Enter blood type: ");
            String bloodType = scanner.nextLine();
            if (checkBloodType(bloodType)) {
                return bloodType;
            } else{
                System.out.println("Invalid blood type. Please enter a valid blood type.");
            }
        }
    }
    private static boolean checkHeight(double height) {
        final double MIN_HEIGHT = 0;
        if (height < MIN_HEIGHT) {
            return false;
        }
        return true;
    }

    private static boolean checkWeight(double weight) {
        final double MIN_WEIGHT = 0;
        if (weight < MIN_WEIGHT) {
            return false;
        }
        return true;
    }
    public static double getHeight(Scanner scanner) {
        final double MIN_HEIGHT = 0;
        while (true) {
            System.out.print("Enter height (cm): ");
            double height = HandlingException.getDouble(scanner);
            if (checkHeight(height)) {
                return height;
            }
            System.out.print("Invalid height. Please enter a value between " + MIN_HEIGHT + "cm.");
            scanner.nextLine(); // Clear the newline character from the buffer
        }
    }

    public static double getWeight(Scanner scanner) {
        final double MIN_WEIGHT = 0;
        while (true) {
            System.out.print("Enter weight (kg): ");
            double weight = scanner.nextInt();
            if (checkWeight(weight)) {
                return weight;
            }
            System.out.print("Invalid weight. Please enter a value between " + MIN_WEIGHT +"kg.");
            scanner.nextLine(); // Clear the newline character from the buffer
        }
    }
}
