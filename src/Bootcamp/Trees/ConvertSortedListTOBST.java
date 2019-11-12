package Bootcamp.Trees;

public class ConvertSortedListTOBST {

    public static TreeNode sortedListToBST(ListNode head) {
        

        return null;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(-10);
        first.next = new ListNode(-3);
        first.next.next = new ListNode(0);
        first.next.next.next = new ListNode(5);
        first.next.next.next.next = new ListNode(9);
        TreeNode result = sortedListToBST(first);
        System.out.println(result);
    }
}
