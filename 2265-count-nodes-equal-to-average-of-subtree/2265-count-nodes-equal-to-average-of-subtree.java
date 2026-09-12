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
    int ans = 0;
    public int averageOfSubtree(TreeNode root) {
        count(root);
        return ans;
    }

    private int[] count(TreeNode root){
        if(root == null) return new int[]{0, 0};

        int[] left = count(root.left);
        int[] right = count(root.right);

        int subTreeSum = left[0] + right[0] + root.val;
        int subTreeCounts = left[1] + right [1] + 1;

        if((subTreeSum / subTreeCounts) == root.val) ans++; 
        return new int[]{subTreeSum, subTreeCounts};

    }
}