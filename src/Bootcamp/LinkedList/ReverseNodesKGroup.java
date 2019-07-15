package Bootcamp.LinkedList;


/**
 * Reverse a link list between begin and end exclusively
 * an example:
 * a linked list:
 * 0->1->2->3->4->5->6
 * |           |
 * begin       end
 * after call begin = reverse(begin, end)
 *
 * 0->3->2->1->4->5->6
 *          |  |
 *      begin end
 * @return the reversed list's 'begin' node, which is the precedence of node end
 */

public class ReverseNodesKGroup {

    public static Node reverseKGroup(Node head, int k) {
        if(head==null||k==1)
            return head;

        Node fake = new Node(0);
        fake.next = head;
        Node prev = fake;
        int i=0;

        Node p = head;
        while(p!=null){
            i++;
            if(i%k==0){
                prev = reverse(prev, p.next);
                p = prev.next;
            }else{
                p = p.next;
            }
        }

        return fake.next;
    }

    public static Node reverse(Node prev, Node next){
        Node last = prev.next;
        Node curr = last.next;

        while(curr != next){
            last.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = last.next;
        }

        return last;
    }


    public static void main(String[] args) {
        Node first = new Node(1);
        first.next = new Node(2);
        first.next.next = new Node(3);
        first.next.next.next = new Node(4);
        first.next.next.next.next = new Node(5);
        System.out.println(reverseKGroup(first,2));
    }


}
