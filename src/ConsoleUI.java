import java.awt.*;

public class ConsoleUI {

    private Delfinen delfinen;
    private UserType userType;

    public ConsoleUI(Delfinen delfinen) {
        this.delfinen = delfinen;
    }

    public void run(){
        IO.println("Hvem vil du logge ind som");
        String option = IO.readln(loginMenu());

        Menu userConsoleUI = switch (option) {
            case "1" -> null;
            case "2" -> null;
            case "3" -> new CashierConsoleUI(delfinen, 1);
            case "4" -> null;
            default -> null;
        };

        userConsoleUI.run();
    }

    private String loginMenu() {
        return "1: Medlem \n" +
                "2: Træner \n" +
                "3: Kasserer \n" +
                "4: Formand \n";
    }

    private void loginAuthentication() {

    }

    private void chooseUserConsoleUI() {

    }
}
