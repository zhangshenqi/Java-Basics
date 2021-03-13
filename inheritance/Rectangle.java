/**
 * Class for rectangle.
 * @author Shenqi Zhang
 *
 */
public class Rectangle extends Shape {
    /**
     * Number of rectangles.
     */
    private static int numRectangles = 0;
    
    /**
     * Gets the number of rectangles.
     * @return number of rectangles
     */
    public static int getNumRectangles() {
        return numRectangles;
    }
    
    /**
     * Id of this rectangle.
     */
    private final int idRectangle;
    /**
     * Length of this rectangle.
     */
    private double length;
    /**
     * Width of this rectangle.
     */
    private double width;
    
    /**
     * Constructs a rectangle with specified length and width.
     * @param length length of this rectangle
     * @param width width of this rectangle
     */
    public Rectangle(double length, double width) {
        idRectangle = numRectangles;
        numRectangles++;
        setLength(length);
        setWidth(width);
    }
    
    /**
     * Gets the id of this rectangle.
     * @return id of this rectangle
     */
    public int getIdRectangle() {
        return idRectangle;
    }
    
    /**
     * Gets the length of this rectangle.
     * @return length of this rectangle
     */
    public double getLength() {
        return length;
    }
    
    /**
     * Gets the width of this rectangle.
     * @return width of this rectangle
     */
    public double getWidth() {
        return width;
    }
    
    /**
     * Sets the length of this rectangle.
     * @param length length of this rectangle
     */
    public void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Parameter must be positive!");
        }
        this.length = length;
    }
    
    /**
     * Sets the width of this rectangle.
     * @param width width of this rectangle
     */
    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Parameter must be positive!");
        }
        this.width = width;
    }
    
    /**
     * Gets the area of this rectangle.
     * @return area of this rectangle
     */
    @Override
    protected double getArea() {
        return length * width;
    }

    /**
     * Gets the circumference of this rectangle.
     * @return circumference of this rectangle
     */
    @Override
    protected double getCircumference() {
        return 2 * (length + width);
    }
    
    /**
     * Returns the string representation of this rectangle.
     * @return string representation of this rectangle
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("rectangle:");
        sb.append(" id = ").append(idRectangle);
        sb.append(" length = ").append(length);
        sb.append(" width = ").append(width);
        sb.append(" area = ").append(getArea());
        sb.append(" circumference = ").append(getCircumference());
        return sb.toString();
    }
    
    /**
     * Indicates whether some other object is "equal to" this rectangle.
     * @param obj the reference object with which to compare
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        
        Rectangle that = (Rectangle) obj;
        return this.length == that.length && this.width == that.width;
    }
}
