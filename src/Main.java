void main() {
Delfinen delfinen = new Delfinen();
ConsoleUI consoleUI = new ConsoleUI(delfinen);

Coach coach = new Coach("Træner", 1);
delfinen.getCoachList().add(coach);
ExcerciseMember amalie = new ExcerciseMember("Amalie", 420, LocalDate.of(2000, 03, 16), true);
ExcerciseMember zakarias = new ExcerciseMember("Zakarias", 911, LocalDate.of(2010, 04, 05), true);
CompetitiveMember nicolaj = new CompetitiveMember("Nicolaj", 100, LocalDate.of(2008, 1, 1), true, coach);

delfinen.addMember(amalie);
delfinen.addMember(zakarias);
delfinen.addMember(nicolaj);

coach.addStudent(nicolaj);

consoleUI.run();
}