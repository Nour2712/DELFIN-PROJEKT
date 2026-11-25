import java.awt.Menu;
import java.time.LocalDate;
import java.util.ArrayList;

public class ChairmanConsoleUI extends Menu{
    Delfinen delfinen;
    ArrayList<Member> memberList = new ArrayList<>();


    public ChairmanConsoleUI(Delfinen delfinen) {
        this.delfinen = delfinen;
    }

    public void run() {

    }
    private void chairmanMenu(){
        IO.println("Tast 1 for at oprette/registrere et nyt medlem");
        IO.println("Tast 2 for at se alle nuværende medlemmer");
        IO.println("Tast 3 for at vende tilbage til login");
    }

    private void showMenu() {
        String option = IO.readln("Indtast valgmulighed med tal: ");
        switch (option) {
            case "1" -> registerMember();
            case "2" -> showMembers();
            default -> {
                if (option.equalsIgnoreCase("1") || option.equalsIgnoreCase("2")) {
                    IO.println("Fejl i input, prøv at indtaste igen");
                }
            }
        }
    }

    public Member registerMember(){
        String name = IO.readln("Indtast medlemmets navn: ");
        int newMemberId = Integer.parseInt(IO.readln("Indtast medlemmets id: "));
        LocalDate birthdate = LocalDate.parse(IO.readln("Indtast medlemmets fødselsdato: "));
        Member newMember = new Member(name, newMemberId, birthdate, true);
        memberList.add(newMember);
        return newMember;
    }
    public void showMembers(){
        for (Member member : memberList){
            IO.println(member);
        }
    }
}
