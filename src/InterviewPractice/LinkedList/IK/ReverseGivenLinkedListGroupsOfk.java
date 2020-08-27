package InterviewPractice.LinkedList.IK;

import InterviewPractice.LinkedList.Node;

public class ReverseGivenLinkedListGroupsOfk {

    public static Node reverse_linked_list_in_groups_of_k(Node head, int k) {
        Node headPrev = null;
        Node newHead = null;
        while (true) {
            Node temp = head;
            Node prev = null;

            int i = 0;
            while (temp != null && i < k) {
                Node next = temp.next;
                temp.next = prev;
                prev = temp;
                temp = next;
                i++;
            }

            if (headPrev != null) {
                headPrev.next = prev;
            } else {
                newHead = prev;
            }

            if (temp == null) {
                return newHead;
            }

            headPrev = head;
            head = temp;
        }


    }

    public static void main(String[] args) {
        Node first = new Node(1);
        first.next = new Node(2);
        first.next.next = new Node(3);
        first.next.next.next = new Node(4);
        first.next.next.next.next = new Node(5);
        first.next.next.next.next.next = new Node(6);
        Node result = reverse_linked_list_in_groups_of_k(first,3);
        System.out.println(result);
    }
}
