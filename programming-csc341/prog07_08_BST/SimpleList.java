import java.util.*;

/** 
* ADT List that is Ordered. 
* Default ordering is the compareTo method of Simple.
* User can set the ordering by passing in a Comparator.
*/
class SimpleList {

	/** Primary entry point into the tree */
	private Node root = null;

    /** Count of elements in the List */
    private int count = 0;

    /** Comparator for ordering tree. Uses compareTo of Track by default */
    private Comparator<Simple> ordering = new Comparator<Simple>() {
        @Override
        public int compare(Simple simple1, Simple simple2) {
            return simple1.compareTo(simple2);
        }
    };

    // Sentinel for leaf nodes. 
    // This node should be both the left and right child of all leaf nodes.
    // The parent of root should remain null (do not use this sentinel)
    private Node dummy = new Node(null);

	/** Default Constructor */
    public SimpleList() {
    	// height of the dummy node is -1, following the convention of 
    	// calculating the balance factor for ADT trees (see zyBooks)
    	dummy.height = -1;
    	
    	// IMPORTANT: dummy.parent = null 
    	// --> you cannot travel back up the tree from the dummy node!!
    }

	/** 
	* Constructor with user-specified ordering.
	* @param order User-specified comparator for ordering the tree.
	*/
    public SimpleList(Comparator<Simple> order) {
    	// call default constructor so dummy node height gets set
    	this();
        ordering = order;
    }

    private boolean balanced = true;

