import java.util.Arrays;

public class Queue<T> implements QueueInterface<T> {
    private T[] array;
    private int head;
    private int tail;
    private int size;

    @SuppressWarnings("unchecked")
    public Queue(int size) {
        this.size = size + 1;
        // Initialize the array
        this.array = (T[]) new Object[this.size];
        // Set head index
        this.head = 0;
        // Set tail index
        this.tail = 0;
    }

    @Override
    public void push(T value) {
        // Check if the queue is full
        if ((tail + 1) % size == head) {
            throw new IllegalStateException("Queue is full");
        }
        // Add value to the queue
        array[tail] = value;
        // Update tail index
        tail = (tail + 1) % size;
    }

    @Override
    public T pop() {
        // Check if the queue is empty
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        // Get the value at the head
        T value = array[head];
        // Update head index
        head = (head + 1) % size;
        // Return the value
        return value;
    }

    @Override
    public T peek() {
        // Check if the queue is empty
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        // Return the value at the head without removing it
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        // Check if the queue is empty
        return head == tail;
    }

    @Override
    public String toString() {
        // Return a string representation of the queue
        return "Queue{" +
                "array=" + Arrays.toString(array) +
                ", head=" + head +
                ", tail=" + tail +
                ", capacity=" + size +
                '}';
    }
}