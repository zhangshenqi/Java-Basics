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
     * Sorts the specified array into ascending numerical order.
     * @param a the array to be sorted
     */
    public static void mergeSort(int[] a) {
        if (a.length <= 1) {
            return;
        }
        
        int[] temp = new int[a.length];
        mergeSort(a, 0, a.length - 1, temp);
    }
    
    /**
     * Sorts the specified array into ascending numerical order.
     * @param a the array to be sorted
     * @param left the index of the first element, inclusive, to be sorted
     * @param right the index of the last element, inclusive, to be sorted
     * @param a helper array
     */
    private static void mergeSort(int[] a, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int middle = left + (right - left) / 2;
        mergeSort(a, left, middle, temp);
        mergeSort(a, middle + 1, right, temp);
        merge(a, left, middle, right, temp);
    }
    
    /**
     * Merges two subarrays in ascending order.
     * @param a the array to be sorted
     * @param left the index of the first element
     * @param middle the index of the middle element
     * @param right the index of the last element
     * @param a helper array
     */
    private static void merge(int[] a, int left, int middle, int right, int[] temp) {
        int i = left, j = middle + 1, k = 0;
        while (i <= middle && j <= right) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= middle) {
            temp[k++] = a[i++];
        }
        while (j <= right) {
            temp[k++] = a[j++];
        }
        System.arraycopy(temp, left, a, left, right - left + 1);
    }
    
    /**
     * Sorts the specified array into ascending numerical order.
     * @param a the array to be sorted
     */
    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }
    
    /**
     * Sorts the specified array into ascending numerical order.
     * @param a the array to be sorted
     * @param left the index of the first element, inclusive, to be sorted
     * @param right the index of the last element, inclusive, to be sorted
     */
    private static void quickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(a, left, right);
        quickSort(a, left, pivotIndex - 1);
        quickSort(a, pivotIndex + 1, right);
    }
    
    /**
     * Partitions the specified array into two parts with a pivot value.
     * @param a the array to be partitioned
     * @param left the index of the first element, inclusive, to be partitioned
     * @param right the index of the last element, inclusive, to be partitioned
     * @return the index of the pivot value
     */
    private static int partition(int[] a, int left, int right) {
        int pivot = a[right];
        int i = left - 1, j = right;
        while (true) {
            while (a[++i] < pivot);
            while (j > left && a[--j] > pivot);
            if (i >= j) {
                break;
            } else {
                swap(a, i, j);
            }
        }
        swap(a, i, right);
        return i;
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
