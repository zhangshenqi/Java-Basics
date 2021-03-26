/**
 * Code for testing DSU.
 * @author Shenqi Zhang
 *
 */
public class DisjointSetUnionTest {
    /**
     * Test DSU.
     * @param args arguments
     */
    public static void main(String[] args) {
        System.out.println("Construct a DSU");
        DisjointSetUnion dsu = new DisjointSetUnion();
        dsu.makeSet(1);
        dsu.makeSet(2);
        dsu.makeSet(3);
        dsu.makeSet(4);
        System.out.println("Find 1");
        System.out.println(dsu.find(1));
        System.out.println("Find 2");
        System.out.println(dsu.find(2));
        System.out.println("Find 3");
        System.out.println(dsu.find(3));
        System.out.println("Find 4");
        System.out.println(dsu.find(4));
        System.out.println("Union");
        dsu.union(1, 2);
        dsu.union(3, 4);
        dsu.union(1, 4);
        System.out.println("Find 1");
        System.out.println(dsu.find(1));
        System.out.println("Find 2");
        System.out.println(dsu.find(2));
        System.out.println("Find 3");
        System.out.println(dsu.find(3));
        System.out.println("Find 4");
        System.out.println(dsu.find(4));
    }
}
