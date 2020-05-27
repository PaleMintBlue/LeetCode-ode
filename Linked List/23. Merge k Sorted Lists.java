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
 
// divide and conquer
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        if (size == 0)
            return null;
        int interval = 1;
        while (interval < size) {
            for (int i = 0; i < (size - interval); i += interval * 2)
                lists[i] = merge2Lists(lists[i], lists[i + interval]);
            interval *= 2;
        }
        return lists[0];
    }

    // // Recursive 
    // private ListNode merge2Lists(ListNode l1, ListNode l2) {
    //     if (l1 == null) return l2;
    //     if (l2 == null) return l1;
    //     if (l1.val < l2.val) {
    //         l1.next = merge2Lists(l1.next, l2);
    //         return l1;
    //     } else{
    //         l2.next = merge2Lists(l1, l2.next);
    //         return l2;
    //     }
    // }

    // Iterative (faster)
    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = (l1.val <= l2.val) ? l1 : l2;
        ListNode last = null;
        while (l1 != null && l2 != null) {
            while (l1 != null && l1.val <= l2.val) {
                last = l1;
                l1 = l1.next;
            }
            if (last != null) {
                last.next = l2;
                last = null;
            }
            if (l1 == null) break;
            while (l2 != null && l2.val <= l1.val) {
                last = l2;
                l2 = l2.next;
            }
            if (last != null) {
                last.next = l1;
                last = null;
            }
        }
        return head;
    }
}
