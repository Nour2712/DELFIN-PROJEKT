import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

public class Delfinen {
    private ArrayList<Member> memberList = new ArrayList<Member>();
    private ArrayList<Coach> coachList = new ArrayList<Coach>();
    private OverduePayment overduePayment = new OverduePayment(memberList);
    private LeaderboardHandler leaderboardHandler = new LeaderboardHandler();
    private CompetitionHandler competitionHandler = new CompetitionHandler(leaderboardHandler);

    public Delfinen() {
    }

    public boolean addMember(Member member) {
        return memberList.add(member);
    }

    public boolean removeMember(Member member) {
        return memberList.remove(member);
    }

    // --------------------------------------------------
    // Leaderboards
    // --------------------------------------------------

    public void addSwimResultTraining(AgeGroup ageGroup, Discipline discipline, SwimResult swimResult) {
        leaderboardHandler.addSwimResult(ageGroup, discipline, swimResult);
    }

    public Leaderboard findLeaderboard(Discipline discipline, AgeGroup ageGroup) {
        return leaderboardHandler.findLeaderboard(discipline, ageGroup);
    }

    // --------------------------------------------------
    // Competitions
    // --------------------------------------------------

    public void createCompetition(String competitionName, Discipline discipline, AgeGroup ageGroup,
                                  LocalDate localDate, ArrayList<CompetitiveMember> competitorList) {
        competitionHandler.createCompetition(competitionName, discipline, ageGroup, localDate, competitorList);
    }

    public boolean addSwimResultCompetition(String competitionName, int memberID, Duration timeSec) {
        return competitionHandler.addSwimResult(competitionName, memberID, timeSec);
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

    public ArrayList<Member> getMemberList() {

        return memberList;
    }

    public ArrayList<Coach> getCoachList() {
        return coachList;
    }
}
