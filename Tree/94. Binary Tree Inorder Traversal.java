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
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     recursive(root, res);
    //     return res;
    // }
    // public void recursive(TreeNode node, List<Integer> res) {
    //     if(node == null) return;
    //     recursive(node.left, res);
    //     res.add(node.val);
    //     recursive(node.right, res);
    // }
    
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     Deque<TreeNode> stack = new ArrayDeque<>();
    //     TreeNode curr = root;
    //     while(curr != null || !stack.isEmpty()) {
    //         while (curr != null) {
    //             stack.addFirst(curr);
    //             curr = curr.left;
    //         }
    //         curr = stack.removeFirst();
    //         res.add(curr.val);
    //         curr = curr.right;
    //     }
    //     return res;
    // }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root, prev = null;
        while(curr != null) {
            if(curr.left ==null){
                res.add(curr.val);
                curr = curr.right;
            }else{
                prev = curr.left;
                while(prev.right != null){
                    prev = prev.right;
                }
                prev.right = curr;
                TreeNode tmp = curr;
                curr = curr.left;
                tmp.left = null;
            }

        }
        return res;
    }
}
