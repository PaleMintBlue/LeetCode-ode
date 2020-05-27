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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> seq1 = new ArrayList<>();
        List<Integer> seq2 = new ArrayList<>();
        
        dfs(root1, seq1);
        dfs(root2, seq2);

		return seq1.equals(seq2);
    }
    
    private void dfs(TreeNode node, List<Integer> seq) {
        if(node == null) return;
        if (node.left == null && node.right == null)
            seq.add(node.val);
        dfs(node.right, seq);
        dfs(node.left, seq);
    }
}
