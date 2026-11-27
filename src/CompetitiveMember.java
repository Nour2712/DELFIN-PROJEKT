import java.time.LocalDate;
import java.util.ArrayList;

public class CompetitiveMember extends Member {

    private int coachId;

    public CompetitiveMember(String name, int id, LocalDate birthdate, boolean isActive, int coachId) {
        super(name, id, birthdate, isActive);
        this.coachId = coachId;
    }

    public Coach getCoachId(ArrayList<Coach> coachList) {
        for (Coach coach : coachList) {
            if(coach.getId() == coachId) {
                return coach;
            }
        }
        return null;
    }
}
