package binary;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IntBST {
    protected IntBSTNode root;
    public IntBST() {
        root = null;
    }
    protected void visit(IntBSTNode p) {
        System.out.print(p.key + " ");
    }
    public IntBSTNode search(int el) {
        return search(root, el);
    }

    private IntBSTNode search(IntBSTNode p, int el) {
        while (p != null) {
            if (el == p.key) {
                return p;
            } else if (el < p.key) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }
    public void breadthFirst() {
        Queue<IntBSTNode> queue = new LinkedList<>();
        IntBSTNode p = root;
        if (p != null) {
            queue.add(p);
            while (!queue.isEmpty()) {
                p = queue.remove();
                visit(p);
                if (p.left != null)
                    queue.add(p.left);
                if (p.right != null)
                    queue.add(p.right);
            }
        }
    }
    public void preorder(){
        preorder(root);
    }
    protected void preorder(IntBSTNode p) {
        if (p != null) {
            visit(p);
            preorder(p.left);
            preorder(p.right);
        }
    }
    public void inorder() {
        inorder(root);
    }
    protected void inorder(IntBSTNode p) {
        if (p != null) {
            inorder(p.left);
            visit(p);
            inorder(p.right);
        }
    }
    public void postorder() {
        postorder(root);
    }

    protected void postorder(IntBSTNode p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            visit(p);
        }
    }
    public void iterativePreorder() {
        IntBSTNode p = root;
        Stack<IntBSTNode> travStack = new Stack<>();
        if (p != null) {
            travStack.push(p);
            while (!travStack.isEmpty()) {
                p = travStack.pop();
                visit(p);
                if (p.right != null)
                    travStack.push(p.right);
                if (p.left != null)
                    travStack.push(p.left);
            }
        }
    }
    public void iterativeInorder() {
        IntBSTNode p = root;
        Stack<IntBSTNode> travStack = new Stack<>();
        while (p != null) {
            while(p != null) {
                if (p.right != null)
                    travStack.push(p.right);
                travStack.push(p);
                p = p.left;
            }
            p = travStack.pop();
            while (!travStack.isEmpty() && p.right == null) {
                visit(p);
                p = travStack.pop();
            }
            visit(p);
            if (!travStack.isEmpty())
                p = travStack.pop();
            else p = null;
        }
    }
    public void iterativePostorder() {
        IntBSTNode p = root, q = root;
        Stack<IntBSTNode> travStack = new Stack<>();
        while (p != null) {
            for ( ; p.left != null; p = p.left)
                travStack.push(p);
            while (p != null && (p.right == null || p.right == q)) {
                visit(p);
                q = p;
                if (travStack.isEmpty())
                    return;
                p = travStack.pop();
            }
            travStack.push(p);
            p = p.right;
        }
    }
    public void MorrisInorder() {
        IntBSTNode p = root, tmp;
        while (p != null)
        if (p.left == null) {
            visit(p);
            p = p.right;
        }
        else {
            tmp = p.left;
            while (tmp.right != null &&
                tmp.right != p)
                tmp = tmp.right;
            if (tmp.right == null) {
                tmp.right = p;
                p = p.left;
            }
            else {
                visit(p);
                tmp.right = null;
                p = p.right;
            }
        }
    }
    public void insert(int el) {
        IntBSTNode p = root, prev = null;
        while (p != null) {
            prev = p;
            if (p.key < el)
                p = p.right;
            else p = p.left;
        }
        if (root == null)
            root = new IntBSTNode(el);
        else if (prev.key < el)
            prev.right = new IntBSTNode(el);
        else prev.left = new IntBSTNode(el);
    }
    public void deleteByMerging(int el) {
        IntBSTNode tmp, node, p = root, prev = null;
        while (p != null && p.key != el) {
            prev = p;
            if (p.key < el)
                p = p.right;
            else
                p = p.left;
        }
        node = p;
        if (p != null && p.key == el) {
            if (node.right == null)
                node = node.left;
            else if (node.left == null)
                node = node.right;
            else {
                tmp = node.left;
                while (tmp.right != null)
                    tmp = tmp.right;
                tmp.right = node.right;
                node = node.left;
                if (p == root)
                    root = node;
                else if (prev.left == p)
                    prev.left = node;
                else
                    prev.right = node;
            }
        } else if (root != null)
            System.out.println("key " + el + " is not in the tree");
        else
            System.out.println("the tree is empty");
    }
    public void deleteByCopying(int el) {
        IntBSTNode node, p = root, prev = null;
        while (p != null && p.key != el) {
            prev = p;
            if (p.key < el)
                p = p.right;
            else
                p = p.left;
        }
        node = p;
        if (p != null && p.key == el) {
            if (node.right == null)
                node = node.left;
            else if (node.left == null)
                node = node.right;
            else {
                IntBSTNode tmp = node.left;
                IntBSTNode previous = node;
                while (tmp.right != null) {
                    previous = tmp;
                    tmp = tmp.right;
                }
                node.key = tmp.key;
                if (previous == node)
                    previous.left = tmp.left;
                else
                    previous.right = tmp.left;
            }
            if (p == root)
                root = node;
            else if (prev.left == p)
                prev.left = node;
            else
                prev.right = node;
        } else if (root != null)
            System.out.println("key " + el + " is not in the tree");
        else
            System.out.println("the tree is empty");
    }
    public void balance(int data[], int first, int last) {
        if (first <= last) {
            int middle = (first + last) / 2;
            insert(data[middle]);
            balance(data, first, middle - 1);
            balance(data, middle + 1, last);
        }
    }
}
