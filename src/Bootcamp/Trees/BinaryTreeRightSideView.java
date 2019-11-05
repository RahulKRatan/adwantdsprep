package Bootcamp.Trees;

import java.util.List;

public class BinaryTreeRightSideView {
    TreeNode root;

    public List<Integer> rightSideView(TreeNode root) {
            

        return null;
    }

    public static void main(String[] args) {
        BinaryTreeRightSideView tree = new BinaryTreeRightSideView();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(4);
    }
}
