import controller.ControllerMain;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        try {
            ControllerMain controller = new ControllerMain();
            controller.authenticationMenuTitle();
            System.out.println("checking comment");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}