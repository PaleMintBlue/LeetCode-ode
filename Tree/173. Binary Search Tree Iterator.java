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

/**
* Using Stack
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
* In-place
*/
class BSTIterator {

    private TreeNode root;
    private boolean flag;

    public BSTIterator(TreeNode root) {
        this.root = root;
        this.flag = (root==null)?false:true;
    }

    /** @return the next smallest number */
    public int next() {
        return nextHelper(root, root);
    }

    private int nextHelper(TreeNode curr, TreeNode node) {
        // a node without a left child is the smallest one -> O(h)
        while (node.left != null) {
            curr = node;
            node = node.left;
        }

        int smallest = node.val;

        // remove the smallest node
        if (node.right != null) {
            node.val = node.right.val;
            node.left = node.right.left;
            node.right = node.right.right;
        }
        else {
            if (curr == node) flag = false;
            curr.left = null;
        }
        return smallest;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return flag;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
