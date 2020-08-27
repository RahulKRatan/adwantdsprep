package InterviewPractice.LinkedList;

public class RemoveDuplicatesSortedListII {

    public static Node deleteDuplicates(Node head) {
        Node temp = new Node(0);
        temp.next = head;
        Node pre = temp;

        while (pre.next != null && pre.next.next !=null){
            if(pre.next.val == pre.next.next.val){
                int dup = pre.next.val;
                while(pre.next!=null&&pre.next.val==dup){
                    pre.next = pre.next.next;
                }
            }
            else {
                pre = pre.next;
            }
        }
        return temp.next;
    }

    public static void main(String[] args) {
        Node first = new Node(1);
        first.next = new Node(1);
        first.next.next = new Node(1);
        first.next.next.next = new Node(2);
        first.next.next.next.next = new Node(3);
        Node result = deleteDuplicates(first);
        System.out.println(result);
    }

}
