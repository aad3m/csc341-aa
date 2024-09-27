import java.util.Comparator;

public class Main {

	// Define comparator and then instantiate.
	// 1. Area (OrderArea orderArea)
	// 2. Area in reverse order (OrderAreaRev orderAreaRev)
	// 3. Color (OrderColor orderColor)
	
	
	public static class OrderArea implements Comparator<Square> {
		public int compare(Square s1, Square s2) {
			return 0;
		}
	}

	public static void main(String[] args) {
	
		// Square(width, height, color)
		Square s1 = new Square(10,5,Color.RED);
		Square s2 = new Square(20,5,Color.BLUE);
		Square s3 = s1;
		Square s4 = new Square(10,5,Color.RED);
		Square s5 = new Square(10,15,Color.BLACK);
		
		// ___________________________________________________________
		// Compare s1 to s3 testing for equality
		// use ==, .equals, and compareTo
		System.out.println("Comparing s1 to s3 for equality.");
		System.out.println("	Using ==: " + (s1 == s3));
		System.out.println("	Using .equals: " + s1.equals(s3));
		System.out.println("	Using compareTo: " + s1.compareTo(s3));
		
		// Print your results using a similar format shown here
		System.out.println("	" + s1+" == "+s3+" is " + (s1==s3));
		
		// Compare s1 to s4 testing for equality
		// use ==, .equals, and compareTo
		System.out.println("\nComparing s1 to s4 for equality.");
		System.out.println("	Using ==: " + (s1 == s4));
		System.out.println("	Using .equals: " + s1.equals(s4));
		System.out.println("	Using compareTo: " + s1.compareTo(s4));

		// _______________________________________________________
		// Print the value of comparing s1 to s2
		System.out.println("\nComparing s1 to s2: " + s1.compareTo(s2));
		// Print the value of comparing s2 to s1
		System.out.println("Comparing s2 to s1: " + s2.compareTo(s1));
		// Print s1 and s2 in order (using an if-statement with compareTo)
		System.out.println("\nORDER Based on width - using compareTo.");
		if (s1.compareTo(s2) < 0) {
			System.out.println(s2 + "" + s1);
		}
		else {
			System.out.println(s1 + "" + s2);
		}
		// _______________________________________________________
		// Modify compareTo to go from max to min
		// Print s1 and s2 in order (using an if-statement with compareTo)
		System.out.println("\nORDER Based on width - using compareTo.");
		
		// Be sure to switch it back so that it matches equals.
		
		// _______________________________________________________
		// Print s1, s2 in order based on area (from min to max)
		System.out.println("\nORDER Based on area (min to max) - using compare.");

		Comparator<Square> OrderArea = new Comparator<Square>() {
			@Override
			public int compare(Square sq1, Square sq2) {
				return sq1.compareTo(sq2);
			}
		};
		if (s1.compareTo(s2) < 0) {
			System.out.println(s1 + "" + s2);
		}
		else {
			System.out.println(s2 + "" + s1);
		}

		// _______________________________________________________
		// Print s1, s2 in order based on area (from MAX to MIN)
		System.out.println("\nORDER Based on area (max to min) - using compare.");
		
		// _______________________________________________________
		// Print the value of comparing c1 to c2
		// Print s1, s2 in order based on color (using an if-statement)
		System.out.println("\nORDER Based on color - using compare.");
		
		// Define and instantiate in one statement for this
		// Height (with width as tie-breaker) (orderHeight)
		// Comparator<Square> orderHeight ...
		
		// _______________________________________________________
		// Print s1, s5 in order based on height (from min to max) 
		//    with width (from min to max) as tie-breaker
		System.out.println("\nORDER Based on height with width as tie-breaker - using compare.");
	
	
	} // end main()

} // end class Main