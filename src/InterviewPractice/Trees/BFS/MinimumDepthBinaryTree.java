package InterviewPractice.Trees.BFS;

import InterviewPractice.Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * minDepth() vs MaxDepth()/getHeight()
 *
 * At the first look, I thought it is the same as the maxDepth/getHeight() problem, just change Math.max() to Math.min(), but I was wrong!!!
 *
 * For the maxDepth()/getHeight() problem, leaf nodes will always be in the longest path. So we do not need to care about anything. But for minDepth(), if there is one branch for a node, path has to go that branch rather than stop here because it is not a leaf node. For example:
 *
 * 		6
 * 	   /  \
 * 	  4*   7
 * 	   \
 * 		6*
 * 	   /
 * 	  5
 * For node 4, the minDepth is 3.
 * For node 6, the minDepth is 2.
 * ...
 *
 * Basically we are looking for the paths where leaf nodes exist. And find the shortest path. So the base case in recursion should be: if the current node is leaf node.
 */


public class MinimumDepthBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left == null && curNode.right == null) {
                    return level;
                }
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            level++;
        }
        return level;
    }

    /* DFS Solution

    * Key point:
    * if a node only has one child -> MUST return the depth of the side with child, i.e. MAX(left, right) + 1
    * if a node has two children on both side -> return min depth of two sides, i.e. MIN(left, right) + 1

    public int minDepth(TreeNode root) {
         if(root == null) return 0;

        // leaf node
        if(root.left == null && root.right == null) return 1;

		int left = minDepth(root.left);
        int right = minDepth(root.right);

        if(root.left == null) return right + 1; // leaf nodes are in right subtree
        if(root.right == null) return left + 1; // leaf nodes are in left subtree

        // left/right subtrees both contains leaf nodes
        return Math.min(left, right) + 1;
    }
     */
}
