package Bootcamp.Trees;


/**
 * For each node there can be four ways that the max path goes through the node:
 * 1. Node only
 * 2. Max path through Left Child + Node
 * 3. Max path through Right Child + Node
 * 4. Max path through Left Child + Node + Max path through Right Child
 *
 * The idea is to keep trace of four paths and pick up the max one in the end.
 * An important thing to note is, root of every subtree need to return maximum path sum such that at most one child of root is involved.
 * This is needed for parent function call. In below code, this sum is stored in ‘max_single’ and returned by the recursive function.
 */
public class BinaryTreeMaximumPathSum {
    TreeNode node;
    static int res=Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        // Compute and return result
        findMaxUtil(root);
        return res;
    }

    public static int findMaxUtil(TreeNode node)
    {
        // Base Case
        if (node == null)
            return 0;

        // max sum on the left and right sub-trees of node
        int left_gain = Math.max(findMaxUtil(node.left), 0);
        int right_gain = Math.max(findMaxUtil(node.right), 0);

        // the price to start a new path where `node` is a highest node
        int price_newpath = node.val + left_gain + right_gain;

        // update max_sum if it's better to start a new path
        res = Math.max(res, price_newpath);

        // for recursion :
        // return the max gain if continue the same path
        return node.val + Math.max(left_gain, right_gain);
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum tree = new BinaryTreeMaximumPathSum();
        tree.node = new TreeNode(-10);
        tree.node.left = new TreeNode(9);
        tree.node.right = new TreeNode(20);
        tree.node.right.left = new TreeNode(15);
        tree.node.right.right = new TreeNode(7);
        System.out.println(maxPathSum(tree.node));
    }

}
