package Bootcamp.Trees;

public class MergeTwoBinaryTrees {
    TreeNode node1;
    TreeNode node2;


    public static void main(String[] args) {
        MergeTwoBinaryTrees trees = new MergeTwoBinaryTrees();
        trees.node1 = new TreeNode(2);
        trees.node1.left = new TreeNode(1);
        trees.node1.right = new TreeNode(3);
        trees.node2 = new TreeNode(5);
        trees.node2 = new TreeNode(4);
        trees.node2 = new TreeNode(6);
    }

}
