package Bootcamp.LinkedList;

public class LinkedListCycle {
// T - O(N) ; S - O(1)
    public boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                return true;
        }

        return false;
    }

    /* T - O(N) ; S - O(N)
    public boolean hasCycle(Node head) {
    Set<Node> nodesSeen = new HashSet<>();
    while (head != null) {
        if (nodesSeen.contains(head)) {
            return true;
        } else {
            nodesSeen.add(head);
        }
        head = head.next;
    }
    return false;
}
     */

}
