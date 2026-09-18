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
        int size = 0;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            size++;
        }
        int toRe = size - n;
        size = 0;
        ListNode temp2 = new ListNode(-1);
        temp2.next = head;
        while(size <= toRe - 1) {
            temp2 = temp2.next;
            size++;
        }
        if(size == 0) return head.next;
        temp2.next = temp2.next.next;
        return head;
        
    }
}
