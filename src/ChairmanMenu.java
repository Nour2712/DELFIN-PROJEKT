import java.time.LocalDate;
public class ChairmanMenu {
    Menu run;
    Delfinen delfinen;
    int chairmanId;

    public ChairmanMenu(Menu run, Delfinen delfinen, int chairmanId) {
        this.run = run;
        this.delfinen = delfinen;
        this.chairmanId = chairmanId;
    }

    public Member registerMember(){
        String name = "newMemberName"; //getters mangler -> kald dem til en IO.readln fra consoleUI
        int id = 0; //newMemberId;        //getters mangler -> kald dem til en IO.readln fra consoleUI
        LocalDate birthdate = LocalDate.now(); //newMemberBirthdate //getters mangler -> kald dem til en IO.readln fra consoleUI

        return new Member(name, id, birthdate, false);
    }
}
