package InterviewPractice.Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BoundaryOfBinaryTree {
    TreeNode node;
    public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        List<Integer> rightResult = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if((i==0 && (node.left!=null || node.right!=null))) result.add(node.val);
                if((i==size-1 && (node.left!=null || node.right!=null))) rightResult.add(node.val);
                if(node.left == null && node.right == null) result.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
        }
        int size = rightResult.size();
        for(int i=size-1;i>0;i--){
            result.add(rightResult.remove(i));
        }
        return result;
    }

    public static void main(String[] args) {
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
        System.out.println(boundaryOfBinaryTree(tree.node));
    }
}
