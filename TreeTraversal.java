import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {
    // Node class representing each element in the tree
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    // ==========================================
    // 1. DFS (Depth-First Search) Traversals
    // ==========================================

    // Preorder Traversal: Root -> Left -> Right
    public void preorder(Node node) {
        if (node == null) return;
        
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Inorder Traversal: Left -> Root -> Right
    public void inorder(Node node) {
        if (node == null) return;
        
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Postorder Traversal: Left -> Right -> Root
    public void postorder(Node node) {
        if (node == null) return;
        
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    // Generic DFS wrapper (DFS on a binary tree defaults to Preorder style)
    public void dfs(Node node) {
        preorder(node); 
    }

    // ==========================================
    // 2. BFS / Level Order Traversal
    // ==========================================

    // Level Order / BFS Traversal: Level by Level (Left to Right)
    public void levelOrderOrBfs(Node node) {
        if (node == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            // Enqueue left child
            if (current.left != null) {
                queue.add(current.left);
            }

            // Enqueue right child
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    // ==========================================
    // 3. Main Function
    // ==========================================
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        /* Constructing the sample tree:
                 1
               /   \
              2     3
             / \   /
            4   5 6
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);

        System.out.print("Preorder Traversal:   ");
        tree.preorder(tree.root);
        System.out.println();

        System.out.print("Inorder Traversal:    ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.print("Postorder Traversal:  ");
        tree.postorder(tree.root);
        System.out.println();

        System.out.print("DFS Traversal:        ");
        tree.dfs(tree.root);
        System.out.println();

        System.out.print("Level Order / BFS:    ");
        tree.levelOrderOrBfs(tree.root);
        System.out.println();
    }
}
