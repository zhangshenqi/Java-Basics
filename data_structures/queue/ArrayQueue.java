import java.util.NoSuchElementException;

/**
 * Array implementation of the Queue interface.
 * @author Shenqi Zhang
 * @param <E> the type of elements in this queue
 * 
 */
public class ArrayQueue<E> implements Queue<E> {
    /**
     * Default capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * Elements in this queue.
     */
    private Object[] elements;
    /**
     * Index of the front element.
     */
    private int front;
    /**
     * Index of the back element.
     */
    private int back;
    /**
     * Size of this queue.
     */
    private int size;
    
    /**
     * Constructs an empty queue with a capacity of ten.
     */
    ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }
    
    /**
     * Constructs an empty queue with the specified capacity.
     */
    ArrayQueue(int capacity) {
        elements = new Object[capacity];
        front = 0;
        back = -1;
        size = 0;
    }
    
    /**
     * Tests if this queue is empty.
     * @return true if and only if this queue contains no items; false otherwise
     */
    @Override
    public boolean empty() {
        return size == 0;
    }
    
    /**
     * Tests if this queue is full.
     * @return true if and only if this queue is full
     */
    @Override
    public boolean full() {
        return size == elements.length;
    }
    
    /**
     * Returns the number of elements in this queue.
     * @return the number of elements in this queue
     */
    @Override
    public int size() {
        return size;
    }
    
    /**
     * Returns the head of this queue.
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    @Override
    public E front() throws NoSuchElementException {
        if (empty()) {
            throw new NoSuchElementException();
        }
        
        @SuppressWarnings("unchecked")
        E e = (E) elements[front];
        return e;
    }
    
    /**
     * Returns the tail of this queue.
     * @return the tail of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    @Override
    public E back() throws NoSuchElementException {
        if (empty()) {
            throw new NoSuchElementException();
        }
        
        @SuppressWarnings("unchecked")
        E e = (E) elements[back];
        return e;
    }
    
    /**
     * Pushes an item to the back of this queue.
     * @param item the item to be pushed to this stack
     * @return true if this queue changed as a result of the call
     */
    @Override
    public boolean pushBack(E item) {
        if (full()) {
            return false;
        }
        
        back = (back + 1) % elements.length;
        elements[back] = item;
        size++;
        return true;
    }
    
    /**
     * Removes the item at front of this queue
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    @Override
    public E popFront() throws NoSuchElementException {
        if (empty()) {
            throw new NoSuchElementException();
        }
        
        @SuppressWarnings("unchecked")
        E e = (E) elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        return e;
    }
}
