import java.util.Map;
import java.util.HashMap;

/**
 * Class for disjoint set union.
 * @author Shenqi Zhang
 *
 */
public class DisjointSetUnion {
    /**
     * Stores the parent of each set.
     */
    private Map<Integer, Integer> parents;
    
    /**
     * Constructs an empty disjoint union set.
     */
    public DisjointSetUnion() {
        parents = new HashMap<Integer, Integer>();
    }
    
    /**
     * Adds a new element.
     * @param x a new element
     */
    public void makeSet(int x) {
        if (!parents.containsKey(x)) {
            parents.put(x, x);
        }
    }
    
    /**
     * Merges two elements.
     * @param x the first element to be merged
     * @param y the second element to be merged
     */
    public void union(int x, int y) {
        int root1 = find(x), root2 = find(y);
        if (root1 != root2) {
            parents.put(root1, root2);
        }
    }
    
    /**
     * Finds the root of the specified element.
     * @param x the specified element
     * @return the root of the specified element
     */
    public int find(int x) {
        int root = x;
        while (parents.get(root) != root) {
            parents.put(root, parents.get(parents.get(root)));
            root = parents.get(root);
        }
        return root;
    }
}
