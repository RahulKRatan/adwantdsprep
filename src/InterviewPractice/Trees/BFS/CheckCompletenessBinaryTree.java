package InterviewPractice.Trees.BFS;

import InterviewPractice.Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, determine if it is a complete binary tree.
 *
 * In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Solution 1, BFS
 * Use BFS to do a level order traversal,
 * add children to the bfs queue,
 * until we met the first empty node.
 *
 * For a complete binary tree,
 * there should not be any node after we met an empty one.
 *
 * Time O(N), Space O(N)
 */
public class CheckCompletenessBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);
        while (bfs.peek() != null) {
            TreeNode node = bfs.poll();
            bfs.offer(node.left);
            bfs.offer(node.right);
        }
        while (!bfs.isEmpty() && bfs.peek() == null)
            bfs.poll();
        return bfs.isEmpty();
    }
}

/* BFS Optimization
Also you may want to return earlier.
We can stop the first while loop when met the first null child.
From then on there should not be any more child.
This optimisation help reduce half of operations.

public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<TreeNode>();
        bfs.offer(root);
        while (true) {
            TreeNode node = bfs.poll();
            if (node.left == null) {
                if (node.right != null)
                    return false;
                break;
            }
            bfs.offer(node.left);
            if (node.right == null) break;
            bfs.offer(node.right);
        }
        while (!bfs.isEmpty()) {
            TreeNode node = bfs.poll();
            if (node.left != null || node.right != null)
                return false;
        }
        return true;
    }
 */
