package Bootcamp.LinkedList;

import java.util.Stack;

public class AddTwoNumbersII {

    public static Node addTwoNumbers(Node l1, Node l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        Node result = new Node(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            result.val = sum % 10;
            Node head = new Node(sum / 10);
            head.next = result;
            result = head;
            sum /= 10;
        }
        return result.val == 0 ? result.next : result;
    }


    public static void main(String[] args) {
        Node first = new Node(2);
        first.next = new Node(4);
        first.next.next = new Node(3);

        Node second = new Node(5);
        second.next = new Node(6);
        second.next.next = new Node(4);
    }

}
