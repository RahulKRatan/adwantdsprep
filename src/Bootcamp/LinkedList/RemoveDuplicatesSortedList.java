package Bootcamp.LinkedList;

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
