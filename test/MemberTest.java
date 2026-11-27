import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    //------------------Tester alle udfald af calculateMemberFee()------------------
    @Test
    void testJuniorFee() {
        //tester at et aktivt medlem under 18 år får det rigtige kontingent på 1000kr:
        //Arrange
        Member member = new Member("Test", 1, LocalDate.parse("2016-01-01"), true);

        //Act
        int result = member.calculateMemberFee();

        //Assert
        assertEquals(1000, result);

    }


    @Test
    void testSeniorFee() {
        //tester at et aktivt medlem mellem 18 og 60 år skal betale 1600kr:
        //Arrange
        Member member = new Member("Test", 2, LocalDate.parse("1996-01-01"), true);

        //Act
        int result = member.calculateMemberFee();

        //Assert
        assertEquals(1600, result);
    }



    @Test
    void testSeniorPlusFee() {
        //tester at aktivt medlem over 60 år skal betale 1200k:
        //Arrange
        Member member = new Member("Test", 3, LocalDate.parse("1960-01-01"), true);

        //Act
        int result = member.calculateMemberFee();

        //Assert
        assertEquals(1200, result);
    }


    @Test
    void testPassiveFee() {
        //tester at et passivt medlem skal betale 500kr uanset alder:
        //Arrange
        Member member = new Member("Test", 4, LocalDate.parse("1996-01-01"), false);

        //Act
        int result = member.calculateMemberFee();

        //Assert
        assertEquals(500, result);
    }


    //--------------------------Tester Getters----------------------------
    @Test
    void testGetId() {
        //tester at getId() returnerer det id som medlemmet blev oprettet med:
        //Arrange
        Member member = new Member("Test", 5, LocalDate.parse("1996-01-01"), true);

        //Act
        int result = member.getId();

        //Assert
        assertEquals(5, result);
    }

    @Test
    void testGetName() {
        //tester at getName() returnerer det navn, medlemmet blev oprettet med:
        //Arrange
        Member member = new Member("Anna", 6, LocalDate.parse("1996-01-01"), true);

        //Act
        String result = member.getName();

        //Assert
        assertEquals("Anna", result);
    }


    //--------------------------Tester Restance----------------------------
    @Test
    void testNewMemberHasNoMissingPayments() {
        //tester at et nyt medlem starter med 0kr i restance:
        //Arrange
        Member member = new Member("Test", 7, LocalDate.parse("1996-01-01"), true);

        //Act
        double result = member.getMissingPayments();

        //Assert
        assertEquals(0.0, result);
    }

    @Test
    void testAddMonthlyFee() {
        //tester at restancen stiger med 1/12 af årskontingentet efter en måned:
        //Arrange
        Member member = new Member("Test", 8, LocalDate.parse("2016-01-01"), true);

        //Act
        member.addMonthlyFee();
        double result = member.getMissingPayments();

        //Assert
        assertEquals(1000.0 / 12, result);
    }

    @Test
    void testPayFee() {
        //tester at restancen falder med det beløb medlemmet betaler:
        //Arrange
        Member member = new Member("Test", 9, LocalDate.parse("1996-01-01"), true);

        //Act
        member.payFee(100);
        double result = member.getMissingPayments();

        //Assert
        assertEquals(-100.0, result);
    }

    @Test
    void testAddMonthlyFeeAndPayFee() {
        //tester at restancen er 0kr når medlemmet betaler præcis en måneds kontingent:
        //Arrange
        Member member = new Member("Test", 10, LocalDate.parse("2016-01-01"), true);

        //Act
        member.addMonthlyFee();
        member.payFee(1000.0 / 12);
        double result = member.getMissingPayments();

        //Assert
        assertEquals(0.0, result);
    }
}




