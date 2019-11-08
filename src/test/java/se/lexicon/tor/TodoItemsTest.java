package se.lexicon.tor;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.tor.data.PersonSequencer;
import se.lexicon.tor.data.TodoItems;
import se.lexicon.tor.model.Person;
import se.lexicon.tor.model.Todo;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TodoItemsTest {
    static Todo todo;
    static TodoItems test = new TodoItems();
    static Person person;
    static Person person2;
    static Person person3;
    Todo[] test2;
    Todo[] test3;

    @Before
    public void setup(){

        PersonSequencer.reset();
        person = new Person(PersonSequencer.nextPersonId(), "test", "test");
        person2 = new Person(PersonSequencer.nextPersonId(), "test", "test");
        person3 = new Person(PersonSequencer.nextPersonId(), "test", "test");

        test2 = new Todo[7];
        test = new TodoItems();
        test.clear();
        test2[0] = test.newTodo("task");
        test2[1] = test.newTodo("task");
        test2[2] = test.newTodo("task");
        test2[3] = test.newTodo("task");
        test2[4] = test.newTodo("task");
        test2[5] = test.newTodo("task");
        test2[6] = test.newTodo("task");

        test3 = test.findAll();

        test3[0].setDone(true);
        test3[2].setDone(true);

        test3[0].setAssignee(person);
        test3[2].setAssignee(person);

        test3[1].setAssignee(person2);
        test3[4].setAssignee(person2);

        test3[3].setAssignee(person3);
    }

    @Test
    public void testSize() {
        assertEquals(7, test.size());
    }

    @Test
    public void testFindAll() {
        TodoItems test = new TodoItems();
        test.clear();
        Todo[] test2 = new Todo[2];
        test2[0] = test.newTodo("task");
        test2[1] = test.newTodo("task");
        assertArrayEquals(test2, test.findAll());
    }

    @Test
    public void testFindByIdis() {
        TodoItems test = new TodoItems();
        test.clear();
        Todo[] test2 = new Todo[2];
        test2[0] = test.newTodo("task");
        test2[1] = test.newTodo("task");
        assertEquals(test2[1], test.findById(test2[1].getTodoId()));
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
    public void testNewTodo() {
        test.clear();
        Todo test2 = test.newTodo("task");
        assertEquals(test2, test.findAll()[0]);
    }

    @Test
    public void testFindByDoneTrue(){
        Todo[] test3 = test.findByDoneStatus(true);

        assertEquals(2, test3.length);
        assertTrue(test3[0].isDone());
        assertTrue(test3[1].isDone());
    }

    @Test
    public void testFindByDoneFalse(){
        Todo[] test3 = test.findByDoneStatus(false);

        assertEquals(5, test3.length);
        assertFalse(test3[0].isDone());
        assertFalse(test3[1].isDone());
        assertFalse(test3[2].isDone());
        assertFalse(test3[3].isDone());
        assertFalse(test3[4].isDone());
    }

    @Test
    public void testFindByAssigneeId(){

        Todo[] test6 = test.findByAssignee(1);

        assertEquals(1, person.getPersonId());
        assertEquals(2, test6.length);
        assertEquals(1, test6[0].getAssignee().getPersonId());
        assertEquals(1, test6[1].getAssignee().getPersonId());
    }

    @Test
    public void testFindByAssigneeIdNot(){

        Todo[] test2 = test.findByAssignee(24);

        assertEquals(0, test2.length);
    }

    @Test
    public void testFindByAssigneePerson(){

        Todo[] test2 = test.findByAssignee(person2);

        assertEquals(2, person2.getPersonId());
        assertEquals(2, test2.length);
        assertEquals(person2, test2[0].getAssignee());
        assertEquals(person2, test2[1].getAssignee());
    }

    @Test
    public void testFindByAssigneePerson3(){

        Todo[] test2 = test.findByAssignee(person3);

        assertEquals(3, person3.getPersonId());
        assertEquals(1, test2.length);
        assertEquals(person3, test2[0].getAssignee());
    }

    @Test
    public void testFindUnassigned(){

        Todo[] test2 = test.findUnassignedTodoItems();


        assertEquals(2, test2.length);
        assertNull(test2[0].getAssignee());
        assertNull(test2[1].getAssignee());
    }
}
