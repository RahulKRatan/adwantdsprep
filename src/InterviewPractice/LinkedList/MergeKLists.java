package InterviewPractice.LinkedList;

import java.util.*;

/**
 * The complexity of this problem is O(knlogk), no algorithm can run it O(nlogk). We have T(n) = 2T(n/2) + kn, and therefore, O(kn*logk).
 *
 * Or you can think about the complexity on each node and expand. For each node, the complexity is O(logk), which is the complexity for adding to the PQ, and there are k*n that many of nodes, which gives us O(knlogk).
 *
 * I would say this, where k = number of lists and n = average number of nodes in each list
 * Time : O(k log k + nk log k), where k log k for inserting k nodes in the min heap.
 * Space : O(nk)
 */
public class MergeKLists {

    public static Node mergeKLists(List<Node> lists) {

        Queue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));// increasing list 1..,2..,3..
        /*
        public static class NodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
            }
         }
         */
        for(Node node: lists){
            if(node != null) {
                minHeap.add(node);
            }
        }

        Node head = new Node(0);
        Node point = head;

        while(!minHeap.isEmpty()){
            point.next = minHeap.poll();
            point = point.next;
            Node next = point.next;
            if(next!=null){
                minHeap.add(next);
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        Node first = new Node(2);
        first.next = new Node(3);

        Node second = new Node(1);
        second.next = new Node(5);

        Node third = new Node(3);
        third.next = new Node(7);

        List<Node> list = new ArrayList<>();
        list.add(first);
        list.add(second);
        list.add(third);
        System.out.println(mergeKLists(list));
    }
}
