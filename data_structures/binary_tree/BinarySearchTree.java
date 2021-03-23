import java.util.Comparator;

/**
 * Binary search tree.
 * Permits all elements, including null.
 * @author Shenqi Zhang
 * @param <E> the type of elements in this tree
 *
 */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {
    /**
     * The comparator to determine the order of this tree.
     */
    private Comparator<E> comparator;
    
    /**
     * Constructs an empty binary search tree with the natural order.
     */
    public BinarySearchTree() {
        this(null);
    }
    
    /**
     * Constructs an empty binary search tree with specified comparator.
     * @param c the comparator to determine the order of this tree
     */
    public BinarySearchTree(Comparator<E> c) {
        super();
        if (c == null) {
            comparator = (e1, e2) -> e1.compareTo(e2);
        } else {
            comparator = c;
        }
    }
    
    /**
     * Returns true if this tree contains the specified element.
     * @param e element whose presence in this tree is to be tested
     * @return true if this tree contains the specified element
     */
    @Override
    public boolean contains(E e) {
        return contains(e, root);
    }
    
    /**
     * Returns true if the specified tree contains the specified element.
     * @param e element whose presence in the specified tree is to be tested
     * @param node root of the specified tree
     * @return true if the specified tree contains the specified element
     */
    @Override
    protected boolean contains(E e, Node<E> node) {
        if (node == null) {
            return false;
        }
        
        int compareResult = comparator.compare(e, node.item);
        if (compareResult < 0) {
            return contains(e, node.left);
        }
        if (compareResult > 0) {
            return contains(e, node.right);
        }
        return true;
    }
    
    /**
     * Adds an item into this tree.
     * @param e the item to be added into this tree
     * @return true if this tree changed as a result of the call
     */
    public boolean add(E e) {
        if (root == null) {
            root = new Node<E>(e);
            return true;
        }
        
        return add(e, root, root, false);
    }
    
    /**
     * Adds an item into this tree.
     * @param e the item to be added into this tree
     * @param curr current node
     * @param parent parent node
     * @param isLeftChild true if curr is the left child of parent
     * @return true if this tree changed as a result of the call
     */
    protected boolean add(E e, Node<E> curr, Node<E> parent, boolean isLeftChild) {
        if (curr == null) {
            if (isLeftChild) {
                parent.left = new Node<E>(e);
            } else {
                parent.right = new Node<E>(e);
            }
            return true;
        }
        
        int compareResult = comparator.compare(e, curr.item);
        if (compareResult < 0) {
            return add(e, curr.left, curr, true);
        }
        if (compareResult > 0) {
            return add(e, curr.right, curr, false);
        }
        return false;
    }
    
    /**
     * Removes an item from this tree.
     * @param e the item to be removed from this tree
     * @return true if this tree changed as a result of the call
     */
    public boolean remove(E e) {
        if (root == null) {
            return false;
        }
        
        return remove(e, root, root, false);
    }
    
    /**
     * Removes an item from this tree.
     * @param e the item to be removed from this tree
     * @param curr current node
     * @param parent parent node
     * @param isLeftChild true if curr is the left child of parent
     * @return true if this tree changed as a result of the call
     */
    protected boolean remove(E e, Node<E> curr, Node<E> parent, boolean isLeftChild) {
        if (curr == null) {
            return false;
        }
        
        int compareResult = comparator.compare(e, curr.item);
        if (compareResult < 0) {
            return remove(e, curr.left, curr, true);
        }
        if (compareResult > 0) {
            return remove(e, curr.right, curr, false);
        }
        
        if (curr.left == null) {
            if (curr.right == null) {
                if (curr == root) {
                    root = null;
                } else if (isLeftChild) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else {
                if (curr == root) {
                    root = curr.right;
                } else if (isLeftChild) {
                    parent.left = curr.right;
                } else {
                    parent.right = curr.right;
                }
            }
        } else {
            if (curr.right == null) {
                if (curr == root) {
                    root = curr.left;
                } else if (isLeftChild) {
                    parent.left = curr.left;
                } else {
                    parent.right = curr.left;
                }
            } else {
                Node<E> successor = curr.right;
                Node<E> successorParent = curr;
                while (successor.left != null) {
                    successorParent = successor;
                    successor = successor.left;
                }
                
                if (successor != curr.right) {
                    successorParent.left = successor.right;
                    successor.right = curr.right;
                }
                successor.left = curr.left;
                
                if (curr == root) {
                    root = successor;
                } else if (isLeftChild) {
                    parent.left = successor;
                } else {
                    parent.right = successor;
                }
            }
        }
        
        return true;
    }
}
