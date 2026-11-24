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

    public void addSwimResult(SwimResult swimResult) {
        for (SwimResult result : leaderboard) {
            if (result.memberID() == swimResult.memberID()) {
                if (result.time().getSeconds() > swimResult.time().getSeconds()) {
                    removeSwimResult(result);
                    leaderboard.add(swimResult);
                }
            }
        }

        sortLeaderboard();
    }

    public void removeSwimResult(SwimResult swimResult) {
        leaderboard.remove(swimResult);

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
