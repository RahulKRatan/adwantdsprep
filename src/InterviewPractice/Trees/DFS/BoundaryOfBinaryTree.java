package InterviewPractice.Trees.DFS;

import InterviewPractice.Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Complexity:
 * O(n) leftBoundary(root.left);
 * O(n) leaves(root.left);
 * O(n) leaves(root.right);
 * O(n) rightBoundary(root.right);
 *
 * Total: O(n)
 */
public class BoundaryOfBinaryTree {
    //TreeNode node;
    List<Integer> nodes = new ArrayList<>(1000);
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null) return nodes;
        nodes.add(root.val);
        leftBoundary(root.left);
        leaves(root.left); // adding leaves of left side
        leaves(root.right); // adding leaves of left side
        rightBoundary(root.right);
        return nodes;
    }
    public void leftBoundary(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return; //Avoid adding leftmost leaf node and rightmost leaf node while traverse left and right boundary.
        nodes.add(root.val);
        if(root.left == null) leftBoundary(root.right);
        else leftBoundary(root.left);
    }
    public void rightBoundary(TreeNode root) {
        if(root == null || (root.right == null && root.left == null)) return; //Avoid adding leftmost leaf node and rightmost leaf node while traverse left and right boundary.
        if(root.right == null) rightBoundary(root.left);
        else rightBoundary(root.right);
        nodes.add(root.val); // add after child visit(reverse)
    }
    public void leaves(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            nodes.add(root.val);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }

   /* public static void main(String[] args) {
        BoundaryOfBinaryTree tree = new BoundaryOfBinaryTree();
        tree.node = new TreeNode(1);
        tree.node.left = new TreeNode(2);
        tree.node.right = new TreeNode(3);
        tree.node.left.left = new TreeNode(4);
        tree.node.left.right = new TreeNode(5);
        tree.node.left.right.left = new TreeNode(7);
        tree.node.left.right.right = new TreeNode(8);
        tree.node.right.left = new TreeNode(6);
        tree.node.right.left.left = new TreeNode(9);
        tree.node.right.left.right = new TreeNode(10);
        //System.out.println(boundaryOfBinaryTree(tree.node));
    }*/
}
