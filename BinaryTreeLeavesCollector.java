// Problem: Collect and remove leaf nodes of a binary tree in a level-by-level manner.
// Author: Roshan Adhikari

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLeavesCollector {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> collectLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        while (root != null) {
            List<Integer> leaves = new ArrayList<>();
            root = removeLeaves(root, leaves);
            result.add(leaves);
        }
        return result;
    }

    private TreeNode removeLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) return null;

        // Check if the node is a leaf node
        if (node.left == null && node.right == null) {
            leaves.add(node.val); // Add leaf value to the list
            return null; // Remove the leaf node
        }

        // Recursively remove leaves from left and right subtrees
        node.left = removeLeaves(node.left, leaves);
        node.right = removeLeaves(node.right, leaves);

        return node; // Return the updated tree after leaf removal
    }

    public static void main(String[] args) {
        BinaryTreeLeavesCollector solution = new BinaryTreeLeavesCollector();

        // Example 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        System.out.println(solution.collectLeaves(root1)); // Expected Output: [[4,5,3],[2],[1]]

        // Example 2
        TreeNode root2 = new TreeNode(1);

        System.out.println(solution.collectLeaves(root2)); // Expected Output: [[1]]
    }
}
