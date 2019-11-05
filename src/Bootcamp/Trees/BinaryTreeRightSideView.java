package Bootcamp.Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    TreeNode root;

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            Integer rightMost=0;
            for(int i=0;i<len;i++){
            TreeNode temp = queue.poll();
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                    queue.add(temp.right);
            }
            rightMost = temp.val;
            }
            res.add(rightMost);
        }

        return res;
    }

    public static void main(String[] args) {
        BinaryTreeRightSideView tree = new BinaryTreeRightSideView();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(4);
        List<Integer> result = rightSideView(tree.root);
        System.out.println(result);
    }
}
