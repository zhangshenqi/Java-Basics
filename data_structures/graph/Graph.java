import java.util.List;
import java.util.Map;

/**
 * A graph consists of a finite set of vertices and edges.
 * @author Shenqi Zhang
 *
 */
public interface Graph {
    /**
     * Adds a vertex into this graph.
     * @param vertex the vertex to be added
     * @return true if this graph changed as a result of the call
     */
    boolean addVertex(int vertex);
    
    /**
     * Removes a vertex from this graph.
     * @param vertex the vertex to be removed
     * @return true if this graph changed as a result of the call
     */
    boolean removeVertex(int vertex);
    
    /**
     * Gets the shortest distance from the source vertex to the destination vertex.
     * @param source the source vertex
     * @param destination the destination vertex
     * @return the shortest distance from the source vertex to the destination vertex, if it is found; otherwise, -1.
     */
    int getShortestDistance(int source, int destination);
    
    /**
     * Gets the shortest distances from the source vertex to all vertices.
     * @param source the source vertex
     * @return the shortest distances from the source vertex to to all vertices, if it is found; otherwise, -1.
     */
    Map<Integer, Integer> getShortestDistances(int source);
    
    /**
     * Gets the shortest path from the source vertex to the destination vertex.
     * If there are multiple shortest path, there is no guarantee which one will be found.
     * @param source the source vertex
     * @param destination the destination vertex
     * @return the shortest path from the source vertex to the destination vertex, if it is found; otherwise, empty list.
     */
    List<Integer> getShortestPath(int source, int destination);
}
