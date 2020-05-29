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
class BSTIterator {
    
    Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new ArrayDeque<TreeNode>();
        this._leftTraverse(root);
    }
    
    private void _leftTraverse(TreeNode root) {
        while (root != null) {
            this.stack.addFirst(root);
            root = root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode smallest = this.stack.removeFirst();
        if (smallest.right != null) this._leftTraverse(smallest.right);
        return smallest.val;  
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (this.stack.size() > 0);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
