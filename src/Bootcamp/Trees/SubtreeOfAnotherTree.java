package Bootcamp.Trees;


//For each node during pre-order traversal of s, use a recursive function isSame to validate if sub-tree started with this node is the same with t.
public class SubtreeOfAnotherTree {
    TreeNode node1;
    TreeNode node2;

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    private static boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val != t.val) return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    public static void main(String[] args) {
        SubtreeOfAnotherTree tree = new SubtreeOfAnotherTree();
        tree.node1 = new TreeNode(3);
        tree.node1.left = new TreeNode(4);
        tree.node1.right = new TreeNode(5);
        tree.node1.left.left = new TreeNode(1);
        tree.node1.left.right = new TreeNode(2);

        tree.node2 = new TreeNode(4);
        tree.node2.left = new TreeNode(1);
        tree.node2.right = new TreeNode(2);
        System.out.println(isSubtree(tree.node1,tree.node2));
    }
}
