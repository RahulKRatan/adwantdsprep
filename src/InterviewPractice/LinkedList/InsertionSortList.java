package InterviewPractice.LinkedList;

public class InsertionSortList {

    public static Node insertionSortList(Node head) {
        return null;
    }

    public static void main(String[] args) {
        Node first = new Node(4);
        first.next = new Node(2);
        first.next.next = new Node(1);
        first.next.next.next = new Node(3);
        Node result = insertionSortList(first);
        System.out.println(result);
    }


}
