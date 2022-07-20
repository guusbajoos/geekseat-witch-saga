package id.guusbajoos.test;

import id.guusbajoos.util.GeneralUtility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class GeneralUtilityTest {

    GeneralUtility generalUtility = new GeneralUtility();

    @Test
    @DisplayName("Count number of dead villager if year > 0")
    void countDeadVillagersIfYearMoreThanZero() {
        assertEquals(1, generalUtility.countDeadVillagers(1));
        assertEquals(2, generalUtility.countDeadVillagers(2));
        assertEquals(4, generalUtility.countDeadVillagers(3));
        assertEquals(7, generalUtility.countDeadVillagers(4));
        assertEquals(12, generalUtility.countDeadVillagers(5));
    }

    @Test
    @DisplayName("Count number of dead villager if year = 0")
    void countDeadVillagersIfYearEqualZero() {
        assertEquals(0, generalUtility.countDeadVillagers(0));
    }

    @Test
    @DisplayName("Count number of dead villager if year < 0")
    void countDeadVillagersIfYearLessThanZero() {
        assertThrows(IllegalArgumentException.class, () -> generalUtility.countDeadVillagers(-1));
    }


    @Test
    @DisplayName("Get average number between two numbers")
    void getAverageNumber() {
        assertEquals(0, generalUtility.getAverageNumber(0, 0));
        assertEquals(0.5, generalUtility.getAverageNumber(0, 1));
        assertEquals(2.5, generalUtility.getAverageNumber(1, 4));
        assertEquals(4, generalUtility.getAverageNumber(1, 7));
        assertEquals(4.5, generalUtility.getAverageNumber(2, 7));
        assertEquals(5.5, generalUtility.getAverageNumber(4, 7));
    }
}