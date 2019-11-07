package se.lexicon.tor;

import org.junit.Test;
import se.lexicon.tor.data.TodoSequencer;

import static org.junit.Assert.assertEquals;

public class TodoSequencerTest
{
    @Test
    public void testTodoSequencerNext()
    {
        //arrange
        int expected = 3;
        //act
        TodoSequencer.nextTodoId();
        TodoSequencer.nextTodoId();
        //assert
        assertEquals(TodoSequencer.nextTodoId(), expected);
    }

    @Test
    public void testTodoSequencerReset()
    {
        //arrange
        int expected = 1;
        //act
        TodoSequencer.nextTodoId();
        TodoSequencer.nextTodoId();
        TodoSequencer.reset();
        //assert
        assertEquals(TodoSequencer.nextTodoId(), expected);
    }
}
