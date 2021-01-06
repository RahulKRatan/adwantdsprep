package InterviewPractice.Trees.BFS;

import InterviewPractice.Trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 */
public class FindLargestValueEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> values = new ArrayList<Integer>();

        if(root != null) q.offer(root);

        while(!q.isEmpty()) {
            int max = Integer.MIN_VALUE, n = q.size();
            for(int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            values.add(max);
        }

        return values;
    }

    /*
        DFS Solution - Just a simple pre-order traverse idea. Use depth to expand result list size and put the max value in the appropriate position.
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }
      private void helper(TreeNode root, List<Integer> res, int d){
        if(root == null){
            return;
        }
       //expand list size
        if(d == res.size()){
            res.add(root.val);
        }
        else{
        //or set value
            res.set(d, Math.max(res.get(d), root.val));
        }
        helper(root.left, res, d+1);
        helper(root.right, res, d+1);
    }
     */
}
