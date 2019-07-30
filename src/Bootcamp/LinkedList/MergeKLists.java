package Bootcamp.LinkedList;

import java.util.*;

public class MergeKLists {

    public static Node mergeKLists(List<Node> lists) {
        Comparator<Node> comparator = Comparator.comparingInt(o -> o.val);
        Queue<Node> queue = new PriorityQueue<>(comparator);

        for(Node node: lists){
            if(node != null) {
                queue.add(node);
            }
        }

        Node head = new Node(0);
        Node point = head;

        while(!queue.isEmpty()){
            point.next = queue.poll();
            point = point.next;
            Node next = point.next;
            if(next!=null){
                queue.add(next);
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