package Bootcamp.Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AllNodesDistanceKBinaryTree {
    TreeNode node;
    static Map<TreeNode, Integer> map = new HashMap<>();
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<>();
        find(root, target);
        dfs(root, target, K, map.get(root), res);
        return res;
    }

    // find target node first and store the distance in that path that we could use it later directly
    private static int find(TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = find(root.left, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }
        int right = find(root.right, target);
        if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }

    private static void dfs(TreeNode root, TreeNode target, int K, int length, List<Integer> res) {
        if (root == null) return;
        if (map.containsKey(root)) length = map.get(root);
        if (length == K) res.add(root.val);
        dfs(root.left, target, K, length + 1, res);
        dfs(root.right, target, K, length + 1, res);
    }

    public static void main(String[] args) {
        AllNodesDistanceKBinaryTree tree = new AllNodesDistanceKBinaryTree();
        tree.node = new TreeNode(3);
        tree.node.left = new TreeNode(5);
        tree.node.right = new TreeNode(1);
        tree.node.left.left = new TreeNode(6);
        tree.node.left.right = new TreeNode(2);
        tree.node.left.right.left = new TreeNode(7);
        tree.node.left.right.right = new TreeNode(4);
        tree.node.right.left = new TreeNode(0);
        tree.node.right.right = new TreeNode(8);
        List<Integer> result = distanceK(tree.node,tree.node.left,2);
        System.out.println(result);
    }
}
