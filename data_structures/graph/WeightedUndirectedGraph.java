import java.util.Map;
import java.util.HashMap;

/**
 * Class for weighted undirected graph.
 * @author Shenqi Zhang
 *
 */
public class WeightedUndirectedGraph extends WeightedGraph {
    /**
     * Adds an edge into this graph.
     * @param source the source vertex
     * @param destination the destination vertex
     * @weight weight of the edge
     * @return true if this graph changed as a result of the call
     */
    @Override
    public boolean addEdge(int source, int destination, int weight) {
        addVertex(source);
        addVertex(destination);
        
        for (Pair neighbor : adjacencyList.get(source)) {
            if (neighbor.vertex == destination) {
                return false;
            }
        }
        
        adjacencyList.get(source).add(new Pair(destination, weight));
        adjacencyList.get(destination).add(new Pair(source, weight));
        return true;
    }
    
    /**
     * Removes an edge from this graph.
     * @param source the source vertex
     * @param destination the destination vertex
     * @return true if this graph changed as a result of the call
     */
    @Override
    public boolean removeEdge(int source, int destination) {
        if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(destination)) {
            return false;
        }
        
        int size = adjacencyList.get(source).size();
        for (int i = 0; i < size; i++) {
            Pair neighbor = adjacencyList.get(source).get(i);
            if (neighbor.vertex == destination) {
                adjacencyList.get(source).remove(i);
                neighbor.vertex = source;
                adjacencyList.get(destination).remove(neighbor);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Gets the minimum spanning tree of this graph.
     * @return the minimum spanning tree of this graph
     */
    public WeightedUndirectedGraph getMinimumSpanningTree() {
        WeightedUndirectedGraph graph = new WeightedUndirectedGraph();
        if (adjacencyList.size() == 0) {
            return graph;
        }
        
        if (adjacencyList.size() == 1) {
            graph.addVertex(adjacencyList.keySet().iterator().next());
            return graph;
        }
        
        Map<Integer, Integer> parentMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> costs = new HashMap<Integer, Integer>();
        for (int key : adjacencyList.keySet()) {
            costs.put(key, Integer.MAX_VALUE);
        }
        int root = adjacencyList.keySet().iterator().next();
        costs.put(root, -1);
        
        for (int i = adjacencyList.size() - 1; i >= 0; i--) {
            int curr = -1, minCost = Integer.MAX_VALUE;
            for (int key : costs.keySet()) {
                if (!graph.adjacencyList.containsKey(key) && costs.get(key) < minCost) {
                    minCost = costs.get(key);
                    curr = key;
                }
            }
            if (curr == -1) {
                return null;
            }
            costs.remove(curr);
            if (parentMap.containsKey(curr)) {
                graph.addEdge(parentMap.get(curr), curr, minCost);
            }
            
            for (Pair neighbor : adjacencyList.get(curr)) {
                if (costs.containsKey(neighbor.vertex) && neighbor.weight < costs.get(neighbor.vertex)) {
                    costs.put(neighbor.vertex, neighbor.weight);
                    parentMap.put(neighbor.vertex, curr);
                }
            }
        }
        return graph;
    }
}
