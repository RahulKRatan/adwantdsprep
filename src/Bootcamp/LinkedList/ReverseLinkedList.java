package Bootcamp.LinkedList;

public class ReverseLinkedList {
    public static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
/*
Recursive
public Node reverseList(Node head) {
    if (head == null || head.next == null) return head;
    Node p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
}
 */


    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        Node res = reverseList(head);
    }
}

