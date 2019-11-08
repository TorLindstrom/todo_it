package se.lexicon.tor.data;

import se.lexicon.tor.model.Person;
import se.lexicon.tor.model.Todo;

import java.util.Arrays;

public class TodoItems {

    private static Todo[] items = new Todo[0];

    /*-----------------------------------------------------------------------------------------*/

    public Todo[] findByDoneStatus(boolean doneStatus){
        Todo[] array = new Todo[0];
        for (Todo todo: items){
            if (todo.isDone()==doneStatus){
                array = Arrays.copyOf(array,array.length+1);
                array[array.length-1] = todo;
            }
        }
        return array;
    }

    public Todo[] findByAssignee(int personId){
        Todo[] array = new Todo[0];
        for (Todo todo: items){
            if (todo.getAssignee() != null && todo.getAssignee().getPersonId()==personId){
                array = Arrays.copyOf(array,array.length+1);
                array[array.length-1] = todo;
            }
        }
        return array;
    }

    public Todo[] findByAssignee(Person assignee){
        Todo[] array = new Todo[0];
        for (Todo todo: items){
            if (todo.getAssignee()==assignee){
                array = Arrays.copyOf(array,array.length+1);
                array[array.length-1] = todo;
            }
        }
        return array;
    }

    public Todo[] findUnassignedTodoItems() {
        Todo[] array = new Todo[0];
        for (Todo todo: items){
            if (todo.getAssignee()==null){
                array = Arrays.copyOf(array,array.length+1);
                array[array.length-1] = todo;
            }
        }
        return array;
    }

    public int size() {
        return items.length;
    }

    public Todo[] findAll() {
        return items;
    }

    public Todo findById(int todoId) {
        for (Todo todo : items) {
            if (todo.getTodoId() == todoId) {
                return todo;
            }
        }
        return null;
    }

    public Todo newTodo(String description) {
        items = Arrays.copyOf(items, items.length + 1);
        int id = TodoSequencer.nextTodoId();
        Todo todo = new Todo(id, description);
        items[items.length - 1] = todo;
        return todo;
    }

    public void clear() {
        items = new Todo[0];
    }

    public void remove(Todo toBeRemoved) {
        int index = -1;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == toBeRemoved) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            Todo[] part1 = Arrays.copyOfRange(items, 0, index);
            Todo[] part2 = Arrays.copyOfRange(items, index + 1, items.length);
            items = new Todo[items.length - 1];
            System.arraycopy(part1, 0, items, 0, part1.length);
            System.arraycopy(part2, 0, items, part1.length, part2.length);
        }
    }

}

