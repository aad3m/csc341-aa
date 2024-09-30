class TestRecursion {

	// Ali, AbdiRashid, Armand

	public static void main(String[] args) {

		int[] A = { 5, 4, 3, 2, 1 };

		for (int i=0; i<A.length; i++) {
			System.out.println("sumUpTo("+i+")="+sumUpTo(A,i));
		}

		System.out.println("All sum = "+sumRange(A,0,A.length-1));
		System.out.println("A[2..4] sum = "+sumRange(A,2,4));

		System.out.println("All sum = "+sumSubarray(A,0,A.length-1));
		System.out.println("A[1..3] sum = "+sumSubarray(A,1,3));
	}

	/*** ----- DO NOT FORGET TO HAVE A STOPPING CONDITION!    ****/

	/** Create a recursive algorithm to sum up to index n **/
	// The recursive call to sumUpTo should be modifying the "end" value
	public static int sumUpTo(int[] A, int end) {
		if (end == 0) {
			return 0;
		}
		else {
			return A[end]+sumUpTo(A,end-1);
		}
	}

	/** Create a recursive algorithm to sum from start to end index */
	// In this version, the recursive call should be modifying both start and end.
	public static int sumRange(int[] A, int start, int end) {
		if (start >= end){
			return 0;
		}
		else {
			return A[start]+A[end]+sumRange(A,start+1,end-1);
		}

	}

	/** Create a recursive algorithm to sum from start to end index */
	// In this version, split the array into 2 subarrays.
	// You should have 2 recursive calls.
	public static int sumSubarray(int[] A, int start, int end) {
		int mid = (end+start)/2;
		if (start == end) {
			return 0;
		}
		else {
			return sumSubarray(A,start+1,mid) + sumSubarray(A,mid,end-1);
		}
	}

}
