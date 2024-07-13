import viewLayer.ViewMain;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        try {
            ViewMain controller = new ViewMain();
            controller.authenticationMenuTitle();
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}