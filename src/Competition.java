import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Competition {
    private String name;
    private Member[] members;
    private Discipline discipline;
    private LocalDate localDate;
    private ArrayList<SwimResult> placementList;

    public Competition(String name, Member[] members, Discipline discipline,
                       LocalDate localDate, ArrayList<SwimResult> placementList) {
        this.name = name;
        this.members = members;
        this.discipline = discipline;
        this.localDate = localDate;
        this.placementList = placementList;

    }

    public void addSwimResult(SwimResult swimResult) {
        placementList.add(swimResult);
        sortPlacementList();
    }

    public void sortPlacementList() {
        Collections.sort(placementList);
    }


}
