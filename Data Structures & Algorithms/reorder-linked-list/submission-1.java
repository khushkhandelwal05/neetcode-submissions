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
        if(head == null || head.next == null) return ;
        ListNode s = head;
        ListNode f = head.next;
        while(f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        f = s.next;
        s.next = null;
        s = f;
        ListNode rhead = null;
        while(s != null) {
            ListNode t = s.next;
            s.next = rhead;
            rhead = s;
            s = t;
        }
        ListNode temp = head;
        while(temp != null && rhead != null) {
            s = temp.next;
            f = rhead.next;
            temp.next = rhead;
            rhead.next = s;
            temp = s;
            rhead = f;
        }
        return;

    }
}
