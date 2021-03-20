import java.util.Collections;
import java.util.Iterator;

/**
 * Code for testing LinkedList.
 * @author Shenqi Zhang
 *
 */
public class LinkedListTest {
    /**
     * Print the list.
     * @param list the list to print
     */
    public static <E extends Comparable<E>> void printList(List<E> list) {
        System.out.print("size = ");
        System.out.print(list.size());
        System.out.print(" elements = ");
        System.out.println(list);
    }
    
    /**
     * Test the list.
     * @param list the list to test
     */
    public static void testList(List<String> list) {
        System.out.println("Create a list");
        printList(list);
        System.out.println("The list is empty");
        System.out.println(list.isEmpty());
        System.out.println("Add elements");
        list.add("One");
        list.add("Three");
        list.add(0, "Zero");
        list.add(2, "Two");
        list.add(4, "Four");
        printList(list);
        System.out.println("The list is empty");
        System.out.println(list.isEmpty());
        System.out.println("Remove elements");
        list.remove(4);
        list.remove(2);
        list.remove(0);
        list.remove("One");
        printList(list);
        System.out.println("Clear the list");
        list.clear();
        printList(list);
        System.out.println("Add elements");
        list.add(0, "One");
        list.add(0, "Zero");
        list.add(2, "Two");
        list.add(3, "Zero");
        printList(list);
        System.out.println("Get the index of Zero");
        System.out.println(list.indexOf("Zero"));
        System.out.println("Get the index of Four");
        System.out.println(list.indexOf("Four"));
        System.out.println("Get the last index of Zero");
        System.out.println(list.lastIndexOf("Zero"));
        System.out.println("Get the last index of Four");
        System.out.println(list.lastIndexOf("Four"));
        System.out.println("Get the element at index 0");
        System.out.println(list.get(0));
        System.out.println("Get the element at index 3");
        System.out.println(list.get(3));
        System.out.println("Set the element at index 3 to be Three");
        System.out.println(list.set(3, "Three"));
        printList(list);
        System.out.println("Reverse the list");
        list.reverse();
        printList(list);
        System.out.println("Sort the list in natural order");
        list.sort();
        printList(list);
        System.out.println("Sort the list in reverse order");
        list.sort(Collections.reverseOrder());
        printList(list);
        System.out.println("Sort the list using string length");
        list.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        printList(list);
        System.out.println("Sort the list in natural order");
        list.sort(null);
        printList(list);
        System.out.println("Iterate the list");
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
    
    /**
     * Test LinkedList.
     * @param args arguments
     */
    public static void main(String[] args) {
        testList(new SinglyLinkedList<String>());
        System.out.println();
        testList(new DoublyLinkedList<String>());
    }
}
