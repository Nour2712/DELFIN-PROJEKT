import java.time.Duration;
import java.time.LocalDate;

public class CoachConsoleUI implements Menu {

    private Delfinen delfinen;
    private int coachID;

    public CoachConsoleUI(Delfinen delfinen, int coachID) {
        this.delfinen = delfinen;
        this.coachID = coachID;
    }

    @Override
    public void run() {
        boolean running = true;
        IO.println("Velkommen Træner");

        while (running) {
            IO.println("");
            String option = IO.readln(showMenu());

            switch (option) {

                // Se leaderboards
                case "1" -> {

                }

                // Se elever
                case "2" -> {

                }

                // Konkurrencer
                case "3" -> {
                    boolean showCompetitionMenu = true;
                    while (showCompetitionMenu) {
                        IO.println("");
                        String competitionOption = IO.readln(showCompetitionMenu());

                        switch (competitionOption) {

                            // Vis alle konkurencer
                            case "1" -> {
                                showCompetitions();
                            }

                            // Vælg en specifik konkurence
                            case "2" -> {
                                Competition competition = findCompetition();
                                if (competition != null) {

                                    boolean showSpecificCompetitionMenu = true;
                                    while (showSpecificCompetitionMenu) {
                                        IO.println("");
                                        String specificCompetitionMenu = IO.readln(showSpecificCompetitionMenu());

                                        switch (specificCompetitionMenu) {

                                            // Få ranglisten fra konkurencen
                                            case "1" -> {
                                                delfinen.getPlacementList(competition.getCompetitionName());
                                            }

                                            // Tilføj en tid fra et medlem af Delfinen
                                            case "2" -> {
                                                addStudentSwimResult(competition.getCompetitionName());
                                            }

                                            // Tilføj en tid fra et ikke-medlem af Delfinen
                                            case "3" -> {
                                                addNonStudentSwimResult(competition.getCompetitionName());
                                            }

                                            default -> showSpecificCompetitionMenu = false;

                                        }
                                    }
                                }
                            }

                            // Opret ny konkurence
                            case "3" -> {
                                createCompetition();
                            }

                            default -> {
                                showCompetitionMenu = false;
                            }
                        }
                    }
                }
                case "0" -> {

                }
            }
        }
    }

    private String showMenu() {
        return  "1: Se leaderboards \n" +
                "2: Se elever \n" +
                "3: Konkurencer \n" +
                "0: Afslut \n";
    }

    // --------------------------------------------------
    // Leaderboard
    // --------------------------------------------------

    private void leaderboards() {

    }

    // --------------------------------------------------
    // Students
    // --------------------------------------------------

    private void students() {

    }

    // --------------------------------------------------
    // Competitions
    // --------------------------------------------------

    private String showCompetitionMenu() {
        return  "1: Vis konkurencer \n" +
                "2: Vælg konkurence \n" +
                "3: Opret konkurence \n" +
                "0: Afslut \n";
    }

    private void showCompetitions() {
        for (Competition competition : delfinen.getCompetitionList()) {
            IO.println(competition);
        }
    }

    private Competition findCompetition() {
        String competitionName = IO.readln("Konkurencens navn: ");
        Competition competition = null;
        for (Competition comp : delfinen.getCompetitionList()) {
            if (comp.getCompetitionName().equals(competitionName)) {
                competition = comp;
            }
        }
        return competition;
    }

    private String showSpecificCompetitionMenu() {
        return  "1: Vis leaderboard fra konkurencen \n" +
                "2: tilføj elev resultat til konkurencen \n" +
                "3: tilføj ikke-elev resultat til konkurencen \n" +
                "0: Afslut \n";
    }

    private void addStudentSwimResult(String competitionName) {
        String memberIDStr = IO.readln("Indtast member ID: ");
        int memberID = Integer.parseInt(memberIDStr);

        String durationStr = IO.readln("Indtast elevens resultat i skunder: ");
        Duration duration = Duration.parse(durationStr);

        for (Member member : delfinen.getMemberList()) {
            if (member.getId() == memberID) {
                delfinen.addStudentSwimResult(competitionName, memberID, duration);
            }
        }
    }

    private void addNonStudentSwimResult(String competitionName) {
        String durationStr = IO.readln("Indtast elevens resultat i skunder: ");
        Duration duration = Duration.parse(durationStr);
        delfinen.addNoneStudentSwimResult(competitionName, duration);
    }

    private void createCompetition() {
        String competitionName = IO.readln("Hvad skal konkurencen hedde: ");

        String disciplineStr = IO.readln("Hvilken disciplin: ");
        Discipline discipline = Discipline.parse(disciplineStr);

        String localDateStr = IO.readln("hvilken dato finder konkurencen sted. \n" +
                "Skriv i dette format 'XXXX-XX-XX' (årstal, måned, dag): ");
        LocalDate localDate = LocalDate.parse(localDateStr);

        delfinen.createCompetition(competitionName, discipline, localDate);
    }

    // --------------------------------------------------
    // Personal information
    // --------------------------------------------------

    private void personalInfo() {

    }
}
