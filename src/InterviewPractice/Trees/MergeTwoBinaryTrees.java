package InterviewPractice.Trees;

public class MergeTwoBinaryTrees {
    TreeNode node1;
    TreeNode node2;
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null)
            return t2;
        if(t2 == null)
            return t1;
        TreeNode result = new TreeNode(t1.val+t2.val);
        result.left = mergeTrees(t1.left,t2.left);
        result.right = mergeTrees(t1.right,t2.right);
        return result;
    }

    public static void main(String[] args) {
        MergeTwoBinaryTrees trees = new MergeTwoBinaryTrees();
        trees.node1 = new TreeNode(1);
        trees.node1.left = new TreeNode(3);
        trees.node1.right = new TreeNode(2);
        trees.node1.left.left = new TreeNode(5);
        trees.node2 = new TreeNode(2);
        trees.node2.left = new TreeNode(1);
        trees.node2.right = new TreeNode(3);
        trees.node2.right.right = new TreeNode(7);
        trees.node2.left.right = new TreeNode(4);
        TreeNode result = mergeTrees(trees.node1,trees.node2);
        System.out.println(result.val);
    }

}
