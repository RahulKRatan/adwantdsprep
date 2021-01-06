package InterviewPractice.Trees.DFS;

import InterviewPractice.Trees.TreeNode;

public class ValidateBST {
    TreeNode root;
    boolean isBST(TreeNode root){
        return isBST(root,Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    boolean isBST(TreeNode root,double min, double max)
    {
        if(root == null)
            return true;
        if(root.val <= min || root.val >= max){
            return false;
        }
        return isBST(root.left,min,root.val) && isBST(root.right,root.val,max);
    }

    public static void main(String[] args) {
        ValidateBST tree = new ValidateBST();
        tree.root = new TreeNode(2);
        tree.root.left = new TreeNode(1);
        tree.root.right = new TreeNode(3);
        System.out.println(tree.isBST(tree.root));
    }
}
