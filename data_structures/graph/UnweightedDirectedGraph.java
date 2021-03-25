import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;
import java.util.HashMap;

/**
 * Class for unweighted directed graph.
 * @author Shenqi Zhang
 *
 */
public class UnweightedDirectedGraph extends UnweightedGraph {
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
        
        if (!adjacencyList.get(source).contains(destination)) {
            return false;
        }
        
        adjacencyList.get(source).remove(Integer.valueOf(destination));
        return true;
    }
    
    /**
     * Returns true if this graph contains loop.
     * @return true if this graph contains loop
     */
    @Override
    public boolean containsLoop() {
        Map<Integer, Integer> indegrees = new HashMap<Integer, Integer>();
        for (int key : adjacencyList.keySet()) {
            indegrees.put(key, 0);
        }
        for (int key : adjacencyList.keySet()) {
            for (int neighbor : adjacencyList.get(key)) {
                indegrees.put(neighbor, indegrees.get(neighbor) + 1);
            }
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int key : indegrees.keySet()) {
            if (indegrees.get(key) == 0) {
                queue.add(key);
            }
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            indegrees.remove(curr);
            for (int neighbor : adjacencyList.get(curr)) {
                indegrees.put(neighbor, indegrees.get(neighbor) - 1);
                if (indegrees.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }
        return indegrees.size() != 0;
    }
}
