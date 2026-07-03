class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        
        // Count paths starting from this root
        int count = countPathsFromNode(root, targetSum, 0);
        
        // Recursively count paths in left and right subtrees
        count += pathSum(root.left, targetSum);
        count += pathSum(root.right, targetSum);
        
        return count;
    }
    
    private int countPathsFromNode(TreeNode node, int targetSum, long currentSum) {
        if (node == null) return 0;
        
        currentSum += node.val;
        int count = (currentSum == targetSum) ? 1 : 0;
        
        // Continue down left and right
        count += countPathsFromNode(node.left, targetSum, currentSum);
        count += countPathsFromNode(node.right, targetSum, currentSum);
        
        return count;
    }
}