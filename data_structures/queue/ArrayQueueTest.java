/**
 * Code for testing ArrayQueue.
 * @author Shenqi Zhang
 *
 */
public class ArrayQueueTest {
    /**
     * Test ArrayQueue.
     * @param args arguments
     */
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<Integer>(3);
        System.out.println("Queue is empty");
        System.out.println(queue.empty());
        System.out.println("Add 1");
        System.out.println(queue.pushBack(1));
        System.out.println("Add 2");
        System.out.println(queue.pushBack(2));
        System.out.println("Size of queue");
        System.out.println(queue.size());
        System.out.println("Add 3");
        System.out.println(queue.pushBack(3));
        System.out.println("Add 4");
        System.out.println(queue.pushBack(4));
        System.out.println("Add 5");
        System.out.println(queue.pushBack(5));
        System.out.println("Queue is empty");
        System.out.println(queue.empty());
        System.out.println("Queue is full");
        System.out.println(queue.full());
        System.out.println("Remove");
        System.out.println(queue.popFront());
        System.out.println("Add 4");
        System.out.println(queue.pushBack(4));
        System.out.println("Front of queue");
        System.out.println(queue.front());
        System.out.println("Back of queue");
        System.out.println(queue.back());
        System.out.println("Remove");
        System.out.println(queue.popFront());
        System.out.println("Add 4");
        System.out.println(queue.pushBack(4));
        System.out.println("Front of queue");
        System.out.println(queue.front());
        System.out.println("Back of queue");
        System.out.println(queue.back());
        System.out.println("Remove");
        System.out.println(queue.popFront());
        System.out.println("Add 4");
        System.out.println(queue.pushBack(4));
        System.out.println("Front of queue");
        System.out.println(queue.front());
        System.out.println("Back of queue");
        System.out.println(queue.back());
    }
}
