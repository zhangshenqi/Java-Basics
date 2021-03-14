import java.util.Comparator;

/**
 * Comparator with the area of shapes.
 * @author Shenqi Zhang
 *
 */
public class ShapeAreaComparator implements Comparator<Shape> {
    /**
     * Compare the area of shapes for order.
     * @param s1 the first shape to be compared
     * @param s2 the second shape to be compared
     */
    @Override
    public int compare(Shape s1, Shape s2) {
        return Double.compare(s1.getArea(), s2.getArea());
    }
}
