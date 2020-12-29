package InterviewPractice.Trees.DFS;

import InterviewPractice.Trees.TreeNode;

//For every node, length of longest path
// which pass it = MaxDepth of its left subtree + MaxDepth of its right subtree.
public class DiameterOfBinaryTree {
    TreeNode node;
    static int max = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
    public static void main(String[] args) {
        DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
        tree.node = new TreeNode(1);
        tree.node.left = new TreeNode(2);
        tree.node.right = new TreeNode(3);
        tree.node.left.left = new TreeNode(4);
        tree.node.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(tree.node));
    }
}
