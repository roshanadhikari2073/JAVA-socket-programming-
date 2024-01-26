import java.util.ArrayList;
import java.util.List;

// Author: Roshan Adhikari
// Question: How can we collect all the leaf nodes of a binary tree?

public class BinaryTreeLeavesCollector {

    // Definition for a binary tree node with a constructor to set children.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        // Constructor to create a tree node with specified value, left child, and right child.
        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }

    // Method to collect leaves of a binary tree.
    public List<Integer> collectLeaves(TreeNode root) {
        List<Integer> leaves = new ArrayList<>();
        collectLeavesHelper(root, leaves);
        return leaves;
    }

    // Helper method to perform DFS and collect leaves.
    private void collectLeavesHelper(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return;
        }

        // Check if the node is a leaf node.
        if (node.left == null && node.right == null) {
            leaves.add(node.val); // Add leaf value to the list.
        }

        // Recursively collect leaves from left and right subtrees.
        collectLeavesHelper(node.left, leaves);
        collectLeavesHelper(node.right, leaves);
    }

    // Main method to test the leaf collection.
    public static void main(String[] args) {
        BinaryTreeLeavesCollector collector = new BinaryTreeLeavesCollector();

        // Construct the tree using the updated constructor.
        TreeNode root = new TreeNode(1, 
                                     new TreeNode(2, 
                                                  new TreeNode(4, null, null), 
                                                  new TreeNode(5, null, null)), 
                                     new TreeNode(3, null, null));

        // Collect and print the leaves of the tree.
        List<Integer> leaves = collector.collectLeaves(root);
        System.out.println("Leaves of the binary tree: " + leaves);
    }
}
