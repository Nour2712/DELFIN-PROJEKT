import java.time.LocalDate;

public class CompetitiveMember extends Member {

    private Coach coach;

    public CompetitiveMember(String name, int id, LocalDate birthdate, boolean isActive, Coach coach) {
        super(name, id, birthdate, isActive);
        this.coach = coach;
    }
}
