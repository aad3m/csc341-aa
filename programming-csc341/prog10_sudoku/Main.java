import java.util.*;

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
		Board puzzle = new Board(easy4x4);
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
		
	} // end main
} // end class Main
