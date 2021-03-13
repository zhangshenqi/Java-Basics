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
        System.out.println("Create Circle0");
        Circle c0 = new Circle(1);
        System.out.println(c0);
        System.out.println("Reset Circle0");
        c0.setRadius(2);
        System.out.println(c0);
        
        System.out.println("Create Rectangle0");
        Rectangle r0 = new Rectangle(2, 1);
        System.out.println(r0);
        System.out.println("Reset Rectangle0");
        r0.setLength(4);
        r0.setWidth(2);
        System.out.println(r0);
        
        System.out.println("Create Square0");
        Square s0 = new Square(1);
        System.out.println(s0);
        System.out.println("Reset Square0");
        s0.setSide(2);
        System.out.println(s0);
        
        System.out.println("Create Circle1");
        Shape c1 = new Circle(1);
        System.out.println(c1);
        System.out.println("Create Rectangle2");
        Shape r2 = new Rectangle(2, 1);
        System.out.println(r2);
        System.out.println("Create Square1");
        Shape s1 = new Square(1);
        System.out.println(s1);
    }
}
