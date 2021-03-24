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
}
