package Bootcamp.Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VerticalOrderTraversalBinaryTree {
    TreeNode root;

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Location> locations = new ArrayList<>();
        dfs(root, 0, 0, locations);
        Collections.sort(locations);
        return groupByVerticals(locations);
    }

    private static void dfs(TreeNode root, int x, int y, List<Location> locations) {
        if (root == null)
            return;
        locations.add(new Location(x, y, root.val));
        dfs(root.left, x - 1, y + 1, locations); // left child
        dfs(root.right, x + 1, y + 1, locations); // right child
    }

    private static List<List<Integer>> groupByVerticals(List<Location> locations) {
        List<List<Integer>> vot = new ArrayList<>();
        vot.add(new ArrayList<>());
        int prev = locations.get(0).x;
        for (Location loc : locations) {
            if (loc.x != prev) {
                prev = loc.x;
                vot.add(new ArrayList<>());
            }
            vot.get(vot.size() - 1).add(loc.val);
        }
        return vot;
    }

    static class Location implements Comparable<Location> {
        int x;
        int y;
        int val;
        Location(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Location that) {
            if (this.x != that.x) // left to right, x increases
                return Integer.compare(this.x, that.x);
            if (this.y != that.y) // top to bottom, y increases
                return Integer.compare(this.y, that.y);
            return Integer.compare(this.val, that.val);
        }
    }


    public static void main(String[] args) {
        VerticalOrderTraversalBinaryTree tree = new VerticalOrderTraversalBinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(4);
        verticalTraversal(tree.root);
    }
}


