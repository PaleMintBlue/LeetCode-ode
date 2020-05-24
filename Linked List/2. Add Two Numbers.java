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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode n1 = l1, n2 = l2, curr = sentinel;
        int carry = 0;
        while(n1 != null || n2 != null){
            int x = n1 != null ? n1.val:0;
            int y = n2 != null ? n2.val:0;
            int sum = x+y+carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (n1 != null) n1 = n1.next;
            if (n2 != null) n2 = n2.next;
        }
        
        if(carry > 0) curr.next = new ListNode(carry);
        return sentinel.next;
    }
}
