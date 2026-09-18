/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        HashMap<Node, Integer> map1 = new HashMap<>();
        HashMap<Integer, Node> map2 = new HashMap<>();
        Node temp = head;
        Node head2 = new Node(temp.val);
        Node temp2 = head2;
        int c = 0;
        while(temp != null) {
            map1.put(temp, c);
            map2.put(c, temp2);
            if (temp.next != null) {
                temp2.next = new Node(temp.next.val);
                temp2 = temp2.next;
            }
            temp = temp.next;
            c++;
        }
        temp = head;
        temp2 = head2;
        while(temp != null) {
            if(temp.random == null) {
                temp2.random = null;
            } else {
                int randomIndex = map1.get(temp.random);
                temp2.random = map2.get(randomIndex);
            }
            temp = temp.next;
            temp2 = temp2.next;
        }
        return head2;
    }
}
