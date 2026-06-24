class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        // Visit root
        result.add(root.val);
        // Traverse left subtree
        helper(root.left, result);
        // Traverse right subtree
        helper(root.right, result);
    }
}