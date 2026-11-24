public class MemberConsoleUI implements Menu {

    private Delfinen delfinen;
    private Member member;

    public MemberConsoleUI(Delfinen delfinen, int memberId) {
        this.delfinen = delfinen;
        for (Member member1 : delfinen.getMemberList()) {
            if (member1.getId() == memberId) {
                this.member = member1;
            }
        }
    }

    @Override
    public void run() {
        boolean running = true;
        IO.println("Velkommen medlem");

        while (running) {
            IO.println("");
            String option = IO.readln(showMenu());

            switch (option) {
                case "1" -> competitions();
                case "2" -> stats();
                case "3" -> coach();
                case "4" -> subscription();
                case "5" -> personalInfo();
                default -> running = false;
            }
        }
    }

    private String showMenu() {
        return "1: Se konkurrencer \n" +
                "2: Se mine resultater \n" +
                "3: Se min træner \n" +
                "4: Se mit kontingent \n" +
                "5: Se mine oplysninger \n" +
                "0: Afslut \n";
    }

    // Viser alle konkurrencer
    private void competitions() {
        for (Competition competition : delfinen.getCompetitionList()) {
            IO.println(competition);
        }
    }

    // Viser medlemmets resultater fra alle konkurrencer
    private void stats() {
        boolean foundResult = false; //Så altså hvis der bliver fundet mindst et resultat så bliver den true

        for (Competition competition : delfinen.getCompetitionList()) {
            for (SwimResult result : competition.getPlacementList()) {
                if (result.memberID() == member.getId()) {
                    IO.println(competition.getCompetitionName() + ": " + result);
                    foundResult = true;
                }
            }
        }

        if (!foundResult) {
            IO.println("Du har ingen resultater endnu");
        }

    }
    // Viser medlemmets træner
    private void coach() {

        Coach myCoach = null;
        for (Coach coach : delfinen.getCoachList()) {
            for (Member student : coach.getStudents()) {
                if (student.getId() == member.getId()) {
                    myCoach = coach;
                }
            }
        }

        // Skriver træneren ud eller giver besked hvis der ikke er nogen træner
        if (myCoach != null) {
            IO.println("Din træner er: " + myCoach.getName());
        } else {
            IO.println("Du har ikke en træner endnu");
        }
    }
    // Viser medlemmets årlige kontingent og hvor meget de mangler at betale
    private void subscription() {
        IO.println("Årligt kontingent: " + member.calculateMemberFee() + " kr.");
        IO.println("Restance: " + member.getMissingPayments() + " kr.");
    }

    // Viser medlemmets personlige oplysninger
    private void personalInfo() {
        IO.println(member); // (bruger toStrin fra Member)
    }
}
