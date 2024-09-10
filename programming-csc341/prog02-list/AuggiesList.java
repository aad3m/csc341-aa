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
    private boolean isValid(int index) {
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

