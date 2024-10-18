/** Homegrown assert class to demostrate testing.
Formal testing frameworks provide this functionality, but this makes the process transparent to students.
Generics could be used here (but you haven't learned about those yet).
Note that Java has a built in "assert" that will end the program if the
input values do not match. For our purpose, we want error messages only with
continued execution.
@author Amy C. Larson
*/
public class Assert {

	/** Testing expected against result of type Double.
	@param expect value that the method is expected to produce.
	@param result value that the method actually produced.
	@param threshold a tolerated difference between the 2 values.
	@param msg error message meant to describe the error
	*/
	public static int assertEquals(
	Double expect, Double result, Double threshold, String msg) {
		boolean match = true;
		// First test for nulls to avoid Exceptions
		if ((null==expect) && (null!=result)) {
			match = false;
		} else if ((null==expect) && (null==result)) {
			match = true;
		} else if (Math.abs(expect - result) > threshold) {
			match = false;
		}
		if (!match) {
			System.out.println(msg+".\n   Expect "+expect+".\n   Result "+result);
			return 0;
		}
		return 1;
	} // end assertEquals (Double)


	/** Testing expected against result of type Integer.
	@param expect value that the method is expected to produce.
	@param result value that the method actually produced.
	@param msg error message meant to describe the error
	*/
	public static int assertEquals(Integer expect, Integer result, String msg) {
		boolean match = true;
		// First test for nulls to avoid Exceptions
		if ((null==expect) && (null!=result)) {
			match = false;
		} else if ((null==expect) && (null==result)) {
			match = true;
		} else if (expect != result) {
			match = false;
		}
		if (!match) {
			System.out.println(msg+".\n   Expect "+expect+".\n   Result "+result);
			return 0;
		}
		return 1;
	} // end assertEquals (Integer)
	
	/** Testing expected against result of type int.
	@param expect value that the method is expected to produce.
	@param result value that the method actually produced.
	@param msg error message meant to describe the error
	*/
	public static int assertEquals(int expect, int result, String msg) {
		// Integer type should not come through, so no null values
		boolean match = (expect == result);
		if (!match) {
			System.out.println(msg+".\n   Expect "+expect+".\n   Result "+result);
			return 0;
		}
		return 1;
	} // end assertEquals (Integer)


	/** Testing expected against result of type String.
	@param expect value that the method is expected to produce.
	@param result value that the method actually produced.
	@param msg error message meant to describe the error
	*/
	public static int assertEquals(String expect, String result, String msg) {
		boolean match = true;
		// First test for nulls to avoid Exceptions
		if ((null==expect) && (null!=result)) {
			match = false;
		} else if ((null==expect) && (null==result)) {
			match = true;
		} else if (!expect.equals(result)) {
			match = false;
		}
		if (!match) {
			System.out.println(msg+".\n   Expect "+expect+".\n   Result "+result);
			return 0;
		}
		return 1;
	} // end assertEquals (String)


	/** Testing expected against result of type Boolean.
	@param expect value to match
	@param result value for comparison.
	@param msg error message if test fails
	*/
	static int assertEquals(Boolean expect, Boolean result, String msg) {
		if (expect != result) {
			System.out.println("ERROR: "+msg+".\n   Expected "+expect+".\n   Result "+result);
			return 0;
		}
		return 1;
	}

} // end class Assert