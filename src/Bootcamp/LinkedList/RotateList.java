package Bootcamp.LinkedList;


/**
 *
 * Algorithm
 *
 * The algorithm is quite straightforward :
 *
 * Find the old tail and connect it with the head old_tail.next = head to close the ring. Compute the length of the list n at the same time.
 *
 * Find the new tail, which is (n - k % n - 1)th node from the head and the new head, which is (n - k % n)th node.
 *
 * Break the ring new_tail.next = None and return new_head.
 *
 * Time complexity : O(N) where N is a number of elements in the list.
 *
 * Space complexity : O(1) since it's a constant space solution.
 */
public class RotateList {

    public static Node rotateRight(Node head, int k) {
        // base cases
        if (head == null) return null;
        if (head.next == null) return head;

        // close the linked list into the ring
        Node old_tail = head;
        int n;
        for(n = 1; old_tail.next != null; n++)
            old_tail = old_tail.next;
        old_tail.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        Node new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++)
            new_tail = new_tail.next;
        Node new_head = new_tail.next;

        // break the ring
        new_tail.next = null;

        return new_head;
    }



    public static void main(String[] args) {
        Node first = new Node(1);
        first.next = new Node(2);
        first.next.next = new Node(3);
        first.next.next.next = new Node(4);
        first.next.next.next.next = new Node(5);
        System.out.println(rotateRight(first,3));
    }
}
