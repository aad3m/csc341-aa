import java.lang.reflect.*;
import java.util.Scanner;
import java.io.*;

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
		
		System.out.println("______________________________________");
		System.out.println("Testing Vector.length");
		
		System.out.println("______________________________________");
		System.out.println("Testing Vector.add");
		
		System.out.println("______________________________________");
		System.out.println("Testing Vector.dot");		
	
	}
}