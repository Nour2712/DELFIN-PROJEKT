public class MemberMenu implements Menu{
    Menu run;
    Delfinen delfinen;
    int member;

    public MemberMenu(Delfinen delfinen, Member member, Menu run){
        this.delfinen = delfinen;
        this.member = member.getId();
        this.run = run;
    }

    public void run() {
        run();
    }

}
