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
    public List<Integer> iterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addFirst(root);
        TreeNode curr = null;
        while(!stack.isEmpty()) {
            curr = stack.removeFirst();
            res.add(curr.val);
            if(curr.right != null) stack.addFirst(curr.right);
            if(curr.left != null) stack.addFirst(curr.left);
            
        }
        return res;
    }
}
