package Bootcamp.Trees;

/**
 * Time complexity : we visit each node exactly once, thus the time complexity is O(N), where N is the number of nodes.
 * Space complexity : in the worst case, the tree is completely unbalanced, e.g. each node has only one child node, the recursion call would occur N times (the height of the tree),
 * therefore the storage to keep the call stack would be O(N). But in the best case (the tree is completely balanced),
 * the height of the tree would be log(N). Therefore, the space complexity in this case would be O(log(N)).
 */
public class PathSum {
    TreeNode root;
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        sum = sum - root.val;
        if ((root.left == null) && (root.right == null)) return (sum == 0);
        return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);
    }


    public static void main(String[] args) {
        PathSum tree = new PathSum();
        tree.root = new TreeNode(5);
        tree.root.left = new TreeNode(4);
        tree.root.right = new TreeNode(8);
        tree.root.left.left = new TreeNode(11);
        tree.root.left.left.left = new TreeNode(7);
        tree.root.left.left.right = new TreeNode(2);
        tree.root.right.left = new TreeNode(13);
        tree.root.right.right = new TreeNode(4);
        tree.root.right.right.right = new TreeNode(1);
        System.out.println(hasPathSum(tree.root,22));
    }
}
