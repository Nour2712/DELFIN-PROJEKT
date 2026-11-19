import java.time.Duration;
import java.time.LocalDate;

public class CoachConsoleUI implements Menu{

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
                case "1" -> {

                }

                case "2" -> {

                }

                case "3" -> {
                    boolean showCompetitionMenu = true;
                    while (showCompetitionMenu) {
                        IO.println("");
                        String competitionOption = IO.readln(showCompetitionMenu());

                        switch (competitionOption) {
                            case "1" -> {
                                showCompetitions();
                            }

                            case "2" -> {
                                String competitionName = IO.readln("Konkurencens navn: ");
                                Competition competition = null;
                                for (Competition comp : delfinen.getCompetitionList()) {
                                    if (comp.getCompetitionName().equals(competitionName)) {
                                        competition = comp;
                                    }
                                }
                                if (competition != null) {

                                    boolean showSpecificCompetitionMenu = true;
                                    while (showSpecificCompetitionMenu) {
                                        String specificCompetitionMenu = IO.readln(showSpecificCompetitionMenu());

                                        switch (specificCompetitionMenu) {
                                            case "1" -> {
                                                delfinen.getPlacementList(competitionName);
                                            }

                                            case "2" -> {
                                                String memberIDStr = IO.readln("Indtast member ID: ");
                                                int memberID = Integer.parseInt(memberIDStr);

                                                String durationStr = IO.readln("indtast elevens resultat i skunder: ");
                                                Duration duration = Duration.parse(durationStr);

                                                for (Member member : delfinen.getMemberList()) {
                                                    if (member.getId() == memberID) {
                                                        delfinen.addStudentSwimResult(competitionName, memberID, duration);
                                                    }
                                                }
                                            }

                                            case "3" -> {
                                                String durationStr = IO.readln("indtast elevens resultat i skunder: ");
                                                Duration duration = Duration.parse(durationStr);
                                                delfinen.addNoneStudentSwimResult(competitionName, duration);
                                            }

                                            default -> showSpecificCompetitionMenu = false;

                                        }
                                    }
                                }
                            }

                            case "3" -> {
                                String competitionName = IO.readln("Hvad skal konkurencen hedde: ");

                                String disciplineStr = IO.readln("Hvilken disciplin: ");
                                Discipline discipline = Discipline.parse(disciplineStr);

                                String localDateStr = IO.readln("hvilken dato finder konkurencen sted. \n" +
                                        "Skriv i dette format 'XXXX-XX-XX' (årstal, måned, dag): ");
                                LocalDate localDate = LocalDate.parse(localDateStr);

                                delfinen.createCompetition(competitionName, discipline, localDate);
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
    // Coach options
    // --------------------------------------------------

    private void leaderboards() {

    }

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

    private String showSpecificCompetitionMenu() {
        return  "1: Vis leaderboard fra konkurencen \n" +
                "2: tilføj elev resultat til konkurencen \n" +
                "3: tilføj ikke-elev resultat til konkurencen \n" +
                "0: Afslut \n";
    }

    private void showCompetitions() {
        for (Competition competition : delfinen.getCompetitionList()) {
            IO.println(competition);
        }
    }

    private void competitions() {

    }

    private void personalInfo() {

    }
}
