public class CashierMenu implements Menu{
    Menu run;
    Delfinen delfinen;
    int cashierId;


    public CashierMenu(Delfinen delfinen, int cashierId, Menu run) {
        this.delfinen = delfinen;
        this.cashierId = cashierId;
        this.run = run;
    }

    public void run() {
        run();
    }
}
