package InterviewPractice.LinkedList;

import java.util.Deque;
import java.util.LinkedList;

public class AddTwoNumbersII {

    public static Node addTwoNumbers(Node l1, Node l2) {
        Deque<Integer> s1 = new LinkedList<>();
        Deque<Integer> s2 = new LinkedList<>();

        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        Node result = new Node(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) sum += s1.pop();
            if (!s2.isEmpty()) sum += s2.pop();
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
