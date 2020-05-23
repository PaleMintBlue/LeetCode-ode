/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
         ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode prev = null, curr = slow;
        ListNode tmp;
        while (curr != null){
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        
        ListNode n1 = head, n2 = prev;
        while (n2.next != null){
            tmp = n1.next;
            n1.next = n2;
            n1 = tmp;
            
            tmp = n2.next;
            n2.next = n1;
            n2 = tmp;
        }
    }
}
