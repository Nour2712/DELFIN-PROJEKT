import java.util.ArrayList;
import java.util.List;

public class LeaderboardHandler {
    private Leaderboard JrCrawl = new Leaderboard(
            new ArrayList<SwimResult>(), AgeGroup.JUNIOR, Discipline.CRAWL);

    private Leaderboard JrBackcrawl = new Leaderboard(
            new ArrayList<SwimResult>(), AgeGroup.JUNIOR, Discipline.BACK_CRAWL);

    private Leaderboard JrButterfly = new Leaderboard(
            new ArrayList<SwimResult>(), AgeGroup.JUNIOR, Discipline.BUTTERFLY);

    private Leaderboard JrBreaststroke = new Leaderboard(
            new ArrayList<SwimResult>(), AgeGroup.JUNIOR, Discipline.BREASTSTROKE);

    private Leaderboard SrCrawl = new Leaderboard(
            new ArrayList<SwimResult>(), AgeGroup.SENIOR, Discipline.CRAWL);

    private Leaderboard SrBackcrawl = new Leaderboard(
            new ArrayList<SwimResult>(), AgeGroup.SENIOR, Discipline.BACK_CRAWL);

    private Leaderboard SrButterfly = new Leaderboard(
            new ArrayList<SwimResult>(), AgeGroup.SENIOR, Discipline.BUTTERFLY);

    private Leaderboard SrBreaststroke = new Leaderboard(
            new ArrayList<SwimResult>(), AgeGroup.SENIOR, Discipline.BREASTSTROKE);

    private ArrayList<Leaderboard> leaderboardList = new ArrayList<>(List.of(
            JrCrawl, JrBackcrawl, JrButterfly, JrBreaststroke,
            SrCrawl, SrBackcrawl, SrButterfly, SrBreaststroke));

    public LeaderboardHandler() {
    }

    public void addSwimResult(AgeGroup ageGroup, Discipline discipline, SwimResult swimResult) {
        for (Leaderboard leaderboard : leaderboardList) {
            if (leaderboard.getAgeGroup().equals(ageGroup)) {
                if (leaderboard.getDiscipline().equals(discipline)) {
                    leaderboard.addSwimResult(swimResult);
                }
            }
        }
    }

    public Leaderboard findLeaderboard(Discipline discipline, AgeGroup ageGroup) {
        Leaderboard leaderboard = null;
        for (Leaderboard lb : leaderboardList) {
            if (lb.getDiscipline().equals(discipline)) {
                if (lb.getAgeGroup().equals(ageGroup)) {
                    leaderboard = lb;
                }
            }
        }
        return leaderboard;
    }
}
