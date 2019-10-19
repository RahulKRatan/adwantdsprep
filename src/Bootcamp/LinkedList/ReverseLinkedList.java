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
    if(head==null || head.next == null)
        return head;

    //get second node
    ListNode second = head.next;
    //set first's next to be null
    head.next = null;

    ListNode rest = reverseList(second);
    second.next = head;

    return rest;
}
 */


    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        Node res = reverseList(head);
    }
}

