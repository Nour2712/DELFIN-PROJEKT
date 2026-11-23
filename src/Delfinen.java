import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

public class Delfinen {
    private ArrayList<Member> memberList = new ArrayList<Member>();
    private ArrayList<Coach> coachList = new ArrayList<Coach>();
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

    public boolean addNoneStudentSwimResult (String competitionName, Duration timeSec){
        return competitionHandler.addNoneStudentSwimResult(competitionName, timeSec);
    }

    public ArrayList<SwimResult> getPlacementList(String competitionName) {
        return competitionHandler.getPlacementList(competitionName);
    }

    public ArrayList<Competition> getCompetitionList() {
        return competitionHandler.getCompetitionList();
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

    public ArrayList<Coach> getCoachList() {
        return coachList;
    }
}
