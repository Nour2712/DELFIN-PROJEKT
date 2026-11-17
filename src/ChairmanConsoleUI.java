import java.time.LocalDate;
public class ChairmanConsoleUI implements Menu{
    Delfinen delfinen;

    public ChairmanConsoleUI(Delfinen delfinen) {
        this.delfinen = delfinen;
    }

    @Override
    public void run() {

    }

    private void showMenu() {

    }

    // --------------------------------------------------
    // Chairman options
    // --------------------------------------------------

    public Member registerMembers(){
        String name = "newMemberName"; //getters mangler -> kald dem til en IO.readln fra consoleUI
        int id = 0; //newMemberId;        //getters mangler -> kald dem til en IO.readln fra consoleUI
        LocalDate birthdate = LocalDate.now(); //newMemberBirthdate //getters mangler -> kald dem til en IO.readln fra consoleUI

        return new Member(name, id, birthdate, false);
    }
}
