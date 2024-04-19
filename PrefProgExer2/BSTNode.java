package PrefProgExer2;

// Node class for a Binary Search Tree (BST)
public class BSTNode {
    protected int key; // Key value stored in the node
    protected BSTNode left, right; // References to the left and right child nodes

    // Constructor: Initialize left and right child nodes to null
    public BSTNode() {
        left = right = null;
    }

    // Constructor: Initialize node with a key value, left child, and right child
    public BSTNode(int el) {
        this(el, null, null);
    }

    // Constructor: Initialize node with a key value, left child, and right child
    public BSTNode(int el, BSTNode lt, BSTNode rt) {
        key = el;
        left = lt;
        right = rt;
    }
}
