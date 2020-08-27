package InterviewPractice.LinkedList;

public class RemoveElements {

    public static Node removeElements(Node head, int val) {
        if(head == null){
            return null;
        }
        Node helper = new Node(0);
        helper.next = head;
        Node p = helper;
        while (p.next != null){

        if(p.next.val == val){
             p.next = p.next.next;
        }else {
            p = p.next;
        }}
        return helper.next;
    }

    public static void main(String[] args) {
        Node first = new Node(1);
        first.next = new Node(2);
        first.next.next = new Node(3);
        first.next.next.next = new Node(4);
        first.next.next.next.next = new Node(5);
        first.next.next.next.next.next = new Node(6);
        System.out.println(removeElements(first,5));
    }
}
