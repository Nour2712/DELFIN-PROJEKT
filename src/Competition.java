import java.time.LocalDate;

public class Competition {
    private String name;
    private Member[] members;
    private Discipline discipline;
    private LocalDate localDate;
    private String location;

    public Competition(String name, Member[] members, Discipline discipline,
                       LocalDate localDate, String location) {
        this.name = name;
        this.members = members;
        this.discipline = discipline;
        this.localDate = localDate;
        this.location = location;
    }
}
