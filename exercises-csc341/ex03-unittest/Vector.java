public class Vector {
	
	/** coordinate along x-axis */
	private int x = 0;
	
	/** coordinate along y-axis */
	private int y = 0;
	
	/** Default constructor (unit vector along x-axis) */
	public Vector() {
		this(1,0);
	}
	
	/** Constructor with initial values
	@param inX x-coordinate
	@param inY y-coordinate
	*/
	public Vector(int inX, int inY) {
		x = inX;
		y = inY;
	}
	
	/** Length of vector (from 0,0 to x,y)
	@return length of the vector
	*/
	public double length() {
		// sqrt((x-x)^2 + (y-y)^2)
		return 0.0;
	}
	
	/** Add a vector to this 
	@param v2 vector to add to this
	@return vector that results from adding v2
	*/
	public Vector add(Vector v2) {
		// new vector with x+x, y+y
		return null;
	}
	
	/** dot product of a vector 
	@param v2 vector to multiply by
	@return result of the dot product 
	*/
	public int dot(Vector v2) {
		// the dot = x*x + y*y
		return 0;
	}
	
	// getters and setters
	public int x() { return x; }
	public void x(int v) { x = v; }
	
	public int y() { return y; }
	public void y(int v) { y = v; }
	
	
}