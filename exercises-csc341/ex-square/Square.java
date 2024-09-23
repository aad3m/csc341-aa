
public class Square implements Comparable<Square> {

    /* Instance variables */
    private int width;
    private int height;

    /* Default Constructor */
    public Square() {
        this.width = 1;
        this.height = 1;
    }

    /* Constructor with parameters */
    public Square(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /* toString method */
    public String toString() {
        return "[ " + width + " x " + height + " ]";
    }

    /* compareTo method */
    public int compareTo(Square s2) {
        int squareArea1 = this.width * this.height;
        int squareArea2 = s2.width * s2.height;
        return squareArea1 - squareArea2;
    }

}