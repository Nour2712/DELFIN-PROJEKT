import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Competition {
    private String competitionName;
    private Discipline discipline;
    private AgeGroup ageGroup;
    private LocalDate localDate;
    private ArrayList<SwimResult> placementList = new ArrayList<>();
    private ArrayList<CompetitiveMember> competitorList;

    public Competition(String competitionName, Discipline discipline, AgeGroup ageGroup,
                       LocalDate localDate, ArrayList<CompetitiveMember> competitorList) {
        this.competitionName = competitionName;
        this.discipline = discipline;
        this.ageGroup = ageGroup;
        this.localDate = localDate;
        this.competitorList = competitorList;
    }

    public SwimResult addSwimResult(int memberID, Duration timeSec) {

        SwimResult newResult = new SwimResult(memberID, discipline, timeSec, localDate);
        SwimResult previousResult = null;
        boolean memberIsCompeting = false;

        for (CompetitiveMember member : competitorList) {
            if (member.getId() == memberID) {
                memberIsCompeting = true;
            }
        }

        if (!memberIsCompeting) {
            return null;
        }

        for (SwimResult result : placementList) {
            if (result.memberID() == newResult.memberID()) {
                previousResult = result;
            }
        }

        if (previousResult == null) {
            placementList.add(newResult);
            sortPlacementList();
            return newResult;
        }

        if (newResult.time().compareTo(previousResult.time()) < 0) {
            placementList.remove(previousResult);
            placementList.add(newResult);
            sortPlacementList();
            return newResult;
        }

        return null;
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

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public boolean competitorExists(int memberID) {
        for (SwimResult result : placementList) {
            if (result.memberID() == memberID) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Konkurrence: " + competitionName + "\n" +
                "Disciplin: " + discipline + "\n" +
                "Dato: " + localDate + "\n";
    }
}
