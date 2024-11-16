import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Test Constructor
        PriorityQ<Integer> pq = new PriorityQ<>();

        System.out.println("=== Test isEmpty ===");
        System.out.println("Initial isEmpty: " + pq.isEmpty()); // Expected: true

        System.out.println("\n=== Test push ===");
        pq.push(10);
        pq.push(5);
        pq.push(20);
        pq.push(1);
        System.out.println("Heap after pushes: " + Arrays.toString(pq.getHeap()));
        // Expected: [1, 5, 20, 10] (min-heap order)

        System.out.println("\n=== Test peek ===");
        System.out.println("Peek: " + pq.peek()); // Expected: 1

        System.out.println("\n=== Test pop ===");
        System.out.println("Pop: " + pq.pop()); // Expected: 1
        System.out.println("Heap after pop: " + Arrays.toString(pq.getHeap()));
        // Expected: [5, 10, 20] (updated heap)
        System.out.println("Pop: " + pq.pop()); // Expected: 5
        System.out.println("Pop: " + pq.pop()); // Expected: 10
        System.out.println("Pop: " + pq.pop()); // Expected: 20
        System.out.println("Pop on empty heap: " + pq.pop()); // Expected: null

        System.out.println("\n=== Test isEmpty after pops ===");
        System.out.println("Is empty: " + pq.isEmpty()); // Expected: true

        System.out.println("\n=== Test getHeap on empty ===");
        System.out.println("Heap: " + java.util.Arrays.toString(pq.getHeap()));
        // Expected: []

        System.out.println("\n=== Test heapify with array ===");
        Integer[] inputArray = {10, 5, 20, 1, 15, 30};
        PriorityQ<Integer> pqFromArray = new PriorityQ<>(inputArray);
        System.out.println("Heap from array: " + Arrays.toString(pqFromArray.getHeap()));
        // Expected: [1, 5, 20, 10, 15, 30] (min-heap)

        System.out.println("\n=== Test edge case: push on full heap ===");
        PriorityQ<Integer> smallPQ = new PriorityQ<>();
        for (int i = 0; i < 20; i++) {
            smallPQ.push(i);
        }
        System.out.println("Heap after pushing 20 elements: " + Arrays.toString(smallPQ.getHeap()));
        // Expected: [0, 1, ..., 19]
        smallPQ.push(100);
        System.out.println("Heap after trying to push on full heap: " + Arrays.toString(smallPQ.getHeap()));
        // Expected: No change
    }
}
