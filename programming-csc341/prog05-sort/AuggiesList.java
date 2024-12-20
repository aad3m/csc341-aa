import java.util.*;

/** A collection of Auggie objects listed in no particular order. */
public class AuggiesList {

    /** Comparator for ordering array. Uses compareTo of Auggie by default */
    private Comparator<Auggie> orderBy = new Comparator<Auggie>() {
        @Override
        public int compare(Auggie a1, Auggie a2) {
            return a1.compareTo(a2);
        }
    };

    /** Primitive structure for storing the collection of Auggies */
    private Auggie[] auggies;

    /** Default for maximum number of auggies that can be stored */
    private static final int DEFAULT_CAPACITY = 200;

    /** The number of auggies stored in the array. */
    private int size = 0;

    AuggiesList(Comparator<Auggie> ordering) {
        this();
        this.orderBy = ordering;
    }
    AuggiesList(Comparator<Auggie> ordering, int capacity) {
        this.auggies = new Auggie[capacity];
        this.orderBy = ordering;
    }

    // ____________________________________________________
    //              CONSTRUCTORS
    // ____________________________________________________

    /**
     * Constructor with a set capacity for data
     *
     * @param capacity maximum number of Auggies that can be stored
     */
    public AuggiesList(int capacity) {
        auggies = new Auggie[capacity];
    }

    /** Default Constructor */
    public AuggiesList() {
        this(DEFAULT_CAPACITY);
    }

    // ____________________________________________________

    @Override
    public String toString() {
        // Create numbered list of auggies in the collection
        String printedList = "";
        for (int i = 0; i < size; i++) {
            printedList += (i + 1) + ". " + auggies[i].toString() + "\n";
        }
        return printedList;
    } // end toString()


    // ____________________________________________________
    //              LIST STATUS METHODS
    // ____________________________________________________

    /**
     * Determines whether there is capacity for more students
     *
     * @return true or false
     */
    public boolean isFull() {
        return size == auggies.length;
    }

    /**
     * Determines whether there are any students in the List
     *
     * @return true or false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Determines if the given index corresponds to an element stored in the List
     *
     * @return true or false
     */
    public boolean isValid(int index) {
        return index >= 0 && index < size;
    }


    // ____________________________________________________
    //                   ADD METHODS
    // ____________________________________________________

    /**
     * Adds new Auggie to list based on order
     *
     * @param auggie a student, faculty, or staff member
     * @throws IllegalOperationException if list is full
     */
    public void add(Auggie auggie) throws IllegalOperationException {
        if (isFull()) {
            throw new IllegalOperationException("List is full");
        }
        int i = size - 1;
        while (i >= 0 && orderBy.compare(auggies[i], auggie) > 0) {
            auggies[i + 1] = auggies[i];
            i--;
        }
        auggies[i + 1] = auggie;
        size++;
    }

    /**
     * Adds new Auggie to specified index if no exceptions are thrown while also
     * shifting all other elements to the right
     *
     * @param auggie a student, faculty, or staff member
     * @param index location of element in list
     * @throws IllegalOperationException if list is full
     * @throws ArrayIndexException if index is invalid
     */
    public void add(Auggie auggie, int index) throws Exception {
        if (isFull()) {
            throw new IllegalOperationException("List is full");
        }
        if (!isValid(index)) {
            throw new ArrayIndexException("Index is invalid");
        }
        for (int i = size; i > index; i--) {
            auggies[i] = auggies[i - 1];
        }
        auggies[index] = auggie;
        size++;
    }

    /**
     * Adds all Auggies in array to the end of the list
     *
     * @param array an array of students, faculty, or staff members
     * @throws IllegalOperationException if list is full
     */
    public void addAll(Auggie[] array) throws IllegalOperationException {
        if (array.length > auggies.length - size) {
            throw new IllegalOperationException("Not enough space");
        }
        for (int i = 0; i < array.length; i++) {
            auggies[size + i] = array[i];
        }
        size += array.length;
    }


    // ____________________________________________________
    //                   REMOVE METHODS
    // ____________________________________________________

    /**
     * Removes Auggie at specified index if no exceptions are thrown
     *
     * @param index location of element in list
     * @throws ArrayIndexException if index is invalid
     * @return removedAuggie is the Auggie removed
     */
    public Auggie remove(int index) throws ArrayIndexException {
        if (!isValid(index)) {
            throw new ArrayIndexException("Index is invalid");
        }
        Auggie removedAuggie = auggies[index];
        for (int i = index; i < size - 1; i++) {
            auggies[i] = auggies[i + 1];
        }
        size--;
        return removedAuggie;
    }

