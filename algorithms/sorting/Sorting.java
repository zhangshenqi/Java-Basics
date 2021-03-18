/**
 * This class contains various methods for sorting an array.
 * @author Shenqi Zhang
 *
 */
public class Sorting {
    /**
     * Sorts the specified array into ascending numerical order.
     * @param a the array to be sorted
     */
    public static void bubbleSort(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }
    
    /**
     * Swap two elements in the array.
     * @param a array
     * @param index1 index of the first element
     * @param index2 index of the second element
     */
    private static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}
