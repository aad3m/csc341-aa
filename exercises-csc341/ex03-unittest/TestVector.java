import java.lang.reflect.*;
import java.util.Scanner;
import java.io.*;
import java.lang.Math;



public class TestVector extends Assert {

	
	public static void assertEquals(Vector expect, Vector result, String msg) {
		boolean match = true;
		// First test for nulls to avoid Exceptions
		if ((null==expect) && (null!=result)) {
			match = false;
		} else if ((null==expect) && (null==result)) {
			match = true;
		} else {
			match = (expect.x()==expect.x() && expect.y()==expect.y());
		}
		if (!match) {
			System.out.println(msg+".\n   Expect "+expect+".\n   Result "+result);
		}}

	public static void main(String[] args) {
	
		System.out.println("______________________________________");
		System.out.println("Testing class Vector");
		System.out.println("______________________________________");
		
		System.out.println("______________________________________");
		System.out.println("Sanity Check -- Testing Constructors");
		try{
			Vector v = new Vector(1,2);
			Vector v2 = new Vector();
			v.x();
			v.y();
			v2.x();
			v2.y();
			assertEquals(1, v.x(), "Test failed for x");
			assertEquals(2, v.y(), "Test failed for y");
			assertEquals(1, v2.x(), "Test failed for x");
			assertEquals(0, v2.y(), "Test failed for y");

		} catch (Exception e) {
			System.out.println("Sanity Check FAILED ... DO NOT PROCEED.");
			e.printStackTrace();
		}
		System.out.println("Sanity Check Complete!");

		System.out.println("______________________________________");
		System.out.println("Testing Vector.length");
        {
            Vector v = new Vector(2,3);
            v.length();
            assertEquals(Math.sqrt(15), v.length(), .01, "Test failed for length");
        }

		// Test along x-axis
		Vector v = new Vector();
		assertEquals(5.0,v.length(),.01 ,"failed along x-axis");
		System.out.println("______________________________________");
		System.out.println("Testing Vector.add");
		
		System.out.println("______________________________________");
		System.out.println("Testing Vector.dot");		
	
	}
}