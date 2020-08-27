package InterviewPractice.Trees;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    TreeNode root;
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result  = new ArrayList<>();
        List<Integer> num  = new ArrayList<>();
        pathSum(root,sum,num,result);
        return result;
    }

    public static void pathSum(TreeNode root, int sum, List<Integer> num,
                        List<List<Integer>> result) {

        if (root == null)
            return;
        num.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            // The thing is, you have to new a new list using values from currentResult then add it up to the nested list!!!!
            // You would have nothing if you just add currentResult to the result because you just add a reference by doing this however we remove every last item along exiting the recursion,
            // which means currentResult is always empty in the end.
            result.add(new ArrayList(num));
        } else {
            pathSum(root.left, sum - root.val, num, result);
            pathSum(root.right, sum - root.val, num, result);
        }
        //This is the backtracking point. If we execute two sub recursive code in else branch and still can't get a match pathSum,
        // this means the current "root" which already added into the List currentResult can not lead us to the correct answer.
        // So we need to remove it from List currentResult and try other possible branches, this is what backtracking means.
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
