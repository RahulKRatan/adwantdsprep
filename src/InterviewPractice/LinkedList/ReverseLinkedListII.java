package InterviewPractice.LinkedList;

/**
 * Simply just reverse the list along the way using 4 pointers: dummy, pre, start, then
 *
 * O(N) and O(1)
 */
public class ReverseLinkedListII {

    public static Node reverseBetween(Node head, int m, int n) {
        if(head == null) return null;
        Node dummy = new Node(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        Node pre = dummy; // make a pointer pre as a marker for the node before reversing
        for(int i = 0; i<m-1; i++) pre = pre.next;

        Node first = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        Node second = first.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, first = 2, second = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        for(int i=0; i<n-m; i++)
        {
            first.next = second.next;
            second.next = pre.next;
            pre.next = second;
            second = first.next;
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Node res = reverseBetween(head,2,4);
        System.out.println(res);
    }
}
