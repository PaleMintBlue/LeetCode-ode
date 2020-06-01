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

    /** Reursive
    */
    class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        helper(root, res, path, sum);
        return res;
    }
    
    private void helper(TreeNode root, List<List<Integer>> res, Deque<Integer> path, int sum) {
        if(root == null) return;
        sum -= root.val;
        path.addLast(root.val);
        if(root.left == null && root.right == null && sum == 0) res.add(new ArrayList<Integer> (path));    
        helper(root.left, res, path, sum);
        helper(root.right, res, path, sum);
        path.removeLast();
    }
}
