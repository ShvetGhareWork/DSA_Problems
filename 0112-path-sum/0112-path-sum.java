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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return pathCheck(root, targetSum, 0);
    }
    private boolean pathCheck(TreeNode root, int targetSum, int calculatedSum){
        if(root == null) return false;

        int newSum = calculatedSum + root.val;

        if(root.left == null && root.right == null){
            return targetSum == newSum;
        }
        return pathCheck(root.left, targetSum, newSum) || pathCheck(root.right, targetSum, newSum);

         
    }
}