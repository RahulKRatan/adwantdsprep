package InterviewPractice.Trees.DFS;

import InterviewPractice.Trees.TreeNode;

/**
 * https://leetcode.com/problems/longest-univalue-path/discuss/244850/C-post-order-check-with-parent-value
 * left + right is the length of a path that goes from left subtree
 * and through the current root to its right subtree.
 * Like this / . And from current root, we only return the longer branch between left and right.
 */
public class LongestUnivaluePath {
    int len = 0; // global variable
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        len = 0;
        getLen(root, root.val);
        return len;
    }
    private int getLen(TreeNode node, int val) {
        if (node == null) return 0;
        int left = getLen(node.left, node.val);
        int right = getLen(node.right, node.val);
        len = Math.max(len, left + right);
        if (val == node.val)  return Math.max(left, right) + 1;
        return 0;
    }
}
/// using postorder traversal
/// I like to use binary tree in the following to explain the idea:
///   dummy root
///        |
///        5c
///      /   \
///      5a    5b
/// First, we work on recursive function. Every node is to check with its parent value
/// path value
/// Post order traversal, bottom up, three steps, 5a, 5b, 5c
/// step 1:
///     dummy root
///         |
///         5c
///      /     \
///      5a-1    5b
///   5a-1 stands for the edge from node 5a to 5c.
/// step 2:
///     dummy root
///         |
///         5c
///      /     \
///      5a-1    5b-1
///   5b-1 stands for the edge from node 5b to 5c.
/// step 3:
///     dummy root
///         |
///         5c-0
///      /     \
///      5a-1    5b-1
///    5c-0 stands for the edge from node 5c to its parent node, which is null.
/// combination of step 1, 2, 3:
///    dummy root
///         |
///         5c-0
///      /     \
///      5a-1    5b-1
///  The above tree left child with node value 5, 1 counts for the edge of the node 5
///  to its parent, in other words, edge from node 5a to 5c;
///  likewise the right child.
///  Now the calucation of cross path
///    dummy root
///         |
///         5c-0-2
///      /       \
///      5a-1-0    5b-1-0
///  The node 5c's cross path value is 2, since two edges, one is 5a to 5c, and the other is 5b to 5c.