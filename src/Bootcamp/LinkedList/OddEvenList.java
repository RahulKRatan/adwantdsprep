package Bootcamp.LinkedList;

public class OddEvenList {

    public static Node oddEvenList(Node head) {
        if(head == null)
            return head;

        Node result = head;
        Node p1 = head;
        Node p2 = head.next;
        Node connectNode = head.next;

        while(p1 != null && p2 != null){
            Node t = p2.next;
            if(t == null)
                break;

            p1.next = p2.next;
            p1 = p1.next;

            p2.next = p1.next;
            p2 = p2.next;
        }

        p1.next = connectNode;

        return result;

    }


    public static void main(String[] args) {
        Node first = new Node(1);
        first.next = new Node(2);
        first.next.next = new Node(3);
        first.next.next.next = new Node(4);
        first.next.next.next.next = new Node(5);
        System.out.println(oddEvenList(first));
    }

}
