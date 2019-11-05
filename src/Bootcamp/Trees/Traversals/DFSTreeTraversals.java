package Bootcamp.Trees.Traversals;


import Bootcamp.Trees.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Youtube link - https://youtu.be/nzmtCFNae9k
 * Youtube link - https://youtu.be/elQcrJrfObg
 * Youtube link - https://youtu.be/qT65HltK2uE
 * Youtube link - https://youtu.be/ZM-sV9zQPEs
 *
 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
 * http://www.geeksforgeeks.org/iterative-preorder-traversal/
 */
public class DFSTreeTraversals {
    TreeNode TreeNode;
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public void inorderItr(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode TreeNode = root;
        while(true){
            if(TreeNode != null){
                stack.addFirst(TreeNode);
                TreeNode = TreeNode.left;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                TreeNode = stack.pollFirst();
                System.out.println(TreeNode.val);
                TreeNode = TreeNode.right;
            }
        }
    }


    /**
     * Preorder traversal is used to create a copy of the tree.
     * Preorder traversal is also used to get prefix expression on of an expression tree.
     * Please see http://en.wikipedia.org/wiki/Polish_notation to know why prefix expressions are useful.
     * @param root
     */
    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrderItr(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        stack.addFirst(root);
        while(!stack.isEmpty()){
            root = stack.pollFirst();
            System.out.print(root.val + " ");
            if(root.right != null){
                stack.addFirst(root.right);
            }
            if(root.left!= null){
                stack.addFirst(root.left);
            }
        }
    }

    public void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public void postOrderItr(TreeNode root){
        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();
        stack1.addFirst(root);
        while(!stack1.isEmpty()){
            root = stack1.pollFirst();
            if(root.left != null){
                stack1.addFirst(root.left);
            }
            if(root.right != null){
                stack1.addFirst(root.right);
            }
            stack2.addFirst(root);
        }
        while(!stack2.isEmpty()){
            System.out.print(stack2.pollFirst().val + " ");
        }
    }

    public void postOrderItrOneStack(TreeNode root){
        TreeNode current = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while(current != null || !stack.isEmpty()){
            if(current != null){
                stack.addFirst(current);
                current = current.left;
            }else{
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.poll();
                    System.out.print(temp.val + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.poll();
                        System.out.print(temp.val + " ");
                    }
                } else {
                    current = temp;
                }
            }
        }
    }

    public static void main(String args[]){
        DFSTreeTraversals tree = new DFSTreeTraversals();
        tree.TreeNode = new TreeNode(1);
        tree.TreeNode.left = new TreeNode(2);
        tree.TreeNode.right = new TreeNode(3);
        tree.TreeNode.left.left = new TreeNode(4);
        tree.TreeNode.left.right = new TreeNode(5);


        DFSTreeTraversals tt = new DFSTreeTraversals();
        tt.postOrder(tree.TreeNode);
        System.out.println();
        tt.postOrderItr(tree.TreeNode);
        System.out.println();
        tt.postOrderItrOneStack(tree.TreeNode);
    }
}
