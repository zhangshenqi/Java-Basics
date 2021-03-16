import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Resizable-array implementation of the List interface.
 * @author Shenqi Zhang
 * @param <E> the type of elements in this list
 *
 */
public class ArrayList<E> implements List<E> {
    /**
     * Default capacity.
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    /**
     * Elements in this list.
     */
    private Object[] elements;
    /**
     * Size of this list.
     */
    private int size;
    
    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public ArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }
    
    /**
     * Constructs an empty list with the specified initial capacity.
     * @param initialCapacity the initial capacity of the list
     */
    public ArrayList(int initialCapacity) {
        elements = new Object[initialCapacity];
    }
    
    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }
    
    /**
     * Returns true if this list contains no elements.
     * @return if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Returns the capacity of this list.
     * @return the capacity of this list
     */
    public int capacity() {
        return elements.length;
    }
    
    /**
     * Returns true if this list contains the specified element.
     * @param e element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    @Override
    public boolean contains(E e) {
        return indexOf(e) != -1;
    }
    
    /**
     * Returns an iterator over the elements in this list in proper sequence.
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }
    
    /**
     * Appends the specified element to the end of this list (optional operation).
     * @param e element to be appended to this list
     * @return true if this list changed as a result of the call
     */
    @Override
    public boolean add(E e) {
        ensureCapacity(size + 1);
        elements[size] = e;
        size++;
        return true;
    }
    
    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present (optional operation).
     * @param e element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    @Override
    public boolean remove(E e) {
        int index = indexOf(e);
        if (index == -1) {
            return false;
        }
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        elements[size - 1] = null;
        size--;
        return true;
    }
    
    /**
     * Removes all of the elements from this list (optional operation).
     */
    @Override
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }
    
    /**
     * Returns the element at the specified position in this list.
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        @SuppressWarnings("unchecked")
        E e  = (E) elements[index];
        return e;
    }
    
    /**
     * Replaces the element at the specified position in this list with the specified element (optional operation).
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        @SuppressWarnings("unchecked")
        E e  = (E) elements[index];
        elements[index] = element;
        return e;
    }
    
    /**
     * Inserts the specified element at the specified position in this list (optional operation).
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }
    
    /**
     * Removes the element at the specified position in this list (optional operation).
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        @SuppressWarnings("unchecked")
        E e  = (E) elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        elements[size - 1] = null;
        size--;
        return e;
    }
    
    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     * @param e element to search for
     * @return the index of the first occurrence of the specified element in this list, 
     * or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == null) {
                if (e == null) {
                    return i;
                }
            } else {
                if (elements[i].equals(e)) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    /**
     * Returns the index of the last occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     * @param e element to search for
     * @return the index of the last occurrence of the specified element in this list,
     * or -1 if this list does not contain the element
     */
    @Override
    public int lastIndexOf(E e) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i] == null) {
                if (e == null) {
                    return i;
                }
            } else {
                if (elements[i].equals(e)) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    /**
     * Trims the capacity of this ArrayList instance to be the list's current size.
     */
    public void trimToSize() {
        elements = Arrays.copyOf(elements, size);
    }
    
    /**
     * Increases the capacity of this ArrayList instance, if necessary,
     * to ensure that it can hold at least the number of elements specified by the minimum capacity argument.
     * @param minCapacity the desired minimum capacity
     */
    public void ensureCapacity(int minCapacity) {
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
     * Returns a string representation of this list.
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (size > 0) {
            sb.append(elements[0]);
            for (int i = 1; i < size; i++) {
                sb.append(", ").append(elements[i]);
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    /**
     * An iterator over an array list.
     *
     */
    private class ArrayListIterator implements Iterator<E> {
        /**
         * Next index to iterate.
         */
        private int next;
        ArrayListIterator() {
            next = 0;
        }
        
        /**
         * Returns true if the iteration has more elements.
         * @return true if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return next < size;
        }
        
        /**
         * Returns the next element in the iteration.
         * @return the next element in the iteration
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            
            @SuppressWarnings("unchecked")
            E e = (E) elements[next];
            next++;
            return e;
        }
    }
}
