import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


/**
 * Manages user credentials and student information.
 */
public class Database {

	private Hasher hasher = null;

	private ArrayList<Credentials> users = new ArrayList<>();
	private ArrayList<Student> students = new ArrayList<>();
	
	public Database(Hasher h) {
		hasher = h;
		loadUsers();
		loadStudents();
	}

	/**
	 * Checks if credentials are valid
	 *
	 * @param username username to be validated
	 * @param password password to be validated
	 * @return true if valid credentials, false if invalid credentials
	*/
	public boolean valid(String username, String password) {
		// Traverse users ArrayList
		for (Credentials cr : users) {
			// Check if username matches
			if (cr.username().equals(username)){
				// Hash password
				String hashedPassword = hasher.hash(password);
				if (cr.password().equals(hashedPassword)){
					return true;
				} else {
					return false;
				}

			}
		}


		return false;
	}
	
	/** Open users file and load contents into member variables. */
	public void loadUsers() {
		users = new ArrayList<>();

		try {
			// Open users.txt file
			File file = new File("users.txt");
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				String[] parts = data.split(",");
				String username = parts[0];
				String hashedPassword = parts[1];
				// Put each line into new Credentials
				Credentials cr = new Credentials(username, hashedPassword);
				// Store in users array
				users.add(cr);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: Could not find file.");
			e.printStackTrace();
        }
    }

	/** Open students file and load contents. */
	public void loadStudents()
	{
		students = new ArrayList<>();
		try {
			// Open students.csv
			File file = new File("students.csv");
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				String[] parts = data.split(",");
				String username = parts[0];
				String name = parts[1];
				String major = parts[2];

				// Places all courses into a LinkedList
				LinkedList<String> courses = new LinkedList<>();
				for (int i = 3; i < parts.length; i++) {
					courses.add(parts[i]);
			}
			// Put each line into new Student
				Student st = new Student(username, name, major, courses);
			// Store in students array
				students.add(st);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: Could not find file.");
			e.printStackTrace();
		}
	}
	
	/** Get student given username.
	 * @param user username to be searched for
	 * @return student that matches user otherwise null
	 */
	public Student getStudent(String user) {
		for (Student student : students) {
			if (student.username().equals(user)) {
				return student;
			}
		}
        return null;
    }
}