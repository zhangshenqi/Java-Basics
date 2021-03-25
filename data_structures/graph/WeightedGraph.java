import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

/**
 * Class for weighted graph.
 * @author Shenqi Zhang
 *
 */
public abstract class WeightedGraph implements Graph {
    /**
     * Each vertex stores a list of adjacent vertexes and weights.
     */
    protected Map<Integer, List<Pair>> adjacencyList;
    
    /**
     * Constructs an empty graph.
     */
    public WeightedGraph() {
        adjacencyList = new HashMap<Integer, List<Pair>>();
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
        
        adjacencyList.put(vertex, new ArrayList<Pair>());
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
        for (List<Pair> neighbors : adjacencyList.values()) {
            int size = neighbors.size();
            for (int i = 0; i < size; i++) {
                if (neighbors.get(i).vertex == vertex) {
                    neighbors.remove(i);
                    break;
                }
            }
        }
        return true;
    }
    
    /**
     * Adds an edge into this graph.
     * @param source the source vertex
     * @param destination the destination vertex
     * @weight weight of the edge
     * @return true if this graph changed as a result of the call
     */
    public abstract boolean addEdge(int source, int destination, int weight);
    
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
        
        Map<Integer, Integer> distances = new HashMap<Integer, Integer>();
        for (int key : adjacencyList.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }
        distances.put(source, 0);
        Set<Integer> settled = new HashSet<Integer>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (a[1] - b[1]));
        pq.add(new int[] {source, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[0] == destination) {
                return curr[1];
            }
            if (!settled.add(curr[0])) {
                continue;
            }
            List<Pair> neighbors = adjacencyList.get(curr[0]);
            for (Pair neighbor : neighbors) {
                if (settled.contains(neighbor.vertex)) {
                    continue;
                }
                int newDistance = distances.get(curr[0]) + neighbor.weight;
                if (newDistance < distances.get(neighbor.vertex)) {
                    distances.put(neighbor.vertex, newDistance);
                    pq.add(new int[] {neighbor.vertex, newDistance});
                }
            }
        }
        return -1;
    }
    
    /**
     * Gets the shortest path from the source vertex to the destination vertex.
     * If there are multiple shortest path, there is no guarantee which one will be found.
     * @param source the source vertex
     * @param destination the destination vertex
     * @return the shortest path from the source vertex to the destination vertex, if it is found; otherwise, empty list.
     */
    @Override
    public List<Integer> getShortestPath(int source, int destination) {
        List<Integer> path = new ArrayList<Integer>();
        if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(destination)) {
            return path;
        }
        
        Map<Integer, Integer> distances = new HashMap<Integer, Integer>();
        for (int key : adjacencyList.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }
        distances.put(source, 0);
        Set<Integer> settled = new HashSet<Integer>();
        Map<Integer, Integer> parentMap = new HashMap<Integer, Integer>();
        parentMap.put(source, source);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (a[1] - b[1]));
        pq.add(new int[] {source, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[0] == destination) {
                retrievePath(destination, parentMap, path);
                return path;
            }
            if (!settled.add(curr[0])) {
                continue;
            }
            List<Pair> neighbors = adjacencyList.get(curr[0]);
            for (Pair neighbor : neighbors) {
                if (settled.contains(neighbor.vertex)) {
                    continue;
                }
                int newDistance = distances.get(curr[0]) + neighbor.weight;
                if (newDistance < distances.get(neighbor.vertex)) {
                    distances.put(neighbor.vertex, newDistance);
                    parentMap.put(neighbor.vertex, curr[0]);
                    pq.add(new int[] {neighbor.vertex, newDistance});
                }
            }
        }
        return path;
    }
    
    /**
     * Retrieves the path from the source to the current vertex.
     * @param curr the current vertex
     * @param parentMap map which stores the parent of each vertex
     * @param path path
     */
    private void retrievePath(int curr, Map<Integer, Integer> parentMap, List<Integer> path) {
        while (parentMap.get(curr) != curr) {
            path.add(curr);
            curr = parentMap.get(curr);
        }
        path.add(curr);
        
        int i = 0, j = path.size() - 1;
        while (i < j) {
            int temp = path.get(i);
            path.set(i, path.get(j));
            path.set(j, temp);
            i++;
            j--;
        }
    }
    
    /**
     * Returns the string representation of this graph.
     * @return string representation of this graph
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int key : adjacencyList.keySet()) {
            sb.append(key).append(":");
            List<Pair> neighbors = adjacencyList.get(key);
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
    
    /**
     * A pair consists of the adjacent vertex and the weight of this edge.
     * 
     */
    static class Pair {
        /**
         * The adjacent vertex.
         */
        int vertex;
        /**
         * Weight of this edge.
         */
        int weight;
        
        /**
         * Constructs a pair with specified vertex and weight.
         * @param vertex vertex
         * @param weight weight
         */
        Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        
        /**
         * Returns the string representation of this pair.
         * @return string representation of this pair
         */
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(vertex).append('(').append(weight).append(')');
            return sb.toString();
        }
        
        /**
         * Indicates whether some other object is "equal to" this pair.
         * @param obj the reference object with which to compare
         * @return true if this object is the same as the obj argument; false otherwise.
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }
            
            Pair that = (Pair) obj;
            return this.vertex == that.vertex && this.weight == that.weight;
        }
    }
}
