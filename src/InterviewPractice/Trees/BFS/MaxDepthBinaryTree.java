package InterviewPractice.Trees.BFS;

import InterviewPractice.Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaxDepthBinaryTree {
    TreeNode node;

    public static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
    }

    public static int maxDepthDFS(TreeNode root) {
        if(root == null)
            return 0;
        int left_depth = maxDepthDFS(root.left);
        int right_depth = maxDepthDFS(root.right);
        return 1+ Math.max(left_depth,right_depth);
    }

    public static void main(String[] args) {
        MaxDepthBinaryTree tree = new MaxDepthBinaryTree();
        tree.node = new TreeNode(3);
        tree.node.left = new TreeNode(9);
        tree.node.right = new TreeNode(20);
        tree.node.right.left = new TreeNode(15);
        tree.node.right.right = new TreeNode(7);
        System.out.println(maxDepthDFS(tree.node));
        System.out.println(maxDepth(tree.node));
    }
}
