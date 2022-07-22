package id.guusbajoos.test;

import id.guusbajoos.entity.PersonIdentity;
import id.guusbajoos.util.GeneralUtility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class GeneralUtilityTest {

    GeneralUtility generalUtility = new GeneralUtility();
    PersonIdentity personIdentity = new PersonIdentity();

    @Test
    @DisplayName("Count number of dead villager if year > 0")
    void countDeadVillagersIfYearMoreThanZero() {
        personIdentity.setYearOfBorn(1);
        generalUtility.countDeadVillagers(personIdentity);
        assertEquals(1, personIdentity.getDiedVillagers());
        personIdentity.setYearOfBorn(2);
        generalUtility.countDeadVillagers(personIdentity);
        assertEquals(2, personIdentity.getDiedVillagers());
        personIdentity.setYearOfBorn(3);
        generalUtility.countDeadVillagers(personIdentity);
        assertEquals(4, personIdentity.getDiedVillagers());
        personIdentity.setYearOfBorn(4);
        generalUtility.countDeadVillagers(personIdentity);
        assertEquals(7, personIdentity.getDiedVillagers());
        personIdentity.setYearOfBorn(5);
        generalUtility.countDeadVillagers(personIdentity);
        assertEquals(12, personIdentity.getDiedVillagers());
    }

    @Test
    @DisplayName("Count number of dead villager if year = 0")
    void countDeadVillagersIfYearEqualZero() {
        personIdentity.setYearOfBorn(0);
        generalUtility.countDeadVillagers(personIdentity);
        assertEquals(0, personIdentity.getDiedVillagers());
    }

    @Test
    @DisplayName("Count number of dead villager if year < 0")
    void countDeadVillagersIfYearLessThanZero() {
        personIdentity.setYearOfBorn(-1);
        assertThrows(IllegalArgumentException.class, () -> generalUtility.countDeadVillagers(personIdentity));
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