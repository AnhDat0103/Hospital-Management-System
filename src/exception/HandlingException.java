package exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class HandlingException {

    // Handling exception for integer
    public static int getInteger(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }

    // Handling exception for double
    public static double getDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a double.");
            }
        }
    }

    // Checking if the entered date is in the correct format dd-MM-yyyy
    public static String getBirthOfDay(Scanner scanner) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setLenient(false);
        while (true) {
            try {
                System.out.print("Enter doctor's birth date(DD/MM/YYYY): ");
                String date = scanner.nextLine();
                formatter.parse(date);
                return date;
            } catch (ParseException e) {
                System.out.println("Invalid date. Please enter a date in the format dd/MM/yyyy.");
            }
        }
    }

    // Checking ID for Doctor's IDNumber, Patient's IDNumber
    public static String checkID (Scanner scanner) throws ParseException {
        while (true) {
            System.out.print("Enter doctor's ID((CDL/DML/ENT/NRL/GIT) + XXXX): ");
            String id = scanner.nextLine();
            String pattern = "^(?:CDL|DML|ENT|NRL|GIT|PCDL|PDML|PENT|PNRL|PGIT)\\d{4}$";
            if (id.matches(pattern)) {
                return id;
            } else {
                System.out.println("Invalid ID. Please enter a valid ID.");
            }
        }
    }
}
