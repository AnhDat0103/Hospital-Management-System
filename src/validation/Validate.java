package validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Validate {

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



}
