/**
 * Code for testing priority queue.
 * @author Shenqi Zhang
 *
 */
public class PriorityQueueTest {
    /**
     * Test priority queue.
     * @param args arguments
     */
    public static void main(String[] args) {
        System.out.println("Construct a priority queue");
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(7);
        pq.add(3);
        pq.add(5);
        pq.add(2);
        pq.add(0);
        pq.add(6);
        pq.add(1);
        pq.add(4);
        pq.add(9);
        pq.add(8);
        while (pq.size() > 0) {
            System.out.println(pq.poll());
        }
    }
}
