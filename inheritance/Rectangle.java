/**
 * Class for rectangle.
 * @author Shenqi Zhang
 *
 */
public class Rectangle extends Shape {
    /**
     * Static variable to keep track of the number of rectangles.
     */
    private static int numRectangles = 0;
    
    /**
     * Static method to get the number of rectangles.
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
     * Constructor with length and width.
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
     * Get the id of this rectangle.
     * @return id of this rectangle
     */
    public int getIdRectangle() {
        return idRectangle;
    }
    
    /**
     * Get the length of this rectangle.
     * @return length of this rectangle
     */
    public double getLength() {
        return length;
    }
    
    /**
     * Get the width of this rectangle.
     * @return width of this rectangle
     */
    public double getWidth() {
        return width;
    }
    
    /**
     * Set the length of this rectangle.
     * @param length length of this rectangle
     */
    public void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Parameter must be positive!");
        }
        this.length = length;
    }
    
    /**
     * Set the width of this rectangle.
     * @param width width of this rectangle
     */
    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Parameter must be positive!");
        }
        this.width = width;
    }
    
    /**
     * Get the area of this rectangle.
     * @return area of this rectangle
     */
    @Override
    protected double getArea() {
        return length * width;
    }

    /**
     * Get the circumference of this rectangle.
     * @return circumference of this rectangle
     */
    @Override
    protected double getCircumference() {
        return 2 * (length + width);
    }
    
    /**
     * Return the string representation of this rectangle.
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
     * Indicate whether some other object is "equal" to this rectangle.
     * @param obj other object
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
