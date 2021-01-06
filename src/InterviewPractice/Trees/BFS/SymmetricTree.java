package InterviewPractice.Trees.BFS;

import InterviewPractice.Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center
 */
public class SymmetricTree {
    TreeNode node;

    public static boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        Queue<TreeNode> q = new LinkedList();

        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null)
                continue;
            if(left == null || right == null ||left.val != right.val )
                return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);

        }
        return true;
    }

    /* DFS


    public static boolean isSymmetricDFS(TreeNode root) {
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

    */


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
