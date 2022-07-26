package id.guusbajoos.util;

import id.guusbajoos.entity.PersonIdentity;
import id.guusbajoos.entity.ResponseEntity;

import java.util.List;

public class GeneralUtility {

    public static final Double ERROR_VALUE = -1.0;
    public static final Double ZERO_KILLING_VALUE = 0.0;
    public static final String ERROR_MISSING_PARAMETER = "REQUEST PARAM IS MISSING";
    public static final String ERROR_NEGATIVE_AGE_PARAMETER = "NEGATIVE NUMBER FOR AGE DETECTED";
    public static final String ERROR_NEGATIVE_YEAR_PARAMETER = "NEGATIVE NUMBER FOR YEAR DETECTED";
    public static final String ERROR_BORN_BEFORE_ZERO_PARAMETER = "THERE ARE VILLAGERS THAT BORN BEFORE THE WITCH TOOK CONTROL THE VILLAGE";
    public static final String WARNING_ZERO_KILLING_PARAMETER = "NO VILLAGER HAS BEEN KILLED YET BY THE WITCH";
    public static final String SUCCESS_PARAMETER = "SUCCESS";

    // this function is intended to get how many died villagers based on inputted integer year
    // REQUIREMENT :
    //   Since the witch is a die hard programmer, she follow a specific rule to decide the number of villagers she should kill each year.
    //   On the 1st year she kills 1 villager
    //   On the 2nd year she kills 1 + 1 = 2 villagers
    //   On the 3rd year she kills 1 + 1 + 2 = 4 villagers
    //   On the 4th year she kills 1 + 1 + 2 + 3 = 7 villagers
    //   On the 5th year she kills 1 + 1 + 2 + 3 + 5 = 12 villagers
    //   And so on...

    // ANALYSIS :
    //   this rule is counted based on fibonacci rules, which died villagers is counted by sum of n-th integer in fibonacci array (assume 0 / first number is not in fibonacci array)
    //   param :
    //     year : inputted integer to represent year which year witch did her nasty work
    //   output :
    //     deadVillagers : how many died villagers based on inputted integer year
    public void countDeadVillagers(PersonIdentity personIdentity) {
        // define some variables that will be used in this function
        Integer deadVillagers = 1;
        Integer tempNum1 = 0, tempNum2 = 1, tempSum = 1;

        // check if year = 0, then no villager has been dead yet (deadVillagers = 0)
        if (personIdentity.getYearOfBorn() == 0) {
            personIdentity.setDiedVillagers(0);
        }
        else if (personIdentity.getYearOfBorn() < 0)
            throw new IllegalArgumentException("Year cannot be less than zero!");
        else {
            // looping this calculation until reach intended year
            for (int x = 1; x < personIdentity.getYearOfBorn(); x++) {
                // get fibonacci number per looping
                tempSum = tempNum1 + tempNum2;
                tempNum1 = tempNum2;
                tempNum2 = tempSum;

                // increase number of deadVillagers by desired fibonacci number as looping continue
                deadVillagers = deadVillagers + tempSum;
                // System.out.println("dead villagers on year " + x + " : " + deadVillagers + " villagers.");
            }
            personIdentity.setDiedVillagers(deadVillagers);
        }
    }

    // this function is intended to get the average number of people the witch killed on year of birth of those people

    // ANALYSIS :
    // first number of dead villagers will be added with second number of dead villagers, and it will be divided by 2 to get average number
    // this average number will be used as magic incantation by villager to make the witch leave the village
    //   param :
    //     firstNum : first inputted integer to represent how many villagers has been killed by the witch
    //     secondNum : second inputted integer to represent how many villagers has been killed by the witch
    //   output :
    //     average number of dead villager from two person
    public Double getAverageNumber(Integer firstNum, Integer secondNum) {

        return (double) (firstNum + secondNum) / 2;
    }

    // ANALYSIS :
    // sum of all dead villagers in list person identity will be divided by how much person are included in this program to get average number
    // this average number will be used as magic incantation by villager to make the witch leave the village
    //   param :
    //     personIdentityList : list of personIdentity
    //   output :
    //     average number of dead villager from how much person are included in this list
    public Double getAverageNumberInList(List<PersonIdentity> personIdentityList) {
        Integer sum = 0;
        for (int x = 0; x < personIdentityList.size(); x++) {
            sum = sum + personIdentityList.get(x).getDiedVillagers();
        }

        return (double) sum / personIdentityList.size();
    }

    // generating success response
    public void generateSuccessMessage(ResponseEntity responseEntity, Double value) {
        responseEntity.setValue(value);
        if (value == ZERO_KILLING_VALUE)
            responseEntity.setMessage(WARNING_ZERO_KILLING_PARAMETER);
        else
            responseEntity.setMessage(SUCCESS_PARAMETER);
    }

    // generating error response
    public void generateErrorMessage(ResponseEntity responseEntity, String error) {
        responseEntity.setValue(ERROR_VALUE);
        responseEntity.setMessage(error);
    }
}
