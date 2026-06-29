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
    int height = Integer.MIN_VALUE;
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftMost = maxDepth(root.left);
        int rightMost = maxDepth(root.right);

        return Math.max(leftMost, rightMost) + 1;
    }
}