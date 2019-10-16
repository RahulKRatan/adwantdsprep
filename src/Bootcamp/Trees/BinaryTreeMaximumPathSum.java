package Bootcamp.Trees;


/**
 *
 * Initiate max_sum as the smallest possible integer and call max_gain(node = root).
 * Implement max_gain(node) with a check to continue the old path/to start a new path:
 *      Base case : if node is null, the max gain is 0.
 *      Call max_gain recursively for the node children to compute max gain from the left and right subtrees : left_gain = max(max_gain(node.left), 0) and
 * right_gain = max(max_gain(node.right), 0).
 *      Now check to continue the old path or to start a new path. To start a new path would cost price_newpath = node.val + left_gain + right_gain. Update max_sum if it's better to start a new path.
 *      For the recursion return the max gain the node and one/zero of its subtrees could add to the current path : node.val + max(left_gain, right_gain).
 *
 * Time complexity : O(N) where N is number of nodes, since we visit each node not more than 2 times.
 * Space complexity : O(log(N)). We have to keep a recursion stack of the size of the tree height, which is O(log(N)) for the binary tree.
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
        int left = Math.max(findMaxUtil(node.left), 0);
        int right = Math.max(findMaxUtil(node.right), 0);

        // the price to start a new path where `node` is a highest node
        int price_newpath = node.val + left + right;

        // update max_sum if it's better to start a new path
        res = Math.max(res, price_newpath);

        // for recursion :
        // return the max gain if continue the same path
        return node.val + Math.max(left, right);
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
