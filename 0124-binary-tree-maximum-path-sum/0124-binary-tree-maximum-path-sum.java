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
    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxValue;

    }
    private int helper(TreeNode node){
        if(node == null) return 0;

        int leftSide = helper(node.left);
        int rightSide = helper(node.right);

        // Ignore the negative values
        leftSide = Math.max(0, leftSide);
        rightSide = Math.max(0, rightSide);

        int pathSum = leftSide + rightSide + node.val;

        maxValue = Math.max(pathSum, maxValue);

        return Math.max(leftSide, rightSide) + node.val;
    }
}