/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        List<Integer> result = new ArrayList<>();
        traverse(root, result);

        return result.get(k - 1);
    }
    private void traverse(TreeNode node, List<Integer> result) {
        // Base case: if node is null, stop recursion
        if (node == null) {
            return;
        }

        // 1. Traverse left subtree
        traverse(node.left, result);

        // 2. Visit root node (add to list)
        result.add(node.val);

        // 3. Traverse right subtree
        traverse(node.right, result);
    }
}