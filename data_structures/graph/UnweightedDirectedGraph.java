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
        if (!adjacencyList.get(source).contains(destination)) {
            return false;
        }
        
        adjacencyList.get(source).remove(Integer.valueOf(destination));
        return true;
    }
}
