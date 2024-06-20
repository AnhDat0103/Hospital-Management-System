import database.FileIO;
import exception.HandlingException;
import menu.MainMenu;
import models.Doctor;
import models.Medicine;
import models.Patient;
import models.enums.Education;
import models.enums.Gender;
import models.enums.Specialization;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            MainMenu.authenticationMenuTitle();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}