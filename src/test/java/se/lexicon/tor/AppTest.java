package se.lexicon.tor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.tor.data.PersonSequencer;
import se.lexicon.tor.model.Person;
import se.lexicon.tor.model.Todo;


public class AppTest 
{
    private Person testPerson;
    private Todo testTodo;

    @Before
    public void setup()
    {
        //arrange person
        testPerson = new Person(241,"Tor","Lindström");
        //arrange Todo
        testTodo = new Todo(213, "A task");
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

    /*-----------------------------------------------------------------------------------------*/

    @Test
    public void testConstructingTodo()
    {
        //assert
        assertEquals(testTodo.getTodoId(), 213);
        assertEquals(testTodo.getDescription(), "A task");
    }

    @Test
    public void testSetDescription()
    {
        //arrange
        testTodo.setDescription("Another task");
        //assert
        assertEquals(testTodo.getDescription(), "Another task");
    }

    @Test
    public void testSetAssigne()
    {
        //arrange
        testTodo.setAssignee(testPerson);
        //assert
        assertEquals(testTodo.getAssignee(), testPerson);
    }

    @Test
    public void testSetDone()
    {
        //arrange
        testTodo.setDone(true);
        //assert
        assertTrue(testTodo.isDone());
    }

    /*-----------------------------------------------------------------------------------------*/

    @Test
    public void testPersonSequencerNext()
    {
        //arrange
        int expected = 3;
        //act
        PersonSequencer.nextPersonId();
        PersonSequencer.nextPersonId();
        //assert
        assertEquals(PersonSequencer.nextPersonId(), expected);
    }

    @Test
    public void testPersonSequencerReset()
    {
        //arrange
        int expected = 1;
        //act
        PersonSequencer.nextPersonId();
        PersonSequencer.nextPersonId();
        PersonSequencer.reset();
        //assert
        assertEquals(PersonSequencer.nextPersonId(), expected);
    }
}
