package InterviewPractice.Trees.BFS;

import InterviewPractice.Trees.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The idea is to use heap indexing:
 *
 *         1
 *    2         3
 *  4   5     6   7
 * 8 9 x 11  x 13 x 15
 * Regardless whether these nodes exist:
 *
 * Always make the id of left child as parent_id * 2;
 * Always make the id of right child as parent_id * 2 + 1;
 * So we can just:
 *
 * Record the id of left most node when first time at each level of the tree during an pre-order run.(you can tell by check the size of the container to hold the first nodes);
 * At each node, compare the distance from it the left most node with the current max width;
 */
public class MaximumWidthBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> bfs = new LinkedList<>();
        bfs.offer(new Pair(root, 1));
        int max = 0;
        while (!bfs.isEmpty()) {
            int l = bfs.peek().getValue(), r = l, size = bfs.size();
            while (size-- > 0) {
                TreeNode node = bfs.peek().getKey();
                r = bfs.poll().getValue();
                if (node.left !=null) bfs.offer(new Pair(node.left, r*2));
                if (node.right !=null) bfs.offer(new Pair(node.right, r*2+1));
            }
            max = Math.max(max, r-l+1);
        }
        return max;
    }
}
/* DFS Solution

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> lefts = new ArrayList<Integer>(); // left most nodes at each level;
        int[] res = new int[1]; // max width
        dfs(root, 1, 0, lefts, res);
        return res[0];
    }
    private void dfs(TreeNode node, int id, int depth, List<Integer> lefts, int[] res) {
        if (node == null) return;
        if (depth >= lefts.size()) lefts.add(id);   // add left most node
        res[0] = Integer.max(res[0], id + 1 - lefts.get(depth));
        dfs(node.left,  id * 2,     depth + 1, lefts, res);
        dfs(node.right, id * 2 + 1, depth + 1, lefts, res);
    }
}
 */