package InterviewPractice.LinkedList;


/**
 * Why is merge sort preferred over quick sort for sorting linked lists?
 *
 * As Singly Linked list can be accessed in only one direction and cannot be accessed randomly, Quick sort will not be well suitable here.
 *
 * Quick sort requires access to elements in both direction for swapping and doing such operation in Linked list is not as easy as working with Arrays.
 * Starting from the end and moving backward is usually expensive operation in Singly linked list.
 * So Quick sort is well suited for arrays and not linked list.
 *
 * Merge sort is a divide and conquer algorithm in which need of Random access to elements is less.
 * So Merge Sort can be used for sorting Linked list.
 *
 * Break the list to two in the middle
 * Recursively sort the two sub lists
 * Merge the two sub lists
 */
public class SortList {


    public static Node sortList(Node head) {
        if(head==null || head.next==null){
            return head;
        }
        //partition the list
        Node p1 = head;
        Node firstEnd = getFirstEnd(head);
        Node p2 = firstEnd.next;
        firstEnd.next = null;

        //sort each list
        p1 = sortList(p1);
        p2 = sortList(p2);

        //merge two lists
        return merge(p1, p2);
    }

    //get the list partition point - using fast and slow pointers
    private static Node getFirstEnd(Node head){
        Node p1 = head;
        Node p2 = head;
        while(p1!=null && p2!=null){
            if(p2.next==null||p2.next.next==null){
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return head; //never reaches here
    }

    //merge two list
    private static Node merge(Node n1, Node n2){
        Node head = new Node(0);
        Node p = head;
        Node p1 = n1;
        Node p2 = n2;
        while(p1!=null && p2!=null){
            if(p1.val<p2.val){
                p.next = p1;
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if(p1!=null){
            p.next = p1;
        }
        if(p2!=null){
            p.next = p2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Node first = new Node(4);
        first.next = new Node(2);
        first.next.next = new Node(1);
        first.next.next.next = new Node(3);
        System.out.println(sortList(first));
    }
}
