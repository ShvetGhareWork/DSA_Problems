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
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathKaSum(root, targetSum, 0, result, new ArrayList<>());
        return result;
    }
    private void pathKaSum(TreeNode root, int targetSum, int calculatedSum, List<List<Integer>> result, List<Integer> currentPath){
        if(root == null) return;

        calculatedSum += root.val;
        currentPath.add(root.val);

         if (root.left == null && root.right == null && calculatedSum == targetSum) {
            result.add(new ArrayList<>(currentPath));
        }

        pathKaSum(root.left, targetSum, calculatedSum, result, currentPath);
        pathKaSum(root.right, targetSum, calculatedSum, result, currentPath);

        currentPath.remove(currentPath.size() - 1);

    }
}