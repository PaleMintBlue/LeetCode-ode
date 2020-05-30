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

    /** Iterative
    */
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
    
    /** Recursive
    */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        recurse(root, ans);
        return ans;
    }
    
    private void recurse(TreeNode node, List<Integer> list){
        if(node == null) return;
        recurse(node.left, list);
        recurse(node.right, list);
        list.add(node.val);
    }
    
    /** Morris
    */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        TreeNode prev = null, curr = root;
        while (curr != null) {
            if (curr.right == null) {
                list.addFirst(curr.val);
                curr = curr.left;
            } else {
                prev = curr.right;
                while (prev.left != null && prev.left != curr) {
                    prev = prev.left;
                }
                if (prev.left == null) {
                    prev.left = curr;
                    list.addFirst(curr.val);
                    curr = curr.right;
                } else {
                    prev.left = null;
                    curr = curr.left;
                }
            }
        }
        return list;
    }
}
