import java.util.*;

public class DequeEx {
    public static void main(String[] args) {
        // Create an instance of Deque
        Deque<String> deque = new ArrayDeque<>();

        // Add elements to the deque
        deque.add("1");
        deque.add("2");
        deque.add("3");

        // Display the deque
        System.out.println("Deque: " + deque);

        // Remove and display the first element
        String firstElement = deque.removeFirst();
        System.out.println("First element removed: " + firstElement);

        // Retrieve and display last element
        String peekLast = deque.peekLast();
        System.out.println("Peek last element: " + peekLast);

        // Display the final state
        System.out.println("Deque after changes: " + deque);
    }
}

