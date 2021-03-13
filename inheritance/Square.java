/**
 * Class for square.
 * @author Shenqi Zhang
 *
 */
public class Square extends Rectangle {
    /**
     * Number of squares.
     */
    private static int numSquares = 0;
    
    /**
     * Gets the number of squares.
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
     * Constructs a square with specified side.
     * @param side side of this square
     */
    public Square(double side) {
        super(side, side);
        idSquare = numSquares;
        numSquares++;
    }
    
    /**
     * Gets the id of this square.
     * @return id of this square
     */
    public int getIdSquare() {
        return idSquare;
    }
    
    /**
     * Gets the side of this square.
     * @return side of this square
     */
    public double getSide() {
        return getLength();
    }
    
    /**
     * Sets the side of this square.
     * @param side side of this square
     */
    public void setSide(double side) {
        setLength(side);
        setWidth(side);
    }
    
    /**
     * Returns the string representation of this square.
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
