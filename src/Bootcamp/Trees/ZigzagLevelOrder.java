package Bootcamp.Trees;

public class ZigzagLevelOrder {

    TreeNode node;


    public static void main(String[] args) {
        ZigzagLevelOrder tree = new ZigzagLevelOrder();
        tree.node = new TreeNode(1);
        tree.node.left = new TreeNode(2);
        tree.node.right = new TreeNode(5);
        tree.node.left.left = new TreeNode(3);
        tree.node.left.right = new TreeNode(4);
    }

}
