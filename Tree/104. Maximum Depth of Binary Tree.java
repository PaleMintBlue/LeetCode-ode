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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> depths = new LinkedList<>();
        stack.add(root);
        depths.add(1);
        
        int depth = 0, current_depth = 0;
        while(!stack.isEmpty()) {
          root = stack.pollLast();
          current_depth = depths.pollLast();
          if (root != null) {
            depth = Math.max(depth, current_depth);
            stack.add(root.left);
            stack.add(root.right);
            depths.add(current_depth + 1);
            depths.add(current_depth + 1);
          }
        }
        return depth;
    }
}
