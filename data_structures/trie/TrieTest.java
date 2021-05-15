/**
 * Code for testing Trie
 * @author Shenqi Zhang
 *
 */
public class TrieTest {
    /**
     * Test Trie.
     * @param args arguments
     */
    public static void main(String[] args) {
        System.out.println("Create a trie");
        Trie trie = new Trie();
        trie.add("a");
        trie.add("app");
        trie.add("apple");
        trie.add("abc");
        System.out.println("Test word");
        System.out.println(trie.constains("a", true));
        System.out.println(trie.constains("ap", true));
        System.out.println(trie.constains("app", true));
        System.out.println(trie.constains("appl", true));
        System.out.println(trie.constains("apple", true));
        System.out.println(trie.constains("ab", true));
        System.out.println(trie.constains("abc", true));
        System.out.println("Test prefix");
        System.out.println(trie.constains("a", false));
        System.out.println(trie.constains("ap", false));
        System.out.println(trie.constains("app", false));
        System.out.println(trie.constains("appl", false));
        System.out.println(trie.constains("apple", false));
        System.out.println(trie.constains("ab", false));
        System.out.println(trie.constains("abc", false));
    }
}
