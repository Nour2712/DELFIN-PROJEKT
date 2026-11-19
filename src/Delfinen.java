import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

public class Delfinen {
    private ArrayList<Member> memberList = new ArrayList<Member>();
    private Leaderboard leaderBoard = new Leaderboard();
    private OverduePayment overduePayment = new OverduePayment(memberList);
    private CompetitionHandler competitionHandler = new CompetitionHandler();

    public Delfinen() {
    }

    public boolean addMember(Member member) {
        return memberList.add(member);
    }

    public boolean removeMember(Member member) {
        return memberList.remove(member);
    }

    // --------------------------------------------------
    // Competitions
    // --------------------------------------------------

    public void createCompetition(String competitionName, Discipline discipline, LocalDate localDate) {
        competitionHandler.createCompetition(competitionName, discipline, localDate);
    }

    public boolean addStudentSwimResult(String competitionName, int memberID, Duration timeSec) {
        return competitionHandler.addStudentSwimResult(competitionName, memberID, timeSec);
    }

    public ArrayList<SwimResult> getPlacementList(String competitionName) {
        return getPlacementList(competitionName);
    }

    // --------------------------------------------------
    // Payments
    // --------------------------------------------------

    public boolean payFee(int memberId, double amount) {
        return overduePayment.payFee(memberId, amount);
    }

    public ArrayList<Member> findMissingPaymentMembers() {
        return overduePayment.findMissingPaymentMembers();
    }

    public boolean monthlyPayment() {
        return overduePayment.monthlyFee();
    }

    // --------------------------------------------------
    // Getters og setters
    // --------------------------------------------------


    public ArrayList<Member> getMemberList() {
        return memberList;
    }
}
