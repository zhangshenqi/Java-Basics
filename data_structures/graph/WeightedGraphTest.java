/**
 * Code for testing weighted graphs.
 * @author Shenqi Zhang
 *
 */

public class WeightedGraphTest {
    /**
     * Test the graph.
     * @param graph the graph to be tested
     */
    public static void testGraph(WeightedGraph graph) {
        //   0---1
        //  /   / \
        // 2---3   4
        //  \     /
        //   5---6
        System.out.println("Add edges");
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 2);
        graph.addEdge(2, 3, 3);
        graph.addEdge(2, 5, 3);
        graph.addEdge(4, 6, 4);
        graph.addEdge(5, 6, 5);
        System.out.print(graph);
//        System.out.println("Distance from 0 to 0");
//        System.out.println(graph.getShortestDistance(0, 0));
//        System.out.println("Path from 0 to 0");
//        System.out.println(graph.getShortestPath(0, 0));
//        System.out.println("Distance from 2 to 4");
//        System.out.println(graph.getShortestDistance(2, 4));
//        System.out.println("Path from 2 to 4");
//        System.out.println(graph.getShortestPath(2, 4));
//        System.out.println("Distance from 0 to 6");
//        System.out.println(graph.getShortestDistance(0, 6));
//        System.out.println("Path from 0 to 6");
//        System.out.println(graph.getShortestPath(0, 6));
//        System.out.println("Contain loop");
//        System.out.println(graph.containsLoop());
    }
    
    /**
     * Test weighted graphs.
     * @param args arguments
     */
    public static void main(String[] args) {
        System.out.println("Constructs a weighted undirected graph");
        testGraph(new WeightedUndirectedGraph());
//        System.out.println();
//        System.out.println("Constructs a weighted directed graph");
//        testGraph(new UnweightedDirectedGraph());
    }
}
