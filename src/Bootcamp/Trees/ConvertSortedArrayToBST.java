package Bootcamp.Trees;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedArrayToBST {
    List<Integer> values = null;
    public TreeNode sortedArrayToBST(int[] nums) {
        values = new ArrayList<Integer>(nums.length);
        for (int i : nums)
        {
            values.add(i);
        }
        return convertListToBST(0, values.size() - 1);
    }

    private TreeNode convertListToBST(int left, int right) {
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
}
