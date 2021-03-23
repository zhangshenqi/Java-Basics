/**
 * This class contains some methods of binary search
 * @author Shenqi Zhang
 *
 */
public class BinarySearch {
    /**
     * Searches the specified array of ints for the specified value using the binary search algorithm.
     * The array must be sorted prior to making this call. If it is not sorted, the results are undefined.
     * If the array contains multiple elements with the specified value, there is no guarantee which one will be found.
     * @param a the array to be searched
     * @param key the value to be searched for
     * @return index of the search key, if it is contained in the array; otherwise, (-(insertion point) - 1).
     */
    public static int findIndexOf(int[] a, int key) {
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (a[middle] < key) {
                left = middle + 1;
            } else if (a[middle] > key) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -left - 1;
    }
    
    /**
     * Searches the specified array of ints for the first element no less than the specified value using the binary search algorithm.
     * The array must be sorted prior to making this call. If it is not sorted, the results are undefined.
     * @param a the array to be searched
     * @param key the value to be searched for
     * @return index of the first element no less than the specified value, if it is contained in the array; otherwise, -1.
     */
    public static int findFirstIndexNoSmallerThan(int[] a, int key) {
        int left = 0, right = a.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (a[middle] >= key) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        if (left == a.length - 1 && a[left] < key) {
            return -1;
        }
        return left;
    }
}
