
public class Square implements Comparable<Square> {

    /* Member variables */
    private Integer width;
    private Integer height;
    private Color color;

    /* Default Constructor */
    public Square() {
        this.width = 1;
        this.height = 1;
        this.color = color.WHITE;

    }

    /* Constructor with parameters */
    public Square(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;

    }

    /* toString method */
    @Override
    public String toString() {
        return "[ " + width + " x " + height + " ]";
    }

    /* compareTo method */
    @Override
    public int compareTo(Square other) {
        int x = width.compareTo(other.width);
        if (x == 0){
            return height.compareTo(other.height);
        }
        else {
            return x;
        }
    }
     /* equals method */
    public boolean equals(Object other) {
        if (other instanceof Square) {
            Square otherSquare = (Square) other;
            return compareTo(otherSquare) == 0;
        }
        else {
            return true;
        }
    }

    public Integer getArea() {
        return width * height;
    }



}