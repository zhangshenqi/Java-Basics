/**
 * Code for testing shapes.
 * @author Shenqi Zhang
 *
 */
public class ShapeTest {
    /**
     * Test shapes.
     * @param args arguments
     */
    public static void main(String[] args) {
        System.out.println("Create Circle");
        Shape c = new Circle(1);
        System.out.println(c);
        System.out.println("Create Rectangle");
        Shape r = new Rectangle(2, 1);
        System.out.println(r);
    }
}
