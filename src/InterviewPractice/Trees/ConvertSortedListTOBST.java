package InterviewPractice.Trees;

import java.util.ArrayList;
import java.util.List;


/**
 * Time Complexity: The time complexity comes down to just O(N) now since we convert the linked list to an array initially and then we convert the array into a BST. Accessing the middle element now takes O(1) time and hence the time complexity comes down.
 * Space Complexity: Since we used extra space to bring down the time complexity, the space complexity now goes up to O(N) as opposed to just O(logN) in the previous solution. This is due to the array we construct initially.
 *
 * Convert the given linked list into an array. Let's call the beginning and the end of the array as left and right
 * Find the middle element as (left + right) / 2. Let's call this element as mid. This is a O(1)O(1) time operation and is the only major improvement over the previous algorithm.
 * The middle element forms the root of the BST.
 * Recursively form binary search trees on the two halves of the array represented by (left, mid - 1) and (mid + 1, right) respectively.
 */
public class ConvertSortedListTOBST {
    private static List<Integer> values = new ArrayList<>();
    public static TreeNode sortedListToBST(ListNode head) {
        // Form an array out of the given linked list and then
        // use the array to form the BST.
        mapListToValues(head);

        // Convert the array to
        return convertListToBST(0, values.size() - 1);
    }

    private static void mapListToValues(ListNode head) {
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
    }

    private static TreeNode convertListToBST(int left, int right) {
        // Invalid case
        if (left > right) {
            return null;
        }

        // Middle element forms the root.
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(values.get(mid));

        // Base case for when there is only one element left in the array
        if (left == right) {
            return node;
        }

        // Recursively form BST on the two halves
        node.left = convertListToBST(left, mid - 1);
        node.right = convertListToBST(mid + 1, right);
        return node;
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
