package id.guusbajoos.main;

import id.guusbajoos.entity.PersonIdentity;
import id.guusbajoos.util.GeneralUtility;

import java.util.Scanner;

public class MainApplication {
    // PROBLEM :
    //   The witch will only leave if there is a brave programmer in the villager who can create a program to solve this problem :
    //   If given two people whose age of death and year of death are known, find the average number of people the witch killed on year of birth of those people

    public static void main(String[] args) {
        // construct new utility class and person object
        GeneralUtility generalUtility = new GeneralUtility();
        PersonIdentity firstPerson = new PersonIdentity();
        PersonIdentity secondPerson = new PersonIdentity();

        // open the scanner to detect user input
        // input : person A age of death and year of death, person B age of death and year of death
        Scanner scanner = new Scanner(System.in);

        // change approach with OOP method
        System.out.print("Input first person's Age of Death : ");
        // Integer firstPersonAgeOfDeath = scanner.nextInt();
        firstPerson.setAgeOfDeath(scanner.nextInt());

        System.out.print("Input first person's Year of Death : ");
        // Integer firstPersonYearOfDeath = scanner.nextInt();
        firstPerson.setYearOfDeath(scanner.nextInt());

        // Integer firstPersonYearOfBorn = firstPersonYearOfDeath - firstPersonAgeOfDeath;
        // Integer diedVillagersFromFirstPerson = generalUtility.countDeadVillagers(firstPersonYearOfBorn);
        firstPerson.setYearOfBorn(firstPerson.getYearOfDeath() - firstPerson.ageOfDeath);
        firstPerson.setDiedVillagers(generalUtility.countDeadVillagers(firstPerson.getYearOfBorn()));

        System.out.print("Input second person's Age of Death : ");
        // Integer secondPersonAgeOfDeath = scanner.nextInt();
        secondPerson.setAgeOfDeath(scanner.nextInt());
        System.out.print("Input second person's Year of Death : ");
        // Integer secondPersonYearOfDeath = scanner.nextInt();
        secondPerson.setYearOfDeath(scanner.nextInt());

        // Integer secondPersonYearOfBorn = secondPersonYearOfDeath - secondPersonAgeOfDeath;
        // Integer diedVillagersFromSecondPerson = generalUtility.countDeadVillagers(secondPersonYearOfBorn);
        secondPerson.setYearOfBorn(secondPerson.getYearOfDeath() - secondPerson.ageOfDeath);
        secondPerson.setDiedVillagers(generalUtility.countDeadVillagers(secondPerson.getYearOfBorn()));

        // System.out.println("First person died on year " + firstPersonYearOfDeath + " in age " + firstPersonAgeOfDeath + " years old. So the first person is born on year " + firstPersonYearOfBorn);
        // System.out.println("On year " + firstPersonYearOfBorn + ", " + diedVillagersFromFirstPerson + " has been killed by witch.");
        // System.out.println("Second person died on year " + secondPersonYearOfDeath + " in age " + secondPersonAgeOfDeath + " years old. So the second person is born on year " + secondPersonYearOfBorn);
        // System.out.println("On year " + secondPersonYearOfBorn + ", " + diedVillagersFromSecondPerson + " has been killed by witch.");

        System.out.println("First person died on year " + firstPerson.getYearOfDeath() + " in age " + firstPerson.getAgeOfDeath() + " years old. So the first person is born on year " + firstPerson.getYearOfBorn());
        System.out.println("On year " + firstPerson.getYearOfBorn() + ", " + firstPerson.getDiedVillagers() + " has been killed by witch.");
        System.out.println("Second person died on year " + secondPerson.getYearOfDeath() + " in age " + secondPerson.getAgeOfDeath() + " years old. So the second person is born on year " + secondPerson.getYearOfBorn());
        System.out.println("On year " + secondPerson.getYearOfBorn() + ", " + secondPerson.getDiedVillagers() + " has been killed by witch.");

        // find the average number of people the witch killed on year of birth of those people
        System.out.println("Average number as magic incantation to make the witch leave = " + generalUtility.getAverageNumber(firstPerson.getDiedVillagers(), secondPerson.getDiedVillagers()));
    }
}
