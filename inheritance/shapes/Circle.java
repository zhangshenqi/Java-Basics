/**
 * Class for circle.
 * @author Shenqi Zhang
 *
 */
public class Circle extends Shape {
    /**
     * Number of circles.
     */
    private static int numCircles = 0;
    
    /**
     * Gets the number of circles.
     * @return number of circles
     */
    public static int getNumCircles() {
        return numCircles;
    }
    
    /**
     * Id of this circle.
     */
    private final int idCircle;
    /**
     * Radius of this circle.
     */
    private double radius;
    
    /**
     * Constructs a circle with specified radius.
     * @param radius radius of this circle
     */
    public Circle(double radius) {
        idCircle = numCircles;
        numCircles++;
        setRadius(radius);
    }
    
    /**
     * Gets the id of this circle.
     * @return id of this circle
     */
    public int getIdCircle() {
        return idCircle;
    }
    
    /**
     * Gets the radius of this circle.
     * @return radius of this circle
     */
    public double getRadius() {
        return radius;
    }
    
    /**
     * Sets the radius of this circle.
     * @param radius radius of this circle
     */
    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Parameter must be positive!");
        }
        this.radius = radius;
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
        sb.append(" id = ").append(idCircle);
        sb.append(" radius = ").append(radius);
        sb.append(" area = ").append(getArea());
        sb.append(" circumference = ").append(getCircumference());
        return sb.toString();
    }
    
    /**
     * Indicates whether some other object is "equal to" this circle.
     * @param obj the reference object with which to compare
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        
        Circle that = (Circle) obj;
        return this.radius == that.radius;
    }
}
