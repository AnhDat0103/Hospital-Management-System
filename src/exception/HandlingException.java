package exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
                String date = scanner.nextLine();
                formatter.parse(date);
                return date;
            } catch (ParseException e) {
                System.out.println("Invalid date. Please enter a date in the format dd-MM-yyyy.");
            }
        }
    }

    // Calculate age from birthdate
    public static int toAge(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        formatter.setLenient(false);
        long diff = new Date().getTime() - formatter.parse(date).getTime();
        return (int) (TimeUnit.MILLISECONDS.toDays(diff) / 365.25);
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

    // Get valid telephone number
    public static String getTelephoneNumber(Scanner scanner) {
        while (true) {
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
}