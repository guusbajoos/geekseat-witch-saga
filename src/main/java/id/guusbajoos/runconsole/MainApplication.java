package id.guusbajoos.runconsole;

import id.guusbajoos.entity.PersonIdentity;
import id.guusbajoos.util.GeneralUtility;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
        // construct new utility class and list person object
        GeneralUtility generalUtility = new GeneralUtility();
        List<PersonIdentity> listPerson = new ArrayList<PersonIdentity>();

        // open the scanner to detect user input
        // input : how many person are included in this program, and data of every person age of death and year of death
        Scanner scanner = new Scanner(System.in);

        try {
            // add flexible number of person
            System.out.print("Input how many person/villagers you want to be included in this program : ");
            Integer countPerson = scanner.nextInt();

            // validation for number of person
            if (countPerson < 0) {
                System.out.println("Can't input negative number for number of person ! Exiting the application...");
                System.out.println("Returned value = -1");
                System.exit(0);
            } else if (countPerson < 1) {
                System.out.println("Minimal one person is needed to be included in this program ! Exiting the application...");
                System.out.println("Returned value = -1");
                System.exit(0);
            }

            // looping process for countPerson times
            for (int x = 1; x < countPerson + 1; x++) {
                PersonIdentity personIdentity = new PersonIdentity();
                System.out.print("Input Age of Death of Person #" + x + " : ");
                personIdentity.setAgeOfDeath(scanner.nextInt());

                // validation for n-th person age of death
                if (personIdentity.getAgeOfDeath() < 0) {
                    System.out.println("Can't input negative number for person's age ! Exiting the application...");
                    System.out.println("Returned value = -1");
                    System.exit(0);
                }

                System.out.print("Input Age of Death of Person #" + x + " : ");
                personIdentity.setYearOfDeath(scanner.nextInt());

                // validation for n-th person year of death
                if (personIdentity.getYearOfDeath() < 0) {
                    System.out.println("Can't input negative number for death of year ! Exiting the application...");
                    System.out.println("Returned value = -1");
                    System.exit(0);
                }

                // get year of born and died villagers baes on person's year of death and age of death
                personIdentity.setYearOfBorn(personIdentity.getYearOfDeath() - personIdentity.ageOfDeath);
                generalUtility.countDeadVillagers(personIdentity);

                System.out.println("Person #" + x + " died on year " + personIdentity.getYearOfDeath() + " in age " + personIdentity.getAgeOfDeath() + " years old. So the person #" + x + " is born on year " + personIdentity.getYearOfBorn());
                System.out.println("On year " + personIdentity.getYearOfBorn() + ", " + personIdentity.getDiedVillagers() + " has been killed by witch.");

                // add single person identity data into list
                listPerson.add(personIdentity);
            }

            // find the average number of people the witch killed on year of birth of those people
            Double averageNum = generalUtility.getAverageNumberInList(listPerson);
            if (averageNum == 0.0) {
                System.out.println("Since all persons born in year 0, no villager has been killed yet by the witch.");
            } else
                System.out.println("Average number as magic incantation to make the witch leave = " + averageNum);

            System.out.println("Returned value = " + averageNum);
        } catch (InputMismatchException ime) {
            System.out.println("Invalid input !");
            System.out.println("Returned value = -1");
        }
    }
}
