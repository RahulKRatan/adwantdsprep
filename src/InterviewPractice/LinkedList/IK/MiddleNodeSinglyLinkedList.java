package InterviewPractice.LinkedList.IK;

import InterviewPractice.LinkedList.Node;

public class MiddleNodeSinglyLinkedList {


    public static Node find_middle_node(Node head) {
        Node temp = head;
        int count = 0;
        while(temp!=null){
            count = count+1;
            temp = temp.next;
        }
        int result = count/2 + 1;

        count = 1;
        Node resultNode = head;
        while (count != result){
            count = count+1;
            resultNode = resultNode.next;
        }
        return resultNode;
    }

    /**
     * static LinkedListNode find_middle_node(LinkedListNode head) {
     *
     *     LinkedListNode slow = head;
     *     LinkedListNode fast = head;
     *
     *     if(head == null) return null;
     *
     *     while(fast!=null && fast.next!=null)
     *     {
     *         fast = fast.next.next;
     *         slow = slow.next;
     *     }
     *
     *     return slow;
     *
     *     }
     *
     */


    public static void main(String[] args) {
        Node first = new Node(1);
        first.next = new Node(2);
        first.next.next = new Node(3);
        first.next.next.next = new Node(4);
        first.next.next.next.next = new Node(5);
        Node res = find_middle_node(first);
        System.out.println(res);

    }
}
