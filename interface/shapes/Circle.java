/**
 * Class for circle.
 * @author Shenqi Zhang
 *
 */
public class Circle implements Shape {
    /**
     * Radius of this circle.
     */
    private final double radius;
    
    /**
     * Constructs a circle with specified radius.
     * @param radius radius of this circle
     */
    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Parameter must be positive!");
        }
        this.radius = radius;
    }
    
    /**
     * Gets the radius of this circle.
     * @return radius of this circle
     */
    public double getRadius() {
        return radius;
    }
    
    /**
     * Gets the area of this circle.
     * @return area of this circle
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    /**
     * Gets the circumference of this circle.
     * @return circumference of this circle
     */
    @Override
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
    
    /**
     * Returns the string representation of this circle.
     * @return string representation of this circle
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("circle:");
        sb.append(" radius = ").append(radius);
        sb.append(" area = ").append(getArea());
        sb.append(" circumference = ").append(getCircumference());
        return sb.toString();
    }
}
