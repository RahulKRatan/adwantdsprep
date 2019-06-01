package Bootcamp.LinkedList;

public class AddTwoNumbers {

    public static Node addTwoNumbers(Node l1, Node l2) {
        


        return null;
    }



    public static void main(String[] args) {
        Node first = new Node(2);
        first.next = new Node(4);
        first.next.next = new Node(3);

        Node second = new Node(5);
        second.next = new Node(6);
        second.next.next = new Node(4);

        Node result = addTwoNumbers(first,second);
    }


}
