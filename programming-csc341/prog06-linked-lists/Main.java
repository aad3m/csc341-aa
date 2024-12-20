public class Main {
	public static void main(String[] args) {
	
		AuggiesList alist = new AuggiesList();
		
		Auggie a1 = new Auggie();
		a1.username("a1");
		Auggie a2 = new Auggie();
		a2.username("a2");
		Auggie a3 = new Auggie();
		a3.username("a3");
		Auggie a4 = new Auggie();
		a4.username("a4");
		Auggie a5 = new Auggie();
		a5.username("a5");
		Auggie z = new Auggie();
		
		alist.add(a1);
		alist.add(a2);
		alist.add(a3);
		alist.add(a4);
		alist.add(a5);
		println(alist);
		
		
		try {
			println("Head "+alist.peekFirst().toString());
			println("Tail "+alist.peekLast().toString());
			alist.add(a3,1);
			println(alist);
			println("Head "+alist.peekFirst().toString());
			println("Tail "+alist.peekLast().toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		try {
			println(alist.find(a1));
			println(alist.find(a3));
			println(alist.find(a5));
			println(alist.find(z));
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			println(alist.get(0));
			println(alist.get(1));
			println(alist.get(2));
			println(alist.get(3));
		} catch (Exception e) {
            e.printStackTrace();
        }

        try {
			println("Head "+alist.peekFirst().toString());
			println("Tail "+alist.peekLast().toString());
			println("\nRemoving "+(alist.remove(5)).toString());
			println(alist);
			println("Head "+alist.peekFirst().toString());
			println("Tail "+alist.peekLast().toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			Auggie[] array = alist.toArray();
			for (Auggie a : array) {
				System.out.println(a);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			alist.remove(a1);
			alist.remove(a3);
			println(alist);
		} catch (Exception e) {
			e.printStackTrace();
		}



	}
	
	public static void println(Object o) {
		System.out.println(o.toString());
	}
	public static void print(Object o) {
		System.out.print(o.toString());
	}
}