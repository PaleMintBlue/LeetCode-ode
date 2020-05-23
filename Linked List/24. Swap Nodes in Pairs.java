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
    public ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode curr = sentinel;
        while(head != null && head.next != null){
            ListNode n1 = head;
            ListNode n2 = head.next;
            curr.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            
            curr = n1;
            head = n1.next;
        }
        
        return sentinel.next;
        
    }
}
