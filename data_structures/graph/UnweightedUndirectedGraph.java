import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;
import java.util.HashMap;

/**
 * Class for unweighted undirected graph.
 * @author Shenqi Zhang
 *
 */
public class UnweightedUndirectedGraph extends UnweightedGraph {
    /**
     * Adds an edge into this graph.
     * @param source the source vertex
     * @param destination the destination vertex
     * @return true if this graph changed as a result of the call
     */
    @Override
    public boolean addEdge(int source, int destination) {
        addVertex(source);
        addVertex(destination);
        
        if (adjacencyList.get(source).contains(destination)) {
            return false;
        }
        
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
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
        if (!adjacencyList.get(source).contains(destination)) {
            return false;
        }
        
        adjacencyList.get(source).remove(Integer.valueOf(destination));
        adjacencyList.get(destination).remove(Integer.valueOf(source));
        return true;
    }
    
    /**
     * Returns true if this graph contains loop.
     * @return true if this graph contains loop
     */
    @Override
    public boolean containsLoop() {
        Map<Integer, Integer> degrees = new HashMap<Integer, Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int key : adjacencyList.keySet()) {
            int degree = adjacencyList.get(key).size();
            if (degree > 0) {
                degrees.put(key, degree);
                if (degree == 1) {
                    queue.add(key);
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            degrees.remove(curr);
            for (int neighbor : adjacencyList.get(curr)) {
                if (degrees.containsKey(neighbor)) {
                    degrees.put(neighbor, degrees.get(neighbor) - 1);
                    if (degrees.get(neighbor) == 1) {
                        queue.add(neighbor);
                    }
                }
            }
        }
        return degrees.size() != 0;
    }
}
