import java.util.ArrayList;

public class Delfinen {
    private ArrayList<Member> memberList;
    private Leaderboard leaderBoard = new Leaderboard();

    public Delfinen() {
    }

    public boolean addMember(Member member) {
        return memberList.add(member);
    }

    public boolean removeMember(Member member) {
        return memberList.remove(member);
    }
}
