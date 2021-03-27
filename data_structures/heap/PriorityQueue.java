import java.util.Arrays;
import java.util.Comparator;

/**
 * An unbounded priority queue based on a priority heap.
 * @author Shenqi Zhang
 * @param <E> the type of elements in this priority queue
 * 
 */
public class PriorityQueue<E extends Comparable<E>> {
    /**
     * Default capacity.
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    /**
     * Elements in this priority queue.
     */
    private Object[] elements;
    /**
     * Size of this priority queue.
     */
    private int size;
    /**
     * The comparator to determine the order of this priority queue.
     */
    private Comparator<E> comparator;
    
    /**
     * Constructs an empty priority queue with an initial capacity of ten that orders its elements according to their natural ordering.
     */
    public PriorityQueue() {
        this(DEFAULT_INITIAL_CAPACITY, null);
    }
    
    /**
     * Constructs an empty priority queue with an initial capacity of ten that orders its elements according to the specified comparator.
     * @param c the comparator to determine the order of this priority queue
     */
    public PriorityQueue(Comparator<E> c) {
        this(DEFAULT_INITIAL_CAPACITY, c);
    }
    
    /**
     * Constructs an empty priority queue with the specified initial capacity that orders its elements according to their natural ordering.
     * @param initialCapacity the initial capacity of the priority queue
     */
    public PriorityQueue(int initialCapacity) {
        this(initialCapacity, null);
    }
    
    /**
     * Constructs an empty priority queue with the specified initial capacity that orders its elements according to the specified comparator.
     * @param initialCapacity the initial capacity of the priority queue
     * @param c the comparator to determine the order of this priority queue
     */
    public PriorityQueue(int initialCapacity, Comparator<E> c) {
        elements = new Object[initialCapacity];
        if (c == null) {
            comparator = (e1, e2) -> e1.compareTo(e2);
        } else {
            comparator = c;
        }
    }
    
    /**
     * Returns the number of elements in this priority queue.
     * @return the number of elements in this priority queue
     */
    public int size() {
        return size;
    }
    
    /**
     * Inserts the specified element into this priority queue.
     * @param e the element to add
     */
    public void add(E e) {
        ensureCapacity(size + 1);
        elements[size] = e;
        percolateUp(size);
        size++;
    }
    
    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     * @return the head of this queue, or null if this queue is empty
     */
    public E poll() {
        if (size == 0) {
            return null;
        }
        @SuppressWarnings("unchecked")
        E e = (E) elements[0];
        size--;
        elements[0] = elements[size];
        elements[size] = null;
        percolateDown(0);
        return e;
    }
    
    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     * @return the head of this queue, or null if this queue is empty
     */
    @SuppressWarnings("unchecked")
    public E peek() {
        if (size == 0) {
            return null;
        }
        return (E) elements[0];
    }
    
    /**
     * Increases the capacity of this priority queue, if necessary,
     * to ensure that it can hold at least the number of elements specified by the minimum capacity argument.
     * @param minCapacity the desired minimum capacity
     */
    private void ensureCapacity(int minCapacity) {
        int oldCapacity = elements.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = (oldCapacity * 3) / 2 + 1;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }
    
    /**
     * Percolates up for add operation.
     * @param index the starting index
     */
    @SuppressWarnings("unchecked")
    private void percolateUp(int index) {
        E e = (E) elements[index];
        int i = index;
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (comparator.compare((E) elements[parent], e) <= 0) {
                break;
            }
            elements[i] = elements[parent];
            i = parent;
        }
        elements[i] = e;
    }
    
    /**
     * Percolates down for poll operation.
     * @param index the starting index
     */
    @SuppressWarnings("unchecked")
    private void percolateDown(int index) {
        E e = (E) elements[index];
        int i = index;
        while (i < size / 2) {
            int leftChild = 2 * i + 1, rightChild = leftChild + 1;
            int smallerChild = (rightChild < size && comparator.compare((E) elements[leftChild], (E) elements[rightChild]) >= 0) ? rightChild : leftChild;
            if (comparator.compare((E) elements[smallerChild], e) >= 0) {
                break;
            }
            elements[i] = elements[smallerChild];
            i = smallerChild;
        }
        elements[i] = e;
    }
}
