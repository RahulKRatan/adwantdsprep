package InterviewPractice.LinkedList;

public class InsertionSortList {
    /*
        T : O(N2)
        S : O(1)
     */
    public static Node insertionSortList(Node head) {
        if(head == null) return null;
        Node dummy = new Node();
        dummy.next = head;
        Node cur = head;
        while(cur.next != null) {
            // we will be inserting cur.next to its proper location
            int val = cur.next.val;
            if(cur.val <= val) {
                cur = cur.next;
                continue;// continue if the list is already sorted
            }
            // start searching from head
            Node node = dummy;
            while(node.next.val < val) {
                node = node.next;
            }

            Node temp = cur.next;
            cur.next = cur.next.next; // update cur
            // Move cur.next to the proper location
            temp.next = node.next;
            node.next = temp; // important step to attach dummy to the temp
        }
        return dummy.next;
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
