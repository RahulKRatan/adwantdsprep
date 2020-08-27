package InterviewPractice.Trees;

public class SymmetricTree {
    TreeNode node;
    public static boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left,root.right);
    }
    public static boolean isSymmetric(TreeNode left, TreeNode right){
    if(left == null && right == null){
        return true;
    }
    if(left.val != right.val){
        return false;
    }
    return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }

    public static void main(String[] args) {
        SymmetricTree tree = new SymmetricTree();
        tree.node = new TreeNode(1);
        tree.node.left = new TreeNode(2);
        tree.node.right = new TreeNode(2);
        tree.node.left.left = new TreeNode(3);
        tree.node.left.right = new TreeNode(4);
        tree.node.right.left = new TreeNode(4);
        tree.node.right.right = new TreeNode(3);
        System.out.println(isSymmetric(tree.node));
    }
}
