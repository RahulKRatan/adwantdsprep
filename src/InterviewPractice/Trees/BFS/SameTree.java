package InterviewPractice.Trees.BFS;

import InterviewPractice.Trees.TreeNode;

import java.util.ArrayDeque;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 * Time complexity : O(N) since each node is visited exactly once.
 *
 * Space complexity : O(log(N)) in the best case of completely balanced tree and O(N) in the worst case of completely unbalanced tree, to keep a deque.
 */
public class SameTree {
    public static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return true;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (!check(p, q)) return false;

        // init deques
        ArrayDeque<TreeNode> deqP = new ArrayDeque<>();
        ArrayDeque<TreeNode> deqQ = new ArrayDeque<>();
        deqP.addLast(p);
        deqQ.addLast(q);

        while (!deqP.isEmpty()) {
            p = deqP.removeFirst();
            q = deqQ.removeFirst();

            if (!check(p, q)) return false;
            if (p != null) {
                // in Java nulls are not allowed in Deque
                if (!check(p.left, q.left)) return false;
                if (p.left != null) {
                    deqP.addLast(p.left);
                    deqQ.addLast(q.left);
                }
                if (!check(p.right, q.right)) return false;
                if (p.right != null) {
                    deqP.addLast(p.right);
                    deqQ.addLast(q.right);
                }
            }
        }
        return true;
    }
}

/* Recursive
 public boolean isSameTree(TreeNode p, TreeNode q) {
    // p and q are both null
    if (p == null && q == null) return true;
    // one of p and q is null
    if (q == null || p == null) return false;
    if (p.val != q.val) return false;
    return isSameTree(p.right, q.right) &&
            isSameTree(p.left, q.left);
  }
 */
