import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class CoachConsoleUI implements Menu {

    private Delfinen delfinen;
    private Coach coach;

    public CoachConsoleUI(Delfinen delfinen, int coachID) {
        this.delfinen = delfinen;

        for (Coach coach1 : delfinen.getCoachList()) {
            if (coach1.getId() == coachID) {
                this.coach = coach1;
            }
        }
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
                    boolean showLeaderboardMenu = true;
                    while (showLeaderboardMenu) {
                        String leaderboardOption = IO.readln(showLeaderboardMenu());
                        switch (leaderboardOption) {

                            // Se leaderboard
                            case "1" -> findLeaderboard();

                            // Tilføj ny tid til leaderboard
                            case "2" -> addSwimResult();

                            case "0" -> showLeaderboardMenu = false;

                            default -> {}
                        }
                    }
                }

                // Elev menu
                case "2" -> {
                    boolean showStudentMenu = true;
                    while (showStudentMenu) {
                        IO.println("");
                        String studentOption = IO.readln(showStudentMenu());

                        switch (studentOption) {

                            // Se elever
                            case "1" -> showStudents();

                            // Tilføj ny elev
                            case "2" -> addStudent();

                            // Fjern elev
                            case "3" -> removeStudent();

                            case "0" -> showStudentMenu = false;

                            default -> {}

                        }
                    }
                }

                // Konkurrencer
                case "3" -> {
                    boolean showCompetitionMenu = true;
                    while (showCompetitionMenu) {
                        IO.println("");
                        String competitionOption = IO.readln(showCompetitionMenu());

                        switch (competitionOption) {

                            // Vis alle konkurencer
                            case "1" -> showCompetitions();

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
                                            case "1" -> delfinen.getPlacementList(competition.getCompetitionName());

                                            // Tilføj en tid fra et medlem af Delfinen
                                            case "2" -> addStudentSwimResult(competition.getCompetitionName());

                                            // Tilføj en tid fra et ikke-medlem af Delfinen
                                            case "3" -> addNonStudentSwimResult(competition.getCompetitionName());

                                            case "0" -> showSpecificCompetitionMenu = false;

                                            default -> {}

                                        }
                                    }
                                }
                            }

                            // Opret ny konkurence
                            case "3" -> createCompetition();

                            case "0" -> showCompetitionMenu = false;

                            default -> {}
                        }
                    }
                }
                case "0" -> running = false;

                default -> {}
            }
        }
    }

    private String showMenu() {
        return "1: Se leaderboards \n" +
                "2: Se elever \n" +
                "3: Konkurencer \n" +
                "0: Afslut \n";
    }

    // --------------------------------------------------
    // Leaderboard
    // --------------------------------------------------

    private String showLeaderboardMenu() {
        return "1: Vis leaderboard \n" +
                "2: Tilføj ny tid \n" +
                "0: Gå tilbage \n";
    }

    private void findLeaderboard() {
        String disciplineStr = IO.readln("Hvilken disciplin?");
        Discipline discipline = Discipline.parse(disciplineStr);

        String ageGroupStr = IO.readln("Hvilken aldersgruppe?");
        AgeGroup ageGroup = AgeGroup.parse(ageGroupStr);

        IO.println(delfinen.findLeaderboard(discipline, ageGroup));
    }

    private void addSwimResult() {
        String memberIdStr = IO.readln("Indtast member ID");
        int memberID = Integer.parseInt(memberIdStr);

        String durationStr = IO.readln("Indtast elevens resultat i sekunder");
        Duration duration = Duration.parse(durationStr);

        String disciplineStr = IO.readln("Hvilken disciplin?");
        Discipline discipline = Discipline.parse(disciplineStr);

        String ageGroupStr = IO.readln("Hvilken aldersgruppe?");
        AgeGroup ageGroup = AgeGroup.parse(ageGroupStr);

        SwimResult swimResult = new SwimResult(memberID, discipline, duration, LocalDate.now());

        delfinen.addSwimResult(ageGroup, discipline, swimResult);
    }

    // --------------------------------------------------
    // Students
    // --------------------------------------------------

    private String showStudentMenu() {
        return "1: Vis elever \n" +
                "2: Tilføj elev \n" +
                "3: Fjern elev \n" +
                "0: Gå tilbage \n";
    }

    private void showStudents() {
        for (CompetitiveMember cm : coach.getStudents()) {
            IO.println(cm.getName() + ": " + cm.getId());
        }
    }

    private void addStudent() {
        String memberIDStr = IO.readln("Indtast member ID: ");
        int memberID = Integer.parseInt(memberIDStr);
        for (Member member : delfinen.getMemberList()) {
            if (member.getId() == memberID) {
                if (member instanceof CompetitiveMember) {
                    coach.addStudent((CompetitiveMember) member);
                } else IO.println("Medlemmet er ikke en konkurencesvømmer");
            }
        }
    }

    private void removeStudent() {
        String memberIDStr = IO.readln("Indtast member ID: ");
        int memberID = Integer.parseInt(memberIDStr);
        for (Member member : coach.getStudents()) {
            if (member.getId() == memberID) {
                coach.addStudent((CompetitiveMember) member);
                IO.println("Elev tilføjet");
            }
        }
    }

    // --------------------------------------------------
    // Competitions
    // --------------------------------------------------

    private String showCompetitionMenu() {
        return  "1: Vis konkurencer \n" +
                "2: Vælg konkurence \n" +
                "3: Opret konkurence \n" +
                "0: Gå tilbage \n";
    }

    private void showCompetitions() {
        for (Competition competition : delfinen.getCompetitionList()) {
            IO.println(competition.getCompetitionName());
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
                "0: Gå tilbage \n";
    }

    private void addStudentSwimResult(String competitionName) {
        String memberIDStr = IO.readln("Indtast member ID: ");
        int memberID = Integer.parseInt(memberIDStr);

        String durationStr = IO.readln("Indtast elevens resultat i sekunder: ");
        Duration duration = Duration.parse(durationStr);

        for (Member member : delfinen.getMemberList()) {
            if (member.getId() == memberID) {
                delfinen.addStudentSwimResult(competitionName, memberID, duration);
            }
        }
    }

    private void addNonStudentSwimResult(String competitionName) {
        String durationStr = IO.readln("Indtast elevens resultat i sekunder: ");
        Duration duration = Duration.parse(durationStr);
        delfinen.addNoneStudentSwimResult(competitionName, duration);
    }

    private void createCompetition() {
        String competitionName = IO.readln("Hvad skal konkurencen hedde: ");

        String disciplineStr = IO.readln("Hvilken disciplin: ");
        Discipline discipline = Discipline.parse(disciplineStr);


        // ------
        boolean invalidDateFormat = true;
        LocalDate localDate = null;
        while (invalidDateFormat) {
            String localDateStr = IO.readln("hvilken dato finder konkurencen sted. \n" +
                    "Skriv i dette format 'XXXX-XX-XX' (årstal, måned, dag): ");
            try {
                localDate = LocalDate.parse(localDateStr);

                invalidDateFormat = false;
            } catch (DateTimeParseException dtpe) {
                IO.println("forkert dato format. Prøv igen");
            }
        }
        // ------

        delfinen.createCompetition(competitionName, discipline, localDate);
    }

    // --------------------------------------------------
    // Personal information
    // --------------------------------------------------

    private void personalInfo() {

    }
}
