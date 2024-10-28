## Programming Assignment 8 Balanced Binary Search Trees

Part I and Part II DUE THURSDAY, November 7 <br>

<hr>

In this project, you will be building on the previous lab to create a List class that is implemented with a Binary Search Tree (BST). The primary focus will be on maintaining a balanced tree (but not with rotations).

Start with your BST part I completed, which should have the following:

- `void add(Simple value)`
- `String toString()`
- `int height()`
- `void adjustHeight(Node n)`
- `boolean contains(Simple simple)`
- `Simple min()`
- `Simple max()`
- `ArrayList<Simple> query(Sting value)`
- `Simple findFirst(Integer value)`
- `Simple[] toArray()`

<hr>

**If you cannot get your BST to function, please come to office hours.**

<hr>


## Requirements


#### IMPLEMENTATION: Additions and modifications of methods related to tree height and ordering.

- Add `private boolean balanced = true;`: This will be used as a flag to indicate that the tree is out of balance and the method balance needs to be called.

- Add `public boolean balanced()` : This is the getter for balanced. It is an implementation detail and should not really have a getter, but for testing purposes, please make this gettable.

- MODIFY `public void add(Simple simple)`: After calling `adjustHeight`, if the tree is `(!balanced)`, then call the `balance()` method.

- MODIFY `public void adjustHeight(Node n)`: As you are modifying the height, if at any point, the balance factor is >12, set `balanced = false` and return.

- Add `private void balance()`: Reorganize the tree so that it is balanced -- meaning the height of the tree is as minimal as possible. This method will be called if the tree is not balanced after adding a node. First, call toArray(), then use recursion to build the tree back up. In this method, you can either "hand-craft" the tree by setting the left and right subtree of each node, or by using your add method. If you use your add method, DO NOT CALL the balance() method, as you will be an infinite loop of trying to rebalance. Instead, use the balanced flag -- if it is set before you call adjustHeight in add, then you are in the process of rebalancing.  
	- **Note, if you are using your add, set the root to null before adding.**
	- **Note, reset balanced back to true when you are all done.**

- Add `public Simple[] toArray(Comparator<Simple> comp)`: Return an array in an order based on the specified comparator. Use your toArray() method, then sort the array (not the tree). **You MAY use Java's built-in sorting method for arrays.**

- Add `public void reorder(Comparator<Simple> comp)`: Set ordering. Use your toArray(comp) method to put everything into a reordered array, then use your recursive balance method to build the tree back up.

<hr>

#### IMPLEMENTATION: Additional methods related to search.

When removing nodes or rebalancing a tree, it can be useful to find the successor and predecessor of a given node. We are not using these methods in this implementation because we do not perform rotations or remove nodes, but it is a good exercise.

> Suggestion: draw a tree with various configurations and follow the below algorithms to make sure you understand how these algorithms find the successor and predecessor.

- Add `public Simple successor(Simple value)`.  _Normally, this would be private and probably return a Node, but then I couldn't test your code._ If it has no successor, return null.

  If right subtree is not NULL, then successor is the minimum of the right subtree.
  If right subtree is NULL, then successor is one of the ancestors (if it exists -- notice that if the node is the rightmost node, there is no successor). Travel up using the parent pointer until you see a node which is a left child of its parent. The successor is that child's parent.

- Add `public Simple predecessor(Simple value)`. _Normally, this would be private, but then I couldn't test it._ Again, might be useful to have a helper function that returns the Node with the given value. Then use the below algorithm to find its predecesor in the tree. If it has no predecessor, return null.

  If left subtree is not NULL, then predecessor is maximum value of the left subtree.
  If left subtree is NULL, the predecessor is an ancestor (if it exists -- notice that if the node is the leftmost node, there is no predecessor). Travel up the tree using parent pointers until you see a node that is the right child of its parent. The predecessor is that child's parent.
  
> It might be useful to create a helper get method that returns the node corresponding to a given Simple object. It would be called in the successor and predecessor functions. It can also be called in the contains method. 

<hr>

### Documentation
- Comment the code. Not too much, not too little.
- Style compliant.
- The Javadocs is not required for this assignment.

<hr>

### Testing

It is up to you to test your code and make sure it is meeting the requirements. I will not assess your tests.

