import java.time.LocalDate;
import java.time.Period;

public class Member {
    private final String name;
    private final int id;
    private final LocalDate birthdate;
    AgeGroup ageGroup;
    boolean isActive;

    public Member(String name, int id, LocalDate birthdate, boolean isActive) {
        this.name = name;
        this.id = id;
        this.birthdate = birthdate;
        this.isActive = isActive;

        ageGroup = calculateAgeGroup();
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

    private int calculateMemberFee(AgeGroup ageGroup){
        int memberFee = 0;
        this.ageGroup = null;
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

}
