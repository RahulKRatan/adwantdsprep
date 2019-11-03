package Bootcamp.LinkedList.IK;

import Bootcamp.LinkedList.Node;

public class MergeSortALinkedList {


    public static Node merge_sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // get the middle of the list
        Node middle = split(head);
        Node nextofmiddle = middle.next;

        // set the next of middle SinglyLinkedListNode to null
        middle.next = null;

        // Apply split on left list
        Node left = merge_sort(head);

        // Apply split on right list
        Node right = merge_sort(nextofmiddle);

        // Merge the left and right lists
        Node sortedlist = merge(left, right);
        return sortedlist;
    }

    public static Node merge(Node list1, Node list2) {
        Node result = null;
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        // Pick either list1 or list2 and recur the merge method
        if (list1.val <= list2.val) {
            result = list1;
            result.next = merge(list1.next, list2);
        } else {
            result = list2;
            result.next = merge(list1, list2.next);
        }
        return result;
    }

    public static Node split(Node head) {
        // Base case
        if (head == null) {
            return head;
        }
        Node fast = head.next;
        Node slow = head;

        // Move fast by two and slow by one
        // Finally slow will point to middle SinglyLinkedListNode
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }


    public static void main(String[] args) {
        Node first = new Node(0);
        first.next = new Node(1);
        first.next.next = new Node(10);
        first.next.next.next = new Node(7);
        first.next.next.next.next = new Node(5);
        Node result = merge_sort(first);
        System.out.println(result);
    }
}
