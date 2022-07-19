package id.guusbajoos.main;

import id.guusbajoos.util.GeneralUtility;

import java.util.Scanner;

public class MainApplication {
    // PROBLEM :
    //   The witch will only leave if there is a brave programmer in the villager who can create a program to solve this problem :
    //   If given two people whose age of death and year of death are known, find the average number of people the witch killed on year of birth of those people

    public static final String EXIT_COMMAND = "exit";


    public static void main(String[] args) {
        // construct new utility class
        GeneralUtility generalUtility = new GeneralUtility();

        // open the scanner to detect user input
        // input : person A age of death and year of death, person B age of death and year of death
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input first person's Age of Death : ");
        Integer firstPersonAgeOfDeath = scanner.nextInt();
        System.out.print("Input first person's Year of Death : ");
        Integer firstPersonYearOfDeath = scanner.nextInt();
        Integer firstPersonYearOfBorn = firstPersonYearOfDeath - firstPersonAgeOfDeath;
        Integer diedVillagersFromFirstPerson = generalUtility.countDeadVillagers(firstPersonYearOfBorn);

        System.out.print("Input second person's Age of Death : ");
        Integer secondPersonAgeOfDeath = scanner.nextInt();
        System.out.print("Input second person's Year of Death : ");
        Integer secondPersonYearOfDeath = scanner.nextInt();
        Integer secondPersonYearOfBorn = secondPersonYearOfDeath - secondPersonAgeOfDeath;
        Integer diedVillagersFromSecondPerson = generalUtility.countDeadVillagers(secondPersonYearOfBorn);

        System.out.println("First person died on year " + firstPersonYearOfDeath + " in age " + firstPersonAgeOfDeath + " years old. So the first person is born on year " + firstPersonYearOfBorn);
        System.out.println("On year " + firstPersonYearOfBorn + ", " + diedVillagersFromFirstPerson + " has been killed by witch.");
        System.out.println("Second person died on year " + secondPersonYearOfDeath + " in age " + secondPersonAgeOfDeath + " years old. So the second person is born on year " + secondPersonYearOfBorn);
        System.out.println("On year " + secondPersonYearOfBorn + ", " + diedVillagersFromSecondPerson + " has been killed by witch.");

        // find the average number of people the witch killed on year of birth of those people
        System.out.println("Average number as magic incantation to make the witch leave = " + generalUtility.getAverageNumber(diedVillagersFromFirstPerson, diedVillagersFromSecondPerson));
    }
}
