/**
 * Class for rectangle.
 * @author Shenqi Zhang
 *
 */
public class Rectangle implements Shape {
    /**
     * Length of this rectangle.
     */
    private final double length;
    /**
     * Width of this rectangle.
     */
    private final double width;
    
    /**
     * Constructs a rectangle with specified length and width.
     * @param length length of this rectangle
     * @param width width of this rectangle
     */
    public Rectangle(double length, double width) {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Parameter must be positive!");
        }
        this.length = length;
        this.width = width;
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
     * Gets the area of this rectangle.
     * @return area of this rectangle
     */
    @Override
    public double getArea() {
        return length * width;
    }

    /**
     * Gets the circumference of this rectangle.
     * @return circumference of this rectangle
     */
    @Override
    public double getCircumference() {
        return 2 * (length + width);
    }
    
    /**
     * Returns the string representation of this rectangle.
     * @return string representation of this rectangle
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("rectangle:");
        sb.append(" length = ").append(length);
        sb.append(" width = ").append(width);
        sb.append(" area = ").append(getArea());
        sb.append(" circumference = ").append(getCircumference());
        return sb.toString();
    }
}
