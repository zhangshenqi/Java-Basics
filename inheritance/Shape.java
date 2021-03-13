/**
 * Class for shape.
 * @author Shenqi Zhang
 *
 */
public abstract class Shape {
    /**
     * Static variable to keep track of the number of shapes.
     */
    private static int numShapes = 0;
    
    /**
     * Static method to get the number of shapes.
     * @return number of shapes
     */
    public static int getNumShapes() {
        return numShapes;
    }
    
    /**
     * Id of this shape.
     */
    private final int idShape;
    
    /**
     * Constructor.
     */
    public Shape() {
        idShape = numShapes;
        numShapes++;
    }
    
    /**
     * Get the id of this shape.
     * @return id of this shape
     */
    public int getIdShape() {
        return idShape;
    }
    
    /**
     * Get the area of this shape.
     * @return area of this shape
     */
    protected abstract double getArea();
    
    /**
     * Get the circumference of this shape.
     * @return circumference of this shape
     */
    protected abstract double getCircumference();
    
    /**
     * Return the string representation of this shape.
     * @return string representation of this shape
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("shape:");
        sb.append(" id = ").append(idShape);
        sb.append(" area = ").append(getArea());
        sb.append(" circumference = ").append(getCircumference());
        return sb.toString();
    }
    
    /**
     * Indicate whether some other object is "equal" to this shape.
     * @param obj other object
     */
    @Override
    public boolean equals(Object obj) {
        return (obj != null) && (this.getClass() == obj.getClass());
    }
}
