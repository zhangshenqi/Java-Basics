import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Singly-linked list implementation of the List interface.
 * Permits all elements, including null.
 * @author Shenqi Zhang
 * @param <E> the type of elements in this list
 *
 */
public class SinglyLinkedList<E extends Comparable<E>> implements List<E> {
    /**
     * Head node of this list.
     */
    private Node<E> head;
    
    /**
     * Constructs an empty list.
     */
    public SinglyLinkedList() {
        head = null;
    }
    
    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        int count = 0;
        Node<E> curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
    
    /**
     * Returns true if this list contains no elements.
     * @return if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return head == null;
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
            head = new Node<E>(e, null);
        } else {
            Node<E> curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node<E>(e, null);
        }
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
        if (head == null) {
            return false;
        }
        
        if (elementEquals(head.item, e)) {
            head = head.next;
            return true;
        }
        
        Node<E> prev = head;
        Node<E> curr = head.next;
        while (curr != null) {
            if (elementEquals(curr.item, e)) {
                prev.next = curr.next;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        
        return false;
    }
    
    /**
     * Removes all of the elements from this list (optional operation).
     */
    @Override
    public void clear() {
        head = null;
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
            head = new Node<E>(element, head);
            return;
        }
        
        Node<E> prev = getNode(index - 1);
        Node<E> curr = new Node<E>(element, prev.next);
        prev.next = curr;
    }
    
    /**
     * Removes the element at the specified position in this list (optional operation).
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     */
    @Override
    public E remove(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        
        if (index == 0) {
            E e = head.item;
            head = head.next;
            return e;
        }
        
        Node<E> prev = getNode(index - 1);
        Node<E> curr = prev.next;
        if (curr == null) {
            throw new IndexOutOfBoundsException();
        }
        E e = curr.item;
        prev.next = prev.next.next;
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
        int count = 0, result = -1;
        Node<E> curr = head;
        while (curr != null) {
            if (elementEquals(curr.item, e)) {
                result = count;
            }
            count++;
            curr = curr.next;
        }
        return result;
    }
    
    /**
     * Reverses the list.
     */
    @Override
    public void reverse() {
        Node<E> prev = null;
        Node<E> curr = head;
        while (curr != null) {
            Node<E> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    
    /**
     * Sorts this list into ascending order, according to the natural ordering of its elements.
     */
    @Override
    public void sort() {
        sort(null);
    }
    
    /**
     * Sorts this list into ascending order, according to the natural ordering of its elements.
     * @param c the comparator to determine the order of this list. A null value indicates that the elements' natural ordering should be used.
     */
    @Override
    public void sort(Comparator<E> c) {
        if (c == null) {
            c = (e1, e2) -> e1.compareTo(e2);
        }
        head = mergeSort(head, c);
    }
    
    /**
     * Sorts the specified list into ascending order, according to the natural ordering of its elements.
     * @param l1 the list to be sorted
     * @param c the comparator to determine the order of this list. A null value indicates that the elements' natural ordering should be used.
     * @return the head of the sorted array
     */
    private Node<E> mergeSort(Node<E> l1, Comparator<E> c) {
        if (l1 == null || l1.next == null) {
            return l1;
        }
        Node<E> slow = l1, fast = l1.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node<E> l2 = slow.next;
        slow.next = null;
        l1 = mergeSort(l1, c);
        l2 = mergeSort(l2, c);
        return merge(l1, l2, c);
    }
    
    /**
     * Merges two sorted list into one sorted list.
     * @param l1 the first list to be merged
     * @param l2 the second list to be merged
     * @param c the comparator to determine the order of this list. A null value indicates that the elements' natural ordering should be used.
     * @return the merged list
     */
    private Node<E> merge(Node<E> l1, Node<E> l2, Comparator<E> c) {
        Node<E> dummyHead = new Node<E>(null, null), curr = dummyHead;
        while (l1 != null && l2 != null) {
            if (c.compare(l1.item, l2.item) <= 0) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }
        return dummyHead.next;
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
        int count = 0;
        Node<E> curr = head;
        while (count < index && curr != null) {
            count++;
            curr = curr.next;
        }
        
        if (count == index && curr != null) {
            return curr;
        }
        
        throw new IndexOutOfBoundsException();
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
         * Next node;
         */
        private Node<E> next;
        
        /**
         * Constructs a node with specified element and next node.
         * @param element element
         * @param next next node
         */
        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}
