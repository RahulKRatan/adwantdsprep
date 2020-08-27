package InterviewPractice.LinkedList.IK;

import InterviewPractice.LinkedList.Node;

public class SwapkthNodesGivenLinkedList {

    public static Node swap_nodes(Node head, int k) {
        //find the kth node from start
        Node kth_fromstart=head;
        Node kth_fromstart_prev=null;
        int i=1;
        while(i<k){
            kth_fromstart_prev=kth_fromstart;
            kth_fromstart=kth_fromstart.next;
            i++;
        }

        //now we set temp to kth node from start and we start with a new pointer from head,
        // as distance between temp and head is k so if we move them together then when temp reaches
        // null(end of the list) then kth_from_end would be at distance of k from the end
        Node temp=kth_fromstart;
        Node kth_from_end=head;
        Node kth_from_end_prev=null;
        while(temp.next!=null){
            temp=temp.next;
            kth_from_end_prev=kth_from_end;
            kth_from_end=kth_from_end.next;
        }

        //now we have 4 pointers
        //kthfromend.next=kthfromstart.next
        //connect kthfromstart_prev.next-->kthfromend

        //if k==1 then connect head to kth from end
        if(kth_fromstart_prev==null){
            head = kth_from_end;
        }
        else{
            kth_fromstart_prev.next=kth_from_end;
        }

        if(kth_from_end_prev==null){
            //only 1 node in linked_list
            head = kth_fromstart;
        }
        else{
            kth_from_end_prev.next=kth_fromstart;
        }
        //kthfromstart.next=kthfromend.next
        //connect kthfromend_prev.next-->kthfromstart
        Node kth_from_end_next=kth_from_end.next;

        kth_from_end.next=kth_fromstart.next;
        kth_fromstart.next=kth_from_end_next;
        return head;
    }

    public static void main(String[] args) {
        Node first = new Node(1);
        first.next = new Node(2);
        first.next.next = new Node(3);
        first.next.next.next = new Node(4);
        first.next.next.next.next = new Node(7);
        first.next.next.next.next.next = new Node(0);
    }
}
