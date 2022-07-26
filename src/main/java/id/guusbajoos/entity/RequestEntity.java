package id.guusbajoos.entity;

import java.util.List;

public class RequestEntity {
    public List<PersonIdentity> personIdentity;

    public RequestEntity() {

    }

    public List<PersonIdentity> getPersonIdentity() {
        return personIdentity;
    }

    public void setPersonIdentity(List<PersonIdentity> personIdentity) {
        this.personIdentity = personIdentity;
    }
}
