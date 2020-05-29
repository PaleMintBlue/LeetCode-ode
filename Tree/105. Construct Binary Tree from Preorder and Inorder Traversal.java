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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(inorder, preorder, inorder.length - 1, 0, 0);
}

    public TreeNode build(int[] inorder, int[] preorder, int startId, int endId, int rootId) {
        if (rootId > preorder.length - 1 || startId < endId) return null;
        TreeNode root = new TreeNode(preorder[rootId]);
        int mid = 0;

        for (int i = startId; i >= endId; i--) {
            if (inorder[i] == preorder[rootId]) {
                mid = i;
                break;
            }
        }

        root.left = build(inorder, preorder, mid - 1, endId, rootId + 1); 
        root.right = build(inorder, preorder,startId, mid + 1, rootId + 1 + mid - endId);
        return root;
    }
}
