package id.guusbajoos.util;

public class GeneralUtility {

    // this function is intended to get how many died villagers based on inputted integer year
    // REQUIREMENT :
    //   Since the witch is a die hard programmer, she follow a specific rule to decide the number of villagers she should kill each year.
    //   On the 1st year she kills 1 villager
    //   On the 2nd year she kills 1 + 1 = 2 villagers
    //   On the 3rd year she kills 1 + 1 + 2 = 4 villagers
    //   On the 4th year she kills 1 + 1 + 2 + 3 = 7 villagers
    //   On the 5th year she kills 1 + 1 + 2 + 3 + 5 = 12 villagers
    //   And so on...
    //
    // ANALYSIS :
    //   this rule is counted based on fibonacci rules, which died villagers is counted by sum of n-th integer in fibonacci array (assume 0 / first number is not in fibonacci array)
    public Integer countDeadVillagers(Integer year) {
        Integer deadVillagers = 1;
        Integer tempNum1 = 0, tempNum2 = 1, tempSum = 1;

        for (int x = 1; x < year; x++) {
            tempSum = tempNum1 + tempNum2;
            tempNum1 = tempNum2;
            tempNum2 = tempSum;

            deadVillagers = deadVillagers + tempSum;
            System.out.println("dead villagers on year " + x + " : " + deadVillagers + " villagers.");
        }

        return deadVillagers;
    }
}
