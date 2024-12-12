import java.util.ArrayList;
import java.util.List;

public class Stack<T> implements QueueInterface<T> {
    private List<T> list;

    // Constructor
    public Stack() {
        this.list = new ArrayList<>();
    }

    @Override
    public void push(T value) {
        // Add value to the stack
        list.add(value);
    }

    @Override
    public T pop() {
        // Check if the stack is empty
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        // Remove and return the last element
        return list.remove(list.size() - 1);
    }

    @Override
    public T peek() {
        // Check if the stack is empty
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        // Return the last element without removing it
        return list.get(list.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        // Check if the stack is empty
        return list.isEmpty();
    }

    @Override
    public String toString() {
        // Return a string representation of the stack
        return "Stack{" +
                "list=" + list +
                '}';
    }
}