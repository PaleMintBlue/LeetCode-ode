/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    
    public Node() {}
    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/

class Solution {
    public Node recursive(Node head) {
        if(head == null) return head;
        Node sentinel = new Node(0, null, head, null);
        flattenDFS(sentinel, head);
        sentinel.next.prev = null;
        return sentinel.next;
    }
    
    public Node flattenDFS(Node prev, Node curr) {
        if(curr == null) return prev;
        curr.prev = prev;
        prev.next = curr;
        
        Node n1 = curr.next;
        Node end = flattenDFS(curr, curr.child);
        curr.child = null;
        
        return flattenDFS(end, n1);
    }
    
    public Node iterate(Node head){
        if (head == null) return head;
        Node sentinel = new Node(0, null, head, null);
        Node curr = sentinel, prev = sentinel;
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(head);
        
        while(!stack.isEmpty()){
            curr = stack.pop();
            prev.next = curr;
            curr.prev = prev;
            if(curr.next != null) stack.push(curr.next);
            if (curr.child != null) {
                stack.push(curr.child);
                curr.child = null;
            }
            prev = curr;
        }
        sentinel.next.prev = null;
        
        return sentinel.next;
        
        
    }
}
