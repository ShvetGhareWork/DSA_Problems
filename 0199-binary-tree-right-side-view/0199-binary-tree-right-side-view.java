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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int levelSize = q.size();
            for(int i = 0; i < levelSize; i++){
                TreeNode currentNode = q.poll();

                if(currentNode.left != null) {
                    q.offer(currentNode.left);
                }
                if(currentNode.right != null) {
                    q.offer(currentNode.right);
                }   

                if(i == levelSize - 1){
                    result.add(currentNode.val);
                }
            }
            
        }
        return result;
    }
}

// With Recursion
/*
 public List<Integer> rightSideView(TreeNode root) {
        List<Integer>res=new ArrayList<>();
      rec(root,res,0);
        return res;
    }
    void rec(TreeNode root, List<Integer>res,int level){
        if(root==null)return;
        if(level==res.size()){
            res.add(root.val);
        }
       rec(root.right,res,level+1);
       rec(root.left,res,level+1);

    }
*/