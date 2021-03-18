import java.util.concurrent.ThreadLocalRandom;

/**
 * Code for testing sorting methods.
 * @author Shenqi Zhang
 *
 */
public class SortingTest {
    private static int[] generateRandomArray() {
        int len = ThreadLocalRandom.current().nextInt(10, 50);
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = ThreadLocalRandom.current().nextInt(0, 50);
        }
        return a;
    }
    
    private static boolean sorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Test sorting methods.
     * @param args arguments
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int[] a = generateRandomArray();
            int[] clone = a.clone();
            Sorting.bubbleSort(clone);
            // add "-ea" into VM arguments
            assert sorted(clone);
        }
    }
}
