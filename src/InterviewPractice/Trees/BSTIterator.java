package InterviewPractice.Trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIterator {
    TreeNode node;
    Deque<Integer> stack = new ArrayDeque<>();
    public BSTIterator(){}
    public BSTIterator(TreeNode root){
            inOrder(root);
    }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        stack.push(root.val);
        inOrder(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        return stack.pollLast();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {
        BSTIterator tree = new BSTIterator();
        tree.node = new TreeNode(6);
        tree.node.left = new TreeNode(2);
        tree.node.right = new TreeNode(8);
        tree.node.left.left = new TreeNode(0);
        tree.node.left.right = new TreeNode(4);
        tree.node.left.right.left = new TreeNode(3);
        tree.node.left.right.right = new TreeNode(5);
        tree.node.right.left = new TreeNode(7);
        tree.node.right.right = new TreeNode(9);
        BSTIterator iterator = new BSTIterator(tree.node);
        System.out.println(iterator.hasNext());
    }

}
