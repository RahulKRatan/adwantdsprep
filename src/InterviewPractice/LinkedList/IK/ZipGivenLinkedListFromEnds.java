package InterviewPractice.LinkedList.IK;

import InterviewPractice.LinkedList.Node;

public class ZipGivenLinkedListFromEnds {

    public static Node zip_given_linked_list(Node head) {
        if(head != null && head.next != null){
            Node slow = head;
            Node fast = head;

            while(fast != null && fast.next!=null && fast.next.next !=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            Node second = slow.next;
            slow.next = null;  // need to close first part
            second = reverseOrder(second);

            Node p1 = head;
            Node p2 = second;

            // merge two lists
            while (p2 != null){
                Node temp1 = p1.next;
                Node temp2 = p2.next;

                p1.next = p2;
                p2.next = temp1;

                p1 = temp1;
                p2 = temp2;
            }

        }
        return head;
    }

    public static Node reverseOrder(Node head){

        if (head == null || head.next == null) {
            return head;
        }

        Node pre = head;
        Node curr = pre.next;

        while (curr != null){
            Node temp = curr.next;
            curr.next=pre;
            pre = curr;
            curr = temp;
        }
        head.next = null;
        return pre;
    }

    public static void main(String[] args) {
        Node first = new Node(1);
        first.next = new Node(2);
        first.next.next = new Node(3);
        first.next.next.next = new Node(4);
        first.next.next.next.next = new Node(5);
        first.next.next.next.next.next = new Node(6);
        Node result = zip_given_linked_list(first);
        System.out.println(result);
    }
}
