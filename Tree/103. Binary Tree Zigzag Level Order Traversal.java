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
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    private void helper(TreeNode node, int level) {
        if (levels.size() == level) levels.add(new ArrayList<Integer>());

        levels.get(level).add(node.val);

        if (node.left != null) helper(node.left, level + 1);
        if (node.right != null) helper(node.right, level + 1);
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        for(int i = 0; i<levels.size();i++) {
            if(i % 2 > 0) Collections.reverse(levels.get(i));
        }
        return levels;
    }
}
