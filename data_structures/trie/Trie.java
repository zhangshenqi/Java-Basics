import java.util.HashMap;
import java.util.Map;

/**
 * Prefix Trie.
 * @author Shenqi Zhang
 *
 */
public class Trie {
    /**
     * Root of this trie.
     */
    private Node root;
    
    /**
     * Constructs a trie.
     */
    public Trie() {
        root = new Node();
    }
    
    /**
     * Adds a specified word to this trie.
     * @param word word
     */
    public void add(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new Node());
            node = node.children.get(c);
        }
        node.end = true;
    }
    
    /**
     * Returns true if this trie contains the specified word.
     * @param word word
     * @param exact exact
     * @return true if this trie contains the specified word
     */
    public boolean constains(String word, boolean exact) {
        Node node = root;
        for (char c : word.toCharArray()) {
            Node child = node.children.get(c);
            if (child == null) {
                return false;
            }
            node = child;
        }
        return !exact || node.end;
    }
    
    /**
     * Trie node.
     *
     */
    private static class Node {
        /**
         * True if this is the end of a word.
         */
        boolean end;
        /**
         * Children of this node.
         */
        Map<Character, Node> children;
        
        /**
         * Constructs a node.
         */
        Node() {
            end = false;
            children = new HashMap<Character, Node>();
        }
    }
}
