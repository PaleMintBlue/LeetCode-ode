/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode cross(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) return slow;
        }
        return null;
    }
    
    public ListNode detectCycle(ListNode head) {
        ListNode cross = cross(head);
        if(cross==null) return null;
        ListNode p1 = head;
        while(p1 != cross){
            p1 = p1.next;
            cross = cross.next;
        }
        return p1;
    }
    
}
