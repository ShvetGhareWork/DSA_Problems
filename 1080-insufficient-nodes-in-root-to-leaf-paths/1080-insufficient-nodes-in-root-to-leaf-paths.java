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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return treeTraverse(root, limit, 0);
    }
    private TreeNode treeTraverse(TreeNode root, int limit, int currentSum){
        if(root == null) return null;
        
        if(root.left == null && root.right == null) 
            return root.val + currentSum < limit ? null : root;
        
        root.left = treeTraverse(root.left, limit, currentSum + root.val);
        root.right = treeTraverse(root.right, limit, currentSum + root.val);

        return (root.right == null && root.left == null) ? null : root;
    }
}