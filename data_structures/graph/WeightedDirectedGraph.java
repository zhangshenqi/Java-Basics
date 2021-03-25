/**
 * Class for weighted directed graph.
 * @author Shenqi Zhang
 *
 */
public class WeightedDirectedGraph extends WeightedGraph {
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
                return true;
            }
        }
        return false;
    }
}
