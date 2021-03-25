import java.util.List;
import java.util.ArrayList;
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
    
    @Override
    public int getShortestDistance(int source, int destination) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public List<Integer> getShortestPath(int source, int destination) {
        // TODO Auto-generated method stub
        return null;
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
    }
}
