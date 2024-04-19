package PrefProgExer2;

// Binary Search Tree
public class BST {

    protected BSTNode root; // Root of the BST

    // Constructor
    public BST() {
        root = null; // Initialize root to null
    }

    // Helper method to visit a node
    protected void visit(BSTNode p) {
        System.out.print(p.key + " "); // Print the key of the node
    }

    // Helper method to increment the key of a node
    protected void count(BSTNode p) {
        p.key++; // Increment the key of the node
    }

    // Insert a new element into the BST
    public void insert(int el) {
        BSTNode p = root, prev = null;
        // Traverse the tree to find the correct position for the new element
        while (p != null) {
            prev = p;
            if (p.key < el)
                p = p.right;
            else
                p = p.left;
        }
        // Insert the new element
        if (root == null)
            root = new BSTNode(el);
        else if (prev.key < el)
            prev.right = new BSTNode(el);
        else
            prev.left = new BSTNode(el);
    }

    // Perform a custom postorder traversal of the BST
    public int postorder() {
        return postorder(root);
    }

    // Helper method for custom postorder traversal
    protected int postorder(BSTNode p) {
        if (p == null) {
            return 0; // Base case: return 0 if p is null
        }

        int left = postorder(p.left);
        int right = postorder(p.right);

        if (p.left == null && p.right == null) { // Check if p is a leaf
            p.key++;
            return 1; // Return 1 to indicate a leaf node
        }

        return left + right; // Return the sum of leaf nodes from left and right subtrees
    }

    // Calculate and display the height of the tree
    public void showHeight() {
        int height = calculateHeight(root);
        System.out.println("Height of the tree: " + height);
    }

    // Helper method to calculate the height of a subtree rooted at node p
    protected int calculateHeight(BSTNode p) {
        if (p == null) {
            return -1; // Height of an empty tree is -1
        }

        int leftHeight = calculateHeight(p.left);
        int rightHeight = calculateHeight(p.right);

        // Compare leftHeight and rightHeight to get the maximum height
        return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
    }

    // Display the number of non-terminal nodes in the tree
    public void displayNonTerminalCount() {
        int count = countNonTerminal(root);
        System.out.println("Number of non-terminal nodes: " + count);
    }

    // Helper method to count the number of non-terminal nodes in the tree
    protected int countNonTerminal(BSTNode p) {
        if (p == null || (p.left == null && p.right == null)) {
            return 0; // If the node is null or a leaf, return 0
        }

        // Count this node and recursively count non-terminal nodes in left and right subtrees
        return 1 + countNonTerminal(p.left) + countNonTerminal(p.right);
    }

    // Display the Internal Path Length (IPL) of the tree
    public void showIPL() {
        int ipl = calculateIPL(root, 0); // Start with depth 0 at the root
        System.out.println("Internal Path Length of the tree: " + ipl);
    }

    // Helper method to calculate the Internal Path Length of a subtree rooted at node p
    protected int calculateIPL(BSTNode p, int depth) {
        if (p == null) {
            return 0; // If the node is null, return 0
        }

        // Sum the depth of this node and the depths of its children
        return depth + calculateIPL(p.left, depth + 1) + calculateIPL(p.right, depth + 1);
    }

    // Display the Average Depth of the tree
    public void showAverageDepth() {
        int[] result = calculateAverageDepth(root, 0, 0); // Start with depth 0 at the root
        int totalDepth = result[0];
        int internalNodeCount = result[1];

        if (internalNodeCount == 0) {
            System.out.println("Average Depth of the tree: 0"); // Avoid division by zero
        } else {
            double averageDepth = (double) totalDepth / internalNodeCount;
            System.out.println("Average Depth of the tree: " + averageDepth);
        }
    }

    // Helper method to calculate the total depth and the number of internal nodes
    protected int[] calculateAverageDepth(BSTNode p, int depth, int count) {
        if (p == null) {
            return new int[]{0, 0}; // If the node is null, return 0 depth and count
        }

        int[] leftResult = calculateAverageDepth(p.left, depth + 1, count);
        int[] rightResult = calculateAverageDepth(p.right, depth + 1, count);

        int totalDepth = depth + leftResult[0] + rightResult[0];
        int internalNodeCount = 1 + leftResult[1] + rightResult[1];

        return new int[]{totalDepth, internalNodeCount};
    }

}
