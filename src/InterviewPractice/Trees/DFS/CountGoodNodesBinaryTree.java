package InterviewPractice.Trees.DFS;

import InterviewPractice.Trees.TreeNode;

public class CountGoodNodesBinaryTree {
    TreeNode node;
    public static int goodNodes(TreeNode root) {

        return 0;
    }

    public static void main(String[] args) {
        CountGoodNodesBinaryTree tree = new CountGoodNodesBinaryTree();
        tree.node = new TreeNode(3);
        tree.node.left = new TreeNode(1);
        tree.node.right = new TreeNode(4);
        tree.node.right.right = new TreeNode(5);
        tree.node.left.left = new TreeNode(3);
        tree.node.right.left = new TreeNode(1);
        System.out.println(goodNodes(tree.node));
    }
}
