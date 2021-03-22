import java.util.Collections;

/**
 * Code for testing binary search tree.
 * @author Shenqi Zhang
 *
 */
public class BinarySearchTreeTest {
    /**
     * Test binary search tree.
     * @param args arguments
     */
    public static void main(String[] args) {
        //     3
        //    / \
        //   2   5
        //  /   / \
        // 1   4   6
        BinarySearchTree<Integer> bst;
        
        System.out.println("Construct a binary tree in natural order");
        bst = new BinarySearchTree<Integer>();
        System.out.println("Add 3");
        System.out.println(bst.add(3));
        System.out.println("Add 2");
        System.out.println(bst.add(2));
        System.out.println("Add 5");
        System.out.println(bst.add(5));
        System.out.println("Add 1");
        System.out.println(bst.add(1));
        System.out.println("Add 4");
        System.out.println(bst.add(4));
        System.out.println("Add 6");
        System.out.println(bst.add(6));
        System.out.println("Add 4");
        System.out.println(bst.add(4));
        System.out.println("Add 6");
        System.out.println(bst.add(6));
        System.out.println("Contain 1");
        System.out.println(bst.contains(1));
        System.out.println("Contain 7");
        System.out.println(bst.contains(7));
        System.out.print("preorder: ");
        System.out.println(bst.preorder());
        System.out.print("inorder: ");
        System.out.println(bst.inorder());
        System.out.print("postorder: ");
        System.out.println(bst.postorder());
        System.out.println("Height");
        System.out.println(bst.height());
        System.out.println();
        
        System.out.println("Construct a binary tree in reverse order");
        bst = new BinarySearchTree<Integer>(Collections.reverseOrder());
        bst.add(3);
        bst.add(2);
        bst.add(5);
        bst.add(1);
        bst.add(4);
        bst.add(6);
        System.out.print("preorder: ");
        System.out.println(bst.preorder());
        System.out.print("inorder: ");
        System.out.println(bst.inorder());
        System.out.print("postorder: ");
        System.out.println(bst.postorder());
        System.out.println();
    }
}
