package InterviewPractice.Trees.DFS;

import InterviewPractice.Trees.TreeNode;

import java.util.List;

public class BinaryTreePaths {
    TreeNode node;
    public static List<String> binaryTreePaths(TreeNode root) {

        return null;
    }

    public static void main(String[] args) {
        BinaryTreePaths tree = new BinaryTreePaths();
        tree.node=new TreeNode(1);
        tree.node.left = new TreeNode(2);
        tree.node.right = new TreeNode(3);
        tree.node.left.right = new TreeNode(5);
    }
}
