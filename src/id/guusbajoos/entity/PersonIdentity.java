package id.guusbajoos.entity;

public class PersonIdentity {
    public Integer ageOfDeath;
    public Integer yearOfDeath;
    public Integer yearOfBorn;
    public Integer diedVillagers;

    public PersonIdentity() {

    }

    public Integer getAgeOfDeath() {
        return ageOfDeath;
    }

    public void setAgeOfDeath(Integer ageOfDeath) {
        this.ageOfDeath = ageOfDeath;
    }

    public Integer getYearOfDeath() {
        return yearOfDeath;
    }

    public void setYearOfDeath(Integer yearOfDeath) {
        this.yearOfDeath = yearOfDeath;
    }

    public Integer getYearOfBorn() {
        return yearOfBorn;
    }

    public void setYearOfBorn(Integer yearOfBorn) {
        this.yearOfBorn = yearOfBorn;
    }

    public Integer getDiedVillagers() {
        return diedVillagers;
    }

    public void setDiedVillagers(Integer diedVillagers) {
        this.diedVillagers = diedVillagers;
    }
}
