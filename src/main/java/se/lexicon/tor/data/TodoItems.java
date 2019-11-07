package se.lexicon.tor.data;

import se.lexicon.tor.model.Todo;

import java.util.Arrays;

public class TodoItems {

    private static Todo[] items = new Todo[0];

    /*-----------------------------------------------------------------------------------------*/

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
}

