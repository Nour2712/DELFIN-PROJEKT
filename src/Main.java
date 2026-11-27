void main() {
Delfinen delfinen = new Delfinen();
ConsoleUI consoleUI = new ConsoleUI(delfinen);
Path folder = Path.of("csvFiles");

Coach coach = new Coach("Coach Daniels", 1);
delfinen.getCoachList().add(coach);
ExcerciseMember amalie = new ExcerciseMember("Amalie", 420, LocalDate.of(2000, 3, 16), true);
ExcerciseMember zakarias = new ExcerciseMember("Zakarias", 911, LocalDate.of(2010, 4, 5), true);
CompetitiveMember nicolaj = new CompetitiveMember("Nicolaj", 69, LocalDate.of(2008, 1, 1), true, 1);
CompetitiveMember nour = new CompetitiveMember("Nour", 67, LocalDate.of(1872, 12, 27), true, 1);

delfinen.addMember(amalie);
delfinen.addMember(zakarias);
delfinen.addMember(nicolaj);
delfinen.addMember(nour);

coach.addStudent(nicolaj);
coach.addStudent(nour);
    try {
        CsvSaver saver = new CsvSaver(folder);
        saver.saveMember(delfinen.getMemberList());
        saver.saveCoach(delfinen.getCoachList());

        System.out.println("Medlemmer og trænere er gemt i mappen: csvFiles");
    } catch (IOException e) {
        System.err.println("Fejl ved gemning: " + e.getMessage());
    }

consoleUI.run();
}