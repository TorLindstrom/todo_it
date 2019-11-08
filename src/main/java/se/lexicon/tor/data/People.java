package se.lexicon.tor.data;

/*
Create a new class called People inside the data package.
        a. Have a private static Person array declared and instantiated as empty            -done
        and not null (new Person[0]).
        b. Add a method public int size() that return the length of the array.              -done
        c. Add a method public Person[] findAll() that return the person array.             -done
        d. Add a method public Person findById(int personId) that return the person         -done
        that has a mathing personId as the passed in parameter.
        e. Add a method that creates a new Person, adds newly created object in the         -done
        array and then return the created object. You have to “expand” the Person
        array. (tip: send in parameters needed to create the Person object and use
        the PersonSequencer to give you a unique personId)
        f. Add a method public void clear() that clears all Person objects from the         -done
        Person array.
        g. Unit test People class with Junit.                                               -done
        h. Commit changes.                                                                  -done
*/

import se.lexicon.tor.model.Person;

import java.util.Arrays;

public class People {
    private static Person[] people = new Person[0];

    /*-----------------------------------------------------------------------------------------*/

    public int size() {
        return people.length;
    }

    public Person[] findAll() {
        return people;
    }

    public Person findById(int personId) {
        for (Person person : people) {
            if (person.getPersonId() == personId) {
                return person;
            }
        }
        return null;
    }

    public Person newPerson(String firstName, String lastName) {
        people = Arrays.copyOf(people, people.length + 1);
        int id = PersonSequencer.nextPersonId();
        Person person = new Person(id, firstName, lastName);
        people[people.length - 1] = person;
        return person;
    }

    public void clear() {
        people = new Person[0];
    }

    public void remove(Person toBeRemoved) {
        int index = -1;
        for (int i = 0; i < people.length; i++) {
            if (people[i] == toBeRemoved) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            Person[] part1 = Arrays.copyOfRange(people, 0, index);
            Person[] part2 = Arrays.copyOfRange(people, index + 1, people.length);
            people = new Person[people.length - 1];
            System.arraycopy(part1, 0, people, 0, part1.length);
            System.arraycopy(part2, 0, people, part1.length, part2.length);
        }
    }
}
