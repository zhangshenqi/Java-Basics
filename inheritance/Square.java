/**
 * Class for square.
 * @author Shenqi Zhang
 *
 */
public class Square extends Rectangle {
    /**
     * Static variable to keep track of the number of squares.
     */
    private static int numSquares = 0;
    
    /**
     * Static method to get the number of squares.
     * @return number of squares
     */
    public static int getNumSquares() {
        return numSquares;
    }
    
    /**
     * Id of this square.
     */
    private final int idSquare;
    
    /**
     * Constructor with side.
     * @param side side of this square
     */
    public Square(double side) {
        super(side, side);
        idSquare = numSquares;
        numSquares++;
    }
    
    /**
     * Get the id of this square.
     * @return id of this square
     */
    public int getIdSquare() {
        return idSquare;
    }
    
    /**
     * Get the side of this square.
     * @return side of this square
     */
    public double getSide() {
        return getLength();
    }
    
    /**
     * Set the side of this square.
     * @param side side of this square
     */
    public void setSide(double side) {
        setLength(side);
        setWidth(side);
    }
    
    /**
     * Return the string representation of this square.
     * @return string representation of this square
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("square:");
        sb.append(" id = ").append(idSquare);
        sb.append(" side = ").append(getSide());
        sb.append(" area = ").append(getArea());
        sb.append(" circumference = ").append(getCircumference());
        return sb.toString();
    }
}
