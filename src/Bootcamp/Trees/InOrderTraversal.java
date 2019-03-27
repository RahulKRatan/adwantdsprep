package Bootcamp.Trees;

public class InOrderTraversal {
    TreeNode node;
    public static void inOrderTraversalRecursive(TreeNode node){
    if(node == null)
        return;
    inOrderTraversalRecursive(node.left);
    System.out.println(node.val);
    inOrderTraversalRecursive(node.right);
    }

    public static void main(String[] args) {
        InOrderTraversal tree = new InOrderTraversal();
        tree.node = new TreeNode(1);
        tree.node.left = new TreeNode(2);
        tree.node.right = new TreeNode(3);
        tree.node.left.left = new TreeNode(4);
        tree.node.left.right = new TreeNode(5);
        inOrderTraversalRecursive(tree.node);
    }
}
