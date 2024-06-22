package exception;
import models.enums.Gender;

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
                System.out.print("Enter birth date(DD-MM/-YYYY): ");
                String date = scanner.nextLine();
                formatter.parse(date);
                return date;
            } catch (ParseException e) {
                System.out.println("Invalid date. Please enter a date in the format dd-MM-yyyy.");
            }
        }
    }

    //METHOD TO TAKE GENDER
    public static Gender getGender(Scanner sc) {
        Gender gender = null;
        int choiceGender;
        do {
            System.out.printf("Gender?: %10s"," ");
            System.out.printf("%10s|%10s|%10s|%10s", "1.MALE", "2.FEMALE ", " Your choice:", " ");
            choiceGender = HandlingException.getInteger(sc);
            if (choiceGender == 1) {
                gender = Gender.MALE;
            } else if (choiceGender == 2) {
                gender = Gender.FEMALE;
            }
            else {
                System.out.println("Invalid Gender");
            }
        } while ( choiceGender != 1 && choiceGender != 2);
        return gender;
    }


    // METHOD OF ADMIN
    public static boolean checkAdministration(String userName, String password) throws ParseException {
        if (userName.matches("admin") && password.matches("admin")) {
            return true;
        } else {
            throw new ParseException("user name or password is incorrect", 0);
        }
    }




}
