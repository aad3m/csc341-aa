public class TestReplace extends Assert {

	static Auggie s0 = AuggieFactory.makeAuggie("s00");
	static Auggie s1 = AuggieFactory.makeAuggie("s01");
	static Auggie s2 = AuggieFactory.makeAuggie("s02");
	static Auggie s3 = AuggieFactory.makeAuggie("s03");
	static Auggie s4 = AuggieFactory.makeAuggie("s04");

	public static void assertEquals(Auggie expect, Auggie result, String msg) {
		boolean match = true;
		// First test for nulls to avoid Exceptions
		if ((null==expect) && (null!=result)) {
			match = false;
		} else if ((null==expect) && (null==result)) {
			match = true;
		} else {
			match = (expect.equals(result));
		}
		if (!match) {
			System.out.println(msg+".\n   Expect "+expect+".\n   Result "+result);
		}}

	public static void main(String[] args) {

		System.out.println("______________________________________");
		System.out.println("Testing Enhanced List");
		System.out.println("______________________________________");

		System.out.println("______________________________________");
		System.out.println("Sanity Check -- Testing Constructors");

		try{
			AuggiesList list = new AuggiesList(100);
			AuggiesList list2 = new AuggiesList();
			list.isFull();
			list.isEmpty();
			list.isValid(1);
			assertEquals(100, list.capacity(), "Test failed for length");
			assertEquals(0, list.size(), "Test failed for size");
			assertEquals(200, list2.capacity(), "Test failed for length");
			assertEquals(0, list2.size(), "Test failed for size");

		} catch (Exception e) {
			System.out.println("Sanity Check FAILED ... DO NOT PROCEED.");
			e.printStackTrace();
		}
		System.out.println("Sanity Check Complete!");

		System.out.println("______________________________________");
		System.out.println("Testing Replace:");

		try {
			System.out.println("\tReplace first element");
			AuggiesList list = new AuggiesList(20);
			list.add(s0);
			list.add(s1);
			list.add(s2);
			list.replace(list.get(0), s3);
			assertEquals(s3, list.get(0), "Test failed for replace first element");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			System.out.println("\tReplace last element");
			AuggiesList list = new AuggiesList(20);
			list.add(s0);
			list.add(s1);
			list.add(s2);
			int last = list.size()-1;
			list.replace(list.get(last), s4);
			assertEquals(s4, list.get(last), "Test failed for replace last element");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			System.out.println("\tReplace middle element");
			AuggiesList list = new AuggiesList(20);
			list.add(s0);
			list.add(s1);
			list.add(s2);
			int middle = list.size()/2;
			list.replace(list.get(middle), s3);
			assertEquals(s3, list.get(middle), "Test failed for replace middle element");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			System.out.println("\tReplace non-existent Auggie");
			AuggiesList list = new AuggiesList(20);
			list.add(s0);
			list.add(s1);
			list.add(s2);
			list.replace(s3, s1);
			System.out.println("\t Test failed for replace non-existent Auggie");
		} catch (Exception e) {
			System.out.println();
		}
		System.out.println("Replace Tests Complete!");
		System.out.println("______________________________________");
		System.out.println("All Tests Complete!");

	}
}