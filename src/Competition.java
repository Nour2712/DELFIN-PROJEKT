import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Competition {
    private String competitionName;
    private Discipline discipline;
    private LocalDate localDate;
    private ArrayList<SwimResult> placementList = new ArrayList<>();

    public Competition(String competitionName, Discipline discipline, LocalDate localDate) {
        this.competitionName = competitionName;
        this.discipline = discipline;
        this.localDate = localDate;
    }

    public void addSwimResult(int memberID, Duration timeSec) {
        SwimResult newSwimresult = new SwimResult(memberID, discipline, timeSec, localDate);
        placementList.add(newSwimresult);
        sortPlacementList();
    }




    public void sortPlacementList() {
        Collections.sort(placementList);
    }

    public ArrayList<SwimResult> getPlacementList() {
        return placementList;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public boolean competitorExists(int memberID) {
        for (SwimResult result : placementList) {
            if (result.memberID() == memberID) {
                return true;
            }
        }
        return false;
    }
}
