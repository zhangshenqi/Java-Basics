/**
 * Class for circle.
 * @author Shenqi Zhang
 *
 */
public class Circle extends Shape {
    /**
     * Static variable to keep track of the number of circles.
     */
    private static int numCircles = 0;
    
    /**
     * Static method to get the number of circles.
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
     * Constructor with radius.
     * @param radius radius of this circle
     */
    public Circle(double radius) {
        idCircle = numCircles;
        numCircles++;
        setRadius(radius);
    }
    
    /**
     * Get the id of this circle.
     * @return id of this circle
     */
    public int getIdCircle() {
        return idCircle;
    }
    
    /**
     * Get the radius of this circle.
     * @return radius of this circle
     */
    public double getRadius() {
        return radius;
    }
    
    /**
     * Set the radius of this circle.
     * @param radius radius of this circle
     */
    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Parameter must be positive!");
        }
        this.radius = radius;
    }
    
    /**
     * Get the area of this circle.
     * @return area of this circle
     */
    @Override
    protected double getArea() {
        return Math.PI * radius * radius;
    }
    
    /**
     * Get the circumference of this circle.
     * @return circumference of this circle
     */
    @Override
    protected double getCircumference() {
        return 2 * Math.PI * radius;
    }
    
    /**
     * Return the string representation of this circle.
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
     * Indicate whether some other object is "equal" to this circle.
     * @param obj other object
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
