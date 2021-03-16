import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Doubly-linked list implementation of the List interface.
 * Permits all elements, including null.
 * @author Shenqi Zhang
 * @param <E> the type of elements in this list
 *
 */
public class DoublyLinkedList<E> implements List<E> {
    /**
     * Head node of this list.
     */
    private Node<E> head;
    /**
     * Tail node of this list.
     */
    private Node<E> tail;
    /**
     * Size of this list.
     */
    private int size;
    
    /**
     * Constructs an empty list.
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
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
        return new LinkedListIterator();
    }
    
    /**
     * Appends the specified element to the end of this list (optional operation).
     * @param e element to be appended to this list
     * @return true if this list changed as a result of the call
     */
    @Override
    public boolean add(E e) {
        if (head == null) {
            head = tail = new Node<E>(e, null, null);
        } else {
            tail.next = new Node<E>(e, tail, null);
            tail = tail.next;
        }
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
        Node<E> curr = head;
        while (curr != null) {
            if (elementEquals(curr.item, e)) {
                remove(curr);
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
    
    /**
     * Removes all of the elements from this list (optional operation).
     */
    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }
    
    /**
     * Returns the element at the specified position in this list.
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    @Override
    public E get(int index) {
        return getNode(index).item;
    }
    
    /**
     * Replaces the element at the specified position in this list with the specified element (optional operation).
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
    @Override
    public E set(int index, E element) {
        Node<E> node = getNode(index);
        E e = node.item;
        node.item = element;
        return e;
    }
    
    /**
     * Inserts the specified element at the specified position in this list (optional operation).
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    @Override
    public void add(int index, E element) {
        if (index == 0) {
            head = new Node<E>(element, null, head);
            size++;
            return;
        }
        
        Node<E> prev = getNode(index - 1);
        Node<E> next = prev.next;
        Node<E> curr = new Node<E>(element, prev, next);
        prev.next = curr;
        if (next == null) {
            tail = curr;
        } else {
            next.prev = curr;
        }
        size++;
        return;
    }
    
    /**
     * Removes the element at the specified position in this list (optional operation).
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     */
    @Override
    public E remove(int index) {
        Node<E> node = getNode(index);
        remove(node);
        return node.item; 
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
        int count = 0;
        Node<E> curr = head;
        while (curr != null) {
            if (elementEquals(curr.item, e)) {
                return count;
            }
            count++;
            curr = curr.next;
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
        int count = size - 1;
        Node<E> curr = tail;
        while (curr != null) {
            if (elementEquals(curr.item, e)) {
                return count;
            }
            count--;
            curr = curr.prev;
        }
        return -1;
    }
    
    /**
     * Reverse the list.
     */
    @Override
    public void reverse() {
        Node<E> node1 = head, node2 = tail;
        for (int i = 1; i < size; i += 2) {
            E temp = node1.item;
            node1.item = node2.item;
            node2.item = temp;
            node1 = node1.next;
            node2 = node2.prev;
        }
    }
    
    /**
     * Returns a string representation of this list.
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (head != null) {
            sb.append(head.item);
            Node<E> curr = head.next;
            while (curr != null) {
                sb.append(", ").append(curr.item);
                curr = curr.next;
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    /**
     * Indicates whether two elements are "equal".
     * @param e1 the first element to be compared
     * @param e2 the second element to be compared
     * @return true if the two elements are "equal"; false otherwise.
     */
    private boolean elementEquals(E e1, E e2) {
        if (e1 == null) {
            return e2 == null;
        }
        return e1.equals(e2);
    }
    
    /**
     * Returns the node at the specified position in this list.
     * @param index index of the node to return
     * @return the node at the specified position in this list
     */
    private Node<E> getNode(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        
        Node<E> curr = head;
        while (index > 0) {
            curr = curr.next;
            index--;
        }
        
        return curr;
    }
    
    private void remove(Node<E> curr) {
        Node<E> prev = curr.prev;
        Node<E> next = curr.next;
        if (prev == null) {
            if (next == null) {
                head = tail = null;
            } else {
                next.prev = null;
                head = next;
            }
        } else {
            if (next == null) {
                prev.next = null;
                tail = prev;
            } else {
                prev.next = next;
                next.prev = prev;
            }
        }
        size--;
    }
    
    /**
     * An iterator over a linked list.
     *
     */
    private class LinkedListIterator implements Iterator<E> {
        /**
         * Next node to iterate.
         */
        private Node<E> next;
        LinkedListIterator() {
            next = head;
        }
        
        /**
         * Returns true if the iteration has more elements.
         * @return true if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return next != null;
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
            
            E e = next.item;
            next = next.next;
            return e;
        }
    }
    
    /**
     * Node of the linked list.
     * @param <E> the type of element in this node
     * 
     */
    private static class Node<E> {
        /**
         * Item of this node.
         */
        private E item;
        /**
         * Previous node;
         */
        private Node<E> prev;
        /**
         * Next node;
         */
        private Node<E> next;
        
        /**
         * Constructs a node with specified element and next node.
         * @param element element
         * @param next next node
         */
        Node(E element, Node<E> prev, Node<E> next) {
            this.item = element;
            this.prev = prev;
            this.next = next;
        }
    }
}
