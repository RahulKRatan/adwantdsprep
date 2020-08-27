package InterviewPractice.Trees;


/**
 *  Time complexity : O(N)
 */
public class LargestBSTSubtree {
    static int max = 0;
    TreeNode node;

    static class Result {  // (size, rangeLower, rangeUpper) -- size of current tree, range of current tree [rangeLower, rangeUpper]
        int size;
        int lower;
        int upper;

        Result(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }

    public static int largestBSTSubtree(TreeNode root) {
        if (root == null) { return 0; }
        traverse(root);
        return max;
    }

    private static Result traverse(TreeNode root) {
        if (root == null) { return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE); }
        Result left = traverse(root.left);
        Result right = traverse(root.right);
        /*
        If subtree rooted at current root is not a BST, then return the larger value returned from its children, which can be positive or negative,
        depending on the subtrees rooted at it's children is BST or not. And since we are using sign to indicate if it'a a BST and it's not,
        we negate the result. And since the return value its negative, it's parent will never use the min, max information, so we just set them to zero.
         */
        if (left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower) {
            return new Result(-1, 0, 0);
        }
        int size = left.size + 1 + right.size;
        max = Math.max(size, max);
        return new Result(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
    }

/*
public class Solution {
When node==null we return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0}; since when one node is null, every parent node still can form a BST ((node.val > left[1] && node.val < right[0] this condition can be satisfied later on)

However, when a current subtree is not valid BST (else part) then we return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])}; since no parent subtree can be BST if one child subtree is not valid BST. By setting like that this condition node.val > left[1] && node.val < right[0] will never be satisfied later on
    // return array for each node:
    //     [0] --> min
    //     [1] --> max
    //     [2] --> largest BST in its subtree(inclusive)

    public int largestBSTSubtree(TreeNode root) {
        int[] ret = largestBST(root);
        return ret[2];
    }

    private int[] largestBST(TreeNode node){
        if(node == null){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] left = largestBST(node.left);
        int[] right = largestBST(node.right);
        if(node.val > left[1] && node.val < right[0]){
            return new int[]{Math.min(node.val, left[0]), Math.max(node.val, right[1]), left[2] + right[2] + 1};
        }else{
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])};
        }
    }
}
 */

    public static void main(String[] args) {
        LargestBSTSubtree tree = new LargestBSTSubtree();
        tree.node = new TreeNode(10);
        tree.node.left = new TreeNode(5);
        tree.node.right = new TreeNode(15);
        tree.node.left.left = new TreeNode(1);
        tree.node.left.right = new TreeNode(8);
        tree.node.right.right = new TreeNode(7);
        System.out.println(largestBSTSubtree(tree.node));
    }
}
