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
        System.out.println("Create Circle1");
        Shape c1 = new Circle(1);
        System.out.println(c1);
        System.out.println("Test whether Circle0 equals to Circle1");
        System.out.println(c0.equals(c1));
        System.out.println("Reset Circle0");
        c0.setRadius(2);
        System.out.println(c0);
        System.out.println("Test whether Circle0 equals to Circle1");
        System.out.println(c0.equals(c1));
        System.out.println();
        
        System.out.println("Create Rectangle0");
        Rectangle r0 = new Rectangle(2, 1);
        System.out.println(r0);
        System.out.println("Create Rectangle1");
        Shape r1 = new Rectangle(2, 1);
        System.out.println(r1);
        System.out.println("Test whether Rectangle0 equals to Rectangle1");
        System.out.println(r0.equals(r1));
        System.out.println("Reset Rectangle0");
        r0.setLength(4);
        r0.setWidth(2);
        System.out.println(r0);
        System.out.println("Test whether Rectangle0 equals to Rectangle1");
        System.out.println(r0.equals(r1));
        System.out.println();
        
        System.out.println("Create Square0");
        Square s0 = new Square(1);
        System.out.println(s0);
        System.out.println("Create Square1");
        Shape s1 = new Square(1);
        System.out.println(s1);
        System.out.println("Test whether Square0 equals to Square1");
        System.out.println(s0.equals(s1));
        System.out.println("Reset Square0");
        s0.setSide(2);
        System.out.println(s0);
        System.out.println("Test whether Square0 equals to Square1");
        System.out.println(s0.equals(s1));
        System.out.println();
        
        System.out.println("Get the number of shapes");
        System.out.println(Shape.getNumShapes());
        System.out.println("Get the number of circles");
        System.out.println(Circle.getNumCircles());
        System.out.println("Get the number of rectangles");
        System.out.println(Rectangle.getNumRectangles());
        System.out.println("Get the number of squares");
        System.out.println(Square.getNumSquares());
    }
}
