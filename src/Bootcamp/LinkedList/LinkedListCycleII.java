package Bootcamp.LinkedList;

public class LinkedListCycleII {

    public Node detectCycle(Node head) {

        if(head == null){
            return null;
        }

        // If there is a cycle, the fast/slow pointers will intersect at some
        // node. Otherwise, there is no cycle, so we cannot find an entrance to
        // a cycle.
        Node intersection = getIntersection(head);
        Node start = head;

        if(intersection == null){
            return null;
        }
        // To find the entrance to the cycle, we have two pointers traverse at
        // the same speed -- one from the front of the list, and the other from
        // the point of intersection.
        while (intersection != start) {
            intersection = intersection.next;
            start = start.next;
        }

        return intersection;
    }

    public Node getIntersection(Node head){
        Node tortoise = head;
        Node hare = head;
        // A fast pointer will either loop around a cycle and meet the slow
        // pointer or reach the `null` at the end of a non-cyclic list.
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                return tortoise;
            }
        }
        return null;
    }


}
