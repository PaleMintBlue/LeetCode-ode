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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel  = new ListNode(0);
        sentinel.next = head;
        ListNode cur = head;
        int size = 0;
        while(cur!=null){
            size++;
            cur = cur.next;
        }
        cur = sentinel;
        size -= n;
        while(size>0){
            size--;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return sentinel.next;
    }
}
