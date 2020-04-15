package Bootcamp.LinkedList;

public class ReverseLinkedList {
    public static Node reverseList(Node head) {
        if(head==null||head.next==null)
            return head;

        Node p1 = head;
        Node p2 = p1.next;

        head.next = null;
        while(p1!=null&& p2!=null){
            Node t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }

        return p1;
    }
/*
We always put a node's previous node as one's next,
Take 1 -> 2 -> 3 -> N for example, we reverse the list by
put 1's previous node null as 1's next,
put 2's previous node 1 as 2's next,
put 3's previous node 2 as 3's next,
return 3 // put null's previous node 3 as null's next

    public ListNode reverseList(ListNode head) {
        return putPreAfterNode(head, null);
    }

    private ListNode putPreAfterNode(ListNode node, ListNode pre) {
        if (node == null) {
            return pre;
        }
        ListNode next = node.next;
        node.next = pre;
        return putPreAfterNode(next, node);
    }
 */


    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        Node res = reverseList(head);
    }
}

