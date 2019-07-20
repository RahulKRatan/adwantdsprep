package Bootcamp.LinkedList;

public class RotateList {

    public static Node rotateRight(Node head, int k) {


        return head;
    }



    public static void main(String[] args) {
        Node first = new Node(1);
        first.next = new Node(2);
        first.next.next = new Node(3);
        first.next.next.next = new Node(4);
        first.next.next.next.next = new Node(5);
        System.out.println(rotateRight(first,3));
    }
}
