package InterviewPractice.Trees.DFS;

import InterviewPractice.Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
        TreeNode node;
        // BFS solution
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        InvertBinaryTree tree = new InvertBinaryTree();
        tree.node = new TreeNode(4);
        tree.node.left = new TreeNode(2);
        tree.node.right = new TreeNode(7);
        tree.node.left.left = new TreeNode(1);
        tree.node.left.right = new TreeNode(3);
        tree.node.right.left = new TreeNode(6);
        tree.node.right.right = new TreeNode(9);
        TreeNode result = invertTree(tree.node);
        System.out.println(result.left.val);
    }
}

/* DFS solution
public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;

        TreeNode oldLeft = root.left;
        TreeNode oldRight = root.right;
        root.left = oldRight;
        root.right = oldLeft;

        if(root.left != null){
            invertTree(root.left);
        }

       if(root.right != null){
            invertTree(root.right);
        }
        return root;
    }
*/