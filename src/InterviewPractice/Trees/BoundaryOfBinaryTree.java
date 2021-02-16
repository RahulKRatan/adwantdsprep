package InterviewPractice.Trees;

import java.util.List;

public class BoundaryOfBinaryTree {
    TreeNode node;
    public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
        return null;
    }

    public static void main(String[] args) {
        BoundaryOfBinaryTree tree = new BoundaryOfBinaryTree();
        tree.node = new TreeNode(1);
        tree.node.right = new TreeNode(2);
        tree.node.right.right = new TreeNode(4);
        tree.node.right.left = new TreeNode(3);
        System.out.println(boundaryOfBinaryTree(tree.node));
    }
}
