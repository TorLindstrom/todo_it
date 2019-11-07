package se.lexicon.tor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.tor.model.Person;

public class PersonTest
{
    private Person testPerson;

    @Before
    public void setup()
    {
        //arrange person
        testPerson = new Person(241,"Tor","Lindström");
    }

    @Test
    public void testConstructingPerson()
    {
        //assert
        assertEquals(testPerson.getPersonId(), 241);
        assertEquals(testPerson.getFirstName(), "Tor");
        assertEquals(testPerson.getLastName(), "Lindström");
    }

    @Test
    public void testSetFirstName()
    {
        //act
        testPerson.setFirstName("Bengt");
        //assert
        assertEquals(testPerson.getFirstName(), "Bengt");
    }

    @Test
    public void testSetLastName()
    {
        //act
        testPerson.setLastName("Svensson");
        //assert
        assertEquals(testPerson.getLastName(), "Svensson");
    }
}
