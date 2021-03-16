import java.util.Iterator;

/**
 * Code for testing ArrayList.
 * @author Shenqi Zhang
 *
 */
public class ArrayListTest {
    /**
     * Print the list.
     * @param list the list to print
     */
    public static <E> void printList(List<E> list) {
        System.out.print("size = ");
        System.out.print(list.size());
        if (list instanceof ArrayList<?>) {
            System.out.print(" capacity = ");
            System.out.print(((ArrayList<E>) list).capacity());
        }
        System.out.print(" elements = ");
        System.out.println(list);
    }
    
    /**
     * Test ArrayList.
     * @param args arguments
     */
    public static void main(String[] args) {
        System.out.println("Create a list");
        List<Integer> list1 = new ArrayList<Integer>();
        printList(list1);
        System.out.println("The list is empty");
        System.out.println(list1.isEmpty());
        System.out.println("Add elements");
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(7);
        list1.add(9);
        printList(list1);
        System.out.println("Add elements");
        list1.add(0, 0);
        list1.add(2, 2);
        list1.add(4, 4);
        list1.add(6, 6);
        list1.add(8, 8);
        printList(list1);
        System.out.println("Add elements");
        list1.add(11);
        System.out.println("Add elements");
        list1.add(12);
        list1.add(13);
        list1.add(15);
        list1.add(10, 10);
        list1.add(15, 16);
        printList(list1);
        System.out.println("Add elements");
        list1.add(14, 14);
        printList(list1);
        System.out.println("The list is empty");
        System.out.println(list1.isEmpty());
        System.out.println("The list contains 8");
        System.out.println(list1.contains(8));
        System.out.println("The list contains 8");
        System.out.println(list1.contains(18));
        System.out.println("Get the index of 8");
        System.out.println(list1.indexOf(8));
        System.out.println("Get the index of 18");
        System.out.println(list1.indexOf(18));
        System.out.println("Get the last index of 8");
        System.out.println(list1.lastIndexOf(8));
        System.out.println("Get the last index of 18");
        System.out.println(list1.lastIndexOf(18));
        System.out.println("Get the element at index 8");
        System.out.println(list1.get(8));
        System.out.println("Set the element at index 8 to be 18");
        System.out.println(list1.set(8, 18));
        printList(list1);
        System.out.println("Clear the list");
        list1.clear();
        printList(list1);
        System.out.println();
        
        System.out.println("Create a list");
        List<String> list2 = new ArrayList<String>(3);
        printList(list2);
        System.out.println("Add elements");
        list2.add("One");
        list2.add("Two");
        list2.add(0, "Zero");
        list2.add(3, "Three");
        printList(list2);
        System.out.println("Remove Zero");
        System.out.println(list2.remove("Zero"));
        printList(list2);
        System.out.println("Remove element at index 1");
        System.out.println(list2.remove(1));
        printList(list2);
        System.out.println("Iterate the list");
        Iterator<String> iter = list2.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
