package InterviewPractice.LinkedList;

// get to the middle of the list using fast and slow pointer and then reverse second half of the list and compare it with first half
// for palindrome match
public class PalindromeLinkedList {
    public static boolean isPalindrome(Node head) {
        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public static Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node first = new Node(1);
        first.next = new Node(2);
        first.next.next = new Node(2);
        first.next.next.next = new Node(1);
        System.out.println(isPalindrome(first));
    }
}
