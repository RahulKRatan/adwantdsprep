package InterviewPractice.LinkedList;

/**
 *  time : O(N)
 */


public class RemoveOddElements {

    public static Node removeOddElementsList(Node head){
        Node curr = head;
        Node even;
        while(curr.val %2 != 0){
            curr = curr.next;
        }

        head = curr;
        even = curr;
        curr = curr.next;

        while (curr != null){
            if(curr.val % 2 == 0){
                even.next = curr;
                even = curr;
            }
            curr = curr.next;
        }
        even.next = null;
        return head;
    }


    public static void main(String[] args) {
        Node first = new Node(1);
        first.next = new Node(3);
        first.next.next = new Node(4);
        first.next.next.next = new Node(2);
        first.next.next.next.next = new Node(7);
        first.next.next.next.next.next = new Node(2);
        first.next.next.next.next.next.next = new Node(3);
        Node result = removeOddElementsList(first);
        System.out.println(result);
    }

}
