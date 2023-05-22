import java.util.ArrayList;

public class BST<K extends Comparable<K>, V> {
    private Node root;
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
    public int getSize() {
        return size;
    }
    public void put(K key, V value) {
        this.root = insertNode(root, key, value);
        size++;
    }
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
    public V get(K key) {
        Node node = getTreeNode(root, key);
        return (node.equals(null) ? null : node.val);
    }
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
    public void delete(K key) {

    }
    public Iterable<K> iterator() {
        return null;
    }
}
