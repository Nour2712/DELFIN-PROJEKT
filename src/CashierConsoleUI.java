import java.util.ArrayList;

public class CashierConsoleUI implements Menu{
    Menu run;
    Delfinen delfinen;
    int cashierId;


    public CashierConsoleUI(Delfinen delfinen, int cashierId) {
        this.delfinen = delfinen;
        this.cashierId = cashierId;
    }

    @Override
    public void run() {
        boolean running = true;
        IO.println("Velkommen Kasserer");

        while (running) {
            IO.println("");
            String option = IO.readln(showMenu());

            switch (option) {
                case "1" -> {
                    IO.println("Årlige kontingent: " + contingent() + " \n");
                }

                case "2" -> {
                    ArrayList<Member> missingPaymentMembers = overdueMembers();
                    if (missingPaymentMembers.isEmpty()) {
                        IO.println("Ingen medlemmer der er i restance \n");
                    } else {
                        for (Member member : missingPaymentMembers) {
                            IO.println(member.getName() + ", ID: " + member.getId() +
                                    ", Manglende betaling: " + member.getMissingPayments());
                        }
                    }
                }

                case "3" -> {
                    String memberIdStr = IO.readln("Indtast medlems ID \n");
                    int memberID = Integer.parseInt(memberIdStr);

                    String amountStr = IO.readln("Indtast beløb \n");
                    double amount = Double.parseDouble(amountStr);

                    if (payFee(memberID, amount)) {
                        IO.println("Betaling gennemført \n");
                    } else IO.println("Betaling mislykkedes \n");

                }

                case "4" -> {
                    IO.println(monthlyPayment());
                }

                case "0" -> {
                    return;
                }

                default -> IO.println("Jeg forstår ikke hvad du vil \n");
            }
        }
    }

    private String showMenu() {
        return  "1: Samlet kontingent betalinger \n" +
                "2: Find medlemmer i restance \n" +
                "3: Betal regning \n" +
                "4: Ny mådentlig betaling \n" +
                "0: Afslut \n";
    }

    // Cashier options
    private int contingent() {
        ArrayList<Member> memberList = delfinen.getMemberList();
        int yearlyContingent = 0;
        for (Member member : memberList) {
            yearlyContingent += member.calculateMemberFee();
        }
        return yearlyContingent;
    }

    private ArrayList<Member> overdueMembers() {
        return delfinen.findMissingPaymentMembers();
    }

    private boolean payFee(int memberId, double amount) {
        return delfinen.payFee(memberId, amount);
    }

    private String monthlyPayment() {
        if (delfinen.monthlyPayment()) {
            return "Ny mådentlig afgift er sendt afsted \n";
        }
        return "Det er ikke en ny måned. Afgiften er ikke sendt afsted \n";
    }
}
