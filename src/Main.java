import exception.HandlingException;
import menu.MainMenu;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        MainMenu mainMenu = new MainMenu();
        mainMenu.authenticationMenuTitle();
    }
}