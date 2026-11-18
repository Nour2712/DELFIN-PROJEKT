import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class OverduePayment {
    private ArrayList<Member> allMembers;
    private Month month;

    public OverduePayment(ArrayList<Member> memberList) {
        this.allMembers = memberList;
    }

    public boolean payFee(int memberId, double amount) {
        Member member = null;

        for (Member mmbr : allMembers) {
            if (mmbr.getId() == memberId) {
                member = mmbr;
            }
        }

        if (member == null) {
            return false;
        }

        member.payFee(amount);
        return true;
    }

    public boolean monthlyFee() {
        Month thisMonth = LocalDate.now().getMonth();
        if (month != thisMonth) {
            for (Member member : allMembers) {
                member.addMonthlyFee();
            }
            month = thisMonth;
            return true;
        }
        return false;
    }

    public ArrayList<Member> findMissingPaymentMembers() {
        ArrayList<Member> missingPaymentMembers = new ArrayList<Member>();
        for (Member member : allMembers) {
            if (member.getMissingPayments() > 0) {
                missingPaymentMembers.add(member);
            }
        }
        return missingPaymentMembers;
    }
}
