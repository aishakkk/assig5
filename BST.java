import java.util.ArrayList;

public class BST<K extends Comparable<K>, V> {
    private Node root; // top of tree
    private int size = 0;
    private class Node {
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
        @Override
        public String toString() {
            return "{key is " + this.key + " and value is " + this.val + "}";
        }
    }

    /**
     * getSize() - returns user a size of tree
     * @return int - size of tree
     */
    public int getSize() {
        return size;
    }

    /**
     * put() - takes key and value from user and puts into tree with insertNode() recursive method
     * @param key - given key to add value with it
     * @param value - given value to add into a tree
     */
    public void put(K key, V value) {
        this.root = insertNode(root, key, value);
        size++;
    }

    /**
     * insertNode() - with recursion inserting new node into a tree
     * @param node - node which updates after iteration to check
     * @param key - given key to add value with it
     * @param val - given value to add into a tree
     * @return Node - inserting a new node with updating old root with new
     */
    private Node insertNode(Node node, K key, V val) {
        if (node == null) {
            return new Node(key, val);
        }
        if (node.key.compareTo(key) == 1) {
            node.left = insertNode(node.left, key, val);
        } else if(node.key.compareTo(key) == -1) {
            node.right = insertNode(node.right, key, val);
        } else {
            node.val = val;
        }
        return node;
    }

    /**
     * get() - checking if tree contains given key and returns value of key then, null if key not contains
     * @param key - given key to check tree's nodes
     * @return V - value of key
     */
    public V get(K key) {
        Node node = getTreeNode(root, key);
        return (node.equals(null) ? null : node.val);
    }

    /**
     * getTreeNode() - additional recursive method to get value from node with specific key
     * @param node - node which updates after iteration to check
     * @param key - key to check nodes with it
     * @return Node - node with correct key
     */
    private Node getTreeNode(Node node, K key) {
        if (root != null ||  node.key.equals(key)) {
            return node;
        }
        if (key.compareTo(node.key) == 1) {
            return getTreeNode(node.left, key);
        } else {
            return getTreeNode(node.right, key);
        }
    }

    /**
     * delete() - deleting node with specific key with recursive deleteNode() method
     * @param key - given key to delete node in tree with it
     */
    public void delete(K key) {
        this.root = deleteNode(root, key);
        size--;
    }

    /**
     * deleteNode() - additional recursive method to delete node in tree with specific key
     * @param node - node which updates after iteration to check
     * @param key - given key to delete node with it
     * @return Node - deleting node with updating old root with new
     */
    private Node deleteNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 1) {
            node.left = deleteNode(node.left, key);
        } else if (key.compareTo(node.key) == -1) {
            node.right = deleteNode(node.right, key);
        } else {
            if (node.left == null && node.right == null){
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node minimum_node = findMinimumNode(node);
                node.key = minimum_node.key;
                node.val = minimum_node.val;
                node.right = deleteNode(node.right, minimum_node.key);
            }
        }
        return node;
    }

    /**
     * findMinimumNode() - if node have left child return it, itself otherwise
     * @param node - node which updates after iteration to check
     * @return Node - minimum Node
     */
    private Node findMinimumNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * iterator() - returns an iterator that allows iterating over the binary search tree in an inorder traversal.
     * @return Iterable<Node> - iterator
     */
    public Iterable<Node> iterator() {
        ArrayList<Node> array = inorderTraversal(new ArrayList<>(), root);
        return (Iterable) array;
    }

    /**
     * inorderTraversal - additional recursive method
     * @param array - array which updates after iteration to check
     * @param node - node which updates after iteration to check
     * @return ArrayList<Node>
     */
    private ArrayList<Node> inorderTraversal(ArrayList array, Node node) {
        if(node == null) {
            return null;
        }
        if (node.left != null) {
            array.add(inorderTraversal(array, node.left));
        }
        array.add(node);
        if (node.right != null) {
            array.add(inorderTraversal(array, node.right));
        }
        return array;
    }
}
