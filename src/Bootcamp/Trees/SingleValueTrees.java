package Bootcamp.Trees;

public class SingleValueTrees {
    TreeNode root;
    int count = 0;
    boolean  countSingleRec(TreeNode node, int c)
    {
        // Return false to indicate NULL
        if (node == null)
            return true;

        // Recursively count in left and right subtrees also
        boolean left = countSingleRec(node.left, c);
        boolean right = countSingleRec(node.right, c);

        // If any of the subtrees is not singly, then this
        // cannot be singly.
        if (left == false || right == false)
            return false;

        // If left subtree is singly and non-empty, but val
        // doesn't match
        if (node.left != null && node.val != node.left.val)
            return false;

        // Same for right subtree
        if (node.right != null && node.val != node.right.val)
            return false;

        // If none of the above conditions is true, then
        // tree rooted under root is single valued, increment
        // count and return true.
        count++;
        return true;
    }

    // This function mainly calls countSingleRec()
    // after initializing count as 0
    int countSingle()
    {
        return countSingle(root);
    }

    int countSingle(TreeNode node)
    {
        // Recursive function to count
        countSingleRec(node, count);
        return count;
    }

    public static void main(String[] args) {
        SingleValueTrees tree = new SingleValueTrees();
        tree.root = new TreeNode(2);
        tree.root.left = new TreeNode(1);
        tree.root.right = new TreeNode(3);
        System.out.println("The count of single valued sub trees is : "
                + tree.countSingle());
    }
}



