import java.util.Arrays;

public class Stack<T> implements QueueInterface<T> {
    private T[] array;
    private int top;
    private int size;

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        this.size = size;
        this.array = (T[]) new Object[this.size];
        this.top = -1;
    }

    @Override
    public void push(T value) {
        if (top == size - 1) {
            throw new IllegalStateException("Stack is full");
        }
        array[++top] = value;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return array[top--];
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return array[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    public int getSize() {
        return top + 1;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "array=" + Arrays.toString(array) +
                ", top=" + top +
                ", capacity=" + size +
                '}';
    }
}