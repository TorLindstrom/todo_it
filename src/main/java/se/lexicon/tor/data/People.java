package se.lexicon.tor.data;

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
