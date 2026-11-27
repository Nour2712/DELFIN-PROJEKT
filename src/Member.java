import java.time.LocalDate;
import java.time.Period;

public class Member {
    private final String name;
    private final int id;
    private final LocalDate birthdate;
    private AgeGroup ageGroup;
    private boolean isActive;
    private double missingPayments;

    public Member(String name, int id, LocalDate birthdate, boolean isActive) {
        this.name = name;
        this.id = id;
        this.birthdate = birthdate;
        this.isActive = isActive;

        ageGroup = calculateAgeGroup();
        this.missingPayments = 0;
    }

    public int getId() {
        return id;
    }

    private AgeGroup calculateAgeGroup() {
        LocalDate today = LocalDate.now();
        int age = Period.between(birthdate, today).getYears();

        if (age < 18) return AgeGroup.JUNIOR;
        if (age < 60) return AgeGroup.SENIOR;
        return AgeGroup.SENIOR_PLUS;
    }

    public int calculateMemberFee(){
        int memberFee = 0;

        if (!isActive) {
            return memberFee = 500;
        }
        else if (calculateAgeGroup().equals(AgeGroup.JUNIOR)) {
            return memberFee = 1000;
        }
        else if (calculateAgeGroup().equals(AgeGroup.SENIOR)) {
            return memberFee = 1600;
        }
        else if (calculateAgeGroup().equals(AgeGroup.SENIOR_PLUS)) {
            return memberFee = 1200;
        }
    return memberFee;
    }

    public void addMonthlyFee() {
        double yearlyFee = calculateMemberFee();
        double monthlyFee = yearlyFee / 12;
        missingPayments += monthlyFee;
    }

    public void payFee(double amount) {
        missingPayments -= amount;
    }

    public String getName() {
        return name;
    }

    public double getMissingPayments() {
        return missingPayments;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public boolean getIsActive(){
        return isActive;
    public AgeGroup getAgeGroup() {
        return calculateAgeGroup();
    }

    @Override
    public String toString() {
        String status;
        if (isActive) {
            status = "Aktiv";
        } else {
            status = "Passiv";
        }

        return "Navn: " + name + "\n" +
                "Medlemsnummer: " + id + "\n" +
                "Fødselsdato: " + birthdate + "\n" +
                "Aldersgruppe: " + ageGroup + "\n" +
                "Status: " + status + "\n" +
                "Restance: " + missingPayments + " kr.";
    }


}
