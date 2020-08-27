package InterviewPractice.LinkedList;

/**
 * Time complexity : O(n). Because each node in the list is checked exactly once to determine if it is a
 * duplicate or not, the total run time is O(n), where nn is the number of nodes in the list.
 *
 * Space complexity : O(1). No additional space is used.
 */
public class RemoveDuplicatesSortedList {

    public static Node deleteDuplicates(Node head) {
        Node temp = new Node(-1);
        temp.next = head;
        while (temp != null && temp.next !=null){
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
            }
            else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node first = new Node(1);
        first.next = new Node(1);
        first.next.next = new Node(1);
        Node result = deleteDuplicates(first);
        System.out.println(result);
    }

}
