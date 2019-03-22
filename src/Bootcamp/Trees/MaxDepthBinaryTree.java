package Bootcamp.Trees;

public class MaxDepthBinaryTree {
    TreeNode node;
    public static int maxDepth(TreeNode root) {
        

        return 0;
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
