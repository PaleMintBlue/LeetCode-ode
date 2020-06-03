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
    // Recursive
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode node, int digit){
        if (node == null) return 0;
        if (node.right == null && node.left == null) return digit*10 + node.val;
        int digit = digit*10 + node.val;
        return sum(node.left, digit) + sum(node.right, digit);
    }
    
    //Iterative
    public int sumNumbers(TreeNode root) {
            if(root==null){
                return 0;
            }
            int sum = 0;
            TreeNode curr;
            Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
            stack.addFirst(root);
            
            while(!stack.empty()){
                curr = stack.removeFirst();
                
                if(curr.right!=null){
                    curr.right.val = curr.val*10+curr.right.val;
                    stack.addFirst(curr.right);
                }
                
                if(curr.left!=null){
                    curr.left.val = curr.val*10+curr.left.val;
                    stack.addFirst(curr.left);
                }
                
                if(curr.left==null && curr.right==null){
                    sum+=curr.val;
                }
            }
            return sum;
        }
}
