import java.util.EmptyStackException;

/**
 * Array implementation of the Stack interface.
 * @author Shenqi Zhang
 * @param <E> the type of elements in this stack
 * 
 */
public class ArrayStack<E> implements Stack<E> {
    /**
     * Default capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * Elements in this stack.
     */
    private Object[] elements;
    /**
     * Index of the top element;
     */
    private int top;
    
    /**
     * Constructs an empty stack with a capacity of ten.
     */
    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }
    
    /**
     * Constructs an empty stack with the specified capacity.
     * @param capacity capacity of the list
     */
    public ArrayStack(int capacity) {
        elements = new Object[capacity];
        top = -1;
    }
    
    /**
     * Pushes an item onto the top of this stack.
     * @param item the item to be pushed onto this stack
     * @return true if this stack changed as a result of the call
     */
    @Override
    public boolean push(E item) {
        if (top == elements.length - 1) {
            return false;
        }
        
        elements[++top] = item;
        return true;
    }
    
    /**
     * Removes the object at the top of this stack and returns that object as the value of this function.
     * @return The object at the top of this stack (the last item of the Vector object)
     * @throws EmptyStackException if this stack is empty
     */
    @Override
    public E pop() throws EmptyStackException {
        if (empty()) {
            throw new EmptyStackException();
        }
        
        @SuppressWarnings("unchecked")
        E e = (E) elements[top];
        elements[top--] = null;
        return e;
    }
    
    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     * @return the object at the top of this stack (the last item of the Vector object)
     * @throws EmptyStackException if this stack is empty
     */
    @Override
    public E peek() throws EmptyStackException {
        if (empty()) {
            throw new EmptyStackException();
        }
        
        @SuppressWarnings("unchecked")
        E e = (E) elements[top];
        return e;
    }
    
    /**
     * Tests if this stack is empty.
     * @return true if and only if this stack contains no items; false otherwise
     */
    @Override
    public boolean empty() {
        return top == -1;
    }
}
