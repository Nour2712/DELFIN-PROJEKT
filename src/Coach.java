import java.util.ArrayList;

public class Coach {
    private final String name;
    private final int id;
    private ArrayList<CompetitiveMember> students = new ArrayList<>();

    public Coach(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
