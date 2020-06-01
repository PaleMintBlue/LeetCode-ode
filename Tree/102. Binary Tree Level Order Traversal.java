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
    
    /** Recursive
    */
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    private void helper(TreeNode node, int level) {
        if (levels.size() == level) levels.add(new ArrayList<Integer>());

        levels.get(level).add(node.val);

        if (node.left != null) helper(node.left, level + 1);
        if (node.right != null) helper(node.right, level + 1);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }
    
    /** Iterative
    */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while ( !queue.isEmpty() ) {
          levels.add(new ArrayList<Integer>());
          int level_length = queue.size();
          for(int i = 0; i < level_length; i++) {
            TreeNode node = queue.remove();
            levels.get(level).add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
          }
          level++;
        }
        return levels;
    }
}
