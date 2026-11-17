public class MemberConsoleUI implements Menu{
    Menu run;
    Delfinen delfinen;
    int member;

    public MemberConsoleUI(Delfinen delfinen, Member member, Menu run){
        this.delfinen = delfinen;
        this.member = member.getId();
        this.run = run;
    }

    @Override
    public void run() {

    }

    private void showMenu() {

    }

    // --------------------------------------------------
    // Member options
    // --------------------------------------------------

    private void competitions() {

    }

    private void stats() {

    }

    private void coach() {

    }

    private void subscription() {

    }

    private void personalInfo() {

    }
}
