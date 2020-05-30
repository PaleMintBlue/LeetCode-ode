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

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root == null) return ans;

        stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.removeFirst();
            ans.addFirst(curr.val);
            if (curr.left != null) {
                stack.addFirst(curr.left);
            }
            if (curr.right != null) {
                stack.addFirst(curr.right);
            } 
        }
        return ans;
    }
}
