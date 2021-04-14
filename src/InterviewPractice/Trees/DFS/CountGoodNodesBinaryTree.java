package InterviewPractice.Trees.DFS;

import InterviewPractice.Trees.TreeNode;

public class CountGoodNodesBinaryTree {
    TreeNode node;
    static int goodNode = 0;
    public static int goodNodes(TreeNode root) {
        findGoodNode(root,root.val);
        return goodNode;
    }

    public static void findGoodNode(TreeNode node,int maxTillNow){
        if(node != null){
            if(node.val >= maxTillNow){
                goodNode+=1;
                maxTillNow = node.val;
            }
            findGoodNode(node.left,maxTillNow);
            findGoodNode(node.right,maxTillNow);
        }
    }

    public static void main(String[] args) {
        CountGoodNodesBinaryTree tree = new CountGoodNodesBinaryTree();
        tree.node = new TreeNode(3);
        tree.node.left = new TreeNode(1);
        tree.node.right = new TreeNode(4);
        tree.node.right.right = new TreeNode(5);
        tree.node.left.left = new TreeNode(3);
        tree.node.right.left = new TreeNode(1);
        System.out.println(goodNodes(tree.node));
    }
}
