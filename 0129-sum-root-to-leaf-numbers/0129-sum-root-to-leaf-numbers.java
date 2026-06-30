class Solution {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        // sum = 0; // Reset sum in case the object is reused
        sum(root, 0);
        return sum;
    }

    private void sum(TreeNode root, int path) {
        if (root == null) {
            return;
        }

        path = path * 10 + root.val;

        // Check if it is a leaf node
        if (root.left == null && root.right == null) {
            sum += path; 
            return;      
        }

        sum(root.left, path);
        sum(root.right, path);
    }
}