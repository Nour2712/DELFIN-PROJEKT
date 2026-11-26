import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

public class CompetitionHandler {
    private ArrayList<Competition> competitionList = new ArrayList<>();
    private LeaderboardHandler leaderboardHandler;

    public CompetitionHandler(LeaderboardHandler leaderboardHandler) {
        this.leaderboardHandler = leaderboardHandler;
    }

    public void createCompetition(String competitionName, Discipline discipline, AgeGroup ageGroup,
                                  LocalDate localDate, ArrayList<CompetitiveMember> competitorList) {
        Competition competition = new Competition(competitionName, discipline, ageGroup,
                localDate, competitorList);
        competitionList.add(competition);
    }

    public boolean addSwimResult(String competitionName, int memberID, Duration timeSec) {
        Competition competition = null;

        for (Competition comp : competitionList) {
            if (comp.getCompetitionName().equals(competitionName)) {
                competition = comp;
            }
        }

        if (competition == null) {
            return false;
        }

        // null = medlemmet deltager ikke, eller nye tid er ikke bedre
        SwimResult result = competition.addSwimResult(memberID, timeSec);
        if (result == null) {
            return false;
        }

        leaderboardHandler.addSwimResult(competition.getAgeGroup(), result.discipline(), result);
        return true;
    }

    public ArrayList<SwimResult> getPlacementList(String competitionName) {
        Competition competition = null;

        for (Competition comp : competitionList) {
            if (comp.getCompetitionName().equals(competitionName)) {
                competition = comp;
            }
        }

        if (competition != null) {
            return competition.getPlacementList();
        }
        return null;
    }

    public ArrayList<Competition> getCompetitionList() {
        return competitionList;
    }
}
