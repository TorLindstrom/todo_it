package se.lexicon.tor;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.tor.data.TodoItems;
import se.lexicon.tor.model.Todo;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TodoItemsTest {
    static Todo todo;
    static TodoItems test = new TodoItems();

    @Before
    public void setup(){
        TodoItems test = new TodoItems();
        test.clear();
        test.newTodo("task");
        test.newTodo("task");
    }

    @Test
    public void testSize() {
        assertEquals(2, test.size());
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
    public void testNewPerson() {
        test.clear();
        Todo test2 = test.newTodo("task");
        assertEquals(test2, test.findAll()[0]);
    }
}
