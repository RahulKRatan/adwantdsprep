package Bootcamp.LinkedList;

public class SortList {


    public static Node sortList(Node head) {
    
    }

    public static void main(String[] args) {
        Node first = new Node(4);
        first.next = new Node(2);
        first.next.next = new Node(1);
        first.next.next.next = new Node(3);
        System.out.println(sortList(first));
    }
}
