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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode curr = head, prev = null;
        while(m > 1){
            prev = curr;
            curr = curr.next;
            m--;
            n--;
        }
        ListNode start = prev, end = curr, later = null;
        while(n >0) {
            later = curr.next;
            curr.next = prev;
            prev = curr;
            curr = later;
            n--;
        }
        if(start != null) start.next = prev;
        else head = prev;
        end.next = curr;
        
        return head;
    }
}
