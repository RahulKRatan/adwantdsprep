package InterviewPractice.Trees;

public class BalancedBinaryTree {
    TreeNode node;
    public boolean isBalanced(TreeNode root) {

        return false;
    }

    public static void main(String[] args) {
        BalancedBinaryTree tree = new BalancedBinaryTree();
        tree.node = new TreeNode(3);
        tree.node.left = new TreeNode(9);
        tree.node.right = new TreeNode(20);
        tree.node.right.left = new TreeNode(15);
        tree.node.right.right = new TreeNode(7);
    }
}
