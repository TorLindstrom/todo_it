package se.lexicon.tor;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.tor.model.Person;
import se.lexicon.tor.model.Todo;

import static org.junit.Assert.*;

public class TodoTest
{
    private Todo testTodo;
    private Person testPerson;


    @Before
    public void setup()
    {
        //arrange Todo
        testTodo = new Todo(213, "A task");
        //arrange person
        testPerson = new Person(241, "Tor", "Lindström");
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
    public void testSetAssignee()
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
}
