package InterviewPractice.LinkedList;

public class MergeTwoLists {

    public static Node mergeTwoLists(Node l1, Node l2) {
        Node result = new Node(-1);
        Node prev = result;
        while (l1 !=null && l2 != null){
            if(l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            }
            else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        while (l1 != null){
            prev.next = l1;
            l1 = l1.next;
            prev = prev.next;
        }
        while (l2 != null){
            prev.next = l2;
            l2 = l2.next;
            prev = prev.next;
        }
        return result.next;
    }

    /*
    Recurrsion
       public Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
     */

    public static void main(String[] args) {
        Node first = new Node(-9);
        first.next = new Node(3);

        Node second = new Node(5);
        second.next = new Node(7);
        mergeTwoLists(first,second);
    }
}
