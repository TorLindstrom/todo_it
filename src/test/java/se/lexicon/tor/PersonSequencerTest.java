package se.lexicon.tor;

import org.junit.Test;
import se.lexicon.tor.data.PersonSequencer;

import static org.junit.Assert.*;

public class PersonSequencerTest
{
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
