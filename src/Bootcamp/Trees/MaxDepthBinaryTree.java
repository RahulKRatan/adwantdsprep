package Bootcamp.Trees;

public class MaxDepthBinaryTree {
    TreeNode node;
    public static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);
        return 1+ Math.max(left_depth,right_depth);
    }

    public static void main(String[] args) {
        MaxDepthBinaryTree tree = new MaxDepthBinaryTree();
        tree.node = new TreeNode(3);
        tree.node.left = new TreeNode(9);
        tree.node.right = new TreeNode(20);
        tree.node.right.left = new TreeNode(15);
        tree.node.right.right = new TreeNode(7);
        System.out.println(maxDepth(tree.node));
    }
}
