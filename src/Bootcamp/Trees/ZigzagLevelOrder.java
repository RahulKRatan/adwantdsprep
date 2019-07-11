package Bootcamp.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {

    TreeNode node;
    public static List<List> zigzagLevelOrdertraversal(TreeNode root) {
        List<List> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean order = true; // this is insert elements alternatively
        int size = 1;

        while(!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < size; ++i) {
                TreeNode n = q.poll();
                if(order) {
                    tmp.add(n.val);
                } else {
                    tmp.add(0, n.val); // interesting way to insert - inserts elements at the first position and pushing rest to right
                }
                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
            }
            res.add(tmp);
            size = q.size();
            order = !order;
        }
        return res;
    }

    public static void main(String[] args) {
        ZigzagLevelOrder tree = new ZigzagLevelOrder();
        tree.node = new TreeNode(1);
        tree.node.left = new TreeNode(2);
        tree.node.right = new TreeNode(5);
        tree.node.left.left = new TreeNode(3);
        tree.node.left.right = new TreeNode(4);
        List<List> result = zigzagLevelOrdertraversal(tree.node);
        System.out.println(result);
    }

}
