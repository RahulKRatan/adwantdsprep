package InterviewPractice.Trees.DFS;

import InterviewPractice.Trees.TreeNode;

/**
 * Time complexity : O(N) since we visit each node exactly once.
 * Space complexity : O(N) since we keep up to the entire tree.
 */
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

/*
Time complexity : O(N) in the worst case when the tree is a BST or the "bad" element is a rightmost leaf.
Space complexity : O(N) for the space on the run-time stack.

class Solution {
    // We use Integer instead of int as it supports a null value.
    private Integer prev;

    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!inorder(root.left)) {
            return false;
        }
        if (prev != null && root.val <= prev) {
            return false;
        }
        prev = root.val;
        return inorder(root.right);
    }
}

Iterative Inorder Traversal

class Solution {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Integer prev = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // If next element in inorder traversal
            // is smaller than the previous one
            // that's not BST.
            if (prev != null && root.val <= prev) {
                return false;
            }
            prev = root.val;
            root = root.right;
        }
        return true;
    }
}
 */