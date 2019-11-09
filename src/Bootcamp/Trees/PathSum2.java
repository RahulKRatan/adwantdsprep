package Bootcamp.Trees;

import java.util.LinkedList;
import java.util.List;

public class PathSum2 {
    TreeNode root;
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result  = new LinkedList<>();
        List<Integer> num  = new LinkedList<>();
        pathSum(root,sum,num,result);
        return result;
    }

    public static void pathSum(TreeNode root, int sum, List<Integer> num,
                        List<List<Integer>> result) {

        if (root == null)
            return;
        num.add(new Integer(root.val));
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new LinkedList(num));
            num.remove(num.size() - 1);//don't forget to remove the last integer
            return;
        } else {
            pathSum(root.left, sum - root.val, num, result);
            pathSum(root.right, sum - root.val, num, result);
        }
        num.remove(num.size() - 1);
    }

    public static void main(String[] args) {
        PathSum2 tree = new PathSum2();
        tree.root = new TreeNode(5);
        tree.root.left = new TreeNode(4);
        tree.root.right = new TreeNode(8);
        tree.root.left.left = new TreeNode(11);
        tree.root.left.left.left = new TreeNode(7);
        tree.root.left.left.right = new TreeNode(2);
        tree.root.right.left = new TreeNode(13);
        tree.root.right.right = new TreeNode(4);
        tree.root.right.right.right = new TreeNode(1);
        List<List<Integer>> temp = pathSum(tree.root,22);
        System.out.println(temp);
    }
}
