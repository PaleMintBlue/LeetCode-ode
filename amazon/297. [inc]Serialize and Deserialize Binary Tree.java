/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root!=null){
            preorder(root, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
    private void preorder(TreeNode node, StringBuilder sb){
        if(node==null){
            sb.append("X");
            sb.append(",");
        }else{
            sb.append(node.val);
            sb.append(",");
            preorder(node.left, sb);
            preorder(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String[] arr = data.split(",");
        Deque<String> strList = new LinkedList<String>(Arrays.asList(arr)); 
        TreeNode root = helper(strList);
        return root;
    }
    private TreeNode helper(Deque<String> strList){
        if (strList.size() == 0) return null;
        String str = strList.pop();
        if (str.equals("X")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(str));
        node.left = helper(strList);
        node.right = helper(strList);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
