package id.guusbajoos.controller;

import id.guusbajoos.entity.PersonIdentity;
import id.guusbajoos.entity.RequestEntity;
import id.guusbajoos.entity.ResponseEntity;
import id.guusbajoos.util.GeneralUtility;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class WitchSagaController {

    // construct new utility class and list person object
    GeneralUtility generalUtility = new GeneralUtility();

    @PostMapping("/main")
    public ResponseEntity process(
            @RequestBody RequestEntity requestEntity
    ) throws Exception {
        ResponseEntity responseEntity = new ResponseEntity();

        try {
            if (requestEntity == null) {
                generalUtility.generateErrorMessage(responseEntity, GeneralUtility.ERROR_MISSING_PARAMETER);
            } else {
                // ObjectMapper mapper = new ObjectMapper();
                // System.out.println("mapper = " + mapper.writeValueAsString(requestEntity));

                List<PersonIdentity> personIdentity = requestEntity.getPersonIdentity();
                for (int x = 1; x < requestEntity.getPersonIdentity().size() + 1; x++) {
                    PersonIdentity singlePersonIdentity = personIdentity.get(x-1);
                    if (singlePersonIdentity.getAgeOfDeath() < 0) {
                        generalUtility.generateErrorMessage(responseEntity, GeneralUtility.ERROR_NEGATIVE_AGE_PARAMETER);
                        return responseEntity;
                    }

                    if (singlePersonIdentity.getYearOfDeath() < 0) {
                        generalUtility.generateErrorMessage(responseEntity, GeneralUtility.ERROR_NEGATIVE_YEAR_PARAMETER);
                        return responseEntity;
                    }

                    // get year of born and died villagers baes on person's year of death and age of death
                    singlePersonIdentity.setYearOfBorn(singlePersonIdentity.getYearOfDeath() - singlePersonIdentity.ageOfDeath);
                    generalUtility.countDeadVillagers(singlePersonIdentity);

                    // System.out.println("Person #" + x + " died on year " + singlePersonIdentity.getYearOfDeath() + " in age " + singlePersonIdentity.getAgeOfDeath() + " years old. So the person #" + x + " is born on year " + singlePersonIdentity.getYearOfBorn());
                    // System.out.println("On year " + singlePersonIdentity.getYearOfBorn() + ", " + singlePersonIdentity.getDiedVillagers() + " has been killed by witch.");
                }

                // find the average number of people the witch killed on year of birth of those people
                Double averageNum = generalUtility.getAverageNumberInList(personIdentity);
                generalUtility.generateSuccessMessage(responseEntity, averageNum);
            }
        } catch (IllegalArgumentException iae) {
            generalUtility.generateErrorMessage(responseEntity, GeneralUtility.ERROR_BORN_BEFORE_ZERO_PARAMETER);
            return responseEntity;
        }

        return responseEntity;
    }
}
