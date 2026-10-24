import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class TreeTraversal {

    // ==========================================
    // BREADTH-FIRST SEARCH (BFS / Level Order)
    // ==========================================
    public static void breadthFirstSearch(TreeNode root) {
        if (root == null) return;

        // Use a Queue to explore nodes level-by-level
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        System.out.print("BFS (Level Order): ");
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            // Enqueue left child first to process left-to-right
            if (current.left != null) {
                queue.add(current.left);
            }
            // Enqueue right child
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        System.out.println();
    }

    // ==========================================
    // DEPTH-FIRST SEARCH (DFS Variants)
    // ==========================================
    
    // 1. Pre-Order Traversal (Root -> Left -> Right)
    public static void dfsPreOrder(TreeNode node) {
        if (node == null) return;
        
        System.out.print(node.val + " "); // Process Root
        dfsPreOrder(node.left);           // Process Left Subtree
        dfsPreOrder(node.right);          // Process Right Subtree
    }

    // 2. In-Order Traversal (Left -> Root -> Right)
    public static void dfsInOrder(TreeNode node) {
        if (node == null) return;
        
        dfsInOrder(node.left);            // Process Left Subtree
        System.out.print(node.val + " "); // Process Root
        dfsInOrder(node.right);           // Process Right Subtree
    }

    // 3. Post-Order Traversal (Left -> Right -> Root)
    public static void dfsPostOrder(TreeNode node) {
        if (node == null) return;
        
        dfsPostOrder(node.left);           // Process Left Subtree
        dfsPostOrder(node.right);          // Process Right Subtree
        System.out.print(node.val + " ");  // Process Root
    }

    // ==========================================
    // DRIVER METHOD
    // ==========================================
    public static void main(String[] args) {
        /* 
               1
              / \
             2   3
            / \
           4   5
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Execute BFS
        breadthFirstSearch(root);

        // Execute DFS variants
        System.out.print("DFS Pre-Order:     ");
        dfsPreOrder(root);
        System.out.println();

        System.out.print("DFS In-Order:      ");
        dfsInOrder(root);
        System.out.println();

        System.out.print("DFS Post-Order:    ");
        dfsPostOrder(root);
        System.out.println();
    }
}
