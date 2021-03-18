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
     * Sorts the specified array into ascending numerical order.
     * @param a the array to be sorted
     */
    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (i != min) {
                swap(a, i, min);
            }
        }
    }
    
    /**
     * Sorts the specified array into ascending numerical order.
     * @param a the array to be sorted
     */
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i], j = i;
            while (j > 0 && a[j - 1] > temp) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;
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
