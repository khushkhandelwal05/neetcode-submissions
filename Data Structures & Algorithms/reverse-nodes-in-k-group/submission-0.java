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
        if(head.next == null) return head;

        ListNode start = head.next;
        ListNode temp = start;
        ListNode prev = null;

        while(k > 0 && temp != null) {
            ListNode val = temp.next;
            temp.next = prev;
            prev = temp;
            temp = val;
            k--;
        }
        head.next = prev;
        start.next = temp;
        return start;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int tot = 0;
        ListNode temp = head;
        ListNode temp2 = new ListNode(-1);
        ListNode temp3 = temp2;
        temp2.next = head;
        while(temp != null) {
            temp = temp.next;
            tot++;
        }
        int rot = tot / k;
        for(int i = 0 ; i < rot ; i++) {
            temp3 = reverse(temp3, k);
        }

        return temp2.next;
    }
}
