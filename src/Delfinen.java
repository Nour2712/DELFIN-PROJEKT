import java.util.ArrayList;

public class Delfinen {
    private ArrayList<Member> memberList = new ArrayList<Member>();
    private Leaderboard leaderBoard = new Leaderboard();
    private OverduePayment overduePayment = new OverduePayment(memberList);

    public Delfinen() {
    }

    public boolean addMember(Member member) {
        return memberList.add(member);
    }

    public boolean removeMember(Member member) {
        return memberList.remove(member);
    }

    // --------------------------------------------------
    // Payments
    // --------------------------------------------------

    public boolean payFee(int memberId, double amount) {
        return overduePayment.payFee(memberId, amount);
    }

    public ArrayList<Member> findMissingPaymentMembers() {
        return overduePayment.findMissingPaymentMembers();
    }

    public boolean monthlyPayment() {
        return overduePayment.monthlyFee();
    }

    // --------------------------------------------------
    // Getters og setters
    // --------------------------------------------------


    public ArrayList<Member> getMemberList() {
        return memberList;
    }
}
