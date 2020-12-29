package InterviewPractice.Trees.DFS;

import InterviewPractice.Trees.TreeNode;

/**
 * Time complexity : O(n). The time complexity is the same as an preorder traversal of a binary tree with n nodes.
 *
 * Space complexity : O(n). The extra space comes from implicit stack space due to recursion.
 * For a skewed binary tree, the recursion could go up to n levels deep.
 * the first solution is a tail-recursion, and the second solution is a non-tail recursion.
 */
public class BinaryTreeLongestConsecutiveSequence {
    TreeNode node;
    private static int maxLength = 0;
    public static int longestConsecutive(TreeNode root) {
        dfs(root, null, 0);
        return maxLength;
    }
    private static void dfs(TreeNode root, TreeNode parent, int length) {
        if (root == null) return;
        length = (parent != null && root.val == parent.val + 1) ? length + 1 : 1;
        maxLength = Math.max(maxLength, length);
        dfs(root.left, root, length);
        dfs(root.right, root, length);
    }
    /* Post order traversal

    private int maxLength = 0;
public int longestConsecutive(TreeNode root) {
    dfs(root);
    return maxLength;
}

private int dfs(TreeNode p) {
    if (p == null) return 0;
    int L = dfs(p.left) + 1;
    int R = dfs(p.right) + 1;
    if (p.left != null && p.val + 1 != p.left.val) {
        L = 1;
    }
    if (p.right != null && p.val + 1 != p.right.val) {
        R = 1;
    }
    int length = Math.max(L, R);
    maxLength = Math.max(maxLength, length);
    return length;
}
     */

    public static void main(String[] args) {
    BinaryTreeLongestConsecutiveSequence tree = new BinaryTreeLongestConsecutiveSequence();
        tree.node=new TreeNode(1);
        tree.node.left = new TreeNode(2);
        tree.node.right = new TreeNode(3);
        tree.node.left.right = new TreeNode(5);
        System.out.println(longestConsecutive(tree.node));
    }
}
