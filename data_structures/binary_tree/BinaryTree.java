import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Binary tree.
 * Permits all elements, including null.
 * @author Shenqi Zhang
 * @param <E> the type of elements in this list
 *
 */
public class BinaryTree<E> {
    /**
     * Methods to construct the tree.
     */
    public enum ConstructMethod {PREORDER_INORDER, PREORDER_POSTORDER, INORDER_POSTORDER};
    
    /**
     * Root of this tree.
     */
    protected Node<E> root;
    
    /**
     * Constructs an empty tree.
     */
    public BinaryTree() {
        root =  null;
    }
    
    /**
     * Constructs a tree with two orders. No duplicate element is allowed.
     * @param method the method to construct the tree
     * @param order1 the first order
     * @param order2 the second order
     */
    public BinaryTree(ConstructMethod method, E[] order1, E[] order2) {
        if (order1.length != order2.length) {
            throw new IllegalArgumentException();
        }
        
        switch (method) {
        case PREORDER_INORDER:
            constructFromPreorderInorder(order1, order2);
            break;
        case PREORDER_POSTORDER:
            constructFromPreorderPostorder(order1, order2);
            break;
        case INORDER_POSTORDER:
            constructFromInorderPostorder(order1, order2);
            break;
        default:
            throw new IllegalArgumentException();
        }
    }
    
    /**
     * Constructs a tree with preorder and inorder. No duplicate element is allowed.
     * @param preorder preorder
     * @param inorder inorder
     */
    public void constructFromPreorderInorder(E[] preorder, E[] inorder) {
        Map<E, Integer> inorderIndexMap = new HashMap<E, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        root = constructFromPreorderInorder(preorder, new int[]{0}, inorder, 0, inorder.length - 1, inorderIndexMap);
    }
    
    /**
     * Constructs a tree with preorder and inorder. No duplicate element is allowed.
     * @param preorder preorder
     * @param leftPre the index of the first element in preorder
     * @param inorder inorder
     * @param leftIn the index of the first element in inorder
     * @param rightIn the index of the last element in inorder
     * @param inorderIndexMap the map which contains the index of each element of inorder
     * @return the root of the tree
     */
    private Node<E> constructFromPreorderInorder(E[] preorder, int[] leftPre, E[] inorder, int leftIn, int rightIn, Map<E, Integer> inorderIndexMap) {
        if (leftIn > rightIn) {
            return null;
        }
        
        E nodeVal = preorder[leftPre[0]];
        leftPre[0]++;
        Node<E> node = new Node<E>(nodeVal);
        
        int inorderIndex = inorderIndexMap.get(nodeVal);
        node.left = constructFromPreorderInorder(preorder, leftPre, inorder, leftIn, inorderIndex - 1, inorderIndexMap);
        node.right = constructFromPreorderInorder(preorder, leftPre, inorder, inorderIndex + 1, rightIn, inorderIndexMap);
        return node;
    }
    
    public void constructFromPreorderPostorder(E[] preorder, E[] postorder) {
        
    }
    
    /**
     * Constructs a tree with inorder and postorder. No duplicate element is allowed.
     * @param inorder inorder
     * @param postorder postorder
     */
    public void constructFromInorderPostorder(E[] inorder, E[] postorder) {
        Map<E, Integer> inorderIndexMap = new HashMap<E, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        root = constructFromInorderPostorder(inorder, 0, inorder.length - 1, inorderIndexMap, postorder, new int[]{postorder.length - 1});
    }
    
    /**
     * Constructs a tree with inorder and postorder. No duplicate element is allowed.
     * @param inorder inorder
     * @param leftIn the index of the first element in inorder
     * @param rightIn the index of the last element in inorder
     * @param inorderIndexMap the map which contains the index of each element of inorder
     * @param postorder post order
     * @param rightPost the index of the last element in postorder
     * @return the root of the tree
     */
    private Node<E> constructFromInorderPostorder(E[] inorder, int leftIn, int rightIn, Map<E, Integer> inorderIndexMap, E[] postorder, int[] rightPost) {
        if (leftIn > rightIn) {
            return null;
        }
        
        E nodeVal = postorder[rightPost[0]];
        rightPost[0]--;
        Node<E> node = new Node<E>(nodeVal);
        
        int inorderIndex = inorderIndexMap.get(nodeVal);
        node.right = constructFromInorderPostorder(inorder, inorderIndex + 1, rightIn, inorderIndexMap, postorder, rightPost);
        node.left = constructFromInorderPostorder(inorder, leftIn, inorderIndex - 1, inorderIndexMap, postorder, rightPost);
        return node;
    }
    
    /**
     * Returns the height of this tree.
     * @return the height of this tree
     */
    public int height() {
        return height(root);
    }
    
    /**
     * Returns the height of the specified tree.
     * @param node root of the specified tree
     * @return the height of the specified tree
     */
    public int height(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
    
    /**
     * Returns true if this tree contains the specified element.
     * @param e element whose presence in this tree is to be tested
     * @return true if this tree contains the specified element
     */
    public boolean contains(E e) {
        return contains(e, root);
    }
    
    /**
     * Returns true if the specified tree contains the specified element.
     * @param e element whose presence in the specified tree is to be tested
     * @param node root of the specified tree
     * @return true if the specified tree contains the specified element
     */
    private boolean contains(E e, Node<E> node) {
        if (node == null) {
            return false;
        }
        return node.item.equals(e) || contains(e, node.left) || contains(e, node.right);
    }
    
    /**
     * Gets the preorder list of this tree.
     * @return the preorder list of this tree
     */
    public List<E> preorder() {
        List<E> path = new ArrayList<E>();
        preorder(root, path);
        return path;
    }
    
    /**
     * Gets the preorder list of this tree.
     * @param node the current node in the recursion
     * @param path the preorder list
     */
    private void preorder(Node<E> node, List<E> path) {
        if (node == null) {
            return;
        }
        
        path.add(node.item);
        preorder(node.left, path);
        preorder(node.right, path);
    }
    
    /**
     * Gets the inorder list of this tree.
     * @return the inorder list of this tree
     */
    public List<E> inorder() {
        List<E> path = new ArrayList<E>();
        inorder(root, path);
        return path;
    }
    
    /**
     * Gets the inorder list of this tree.
     * @param node the current node in the recursion
     * @param path the inorder list of this tree
     */
    private void inorder(Node<E> node, List<E> path) {
        if (node == null) {
            return;
        }
        
        inorder(node.left, path);
        path.add(node.item);
        inorder(node.right, path);
    }
    
    /**
     * Gets the postorder list of this tree.
     * @return the postorder list of this tree
     */
    public List<E> postorder() {
        List<E> path = new ArrayList<E>();
        postorder(root, path);
        return path;
    }
    
    /**
     * Gets the postorder list of this tree.
     * @param node the current node in the recursion
     * @param path the postorder list of this tree
     */
    private void postorder(Node<E> node, List<E> path) {
        if (node == null) {
            return;
        }
        
        postorder(node.left, path);
        postorder(node.right, path);
        path.add(node.item);
    }
    
    /**
     * Node of the binary tree.
     * @param <E> the type of element in this node
     * 
     */
    private static class Node<E> {
        /**
         * Item of this node.
         */
        private E item;
        /**
         * Node of the left child.
         */
        private Node<E> left;
        /**
         * Node of the right child.
         */
        private Node<E> right;
        
        /**
         * Constructs a node with specified element and next node.
         * @param element element
         * @param next next node
         */
        Node(E element) {
            this.item = element;
            this.left = null;
            this.right = null;
        }
    }
}
