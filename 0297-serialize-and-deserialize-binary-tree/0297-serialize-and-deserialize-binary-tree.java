/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> serialize = new ArrayList<>();
        preorderTraverse(root, serialize);
        return String.join(",", serialize);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        
        // Split string into a queue for efficient removal from front
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTreeFromQueue(queue);
    }

    private void preorderTraverse(TreeNode node, List<String> result) {
        // Base case: if node is null, stop recursion
        if (node == null) {
            result.add("null");
            return;
        }

        result.add(String.valueOf(node.val));
        preorderTraverse(node.left, result);
        preorderTraverse(node.right, result);
    }

    private TreeNode buildTreeFromQueue(Queue<String> queue) {
        String val = queue.poll();
        
        if (val == null || val.equals("null")) {
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = buildTreeFromQueue(queue);
        node.right = buildTreeFromQueue(queue);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));