    /**
     * Removes Auggie from list if no exceptions are thrown
     *
     * @param auggie a student, faculty, or staff member
     * @throws IllegalOperationException if Auggie is not in list
     */
    public void remove(Auggie auggie) throws Exception {

        int auggieIndex = find(auggie);
        if (auggieIndex == -1 ){
            throw new IllegalOperationException("Auggie doesn't exist");
        }
        remove(auggieIndex);
    }

    /**
     * Removes all Auggies with specified role from list
     *
     * @param role a student, faculty, or staff member
     * @throws IllegalOperationException if Auggie is not in list
     */
    public void removeAll(Role role) throws Exception {
        int i = 0;
        while (i < size) {
            if (auggies[i].role() == role) {
                remove(i);
            } else {
                i++;
            }
        }
    }

    // ____________________________________________________
    //                   SEARCH METHODS
    // ____________________________________________________

    /**
     * Gets Auggie at specified index if no exceptions are thrown
     *
     * @param index location of element in list
     * @throws ArrayIndexException if index is invalid
     * @return element at that index
     */
    public Auggie get(int index) throws ArrayIndexException {
        if (!isValid(index)){
            throw new ArrayIndexException("Index is invalid");
        }
        return auggies[index];
    }

    /**
     * Find an Auggie in the list using binary search
     *
     * @param auggie a student, faculty, or staff member
     * @return index for fount Auggie in list, -1 if not in list
     */
    public int find(Auggie auggie) {
        for (int index = 0; index < size; index++) {
            if (orderBy.compare(auggies[index], auggie) == 0) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Find an Auggie in the list by username
     *
     * @param uname username of Auggie
     * @return index for fount Auggie in list, -1 if not in list
     */
    public int findAuggie(String uname) {
        for (int index = 0; index < size; index++)
            if (auggies[index].username().equals(uname)) {
                return index;
            }
        return -1;
    }

    /**
     * Find all Auggies with specified role
     *
     * @param a1 Auggie to find
     * @param a2 Auggie to replace with
     * @throws IllegalOperationException if Auggie not found
     */
    public void replace(Auggie a1, Auggie a2) throws IllegalOperationException {
        int index = find(a1);
        if (index == -1) {
            throw new IllegalOperationException("Auggie not found");
        }
        auggies[index] = a2;
    }

    /**
     * Locate auggie using binary search
     *
     * @param auggie Auggie to find
     * @return location of auggie or -1 if not present
     */
    int findRecursive(Auggie auggie) {
        if (find(auggie) != -1) {
            return find(auggie);
        }
        return -1;
    }


    // ____________________________________________________
    //                   CONVERT METHODS
    // ____________________________________________________

    /**
     * Creates an array equal to size if list is not empty and copy the contents to new array
     *
     * @throws IllegalOperationException if list is empty
     * @return newAuggie is new list of Auggies
     */
    public Auggie[] toArray() throws IllegalOperationException {
        if (isEmpty()){
            throw new IllegalOperationException("List is empty");
        }
        Auggie[] newAuggie = new Auggie[size];
        for (int i = 0; i < size; i++) {
            newAuggie[i] = auggies[i];
        }
        return newAuggie;
    }

    /**
     * Creates an array equal to size if list is not empty and copy the contents to new array
     *
     * @param array an array of students, faculty, or staff members
     * @throws IllegalOperationException if list is too small
     * @return size number of Auggies copied
     */
    public int toArray(Auggie[] array) throws IllegalOperationException {
        if (array.length < size) {
            throw new IllegalOperationException("Array is too small");
        }
        for (int i = 0; i < size; i++) {
            array[i] = auggies[i];
        }
        return size;
    }

    /**
     * Creates a sublist of Auggies from start to end index
     *
     * @param start index of first element in sublist
     * @param end index of last element in sublist
     * @throws ArrayIndexException if start or end is invalid
     * @return sublist of Auggies
     */
    public Auggie[] sublist(int start, int end) throws ArrayIndexException {
        if (start < 0 || end >= size || start > end) {
            throw new ArrayIndexException("Invalid start or end");
        }
        Auggie[] sublist = new Auggie[end - start + 1];
        for (int i = start; i <= end; i++) {
            sublist[i - start] = auggies[i];
        }
        return sublist;
    }

    /**
     * Creates a sublist from beginning Auggie to last
     *
     * @param astart first Auggie in sublist
     * @param aend last Auggie in sublist
     * @return sublist with or without Auggies
     */
    public Auggie[] sublist(Auggie astart, Auggie aend) throws Exception {
        // Set start and end to first and last index
        int start = 0;
        int end = size - 1;

        // Find the first and last index of the sublist
        while (start < size && orderBy.compare(auggies[start], astart) <= 0) {
            start++;
        }
        while (end >= 0 && orderBy.compare(auggies[end], aend) >= 0) {
            end--;
        }
        if (start > end) {
            return new Auggie[0];
        }
        return sublist(start, end);
    }

    /**
     * Creates an array with list values sorted
     *
     * @param order name for calling comparator
     * @return an array with list values
     */
    public Auggie[] toArray(Comparator<Auggie> order) {
        this.orderBy = order;

        Auggie[] sortedArray = new Auggie[size];
        for (int i = 0; i < size; i++) {
            sortedArray[i] = auggies[i];
        }
        for (int i = 1; i < size; i++) {
        Auggie key = sortedArray[i];
        int j = i - 1;
        while (j >= 0 && order.compare(sortedArray[j], key) > 0) {
            sortedArray[j + 1] = sortedArray[j];
            j--;
        }
        sortedArray[j + 1] = key;
    }
        return sortedArray;
    }

    /**
     * Creates a new list of Auggies with specified role
     *
     * @param role student, faculty, or staff
     * @return new ArrayList
     */
    public ArrayList<Auggie> query(Role role) {
        ArrayList<Auggie> auggiesRole = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (auggies[i].role() == role) {
                auggiesRole.add(auggies[i]);
            }
        }
        return auggiesRole;
    }


    // ____________________________________________________
    //                   ORDERING METHODS
    // ____________________________________________________

    /**
     * Reorder list using insertion sort
     *
     * @param order name for calling comparator
     */
    public void reorder(Comparator<Auggie> order) {
        this.orderBy = order;

        for (int i = 1; i < size; i++) {
            Auggie temp = auggies[i];
            int j = i - 1;
            while (j >= 0 && order.compare(auggies[j], temp) > 0) {
                auggies[j + 1] = auggies[j];
                j--;
            }
            auggies[j + 1] = temp;
        }
    }

    /**
     * Get min value according to current ordering
     *
     * @return first value
     * @throws IllegalOperationException if list is empty
     */
    public Auggie min() throws IllegalOperationException {
        if (isEmpty()) {
            throw new IllegalOperationException("List is empty");
        }
        return auggies[0];
    }

    /**
     * Get max value according to current ordering
     *
     * @return last value
     * @throws IllegalOperationException if list is empty
     */
    public Auggie max() throws IllegalOperationException {
        if (isEmpty()) {
            throw new IllegalOperationException("List is empty");
        }
        return auggies[size - 1];
    }

    /**
     * Gets min value by iterating over list
     *
     * @param order name for calling comparator
     * @return min value
     * @throws IllegalOperationException if list is empty
     */
    public Auggie min(Comparator<Auggie> order) throws IllegalOperationException {
        this.orderBy = order;

        if (isEmpty()) {
            throw new IllegalOperationException("List is empty");
        }
        else {
            Auggie min = auggies[0];
            for (int i = 1; i < size; i++) {
                if (order.compare(min, auggies[i]) > 0) {
                    min = auggies[i];
                }
            }
            return min;
        }
    }

    /**
     * Gets max value by iterating over list
     *
     * @param order name for calling comparator
     * @return max value
     * @throws IllegalOperationException if list is empty
     */
    public Auggie max(Comparator<Auggie> order) throws IllegalOperationException {
        this.orderBy = order;

        if (isEmpty()) {
            throw new IllegalOperationException("List is empty");
        }
        else {
            Auggie max = auggies[0];
            for (int i = 1; i < size; i++) {
                if (order.compare(max, auggies[i]) < 0) {
                    max = auggies[i];
                }
            }
            return max;
        }
    }


    // ____________________________________________________
    //                   SETTERS AND GETTERS
    // ____________________________________________________

    public int size() {
        return size;
    }

    public int capacity() {
        return auggies.length;
    }

} // end class List


