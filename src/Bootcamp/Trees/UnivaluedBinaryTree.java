package Bootcamp.Trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class UnivaluedBinaryTree {
    TreeNode root;
    public static boolean isUnivalTree(TreeNode root) {
        int value = root.val;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp.val != value){
                return false;
            }
            if(temp.left!=null){
                    queue.add(temp.left);
            }
            if(temp.right != null){
                    queue.add(temp.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        UnivaluedBinaryTree tree = new UnivaluedBinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(4);
        System.out.println(isUnivalTree(tree.root));
    }
}
