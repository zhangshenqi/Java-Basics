import java.util.Comparator;

/**
 * Comparator with the circumference of shapes.
 * @author Shenqi Zhang
 *
 */
public class ShapeCircumferenceComparator implements Comparator<Shape> {
    /**
     * Compare the circumference of shapes for order.
     * @param s1 the first shape to be compared
     * @param s2 the second shape to be compared
     */
    @Override
    public int compare(Shape s1, Shape s2) {
        return Double.compare(s1.getCircumference(), s2.getCircumference());
    }
}
