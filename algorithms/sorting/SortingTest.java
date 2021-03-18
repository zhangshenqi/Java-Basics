import java.util.concurrent.ThreadLocalRandom;

/**
 * Code for testing sorting methods.
 * @author Shenqi Zhang
 *
 */
public class SortingTest {
    /**
     * Generates a random array.
     * @return a random array
     */
    private static int[] generateRandomArray() {
        int len = ThreadLocalRandom.current().nextInt(10, 50);
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = ThreadLocalRandom.current().nextInt(0, 50);
        }
        return a;
    }
    
    /**
     * Test if an array is sorted in ascending order.
     * @param a array
     * @return true if the array is in ascending order; false otherwise.
     */
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
      //add "-ea" into VM arguments
        for (int i = 0; i < 10; i++) {
            int[] a = generateRandomArray(), clone;
            
            clone = a.clone();
            Sorting.bubbleSort(clone);
            assert sorted(clone);
            
            clone = a.clone();
            Sorting.selectionSort(clone);
            assert sorted(clone);
            
            clone = a.clone();
            Sorting.insertionSort(clone);
            assert sorted(clone);
            
            clone = a.clone();
            Sorting.mergeSort(clone);
            assert sorted(clone);
        }
    }
}
