package id.guusbajoos.main;

import id.guusbajoos.entity.PersonIdentity;
import id.guusbajoos.util.GeneralUtility;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApplication {
    // OBJECTIVE :
    //   The villagers are furious with the witch and want to get rid of her and there is one way to get rid of her.
    //   The witch will only leave if there is a brave programmer in the villager who can create a program to solve this problem :
    //   If given two people whose age of death and year of death are known, find the average number of people the witch killed on year of birth of those people
    //   So, if a villager who can create a program to solve the problem, the witch will leave, and the killing will be stopped.
    // RULE :
    //   If you give invalid data (i.e. negative age, person who born before the witch took control) the program should return -1.
    //   Note that year is started since the witch take control of the village.
    // LIMITATION :
    //   person's age must in zero or positive Integer format (number with decimal or negative number will give warning and application will return -1)
    //   person's year of death must in zero or positive Integer format (number with decimal or negative number will give warning and application will return -1)
    //   person's year of born must in zero or positive Integer format (number with decimal or negative number will give warning and application will return -1)
    //   year of born or year of death = 0 means the witch is not yet killing villager
    //   year of born or year of death < 0 means the witch is not yet come to disturb the village, so this rule will be ruled out in this application. application will give warning and return -1

    public static void main(String[] args) {
        // construct new utility class and person object
        GeneralUtility generalUtility = new GeneralUtility();
        PersonIdentity firstPerson = new PersonIdentity();
        PersonIdentity secondPerson = new PersonIdentity();

        // open the scanner to detect user input
        // input : person A age of death and year of death, person B age of death and year of death
        Scanner scanner = new Scanner(System.in);

        try {
            // change approach with OOP method
            System.out.print("Input first person's Age of Death : ");
            // Integer firstPersonAgeOfDeath = scanner.nextInt();
            firstPerson.setAgeOfDeath(scanner.nextInt());

            // validation for first person age of death
            if (firstPerson.getAgeOfDeath() < 0) {
                System.out.println("Can't input negative number for person's age ! Exiting the application...");
                System.out.println("Returned value = -1");
                System.exit(0);
            }

            System.out.print("Input first person's Year of Death : ");
            // Integer firstPersonYearOfDeath = scanner.nextInt();
            firstPerson.setYearOfDeath(scanner.nextInt());

            // validation for first person year of death
            if (firstPerson.getYearOfDeath() < 0) {
                System.out.println("Can't input negative number for death of year ! Exiting the application...");
                System.out.println("Returned value = -1");
                System.exit(0);
            }

            // Integer firstPersonYearOfBorn = firstPersonYearOfDeath - firstPersonAgeOfDeath;
            // Integer diedVillagersFromFirstPerson = generalUtility.countDeadVillagers(firstPersonYearOfBorn);
            firstPerson.setYearOfBorn(firstPerson.getYearOfDeath() - firstPerson.ageOfDeath);
            firstPerson.setDiedVillagers(generalUtility.countDeadVillagers(firstPerson.getYearOfBorn()));

            System.out.print("Input second person's Age of Death : ");
            // Integer secondPersonAgeOfDeath = scanner.nextInt();
            secondPerson.setAgeOfDeath(scanner.nextInt());

            // validation for second person age of death
            if (secondPerson.getAgeOfDeath() < 0) {
                System.out.println("Can't input negative number for age's person ! Exiting the application...");
                System.out.println("Returned value = -1");
                System.exit(0);
            }

            System.out.print("Input second person's Year of Death : ");
            // Integer secondPersonYearOfDeath = scanner.nextInt();
            secondPerson.setYearOfDeath(scanner.nextInt());

            // validation for second person year of death
            if (secondPerson.getYearOfDeath() < 0) {
                System.out.println("Can't input negative number for death of year ! Exiting the application...");
                System.out.println("Returned value = -1");
                System.exit(0);
            }

            // Integer secondPersonYearOfBorn = secondPersonYearOfDeath - secondPersonAgeOfDeath;
            // Integer diedVillagersFromSecondPerson = generalUtility.countDeadVillagers(secondPersonYearOfBorn);
            secondPerson.setYearOfBorn(secondPerson.getYearOfDeath() - secondPerson.ageOfDeath);
            secondPerson.setDiedVillagers(generalUtility.countDeadVillagers(secondPerson.getYearOfBorn()));

            // validation for age of born of first person and second person
            if (firstPerson.getYearOfBorn() < 0) {
                System.out.println("This first person is born on year " + firstPerson.getYearOfBorn());
                System.out.println("This first person is born when the witch is not yet come to disturb the village, so this first person year of death and age of death is assumed invalid. Exiting the application...");
                System.out.println("Returned value = -1");
                System.exit(0);
            }

            if (secondPerson.getYearOfBorn() < 0) {
                System.out.println("This second person is born on year " + secondPerson.getYearOfBorn());
                System.out.println("This second person is born when the witch is not yet come to disturb the village, so this second person year of death and age of death is assumed invalid. Exiting the application...");
                System.out.println("Returned value = -1");
                System.exit(0);
            }

            // System.out.println("First person died on year " + firstPersonYearOfDeath + " in age " + firstPersonAgeOfDeath + " years old. So the first person is born on year " + firstPersonYearOfBorn);
            // System.out.println("On year " + firstPersonYearOfBorn + ", " + diedVillagersFromFirstPerson + " has been killed by witch.");
            // System.out.println("Second person died on year " + secondPersonYearOfDeath + " in age " + secondPersonAgeOfDeath + " years old. So the second person is born on year " + secondPersonYearOfBorn);
            // System.out.println("On year " + secondPersonYearOfBorn + ", " + diedVillagersFromSecondPerson + " has been killed by witch.");

            System.out.println("First person died on year " + firstPerson.getYearOfDeath() + " in age " + firstPerson.getAgeOfDeath() + " years old. So the first person is born on year " + firstPerson.getYearOfBorn());
            System.out.println("On year " + firstPerson.getYearOfBorn() + ", " + firstPerson.getDiedVillagers() + " has been killed by witch.");
            System.out.println("Second person died on year " + secondPerson.getYearOfDeath() + " in age " + secondPerson.getAgeOfDeath() + " years old. So the second person is born on year " + secondPerson.getYearOfBorn());
            System.out.println("On year " + secondPerson.getYearOfBorn() + ", " + secondPerson.getDiedVillagers() + " has been killed by witch.");

            // find the average number of people the witch killed on year of birth of those people
            Double averageNum = generalUtility.getAverageNumber(firstPerson.getDiedVillagers(), secondPerson.getDiedVillagers());
            if (averageNum == 0.0) {
                System.out.println("Since first person and second person both born in year 0, no villager has been killed yet by the witch.");
            } else
                System.out.println("Average number as magic incantation to make the witch leave = " + averageNum);

            System.out.println("Returned value = " + averageNum);
        } catch (InputMismatchException ime) {
            System.out.println("Invalid input !");
            System.out.println("Returned value = -1");
        }
    }
}
