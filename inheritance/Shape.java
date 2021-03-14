/**
 * Class for shape.
 * @author Shenqi Zhang
 *
 */
public abstract class Shape implements Comparable<Shape> {
    /**
     * Number of shapes.
     */
    private static int numShapes = 0;
    
    /**
     * Gets the number of shapes.
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
     * Constructs a shape.
     */
    public Shape() {
        idShape = numShapes;
        numShapes++;
    }
    
    /**
     * Gets the id of this shape.
     * @return id of this shape
     */
    public int getIdShape() {
        return idShape;
    }
    
    /**
     * Gets the area of this shape.
     * @return area of this shape
     */
    protected abstract double getArea();
    
    /**
     * Gets the circumference of this shape.
     * @return circumference of this shape
     */
    protected abstract double getCircumference();
    
    /**
     * Returns the string representation of this shape.
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
     * Indicates whether some other object is "equal to" this shape.
     * @param obj the reference object with which to compare
     */
    @Override
    public boolean equals(Object obj) {
        return (obj != null) && (this.getClass() == obj.getClass());
    }
    
    /**
     * Compares this shape with the specified shape for order.
     * @param that the shape to be compared
     */
    @Override
    public int compareTo(Shape that) {
        return Integer.compare(this.idShape, that.idShape);
    }
}
