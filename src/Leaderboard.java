import java.util.ArrayList;
import java.util.Collections;

public class Leaderboard {

    private ArrayList<SwimResult>leaderboard;
    private final AgeGroup ageGroup;
    private final Discipline discipline;

    public Leaderboard(ArrayList<SwimResult>leaderboard, AgeGroup ageGroup, Discipline discipline) {
        this.leaderboard = leaderboard;
        this.ageGroup = ageGroup;
        this.discipline = discipline;
    }

    public ArrayList<SwimResult> getLeaderboard() {
        return leaderboard;
    }

    public boolean addSwimResult(SwimResult newResult) {
        SwimResult previousResult = null;

        for (SwimResult result : leaderboard) {
            if (result.memberID() == newResult.memberID()) {
                previousResult = result;
            }
        }
        if (previousResult == null) {
            leaderboard.add(newResult);
            sortLeaderboard();
            return true;
        }

        if (newResult.time().compareTo(previousResult.time()) < 0) {
            leaderboard.remove(previousResult);
            leaderboard.add(newResult);
            sortLeaderboard();
            return true;
        }

        return false;
    }

    public void sortLeaderboard() {
        Collections.sort(leaderboard);
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public Discipline getDiscipline() {
        return discipline;
    }
}
