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
    public ListNode iterate(ListNode head) {
        ListNode prev = null, cur = head;
        while(cur!=null){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
    
    public ListNode recurse(ListNode head) {
        if(head!=null && head.next!= null){
            ListNode tmp = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return tmp;
        }else{
            return head;
        }
}
