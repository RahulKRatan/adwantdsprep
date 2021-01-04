package InterviewPractice.Trees.BFS;

import InterviewPractice.Trees.TreeNode;

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

    /* DFS Solution
    Everyone likes recursive DFS, so let's add it here as well. The idea is simple: to traverse the tree level by level, starting each time from the rightmost child.
    class Solution {
    List<Integer> rightside = new ArrayList();

    public void helper(TreeNode node, int level) {
        if (level == rightside.size())
            rightside.add(node.val);

        if (node.right != null)
            helper(node.right, level + 1);
        if (node.left != null)
            helper(node.left, level + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return rightside;

        helper(root, 0);
        return rightside;
    }
}
     */


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
