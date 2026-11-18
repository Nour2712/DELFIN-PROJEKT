void main() {
Delfinen delfinen = new Delfinen();
ConsoleUI consoleUI = new ConsoleUI(delfinen);

ExcerciseMember amalie = new ExcerciseMember("Amalie", 420, LocalDate.of(2000, 03, 16), true);
ExcerciseMember zakarias = new ExcerciseMember("Zakarias", 911, LocalDate.of(2010, 04, 05), true);
delfinen.addMember(amalie);
delfinen.addMember(zakarias);

consoleUI.run();
}