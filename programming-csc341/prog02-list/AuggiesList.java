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
     */
    public AuggiesList(int capacity) {
        // TODO
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
     *
     */
    public boolean isFull() {
        // TODO: fix this (can be 1 line of code) 
        return false;
    }

    /**
     *
     */
    public boolean isEmpty() {
        // TODO: fix this (can be 1 line of code) 
        return false;
    }

    /**
     *
     */
    private boolean isValid(int index) {
        // TODO: fix this (a few lines of code) 
        return false;
    }


    // ____________________________________________________
    //                   ADD METHODS
    // ____________________________________________________

    /**
    */
    public void add(Auggie auggie) throws IllegalOperationException {
        // Default location for adding an auggie is at the end of the array
        // TODO implement this method
    } // end add(Auggie)

    /**
    */
    public void add(Auggie auggie, int index) throws Exception {
        // TODO: implement this method
    } // end add(index,auggie)

    // ____________________________________________________
    //                   SEARCH METHODS
    // ____________________________________________________

    /**
    */
    public Auggie get(int index) throws ArrayIndexException {
    	// TODO: implement this method
        // Do not remove the Auggie, just return it

        return null;
    } // end get()
    
    public int find(Auggie auggie) {
		// TODO: implement this method
		return -1;
	}

    
    // ____________________________________________________
    //                   CONVERT METHODS
    // ____________________________________________________

    /**
    */
    public Auggie[] toArray() throws IllegalOperationException {
        // TODO: implement this method
        return null;
    } // end toArray()

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
