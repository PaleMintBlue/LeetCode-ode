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
    int preIdx = 0, postIdx = 0;
    public TreeNode constructFromPrePost(int[]pre, int[]post) {
        TreeNode root = new TreeNode(pre[preIdx++]);
        if (root.val != post[postIdx])
            root.left = constructFromPrePost(pre, post);
        if (root.val != post[postIdx])
            root.right = constructFromPrePost(pre, post);
        postIdx++;
        return root;
    }
}
