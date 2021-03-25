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
        //   0---1
        //  /   / \
        // 2---3   4
        //  \     /
        //   5---6
        System.out.println("Add edges");
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);
        System.out.print(graph);
        System.out.println("Distance from 0 to 0");
        System.out.println(graph.getShortestDistance(0, 0));
        System.out.println("Path from 0 to 0");
        System.out.println(graph.getShortestPath(0, 0));
        System.out.println("Distance from 2 to 4");
        System.out.println(graph.getShortestDistance(2, 4));
        System.out.println("Path from 2 to 4");
        System.out.println(graph.getShortestPath(2, 4));
        System.out.println("Distance from 0 to 6");
        System.out.println(graph.getShortestDistance(0, 6));
        System.out.println("Path from 0 to 6");
        System.out.println(graph.getShortestPath(0, 6));
        System.out.println("Contain loop");
        System.out.println(graph.containsLoop());
        System.out.println("Remove edges");
        graph.removeEdge(0, 1);
        graph.removeEdge(0, 2);
        graph.removeEdge(1, 3);
        graph.removeEdge(1, 4);
        graph.removeEdge(2, 3);
        graph.removeEdge(2, 5);
        graph.removeEdge(4, 6);
        graph.removeEdge(5, 6);
        graph.removeEdge(0, 1);
        graph.removeEdge(0, 7);
        System.out.print(graph);
    }
    
    /**
     * Test unweighted graphs.
     * @param args arguments
     */
    public static void main(String[] args) {
        System.out.println("Constructs an unweighted undirected graph");
        testGraph(new UnweightedUndirectedGraph());
        System.out.println();
        System.out.println("Constructs an unweighted directed graph");
        testGraph(new UnweightedDirectedGraph());
    }
}
