package Bootcamp.Trees;

public class PathSum3 {
    TreeNode node;
    public static int pathSum(TreeNode root, int sum) {
        

        return 0;
    }


    public static void main(String[] args) {
        PathSum3 tree = new PathSum3();
        tree.node = new TreeNode(10);
        tree.node.left = new TreeNode(5);
        tree.node.right = new TreeNode(-3);
        tree.node.left.left = new TreeNode(3);
        tree.node.left.right = new TreeNode(2);
        tree.node.left.left.left = new TreeNode(3);
        tree.node.left.left.right= new TreeNode(-2);
        tree.node.right.right = new TreeNode(11);
        System.out.println(pathSum(tree.node,8));
    }
}
