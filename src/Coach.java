import java.util.ArrayList;

public class Coach {
    private final String name;
    private final int id;
    private ArrayList<CompetitiveMember> students = new ArrayList<>();

    public Coach(String name, int id) {
        this.name = name;
        this.id = id;
    }


    public ArrayList<CompetitiveMember> getStudents() {
        return students;
    }

    public boolean addStudent(CompetitiveMember member) {
        for (CompetitiveMember mmbr : students ){
            if (member.equals(mmbr)){
                return false;
            }
        }
        return students.add(member);

    }


    public boolean removeStudent(CompetitiveMember member){
        return students.remove(member);
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }
}
