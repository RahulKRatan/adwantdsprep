package Bootcamp.LinkedList;


/**
 * Fast and slow pointers
 */
public class RemoveNthFromEnd {

    public static Node removeNthFromEnd(Node head, int n) {
        if(head == null){
            return null;
        }
        Node slow = head;
        Node fast = head;
        for(int i=0; i<n; i++){
            fast = fast.next;
        }
        //if remove the first node
        if(fast == null){
            head = head.next;
            return head;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }

    public static void main(String[] args) {
        Node first = new Node(1);
        first.next = new Node(2);
        first.next.next = new Node(3);
        first.next.next.next = new Node(4);
        first.next.next.next.next = new Node(5);
        System.out.println(removeNthFromEnd(first,2));
    }
}
