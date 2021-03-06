/**
 * Code for testing binary tree.
 * @author Shenqi Zhang
 *
 */
public class BinaryTreeTest {
    /**
     * Test binary tree.
     * @param args arguments
     */
    public static void main(String[] args) {
        //     3
        //    / \
        //   2   5
        //  /   / \
        // 1   4   6
        Integer[] preorder = {3, 2, 1, 5, 4, 6};
        Integer[] inorder = {1, 2, 3, 4, 5, 6};
        Integer[] postorder = {1, 2, 4, 6, 5, 3};
        BinaryTree<Integer> tree;
        
        System.out.println("Construct a binary tree from preorder and inorder");
        tree = new BinaryTree<Integer>(BinaryTree.ConstructMethod.PREORDER_INORDER, preorder, inorder);
        System.out.print("preorder: ");
        System.out.println(tree.preorder());
        System.out.print("inorder: ");
        System.out.println(tree.inorder());
        System.out.print("postorder: ");
        System.out.println(tree.postorder());
        System.out.println();
        
        System.out.println("Construct a binary tree from inorder and postorder");
        tree = new BinaryTree<Integer>(BinaryTree.ConstructMethod.INORDER_POSTORDER, inorder, postorder);
        System.out.print("preorder: ");
        System.out.println(tree.preorder());
        System.out.print("inorder: ");
        System.out.println(tree.inorder());
        System.out.print("postorder: ");
        System.out.println(tree.postorder());
        System.out.println();
        
        System.out.println("Construct a binary tree from preorder and postorder");
        tree = new BinaryTree<Integer>(BinaryTree.ConstructMethod.PREORDER_POSTORDER, preorder, postorder);
        System.out.print("preorder: ");
        System.out.println(tree.preorder());
        System.out.print("inorder: ");
        System.out.println(tree.inorder());
        System.out.print("postorder: ");
        System.out.println(tree.postorder());
        System.out.println();
        
        System.out.println("Contain 5");
        System.out.println(tree.contains(5));
        System.out.println("Contain 1");
        System.out.println(tree.contains(1));
        System.out.println("Contain 7");
        System.out.println(tree.contains(7));
        System.out.println("Height");
        System.out.println(tree.height());
    }
}
