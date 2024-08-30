/** Stores the credentials of a user namely username and password. 
*/
public class Credentials {

	private String username;
	/** The second value of the pair */
	private String password;

	/** Constructor with values to add.
	 * 
	 * @param username for verifying login credentials
	 * @param password for username for login. It is a hashed password.
	 */
	public Credentials(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return username+", "+password;
	}
	

	/** Reset the password (setter)
	*
	* @param newpwd New hashed password.
	*/
	public void reset(String newpwd) {
		password = newpwd;
	}
	
	// Getters
	String username() {
		return username;
	}
	String password() {
		return password;
	}
	

}

