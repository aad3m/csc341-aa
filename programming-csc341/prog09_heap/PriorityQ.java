
public class PriorityQ <T extends Comparable<T>> {

    private T[] heap;
    private int size = 0;

    /**
     * Default Constructor
     */
    public PriorityQ() {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Comparable[20];
        heap = temp;
    }

    /**
     * Remove value from the heap
     * @return the minimum value
     */
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T temp = heap[0];
        heap[0] = heap[size-1];
        size--;
        sinkDown(0);
        return temp;
    }

    /**
     * Add value to the heap
     * @param value value to be added
     */
    public void push(T value) {
        // Check if the heap is full
        if (size == heap.length) {
            return;
        }
        // Add the value
        heap[size] = value;
        floatUp(size);
        size++;
    }

    /**
     * Get the minimum value
     * @return the minimum value
     */
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return heap[0];
    }

    /**
     * Checks if the heap is empty
     * @return true or false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a new array with the elements of the heap
     * @return array with the elements of the heap
     */
    public T[] getHeap() {
        @SuppressWarnings("unchecked")
        // Create a new array
        T[] temp = (T[]) new Comparable[size];
        // Copy the elements
        for (int i = 0; i < size; i++) {
            temp[i] = heap[i];
        }
        // Return the array
        return temp;
    }

    /**
     * Copy the elements of the array to the heap array
     * @param array elements to be copied
     */
    public PriorityQ(T[] array) {
        this();
        // Copy the elements
        for(int i = 0; i < array.length; i++) {
            heap[i] = array[i];
        }
        // Update the size
        size = array.length;
        // Heapify the heap
        heapify();
    }


    // ________________________________________________________________
    //                HELPERS
    // _________________________________________________________________

    /**
     * Get the index of the left element
     * @param index index of the element
     * @return index of the left child
     */
    private int left(int index) {
        return index * 2 + 1;
    }

    /**
     * Get the index of the right element
     * @param index index of the element
     * @return index of the right child
     */
    private int right(int index) {
        return index * 2 + 2;
    }

    /**
     * Get the index of the parent element
     * @param index index of the element
     * @return index of the parent
     */
    private int parent(int index) {
        double temp = Math.floor((double) (index - 1) / 2);
        return (int) temp;
    }

    /**
     * Sinks the element down
     * @param i index of the element
     */
    private void sinkDown(int i) {
        while (left(i) < size) {
            int left = left(i);
            int right = right(i);
            int smallest = left;
            // Check if right is smaller than left
            if (right < size && heap[right].compareTo(heap[left]) < 0) {
                smallest = right;
            }
            // Check if the smallest is smaller than the current element
            if (heap[i].compareTo(heap[smallest]) < 0) {
                break;
            }
            // Swap the elements
            T temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;
            // Update the index
            i = smallest;
        }
    }

    /**
     * Floats the element up
     * @param i index of the element
     */
    private void floatUp(int i) {
        // While the element is smaller than the parent
        while (i > 0 && heap[i].compareTo(heap[parent(i)]) < 0) {
            // Swap the elements
            T temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            // Update the index
            i = parent(i);
        }
    }

    /**
     * Heapify the heap
     */
    private void heapify() {
        // Start from the middle of the heap
        for (int i = size / 2 - 1; i >= 0; i--) {
            sinkDown(i);
        }
    }

}
