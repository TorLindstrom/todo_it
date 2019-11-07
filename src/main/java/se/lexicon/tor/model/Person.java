package se.lexicon.tor.model;


public class Person
{
    private final int personId;
    private String firstName, lastName;

    //-----------------------------------------------------------------------------------------

    public Person(int personId, String firstName, String lastName)
    {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //-----------------------------------------------------------------------------------------


    public int getPersonId() {
        return personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //-----------------------------------------------------------------------------------------

}
