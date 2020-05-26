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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;
        
        ListNode end = head;
        int count = 1;
        while(end.next != null){
            end = end.next;
            count++;
        }
        end.next = head;
        
        ListNode new_end = head;
        int index = count - k % count - 1;
        for(int i= 0; i < index; i++) new_end = new_end.next;
        
        ListNode new_head = new_end.next;
        new_end.next = null;
        
        return new_head;
    }
}
