package exception;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        formatter.setLenient(false);
        while (true) {
            try {
                System.out.print("Enter birth date(DD/MM/YYYY): ");
                String date = scanner.nextLine();
                formatter.parse(date);
                return date;
            } catch (ParseException e) {
                System.out.println("Invalid date. Please enter a date in the format dd-MM-yyyy.");
            }
        }
    }



}
