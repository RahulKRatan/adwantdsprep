package Bootcamp.Trees.Traversals;

import Bootcamp.Trees.TreeNode;

/**
 * Morris inorder/preorder traversals
 *
 * Time complexity O(n)
 * Space complexity O(1)
 */
public class MorrisTraversal {

    public void inorder(TreeNode root) {
        TreeNode current = root;
        while(current != null) {
            //left is null then print the node and go to right
            if (current.left == null) {
                System.out.print(current.val + " ");
                current = current.right;
            }
            else {
                //find the predecessor.
                TreeNode predecessor = current.left;
                //To find predecessor keep going right till right node is not null or right node is not current.
                while(predecessor.right != current && predecessor.right != null){
                    predecessor = predecessor.right;
                }
                //if right node is null then go left after establishing link from predecessor to current.
                if(predecessor.right == null){
                    predecessor.right = current;
                    current = current.left;
                }else{ //left is already visit. Go rigth after visiting current.
                    predecessor.right = null;
                    System.out.print(current.val + " ");
                    current = current.right;
                }
            }
        }
    }

    public void preorder(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if(current.left == null) {
                System.out.print(current.val + " ");
                current = current.right;
            }
            else {
                TreeNode predecessor = current.left;
                while(predecessor.right != current && predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null){
                    predecessor.right = current;
                    System.out.print(current.val + " ");
                    current = current.left;
                }else{
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }
    }

}
