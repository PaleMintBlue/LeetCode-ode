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
    TreeNode prev, first, second;
    public void recoverTree(TreeNode root) {
        helper(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    private void helper(TreeNode curr) {
        if (curr != null) {
            helper(curr.left);
            if (prev != null && prev.val > curr.val) {
                if (first == null) {
                    first = prev;
                    second = curr;
                } else second = curr;
            }
            prev = curr;
            helper(curr.right);
        }
    }
}
