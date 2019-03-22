package Bootcamp.Trees;

public class MaxDepthBinaryTree {
    TreeNode node;

    public static void main(String[] args) {
        MaxDepthBinaryTree tree = new MaxDepthBinaryTree();
        tree.node = new TreeNode(1);
        tree.node.left = new TreeNode(3);
        tree.node.right = new TreeNode(2);
        tree.node.left.left = new TreeNode(5);
    }
}