    // ________________________________________________________________
    //                HELPERS
    // _________________________________________________________________

    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
        toString(root, sb);
        return sb.toString();
    }
    private void toString(Node n, StringBuilder sb) {
        // Base case
    	if (n == dummy) {
    		return;
    	}
        // Recursively process left & right subtree
    	toString(n.left, sb);
    	sb.append(n.value).append(" ");
    	toString(n.right, sb);
    }
    
    /** Return true if the list has no elements, false otherwise. */
    public boolean empty() {
    	return root==null;
    }
    
    /**
    * The height of the tree (i.e. height of the root node).
    * @return Height of the tree
    * @throws IllegalOperationException if tree is empty.
    */
    public int height() throws IllegalOperationException {
        if (root == null) {
        	throw new IllegalOperationException("Tree is empty");
        }
        return root.height;
    }

    /**
     * Find the node that contains the specified value
     * @param n node to start the search from
     * @param alpha value to search for
     * @param result node that contains the specified value
     */
    private void query(Node n, String alpha, ArrayList<Simple> result) {
        // Base case
        if (n == dummy) {
            return;
        }
        // Recursively search left subtree
        query(n.left, alpha, result);
        // Check current node
        if (n.value.alpha().equals(alpha)) {
            result.add(n.value);
        }
        // Recursively search right subtree
        query(n.right, alpha, result);
    }

    /**
     * Find the node that contains the specified value
     * @param n node to start the search from
     * @param number value to search for
     * @return node that contains the specified value
     */
    private Simple findFirst(Node n, Integer number) {
        // Base case
    	if (n == dummy) {
    		return null;
    	}
        // Recursively search left subtree
    	Simple left = findFirst(n.left, number);
        if (left != null) {
            return left;
        }
        // Check current node
        if (n.value.number().equals(number)) {
            return n.value;
        }
        // Recursively search right subtree
        return findFirst(n.right, number);
    }

    /**
     * Find the node that contains the specified value
     * @param n node to start the search from
     * @param array array to store the values in
     * @param index index to start storing the values at
     * @return index to start storing the values at
     */
    private int toArray(Node n, Simple[] array, int index) {
        // Base case
        if (n == dummy) {
            return index;
        }
        // Recursively process left subtree
        index = toArray(n.left, array, index);
        // Add current node to array
        array[index] = n.value;
        index++;
        // Recursively process right subtree
        return toArray(n.right, array, index);
    }

    public boolean balanced() {
        return balanced;
    }

    /**
     * This is a helper function that is called when the tree is unbalanced.
     */
    private void balance() {
        // Convert tree to array
        Simple[] array = toArray();
        root = null;
        count = 0;
        balanced = true;
        // Rebuild tree
        for (Simple s : array) {
            add(s);
        }
    }

    /**
     * Find the specified node in the tree
     * @param value value to search for
     * @return node that contains the specified value
     */
    private Node findNode(Simple value) {
        Node current = root;
        // Traverse tree to find specified object
        while (current != dummy) {
            int compare = ordering.compare(value, current.value);
            if (compare < 0) {
                current = current.left;
            } else if (compare > 0) {
                current = current.right;
            } else {
                return current;
            }
        }
        // If specified object not found, return false
        return null;
    }


    // ________________________________________________________________
    //                ADD
    // _________________________________________________________________

  	/**
  	* Add the specified element to the list.
  	* @param simple Element to add to the list (in order)
  	*/
    public void add(Simple simple) {
        Node n = new Node(simple);

        // If tree is empty, set root to new node
        if (root == null) {
        	root = n;
            root.depth = 0;
            adjustHeight(root);
            return;
        }
        Node current = root;
        Node parent;

        // Traverse tree to find insertion point
        while (current != dummy) {
        parent = current;
            // Compare new node to current node
            if (ordering.compare(n.value, current.value) < 0) {
                current = current.left;
                // If left child is dummy node, insert new node
                if (current == dummy) {
                    parent.left = n;
                    n.parent = parent;
                    n.depth = parent.depth + 1;
                    adjustHeight(n);
                    break;
                }
            } else {
                current = current.right;
                // If right child is dummy node, insert new node
                if (current == dummy) {
                    parent.right = n;
                    n.parent = parent;
                    n.depth = parent.depth + 1;
                    adjustHeight(n);
                    break;
                }
            }
            if (!balanced) {
                balance();
            }
        }
    }

    // Helper function to adjust height of nodes (as is appropriate)
    private void adjustHeight(Node n) {
        // Base case
        if (n == dummy) {
            return;
        }
        // Calculate height of left & right children
        int leftHeight;
        if (n.left != dummy) {
            leftHeight = n.left.height;
        } else {
            leftHeight = -1;
        }

        int rightHeight;
        if (n.right != dummy) {
            rightHeight = n.right.height;
        } else {
            rightHeight = -1;
        }
        // Set height of current node
        n.height = Math.max(leftHeight, rightHeight) + 1;

        if (Math.abs(leftHeight - rightHeight) > 12) {
            balanced = false;
        }

        if (n.parent != null) {
            adjustHeight(n.parent);
        }
    }

    // ________________________________________________________________
    //                SEARCH
    // _________________________________________________________________

    /**
    * Determine if specified object is in the List.
    * @param simple Object searching for in list.
    * @return true if specified object is in list, false otherwise
    */
    public boolean contains(Simple simple) {
    	Node current = root;
        // Traverse tree to find specified object
        while (current != dummy) {
            int compare = ordering.compare(simple, current.value);
            if (compare < 0) {
                current = current.left;
            } else if (compare > 0) {
            current = current.right;
            } else {
                return true;
            }
        }
        // If specified object not found, return false
        return false;
    }

    /**
    * Determine the minimum value in the List based on ordering.
    * @return Minimum value (based on ordering) of the List.
    * @throws IllegalOperationException if list is empty.
    */
    public Simple min() throws IllegalOperationException {
    	if (empty()) {
            throw new IllegalOperationException("Tree is empty");
        }
        Node current = root;
        // Traverse tree to find minimum value
        while (current.left != dummy) {
            current = current.left;
        }
        return current.value;
    }

    /**
    * Determine the maximum value in the List based on ordering.
    * @return Maximum value (based on ordering) of the List.
    * @throws IllegalOperationException if list is empty.
    */
    public Simple max() throws IllegalOperationException {
    	if (empty()) {
            throw new IllegalOperationException("Tree is empty");
        }
        Node current = root;
        // Traverse tree to find maximum value
        while (current.right != dummy) {
            current = current.right;
        }
        return current.value;
    }

    /**
    * Find ALL Simple objects in the List whose alpha matches specified value.
    * @param alpha value to match for elements in the List.
    * @return All matching simple objects with matching value. If nothing matches, returns empty ArrayList.
    */
    public ArrayList<Simple> query(String alpha) {
    	ArrayList<Simple> result = new ArrayList<>();
        query(root, alpha, result);
        return result;
    }

    /**
    * Find the first Simple object whose number matches specified value.
    * @param number Value to match for elements in the List.
    * @return First matching value in List (based on ordering), null if no match
    */
    public Simple findFirst(Integer number) {
    	return findFirst(root, number);
    }

    // ________________________________________________________________
    //                CONVERT
    // _________________________________________________________________

	/**
	* Place all elements of the list in a Simple array in order.
	* @return array of all elements in the list. Return an empty array if list empty.
	*/
    Simple[] toArray() {
        if (empty()) {
            return new Simple[0];
        }
        Simple [] array = new Simple[count];
        toArray(root, array, 0);
        return array;
    }

    /**
     * Put all elements of the list in a Simple array in order
     * @param comp comparator to use for ordering the array
     * @return array of all elements in the list. Return an empty array if list empty
     */
    public Simple[] toArray(Comparator<Simple> comp) {
        Simple[] array = toArray();
        Arrays.sort(array, comp);
        return array;
    }

    /**
     * Reorder the list using the specified comparator
     * @param comp comparator to use for ordering the list
     */
    public void reorder(Comparator<Simple> comp) {
        Simple[] array = toArray();
        Arrays.sort(array, comp);
        root = null;
        count = 0;
        for (Simple s : array) {
            add(s);
        }
    }

    /**
     * Find the successor of the specified value
     * @param value value to find the successor of
     * @return successor of the specified value
     */
    public Simple successor(Simple value) throws IllegalOperationException {
        Node n = findNode(value);
        if (n == null) {
            return null;
        }
        // If the right subtree is not empty, the successor is the minimum of the right subtree
        if (n.right != dummy) {
            return min();
        }
        // Otherwise, the successor is one of the ancestors
        Node parent = n.parent;
        while (parent != null && n == parent.right) {
            n = parent;
            parent = parent.parent;
        }
        if (parent == null) {
            return null;
        }else {
            return parent.value;
        }
    }

    /**
     * Find the predecessor of the specified value
     * @param value value to find the predecessor of
     * @return predecessor of the specified value
     */
    public Simple predecessor(Simple value) throws IllegalOperationException {
        Node n = findNode(value);
        if (n == null) {
            return null;
        }
        // If the left subtree is not empty, the predecessor is the maximum of the left subtree
        if (n.left != dummy) {
            return max();
        }
        // Otherwise, the predecessor is one of the ancestors
        Node parent = n.parent;
        while (parent != null && n == parent.left) {
            n = parent;
            parent = parent.parent;
        }
        if (parent == null) {
            return null;
        }else {
            return parent.value;
        }
    }

    // ________________________________________________________________
    //                private NODE CLASS
    // _________________________________________________________________

    private class Node {
		// pointers to children and parent
    	Node left = null;
    	Node right = null;
    	Node parent = null;

		// node value and information
    	Simple value = null;
    	int height = 0;
    	int depth = 0;

		// Default constructor
		Node() {
			// this will create a Node with a null value
			left = dummy;
    		right = dummy;
		}

		// Constructor
    	Node(Simple v) {
    		this();
    		value = v;

    	}

    	@Override
		public String toString() {
			// both are null
			if ((left == null) && (right == null)) {
				return value + "->(" + left + "|" + right+")";
			}
			// neither are null
			if ((left != null) && (right != null)) {
				return value + "->(" + left.value + "|" + right.value+")";
			}
			// only left is null
			if ((left == null)) {
				return value + "->(" + left + "|" + right.value+")";
			}
			// only right is null
			return value + "->(" + left.value + "|" + right+")";
		}
    } // end class Node
} // end class List

