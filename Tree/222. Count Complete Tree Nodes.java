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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = height(root,1);
        int right = height(root,-1);
        return (left == right) ? (1 << left) - 1:1 + countNodes(root.left) + countNodes(root.right);
    }

    private int height(TreeNode root, int side) {
        if (root == null) return 0;
        return (side == 1) ? 1 + height(root.left, 1):1 + height(root.right, -1);
    }

}
