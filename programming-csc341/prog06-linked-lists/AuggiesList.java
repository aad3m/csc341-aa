/**
ADT List maintaining a List of Auggies.
Auggies are added to the end of the list by default.
The first element of the list is at "index" 0. This is to match the behavior of a List implemented with an array.
*/
public class AuggiesList {

    /** Reference to first element of the list. */
    private Node head = null;

    /** Reference to last element of the list. */
    private Node tail = null;

    /** Number of elements in the list. */
    private int size = 0;
    
    // ____________________________________________________
    //                  PRIVATE NODE CLASS
    // ____________________________________________________
    /*
    This is a Node class private to the AuggieList class because it is an implementation detail. Users of AuggieList do not need access.
    Because it is part of the AuggieList, it is not necessary to create setters and getters -- everything in the class has direct access.

    There are no javadocs for this class because it is private.
    */
    private class Node {
        // Hold a List item
        Auggie value;
        // Reference to the next element in the list.
        Node next;

        // Only constructor for a new Node
        Node(Auggie a) {
            value = a;
        }
    } // end class Node

    // ____________________________________________________
    //              CONSTRUCTORS and toString
    // ____________________________________________________

    /** Default constructor */
    public AuggiesList() {
        // nothing to do here
        // all member variables initialized at declaration
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // Use string builder
        int i = 1;
        Node temp = head;
        while (temp != null) { // Go through entire list
            sb.append(i).append(". "); // Append current index
            sb.append(temp.value).append("\n"); // Append current node value
            temp = temp.next;
            i++;
        }
        return sb.toString();
    }

    // ____________________________________________________
    //              LIST STATUS METHODS
    // ____________________________________________________

    /** Reports status of List. */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
    * Determine validity of index (not out of bounds)
    * @return true if in bounds, false otherwise
    */
    private boolean isValid(int index) {
        return index >= 0 && index < size;
    }

    // ____________________________________________________
    //                   ADD METHODS
    // ____________________________________________________

    /**
    * Add specified item to the end of the List.
    * @param auggie item to be added to the List.
    */
    public void add(Auggie auggie) {
        Node node = new Node(auggie); // Create new node
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node; // Add new node to end
            tail = node;
        }
        size++; // Update size of list

    } // end add(auggie)

    /**
    * Add specified item to the List at specified location (if index valid)
    *
    * @param index Location within the List (0-based indexing)
    * @param auggie item to be added to the List
    * @throws ArrayIndexException if index is out of bounds.
    */
    public void add(Auggie auggie, int index) throws ArrayIndexException {
        if (!isValid(index)) {
            throw new ArrayIndexException("Index out of bounds");
        }
        Node node = new Node(auggie);
        if (index == 0) { // Place at start if index 0
            head = node;
            if (size == 0) { // Checks if list is also empty
                tail = node;
            }
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next; // Go to node before specified index
            }
            node.next = temp.next;
            temp.next = node;

            if (node.next == null) { // Check if node is added at end
                tail = node;
            }

        }
        size++; // Update size of list

    } // end add(auggie,index)

    // ____________________________________________________
    //                   SEARCH METHODS
    // ____________________________________________________

    /**
    * Retrieve the first element in the list (without removing).
    *
    * @return auggie at the front of the list.
    * @throws IllegalOperationException if list is empty.
    */
    public Auggie peekFirst() throws IllegalOperationException {
        if (head==null) {
            throw new IllegalOperationException("List is empty. No peeking.");
        }
        return head.value;
    }
    
    /**
    * Retrieve the last element in the list (without removing).
    *
    * @return auggie at the end of the list.
    * @throws IllegalOperationException if list is empty.
    */
    public Auggie peekLast() throws IllegalOperationException {
        if (head==null) {
            throw new IllegalOperationException("List is empty. No peeking.");
        }
        return tail.value;
    }
    
    
    /**
    * Retrieve auggie at specified index, without removing it.
    *
    * @param index Location within the list (0-based indexing)
    * @return auggie at index if index valid
    * @throws ArrayIndexException if index is out of bounds.
    */
    public Auggie get(int index) throws ArrayIndexException {
        if (!isValid(index)) {
            throw new ArrayIndexException("Index out of bounds");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next; // Go to specified index
        }
        return temp.value;
        
    } // end get(index)



    /**
    * Determine location of specified auggie (0-based indexing).
    *
    * @param auggie item searching for in List.
    * @return location (0-based) of item, or -1 if not in list
    */
    public int find(Auggie auggie) {
        Node temp = head;
        int index = 0;
        while (temp != null) { // Search list until node is found
            if (temp.value == auggie) {
                return index;
            }
            temp = temp.next;
            index++;
        }

        return -1;
        
    } // end find(auggie)

    // ____________________________________________________
    //                   REMOVE METHODS
    // ____________________________________________________

    /**
    * Remove specified item from the List
    *
    * @param auggie item to be removed from the List (if in the List)
    * @throws IllegalOperationException if auggie is not in the list
    */
    public void remove(Auggie auggie) throws IllegalOperationException {
        if (head.value == auggie) { // If node to remove is the head
            head = head.next;
            size--;
            if (size == 0) { // Check if list is empty
                tail = null;
            }
            return; // Exit when fount
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.value == auggie) { // If auggie is fount
                temp.next = temp.next.next;
                size--; // Decrease list size
                if (temp.next == null) { // Checks if next value is null
                    tail = temp;
                }
                return; // Exit when fount
            }
            temp = temp.next;
        }
        throw new IllegalOperationException("Auggie not found in the list");

    } // end remove(auggie)

    /**
    * Remove item at specified index
    *
    * @param index Location within List (0-based indexing)
    * @return auggie at specified location
    * @throws ArrayIndexException if index out of bounds
    */
    public Auggie remove(int index) throws ArrayIndexException {
       if (!isValid(index)) {
           throw new ArrayIndexException("Index out of bounds");
       }
       Auggie removedAuggie; // Create variable to hold removedAuggie
       if (index == 0) { // If node to remove is the head
           removedAuggie = head.value;
           head = head.next;
           size--; // Decrease list size
           if (size == 0) { // Checks if list is empty
               tail = null;
           }
           return removedAuggie;
       }
       Node temp = head;
       for (int i = 0; i < index - 1; i++) { // Go to one before node to remove
           temp = temp.next;
       }
       removedAuggie = temp.next.value;
       temp.next = temp.next.next;
       if (temp.next == null) { // Checks if next value is null
           tail = temp;
       }
       size--;
       return removedAuggie;
       
    } // end remove(index)

    // ____________________________________________________
    //                   CONVERT METHODS
    // ____________________________________________________

    /**
    * Fills a new Auggie array with List items.
    *
    * @return Auggie array with current List items. The size of the array is equal to the number of elements.
    * @throws IllegalOperationException if the List is empty
    */
    public Auggie[] toArray() throws IllegalOperationException {
        if (isEmpty()) {
            throw new IllegalOperationException("List is empty");
        }

        Auggie[] auggies = new Auggie[size]; // Create new Auggie array with same size
        Node temp = head;
        for (int i = 0; i < size; i++) { // Go through list & copy each to new auggies
            auggies[i] = temp.value;
            temp = temp.next;
        }
        return auggies;

    } // end toArray
    
     // ____________________________________________________
    //                  Getters
    // ____________________________________________________
    
    public int size() {
    	return size;
    }
}
