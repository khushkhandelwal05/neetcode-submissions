class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        for(int i = 0 ; i < lists.length ; i++) {
            ListNode temp = dummy.next;
            ListNode temp2 = lists[i];
            dummy.next = mergeTwoLists(temp, temp2);
        }
        return dummy.next;
    }
}

public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
