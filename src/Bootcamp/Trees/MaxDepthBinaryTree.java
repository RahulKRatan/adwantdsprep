package Bootcamp.Trees;

public class MaxDepthBinaryTree {
    TreeNode node;
    static int count = 0;
    public static int maxDepth(TreeNode root) {
        if(root == null)
            return count;
        count = count + 1;
        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);
        if(left_depth > right_depth){
            return left_depth;
        }else
            return right_depth;
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
