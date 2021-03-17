import java.util.NoSuchElementException;

/**
 * A collection designed for holding elements first-in-first-out (FIFO).
 * @author Shenqi Zhang
 * @param <E> the type of elements in this queue
 * 
 */
public interface Queue<E> {
    /**
     * Tests if this queue is empty.
     * @return true if and only if this queue contains no items; false otherwise
     */
    boolean empty();
    
    /**
     * Tests if this queue is full.
     * @return true if and only if this queue is full
     */
    boolean full();
    
    /**
     * Returns the number of elements in this queue.
     * @return the number of elements in this queue
     */
    int size();
    
    /**
     * Returns the head of this queue.
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    E front() throws NoSuchElementException;
    
    /**
     * Returns the tail of this queue.
     * @return the tail of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    E back() throws NoSuchElementException;
    
    /**
     * Pushes an item to the back of this queue.
     * @param item the item to be pushed to this stack
     * @return true if this queue changed as a result of the call
     */
    boolean pushBack(E item);
    
    /**
     * Removes the item at front of this queue
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    E popFront() throws NoSuchElementException;
}
