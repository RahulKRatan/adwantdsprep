package Bootcamp.Trees;

import java.util.*;

public class VerticalOrderTraversalBinaryTree {
    TreeNode root;
    static class TempNode {
        int hd; // horizontal distance
        TreeNode root;
        public TempNode(int hd, TreeNode root) {
            this.hd = hd;
            this.root = root;
        }
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int minHd = Integer.MAX_VALUE; // need to maintain this so we know length of horizontal distance and whats its min and max to loop and retrieve
        int maxHd = Integer.MIN_VALUE;

        Queue<TempNode> q = new LinkedList<>();
        q.offer(new TempNode(0, root));
        while (!q.isEmpty()) {
            TempNode cur = q.poll();
            TreeNode node = cur.root;
            int hd = cur.hd;
            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(node.val);
            minHd = Math.min(minHd, hd);
            maxHd = Math.max(maxHd, hd);

            if (node.left != null) {
                q.offer(new TempNode(hd - 1, node.left));
            }

            if (node.right != null) {
                q.offer(new TempNode(hd + 1, node.right));
            }
        }

        for (int i = minHd; i <= maxHd; i++) {
            res.add(map.get(i));
        }

        return res;

    }





    public static void main(String[] args) {
        VerticalOrderTraversalBinaryTree tree = new VerticalOrderTraversalBinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(4);
        List<List<Integer>> result =verticalTraversal(tree.root);
        System.out.println(result);
    }
}


