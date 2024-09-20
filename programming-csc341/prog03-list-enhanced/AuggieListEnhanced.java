/** A collection of Auggie objects listed in no particular order. */
public class AuggiesList {

    /** Primitive structure for storing the collection of Auggies */
    private Auggie[] auggies;

    /** Default for maximum number of auggies that can be stored */
    private static final int DEFAULT_CAPACITY = 200;

    /** The number of auggies stored in the array. */
    private int size = 0;

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
     * Adds new Auggie to end of list if no exceptions are thrown
     *
     * @param auggie a student, faculty, or staff member
     * @throws IllegalOperationException if list is full
     */
    public void add(Auggie auggie) throws IllegalOperationException {
        // Default location for adding an auggie is at the end of the array
        if (isFull()) {
            throw new IllegalOperationException("List is full");
        }
        auggies[size] = auggie;
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
     * Find an Auggie in the list
     *
     * @param auggie a student, faculty, or staff member
     * @return index for fount Auggie in list, -1 if not in list
     */
    public int find(Auggie auggie) {
        for (int index = 0; index < size; index++)
            if (auggies[index].equals(auggie)) {
                return index;
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
     * @param role a student, faculty, or staff member
     * @return array of Auggies with that role
     */
    public void replace(Auggie a1, Auggie a2) throws IllegalOperationException {
        int index = find(a1);
        if (index == -1) {
            throw new IllegalOperationException("Auggie not found");
        }
        return auggies[index] = a2;
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


