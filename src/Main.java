void main() {
Delfinen delfinen = new Delfinen();
ConsoleUI consoleUI = new ConsoleUI(delfinen);
Path folder = Path.of("csvFiles");

ExcerciseMember amalie = new ExcerciseMember("Amalie", 420, LocalDate.of(2000, 03, 16), true);
ExcerciseMember zakarias = new ExcerciseMember("Zakarias", 911, LocalDate.of(2010, 04, 05), true);
delfinen.addMember(amalie);
delfinen.addMember(zakarias);

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