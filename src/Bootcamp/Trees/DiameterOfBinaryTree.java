package Bootcamp.Trees;

public class DiameterOfBinaryTree {
    TreeNode node;
    

    public static void main(String[] args) {
        DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
        tree.node = new TreeNode(1);
        tree.node.left = new TreeNode(2);
        tree.node.right = new TreeNode(3);
        tree.node.left.left = new TreeNode(4);
        tree.node.left.right = new TreeNode(5);
    }
}
