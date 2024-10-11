import java.util.*;

public class Ordering {

	// Define a comparator orderName that establishes an ordering
	// for Auggies based on their last name with the first name as tie-breaker.
	// Be sure to declare orderName as public static!
	public static Comparator<Auggie> orderName = new Comparator<Auggie>() {
		@Override
		public int compare(Auggie a1, Auggie a2) {
			if (a1.last().compareTo(a2.last()) == 0) {
				return a1.first().compareTo(a2.first());
			} else {
				return a1.last().compareTo(a2.last());
			}
		}
	};
	
	// Define a comparator orderRole that establishes an ordering
	// for Auggies based on their role with the username as a tie-breaker.
	// Be sure to declare orderRole as public static!	
	public static Comparator<Auggie> orderRole = new Comparator<Auggie>() {
		@Override
		public int compare(Auggie a1, Auggie a2) {
			if (a1.role().compareTo(a2.role()) == 0) {
				return a1.username().compareTo(a2.username());
			} else {
			return a1.role().compareTo(a2.role());
			}
		}
	};


	
	public static void main(String[] args) {
	
		// Creating an array to sort
		// Note this is for testing the comparators, not the AuggiesList
		ArrayList<Auggie> auggies = new ArrayList<>();
		
		Auggie a0 = AuggieFactory.makeAuggie("a00");
		Auggie b1 = AuggieFactory.makeAuggie("b01");
		Auggie c2 = AuggieFactory.makeAuggie("c02");
		Auggie d3 = AuggieFactory.makeAuggie("d03");
		Auggie e4 = AuggieFactory.makeAuggie("e04");
		
		// creating a tie to be broken
		a0.last("Larson"); a0.first("Nina");
		b1.last("Larson"); b1.first("Amy");
		
		// Test all your orderings.
		// First we will put in the array.
		
		auggies.add(c2);
		auggies.add(e4);
		auggies.add(b1);
		auggies.add(a0);
		auggies.add(d3);
		
		System.out.println("\nHere they are in added order");
		for (Auggie a: auggies) {
			System.out.println(a);
		}
		
		// Sort using the Collections.sort method for an ArrayList
		// this will use the Auggie.compareTo method for ordering
		Collections.sort(auggies);
		
		System.out.println("\nNow they should be in username order");
		for (Auggie a: auggies) {
			System.out.println(a);
		}
		
		// Sort using the .sort() for ArrayList with orderName as the argument.
		Collections.sort(auggies, orderName);
		
		System.out.println("\nNow they should be in last, first order");
		for (Auggie a: auggies) {
			System.out.println(a);
		}	
		
		// Sort using the .sort() for ArrayList with orderRole as the argument.
		Collections.sort(auggies, orderRole);
		
		System.out.println("\nNow they should be in role, username order");
		for (Auggie a: auggies) {
			System.out.println(a);
		}


	}
}
