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
    int maxCount = 0;
    public int longestZigZag(TreeNode root) {
        return zigZag(root, true, 0);
    }
    private int zigZag(TreeNode root, boolean isLeft, int count){
        if(root == null) return 0;
        maxCount = Math.max(maxCount, count);

        if(isLeft){
            zigZag(root.left, false, count + 1);
            zigZag(root.right, true, 1);
        }else{
            zigZag(root.right, true, count + 1);
            zigZag(root.left, false, 1);
        }

        return maxCount;
    }
}