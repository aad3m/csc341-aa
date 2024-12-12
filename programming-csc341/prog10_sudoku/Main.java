
public class Main {

    // Collection of puzzles for testing
    static Integer[][] easy4x4 = {
		{0,3,4,0},
		{4,0,0,2},
		{1,0,0,3},
		{0,2,1,0}
	};
	static Integer[][] easy6x6 = {
		{0,0,3,0,1,0},
		{5,6,0,3,2,0},
		{0,5,4,2,0,3},
		{2,0,6,4,5,0},
		{0,1,2,0,4,5},
		{0,4,0,1,0,0}
	};
	static Integer[][] medium6x6 = {
		{2,6,0,5,0,1},
		{0,0,1,0,0,2},
		{4,0,0,0,6,0},
		{0,3,0,0,0,4},
		{1,0,0,4,0,0},
		{3,0,4,0,2,6}
	};
	static Integer[][] easy9x9 = {
		{0,1,0,6,0,0,0,9,0},
		{0,0,0,2,0,0,3,8,0},
		{0,3,8,0,4,0,0,0,0},
		{0,0,0,0,0,3,0,2,6},
		{9,6,1,0,0,5,0,7,0},
		{0,8,0,0,0,4,0,0,5},
		{0,0,0,9,0,1,6,0,0},
		{0,0,5,0,0,0,2,3,0},
		{7,4,0,0,8,0,0,0,0}
	};

	public static void main(String[] args) {

		// Use one of the boards defined above (or create your own)
		Board puzzle = new Board(easy9x9);
		System.out.println(puzzle);

		// Build a search tree to brute force the solution
		SudokuTree tree = new SudokuTree(puzzle);
		Node<Board> root = tree.root();

		System.out.println(root.value());
		System.out.println();
		for (Node<Board> n : root.children()) {
			System.out.println(n.value());
			System.out.println();
		}

		// Use BFS or DFS to find solution in tree
        solveSudoku(tree);


	} // end main

	public static void testSearch() {
        // Create a small test tree with known structure and Integer values
        Node<Integer> root = new Node<>(1);
        Node<Integer> child1 = new Node<>(2);
        Node<Integer> child2 = new Node<>(3);
        Node<Integer> child3 = new Node<>(4);
        root.addChild(child1);
        root.addChild(child2);
        child1.addChild(child3);

        // Perform BFS
        System.out.println("BFS:");
        Queue<Node<Integer>> queue = new Queue<>(10);
        queue.push(root);
        int maxQueueSize = 0;
        while (!queue.isEmpty()) {
            Node<Integer> node = queue.pop();
            System.out.println(node.value());
            maxQueueSize = Math.max(maxQueueSize, queue.getSize());
            for (Node<Integer> child : node.children()) {
                queue.push(child);
            }
        }
        System.out.println("Max Queue Size: " + maxQueueSize);

        // Perform DFS
        System.out.println("DFS:");
        Stack<Node<Integer>> stack = new Stack<>(10);
        stack.push(root);
        int maxStackSize = 0;
        while (!stack.isEmpty()) {
            Node<Integer> node = stack.pop();
            System.out.println(node.value());
            maxStackSize = Math.max(maxStackSize, stack.getSize());
            for (Node<Integer> child : node.children()) {
                stack.push(child);
            }
        }
        System.out.println("Max Stack Size: " + maxStackSize);
    } // end testSearch

	public static void solveSudoku(SudokuTree tree) {
    // Choose search strategy: BFS or DFS
    boolean useBFS = false; // Set to false for DFS

    System.out.println("Solving Sudoku with " + (useBFS ? "BFS" : "DFS") + ":");
    Queue<Node<Board>> queue = new Queue<>(100);
    Stack<Node<Board>> stack = new Stack<>(100);

	// Add the root node to the queue or stack
    if (useBFS) {
        queue.push(tree.root());
    } else {
        stack.push(tree.root());
    }

    int visitedNodes = 0;
    int maxSize = 0;

	// Loop until the queue or stack is empty
    while (!queue.isEmpty() || !stack.isEmpty()) {
        Node<Board> node;

		// Pop the next node from the queue or stack
        if (useBFS) {
            node = queue.pop();
        } else {
            node = stack.pop();
        }
        visitedNodes++;

		// Check if the current node is a solution
        if (node.value().isComplete()) {
            System.out.println("Solution found:");
            System.out.println(node.value());
            break;
        }

        // Update the maximum size of the queue or stack
        if (useBFS) {
            if (queue.getSize() > maxSize) {
                maxSize = queue.getSize();
            }
        } else {
            if (stack.getSize() > maxSize) {
                maxSize = stack.getSize();
            }
        }

		// Add children to the queue or stack
        for (Node<Board> child : node.children()) {
            if (useBFS) {
                queue.push(child);
            } else {
                stack.push(child);
            }
        }
    }

    System.out.println("Visited Nodes: " + visitedNodes);
    System.out.println("Max Queue/Stack Size: " + maxSize);
	} // end solveSudoku
} // end class Main
