package Bootcamp.LinkedList;

/**
 *
 *  Refer to SwapNodes image in files
 *
 */



public class SwapNodesInPairs {

    public static Node swapPairs(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node point = dummy;
        while (point.next != null && point.next.next != null) {
            Node swap1 = point.next;
            Node swap2 = point.next.next;
            point.next = swap2;
            swap1.next = swap2.next;
            swap2.next = swap1;
            point = swap1;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node first = new Node(1);
        first.next = new Node(2);
        first.next.next = new Node(3);
        first.next.next.next = new Node(4);
        System.out.println(swapPairs(first));
    }
}
