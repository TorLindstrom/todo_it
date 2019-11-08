package se.lexicon.tor;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.tor.data.People;
import se.lexicon.tor.model.Person;

import static org.junit.Assert.*;

public class PeopleTest {

    static Person person;
    static People test = new People();

    @Before
    public void setup(){
        person = new Person(1,"Sven", "Svensson");

        People test = new People();
        test.clear();
        test.newPerson("Svante", "vante");
        test.newPerson("vante", "Svante");
    }

    @Test
    public void testSize() {
        assertEquals(2, test.size());
    }

    @Test
    public void testFindAll() {
        People test = new People();
        test.clear();
        Person[] test2 = new Person[2];
        test2[0] = test.newPerson("Svante", "vante");
        test2[1] = test.newPerson("vante", "Svante");
        assertArrayEquals(test2, test.findAll());
    }

    @Test
    public void testFindByIdis() {
        People test = new People();
        test.clear();
        Person[] test2 = new Person[2];
        test2[0] = test.newPerson("Svante", "vante");
        test2[1] = test.newPerson("vante", "Svante");
        assertEquals(test2[1], test.findById(test2[1].getPersonId()));
    }

    @Test
    public void testFindByIdisnt() {
        assertNull(test.findById(24));
    }

    @Test
    public void testClear() {
        test.clear();
        assertEquals(0, test.size());
    }

    @Test
    public void testNewPerson() {
        test.clear();
        Person test2 = test.newPerson("Tor", "Svensson");
        assertEquals(test2, test.findAll()[0]);
    }

    @Test
    public void testRemoveIs(){

        Person[] test3 = new Person[6];

        test.clear();
        test3[0] = test.newPerson("Svante", "vante");
        test3[1] =test.newPerson("Svante", "vante");
        test3[2] =test.newPerson("Svante", "vante");
        Person test2 = test.newPerson("Tor", "Svensson");
        test3[3] =test.newPerson("Svante", "vante");
        test3[4] =test.newPerson("Svante", "vante");
        test3[5] =test.newPerson("Svante", "vante");

        test.remove(test2);

        assertArrayEquals(test3, test.findAll());
    }

    @Test
    public void testRemoveIsNot(){

        Person[] test3 = new Person[7];

        test.clear();
        test3[0] = test.newPerson("Svante", "vante");
        test3[1] = test.newPerson("Svante", "vante");
        test3[2] = test.newPerson("Svante", "vante");
        test3[3] = test.newPerson("Tor", "Svensson");
        test3[4] = test.newPerson("Svante", "vante");
        test3[5] = test.newPerson("Svante", "vante");
        test3[6] = test.newPerson("Svante", "vante");

        Person test4 = new Person(1, "Bengt", "Svensson");

        test.remove(test4);

        assertArrayEquals(test3, test.findAll());
    }

}
