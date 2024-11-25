## Programming Assignment 10 Solving Sudoku
## Breadth First (BFS) and Depth First Search (DFS)

### Due Wednesday, December 11 end-of-day
_Zip all files and submit via Moodle_

<hr>

In this project, you will create the ADT Queue and the ADT Stack using Java's basic array data structure, respectively. Both the Queue and Stack must implement the QueueInterface. These data structures are part of a previous in-class exercise.

see https://github.com/lars1050/csc341-f24/tree/main/exercises-csc341/ex08-queues

Also, you will complete the Search methods of Breadth-First Search and Depth-First Search of a tree. These search methods differ only in the type of queue that is used, namely BFS uses a FIFO Queue and DFS uses an LIFO Stack.

After you have completed your BFS and DFS, create a small test tree and output the results of a BFS and DFS to make sure you understand the structure of a tree, traversal of the tree using either BFS or DFS, and to test your code.

You will use your Queue and Stack to traverse a tree that represents a Sudoku puzzle (which has been provided). Each node can have 0 to 9 children, depending on the size of the puzzle and the constraints of the specific puzzle. Children are stored within the node in a `LinkedList<Node<Board>>`. While traversing the tree to find the solution, you will track the number of nodes visited to compare a BFS to a DFS. 

<hr>

### Implementation for Testing Tree Searches

Create a method `public static void testSearch()` in Main. In this method, create a small test tree with known structure and Integer values. Vary the number of children for each node within the tree, ranging from 0 to 3. Perform a BFS and DFS on the tree, printing each node value as it is removed from the queue (this is explained in more detail for the Sudoku puzzle below). Additionally, record the maximum number of elements on the Queue (or Stack) and print that value. Use this to make sure that your Queue and Stack are working. This will also insure that you know how to traverse a tree. 

### Implementation for Solving a Sudoku Puzzle

In the class Main, perform a Breadth-First-Search over the SudokuTree puzzle to find the solution. Start by placing the root of the tree in a Queue. In a while loop (until a solution is found), pop an element from the Queue, check if the value in the Node is a complete solution (board.isComplete()), and if so, **print the solution**. Keep track of the number of "visited" nodes, meaning count the total number of nodes pushed onto the queue. Also keep track of the maximum number of elements that are ever on the queue. **Print each of these statistics.**

Add exactly 1 line of code to the above to make it a Depth-First-Search. Instead of using a Queue, use a Stack. You can use one or the other by simply commenting out one of the 2 lines that declare a Queue and a Stack.


### Documentation

- Comment the code. Not too much, not too little.
- Style compliant.

<hr>

### Testing

It is up to you to test your code and make sure it is meeting the requirements. I will not assess your tests. 

