import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

public class CompetitionHandler {
    private ArrayList<Competition> competitionList = new ArrayList<>();

    public CompetitionHandler() {

    }

    public void createCompetition(String competitionName, Discipline discipline, LocalDate localDate) {
        Competition competition = new Competition(competitionName, discipline, localDate);
        competitionList.add(competition);
    }

    // Hvis man vil tilføje en tid fra en person som er en member hos delfinen
    public boolean addStudentSwimResult(String competitionName, int memberID, Duration timeSec) {
        Competition competition = null;

        for (Competition comp : competitionList) {
            if (comp.getCompetitionName().equals(competitionName)) {
                competition = comp;
            }
        }


        // Konkurencen existerer
        if (competition == null) {
            return false;
        }

        // Competitor er ikke tilføjet flere gange
        if (competition.competitorExists(memberID)) {
            return false;
        }

        competition.addSwimResult(memberID, timeSec);
        return true;
    }

    // Hvis man vil tilføje en tid fra en person som ikke er en member hos delfinen
    public boolean addNoneStudentSwimResult(String competitionName, Duration timeSec) {
        Competition competition = null;
        for (Competition comp : competitionList) {
            if (comp.getCompetitionName().equals(competitionName)) {
                competition = comp;
            }
        }

        if (competition == null) {
            return false;
        }

        competition.addSwimResult(0, timeSec);
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
