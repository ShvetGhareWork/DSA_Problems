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
    Set<Integer> to_delete_set;
    List<TreeNode> result;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        to_delete_set = new HashSet<>();
        result = new ArrayList<>();
        for(int i : to_delete)  
            to_delete_set.add(i);
        
        sequenceOfTree(root, true);
        return result;
    }
    private TreeNode sequenceOfTree(TreeNode root, boolean is_root) {
        if(root == null) return null;

        boolean deleted = to_delete_set.contains(root.val);
        if(is_root && !deleted) result.add(root);

        root.left = sequenceOfTree(root.left, deleted);
        root.right = sequenceOfTree(root.right, deleted);

        return deleted ? null : root;
    }
}