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
    
    public ListNode reverse(ListNode head, int k) {
        ListNode start = null, curr = head;
        while(k>0){
            ListNode later = curr.next;
            curr.next = start;
            start = curr;
            curr = later;
            k--;
        }
        return start; 
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head, end = null, start = null;
        while(curr != null) {
            int count = 0;
            curr = head;
            while(curr != null && count < k) {
                curr = curr.next;
                count ++;
            }
            if(count == k){
                ListNode rev_start = this.reverse(head,k);
                if(start == null) start = rev_start;
                if(end != null) end.next = rev_start;
                end = head;
                head = curr;
            }
        }
        if(end != null) end.next = head;
        
        return (start == null) ? head : start;
    }
    
    
}
