package InterviewPractice.LinkedList;


/**
 * 1. If a loop is found, initialize slow pointer to head, let fast pointer be at its position.
 * 2. Move both slow and fast pointers one node at a time.
 * 3. The point at which they meet is the start of the loop.
 *
 * https://www.geeksforgeeks.org/find-first-node-of-loop-in-a-linked-list/
 * https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
 *
 * Length of linkedlist
 * We know that Floyd’s Cycle detection algorithm terminates when fast and slow pointers meet at a common point.
 * We also know that this common point is one of the loop nodes (2 or 3 or 4 or 5 in the above diagram). We store the address of this common point in a pointer variable say ptr.
 * Then we initialize a counter with 1 and start from the common point and keeps on visiting next node and increasing the counter till we again reach the common point(ptr).
 * At that point, the value of the counter will be equal to the length of the loop.
 *
 *
 */
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
