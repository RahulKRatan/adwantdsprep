package InterviewPractice.Trees;

/** Top down approach
 *
 * We pass the minimum and maximum values to the children,
 * At the leaf node, we return max - min through the path from the root to the leaf.
 * Let NN be the number of nodes in the binary tree.
 *
 * Time complexity: O(N) since we visit all nodes once.
 *
 * Space complexity: O(N) since we need stacks to do recursion,
 * and the maximum depth of the recursion is the height of the tree,
 * which is O(N) in the worst case and (log(N)) in the best case.
 */
public class MaximumDifferenceBetweenNodeAndAncestor {
    public int maxAncestorDiff(TreeNode root) {
        return helper(root, root.val, root.val);
    }
    public int helper(TreeNode root, int min, int max) {
        if (root == null) return max - min;
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        return Math.max(helper(root.left, min, max), helper(root.right, min, max));
    }
}
