/**
 * Code for testing unweighted graphs.
 * @author Shenqi Zhang
 *
 */
public class UnweightedGraphTest {
    /**
     * Test the graph.
     * @param graph the graph to be tested
     */
    public static void testGraph(UnweightedGraph graph) {
        System.out.println("Add edges");
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        System.out.print(graph);
        System.out.println("Distance from 0 to 0");
        System.out.println(graph.getShortestDistance(0, 0));
        System.out.println("Distance from 0 to 4");
        System.out.println(graph.getShortestDistance(0, 4));
        System.out.println("Distance from 1 to 2");
        System.out.println(graph.getShortestDistance(1, 2));
    }
    
    /**
     * Test unweighted graphs.
     * @param args arguments
     */
    public static void main(String[] args) {
        System.out.println("Constructs an unweighted undirected graph");
        testGraph(new UnweightedUndirectedGraph());
    }
}
