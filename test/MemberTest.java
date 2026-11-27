import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    void testJuniorFee(){

        //Arrange
        Member member = new Member("Test", 1, LocalDate.parse("2016-01-01"), true);

        //Act
        int result = member.calculateMemberFee();

        //Assert
        assertEquals(1000, result);

    }
}