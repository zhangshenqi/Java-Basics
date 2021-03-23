/**
 * Code for testing binary search.
 * @author Shenqi Zhang
 *
 */
public class BinarySearchTest {
    /**
     * Test binary search.
     * @param args arguments
     */
    public static void main(String[] args) {
        System.out.println("Create an array");
        System.out.println("[1, 3, 5, 7, 9]");
        int[] a = {1, 3, 5, 7, 9};
        System.out.println("Index of 0");
        System.out.println(BinarySearch.findIndexOf(a, 0));
        System.out.println("Index of 1");
        System.out.println(BinarySearch.findIndexOf(a, 1));
        System.out.println("Index of 4");
        System.out.println(BinarySearch.findIndexOf(a, 4));
        System.out.println("Index of 5");
        System.out.println(BinarySearch.findIndexOf(a, 5));
        System.out.println("Index of 8");
        System.out.println(BinarySearch.findIndexOf(a, 8));
        System.out.println("Index of 9");
        System.out.println(BinarySearch.findIndexOf(a, 9));
        System.out.println("Index of 12");
        System.out.println(BinarySearch.findIndexOf(a, 12));
        System.out.println();
        
        System.out.println("Create an array");
        System.out.println("[1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4]");
        int[] b = {1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4};
        System.out.println("Find first index no smaller than -1");
        System.out.println(BinarySearch.findFirstIndexNoSmallerThan(b, -1));
        System.out.println("Find first index no smaller than 1");
        System.out.println(BinarySearch.findFirstIndexNoSmallerThan(b, 1));
        System.out.println("Find first index no smaller than 2");
        System.out.println(BinarySearch.findFirstIndexNoSmallerThan(b, 2));
        System.out.println("Find first index no smaller than 3");
        System.out.println(BinarySearch.findFirstIndexNoSmallerThan(b, 3));
        System.out.println("Find first index no smaller than 4");
        System.out.println(BinarySearch.findFirstIndexNoSmallerThan(b, 4));
        System.out.println("Find first index no smaller than 5");
        System.out.println(BinarySearch.findFirstIndexNoSmallerThan(b, 5));
    }
}
