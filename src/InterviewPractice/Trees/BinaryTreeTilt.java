package InterviewPractice.Trees;

/**
 * Time and Space - O(N)
 */


public class BinaryTreeTilt {
    TreeNode node;
    static int result = 0;
    public static int findTilt(TreeNode root) {
        helper(root);
        return result;
    }

    public static int helper(TreeNode root){
        if(root == null) return 0;
        int leftSum=0;
        int rightSum=0;
        if(root.left != null){
            leftSum = helper(root.left);
        }
        if(root.right != null){
            rightSum = helper(root.right);
        }
        int tilt = Math.abs(leftSum - rightSum);
        result += tilt;
        return root.val + leftSum + rightSum; //left_sum+right_sum_+node.val is to compute the sum of nodes of a branch. Without knowing the sum of nodes of left and right branch, we cannot compute the tilt for the current root node.
    }


    public static void main(String[] args) {
        BinaryTreeTilt tree = new BinaryTreeTilt();
        tree.node = new TreeNode(4);
        tree.node.left = new TreeNode(2);
        tree.node.right = new TreeNode(9);
        tree.node.left.left = new TreeNode(3);
        tree.node.left.right = new TreeNode(5);
        tree.node.right.right = new TreeNode(7);
        System.out.println(findTilt(tree.node));
    }
}
