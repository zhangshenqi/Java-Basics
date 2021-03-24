import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public abstract class UnweightedGraph implements Graph {
    Map<Integer, List<Integer>> adjacencyList;
    
    public UnweightedGraph() {
        adjacencyList = new HashMap<Integer, List<Integer>>();
    }
    
    /**
     * Adds a vertex into this graph.
     * @param vertex the vertex to be added
     * @return true if this graph changed as a result of the call
     */
    @Override
    public boolean addVertex(int vertex) {
        if (adjacencyList.containsKey(vertex)) {
            return false;
        }
        
        adjacencyList.put(vertex, new ArrayList<Integer>());
        return true;
    }
    
    /**
     * Removes a vertex from this graph.
     * @param vertex the vertex to be removed
     * @return true if this graph changed as a result of the call
     */
    @Override
    public boolean removeVertex(int vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            return false;
        }
        
        adjacencyList.remove(vertex);
        for (int key : adjacencyList.keySet()) {
            adjacencyList.get(key).remove(Integer.valueOf(vertex));
        }
        return true;
    }
    
    /**
     * Adds an edge into this graph.
     * @param source the source vertex
     * @param destination the destination vertex
     * @return true if this graph changed as a result of the call
     */
    public abstract boolean addEdge(int source, int destination);
    
    /**
     * Removes an edge from this graph.
     * @param source the source vertex
     * @param destination the destination vertex
     * @return true if this graph changed as a result of the call
     */
    public abstract boolean removeEdge(int source, int destination);
    
    /**
     * Gets the shortest distance from the source vertex to the destination vertex.
     * @param source the source vertex
     * @param destination the destination vertex
     * @return the shortest distance from the source vertex to the destination vertex, if it is found; otherwise, -1.
     */
    @Override
    public int getShortestDistance(int source, int destination) {
        if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(destination)) {
            return -1;
        }
        
        if (source == destination) {
            return 0;
        }
        
        int distance = 1;
        Set<Integer> visited = new HashSet<Integer>();
        visited.add(source);
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int neighbor : adjacencyList.get(curr)) {
                    if (neighbor == destination) {
                        return distance;
                    }
                    if (visited.add(neighbor)); {
                        queue.add(neighbor);
                    }
                }
            }
            distance++;
        }
        return -1;
    }
    
    /**
     * Gets the shortest path from the source vertex to the destination vertex.
     * If there are multiple shortest path, there is no guarantee which one will be found.
     * @param source the source vertex
     * @param destination the destination vertex
     * @return the shortest path from the source vertex to the destination vertex, if it is found; otherwise, -1.
     */
    @Override
    public List<Integer> getShortestPath(int source, int destination) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int key : adjacencyList.keySet()) {
            sb.append(key).append(":");
            List<Integer> neighbors = adjacencyList.get(key);
            int size = neighbors.size();
            if (size > 0) {
                sb.append(" ").append(neighbors.get(0));
            }
            for (int i = 1; i < size; i++) {
                sb.append(", ").append(neighbors.get(i));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
