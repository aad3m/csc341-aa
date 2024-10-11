import java.util.*;

public class TestBinSearch {

	static Auggie a0 = AuggieFactory.makeAuggie("a00");
	static Auggie b1 = AuggieFactory.makeAuggie("b01");
	static Auggie c2 = AuggieFactory.makeAuggie("c02");
	static Auggie d3 = AuggieFactory.makeAuggie("d03");
	static Auggie e4 = AuggieFactory.makeAuggie("e04");
	static Auggie a1 = AuggieFactory.makeAuggie("a01");
	static Auggie z1 = AuggieFactory.makeAuggie("z01");
	
	/** Comparator for testing purposes. */
	private static Comparator<Auggie> orderCompareTo = new Comparator<Auggie>() {
    	@Override
    	public int compare(Auggie a1, Auggie a2) {
        	return a1.compareTo(a2);
    	}
	};

	public static void main(String[] args) {

		// Code can be verified with this test file through visual inspection.

		// _____________________________________________________________
		// Test constructors
		try {
			AuggiesList list1 = new AuggiesList();
			AuggiesList list2 = new AuggiesList(10);
			AuggiesList list3 = new AuggiesList(orderCompareTo);
			AuggiesList list4 = new AuggiesList(orderCompareTo, 10);	
		} catch (Exception e) {
			System.out.println("ERROR: Constructors are not working.");
			System.out.println("No reason to continue to test until it is fixed.");
			e.printStackTrace();
			return;
		}
		
		// _____________________________________________________________
		// Is add working with default ordering?
		AuggiesList alist = new AuggiesList(10);
		try {
			alist.add(c2);
			alist.add(b1);
			alist.add(a0);
			alist.add(e4);
			alist.add(d3);
		} catch(Exception e) {
			System.out.println("ERROR: Add is not working.");
			System.out.println("Go fix it!");
			e.printStackTrace();
			return;
		}
		
		// These should print in order a0, b1, ...
		System.out.println("Added with default ordering of username.");
		System.out.println("Expect a0, b1, ...");
		System.out.println(alist);
		
		// _____________________________________________________________
		// Is Binary Search working?
		Auggie[] aus = {a0,b1,c2,d3,e4};
		System.out.println("Searching for a0, b1, ...");
		System.out.println("Expect to see 0 1 2 ...");
		for (int i=0; i<aus.length; i++) {
			try {
				System.out.print(alist.find(aus[i])+" ");
			} catch (Exception e) {
				System.out.println();
				System.out.println("ERROR: Just crashed on find("+aus[i]+")");
				System.out.println("Testing on pause until you fix it.");
				e.printStackTrace();
				return;
			}
		}
		System.out.println();
		
		// And one more search for something not there
		try {
			System.out.print("Search for something not there.");
			System.out.println(" Should be -1 -1");
			System.out.println("Returned "+alist.find(a1)+" "+alist.find(z1));
		} catch(Exception e) {
			System.out.println("ERROR: Crashing on something not there");
			e.printStackTrace();
		}
		
		// _____________________________________________________________
		// Is add working with different ordering?
		AuggiesList rlist = new AuggiesList(Ordering.orderRole,10);
		try {
			rlist.add(c2);
			rlist.add(b1);
			rlist.add(a0);
			rlist.add(e4);
			rlist.add(d3);
		} catch(Exception e) {
			System.out.println("ERROR: Add with role ordering is not working.");
			System.out.println("Go fix it!");
			e.printStackTrace();
			return;
		}
		
		// These should print in order a0, b1, ...
		System.out.println("\n\nAdded with role-username ordering.");
		System.out.println("Expect student - staff - faculty");
		System.out.println(rlist);
		
		// _____________________________________________________________
		// Is Binary Search working with different ordering?
		System.out.println("Searching for a0, b1, ...");
		System.out.println("Not sure what will be there -- role is randomized");
		System.out.println("but you can tell from the above list.");
		for (int i=0; i<aus.length; i++) {
			try {
				System.out.print(rlist.find(aus[i])+" ");
			} catch (Exception e) {
				System.out.println();
				System.out.println("ERROR: Just crashed on find("+aus[i]+")");
				System.out.println("Testing on pause until you fix it.");
				e.printStackTrace();
				return;
			}
		}
		System.out.println();
		
		// And one more find for something not there
		try {
			System.out.print("Search for something not there.");
			System.out.println(" Should be -1 -1");
			System.out.println("Returned "+rlist.find(a1)+" "+rlist.find(z1));
		} catch(Exception e) {
			System.out.println("ERROR: Crashing on something not there");
			e.printStackTrace();
		}
		
		// _____________________________________________________________
		// How is that sublist working?
		AuggiesList blist = new AuggiesList(10);
		try {
			blist.add(a1);
			blist.add(b1);
			blist.add(c2);
			blist.add(d3);
			blist.add(e4);
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}
		
		Auggie[] sublist = null;

		try {
			// Takes the middle of the list b1 to d3
			sublist = blist.sublist(a1,e4);
			System.out.println("\nsublist expect b1 c2 d3");
			for (Auggie a : sublist) {
				System.out.println(a);
			}
		
			// Takes the first to middle
			sublist = blist.sublist(a0,d3);
			System.out.println("\nsublist expect a1 b1 c2");
			for (Auggie a : sublist) {
				System.out.println(a);
			}
		
			// Takes the middle to last
			sublist = blist.sublist(c2,z1);
			System.out.println("\nsublist expect d3 e4");
			for (Auggie a : sublist) {
				System.out.println(a);
			}
		
			// Takes none of the list
			sublist = blist.sublist(a0,a1);
			System.out.println("\nsublist range before [0] - expect nothing.");
			for (Auggie a : sublist) {
				System.out.println(a);
			}
		
			sublist = blist.sublist(e4,z1);
			System.out.println("\nsublist range after end - expect nothing.");
			for (Auggie a : sublist) {
				System.out.println(a);
			}
			System.out.println();
			
		} catch (Exception e) {
			System.out.println("\nsomething awry with sublists.");
			e.printStackTrace();
		}

		System.out.println("------------------------------");

		AuggiesList clist = new AuggiesList();
		Comparator<Auggie> comparatorLast = Comparator.comparing(Auggie::last);
		Comparator<Auggie> comparatorFirst = Comparator.comparing(Auggie::first);
		try	{
			clist.add(c2);
			clist.add(b1);
			clist.add(a0);
			clist.add(e4);
			clist.add(d3);

			System.out.println("List of Auggies:");
			for (int i = 0; i < clist.size(); i++) {
				System.out.println(i+1 + ". " + clist.get(i));
			}
		} catch(Exception e) {
			System.out.println("Error: Adding to List Failed!");
			e.printStackTrace();
		}

		System.out.println("\n\033[0;1mTest Ordering Methods:\033[0m");
		System.out.println("Happy Path:");
		try {
			System.out.println("First: " + clist.min());
			System.out.println("Last: " + clist.max());
			System.out.println("First By Last Name: " + clist.min(comparatorLast));
			System.out.println("Last By Last Name: " + clist.max(comparatorLast));
			System.out.println("Max and Min Passed!");

			clist.reorder(comparatorLast);
			System.out.println("\nReordered by Last:");
			for (int i = 0; i < clist.size(); i++) {
				System.out.println(i+1 + ". " + clist.get(i));
			}
			clist.reorder(comparatorFirst);
			System.out.println("Reordered by First:");
			for (int i = 0; i < clist.size(); i++) {
				System.out.println(i+1 + ". " + clist.get(i));
			}
			System.out.println("Reorder Passed!"); // Determined by visual inspection
		} catch(Exception e) {
			System.out.println("Error: Tests Failed!");
			e.printStackTrace();
		}

		System.out.println("\nSad Path:");
		AuggiesList dlist = new AuggiesList();
		try {
			System.out.println("First: " + dlist.min());
			System.out.println("Last: " + dlist.max());
			System.out.println("First By Last Name: " + dlist.min(comparatorLast));
			System.out.println("Last By Last Name: " + dlist.max(comparatorLast));
			dlist.reorder(comparatorLast);
			dlist.reorder(comparatorFirst);
		} catch(Exception e) {
			System.out.println("Passed - List is Empty!"); // Should throw exception
		}

		System.out.println("\n\033[0;1mTest Convert Methods:\033[0m");
		System.out.println("Happy Path:");
		try {
			Auggie[] clistLast = clist.toArray(comparatorLast);
			System.out.println("toArray by Last:");
			for (int i = 0; i < clistLast.length; i++) {
				System.out.println(i+1 + ". " + clistLast[i]);
			}
			Auggie[] clistFirst = clist.toArray(comparatorFirst);
			System.out.println("toArray by First:");
			for (int i = 0; i < clistFirst.length; i++) {
				System.out.println(i+1 + ". " + clistFirst[i]);
			}
			System.out.println("Convert Passed!"); // Determined by visual inspection

		} catch (Exception e) {
			System.out.println("Error: Convert Failed!");
			e.printStackTrace();
		}

		try {
			ArrayList<Auggie> clistF = clist.query(Role.FACULTY);
			System.out.println("\nQuery by Faculty:");
			for (int i = 0; i < clistF.size(); i++) {
				System.out.println(i+1 + ". " + clistF.get(i));
			}
			ArrayList<Auggie> clistS = clist.query(Role.STUDENT);
			System.out.println("Query by Student:");
			for (int i = 0; i < clistS.size(); i++) {
				System.out.println(i+1 + ". " + clistS.get(i));
			}
			ArrayList<Auggie> clistP = clist.query(Role.STAFF);
			System.out.println("Query by Staff:");
			for (int i = 0; i < clistP.size(); i++) {
				System.out.println(i+1 + ". " + clistP.get(i));
			}
			System.out.println("Query Passed!"); // Determined by visual inspection

		} catch (Exception e) {
			System.out.println("Error: Query Failed!");
			e.printStackTrace();
		}

		System.out.println("\n\033[0;1mTest Binary Search Method:\033[0m");
		System.out.println("Happy Path:");
		try {
			System.out.println("Binary Search for a0: " + clist.findRecursive(a0));
			System.out.println("Binary Search for b1: " + clist.findRecursive(b1));
			System.out.println("Binary Search for c2: " + clist.findRecursive(c2));
			System.out.println("Binary Search for d3: " + clist.findRecursive(d3));
			System.out.println("Binary Search for e4: " + clist.findRecursive(e4));
			System.out.println("Binary Search Passed!"); // Determined by visual inspection
		} catch (Exception e) {
			System.out.println("Error: Binary Search Failed!");
			e.printStackTrace();
		}

		System.out.println("\nSad Path:");
		try {
			System.out.println("Binary Search for z1: " + clist.findRecursive(z1)); // Should be -1
			System.out.println("Binary Search for a1: " + clist.findRecursive(a1)); // Should be -1
			System.out.println("Binary Search Passed!");
		} catch (Exception e) {
			System.out.println("Error: Binary Search Failed!");
			e.printStackTrace();
		}








	}
}
