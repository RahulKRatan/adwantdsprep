package InterviewPractice.Trees.DFS;


import InterviewPractice.Trees.TreeNode;

/**
 * The question is exactly similar to the Leetcode 100 Same Tree
 * Solution for Leetcode 100: https://leetcode.com/problems/same-tree/discuss/148340/CPP-Easy-to-Understand
 *
 * Also Check Leetcode 101 [Symmetric Tree]https://leetcode.com/problems/symmetric-tree/description/)
 * Leetcode 101 eh? :P
 *
 * Okay so now you will be absolutely comfortable with this question. It just requires you to
 *
 * Start with a node of tree s (lets call this s-node)
 * Compare the trees forming with root s-node and root t
 * If the trees match(leetcode 100 logic) then return true
 * Else go to step one and check for s->left || s->right
 *
 * If assume m is the number of nodes in the 1st tree and n is the number of nodes in the 2nd tree, then
 * Time complexity: O(m*n), worst case: for each node in the 1st tree, we need to check if isSame(Node s, Node t). Total m nodes, isSame(...) takes O(n) worst case
 * Space complexity: O(height of 1str tree)(Or you can say: O(m) for worst case, O(logm) for average case)
 *
 */
//For each node during pre-order traversal of s, use a recursive function isSame to validate if sub-tree started with this node is the same with t.
public class SubtreeOfAnotherTree {
    TreeNode node1;
    TreeNode node2;

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    private static boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val != t.val) return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    public static void main(String[] args) {
        SubtreeOfAnotherTree tree = new SubtreeOfAnotherTree();
        tree.node1 = new TreeNode(3);
        tree.node1.left = new TreeNode(4);
        tree.node1.right = new TreeNode(5);
        tree.node1.left.left = new TreeNode(1);
        tree.node1.left.right = new TreeNode(2);

        tree.node2 = new TreeNode(4);
        tree.node2.left = new TreeNode(1);
        tree.node2.right = new TreeNode(2);
        System.out.println(isSubtree(tree.node1,tree.node2));
    }
}
