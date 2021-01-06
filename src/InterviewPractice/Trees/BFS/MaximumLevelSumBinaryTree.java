package InterviewPractice.Trees.BFS;

import InterviewPractice.Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 *
 * Return the smallest level X such that the sum of all the values of nodes at level X is maximal.
 */
public class MaximumLevelSumBinaryTree {
    //Use BFS to find the sum of each level, then locate the level with largest sum.
    public int maxLevelSum(TreeNode root) {
        int max = Integer.MIN_VALUE, maxLevel = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for (int level = 1; !q.isEmpty(); ++level) {
            int sum = 0;
            for (int sz = q.size(); sz > 0; --sz) {
                TreeNode n = q.poll();
                sum += n.val;
                if (n.left != null) {
                    q.offer(n.left);
                }
                if (n.right != null) {
                    q.offer(n.right);
                }
            }
            if (max < sum) {
                max = sum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }

    /*
    Method 2: DFS
        Use DFS to compute and store the sum of each level in an ArrayList, then locate the level with largest sum.
        Recurse down from root, level of which is 0, increase level by 1 for each recursion down;
        Use the level as the index of an ArrayList to store the sum of the correspoinding level;
        Find the index of the max sum, then plus 1.

      public int maxLevelSum(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, 0);
        int maxLevel = 0;
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(maxLevel) < list.get(i)) {
                maxLevel = i;
            }
        }
        return maxLevel + 1;
    }
    private void dfs(TreeNode n, List<Integer> l, int level) {
        if (n == null) { return; }
        if (l.size() == level) { l.add(n.val); } // never reach this level before, add first value.
        else { l.set(level, l.get(level) + n.val); } // reached the level before, accumulate current value to old value.
        dfs(n.left, l, level + 1);
        dfs(n.right, l, level + 1);
    }
     */
}
