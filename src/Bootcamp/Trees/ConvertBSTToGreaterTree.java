package Bootcamp.Trees;

public class ConvertBSTToGreaterTree {
    TreeNode node;
    private static int sum = 0;
    public static TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
    ConvertBSTToGreaterTree tree = new ConvertBSTToGreaterTree();
        tree.node = new TreeNode(2);
        tree.node.left = new TreeNode(1);
        tree.node.right = new TreeNode(3);
        TreeNode result = convertBST(tree.node);
        System.out.println(result.val);
    }
}
