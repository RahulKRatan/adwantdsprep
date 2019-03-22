package Bootcamp.Trees;



public class LCABinaryTree {
     TreeNode root;

     int findLCA(TreeNode n1, TreeNode n2)
    {
        return lca(root, n1, n2);
    }

     int lca(TreeNode head, TreeNode a, TreeNode b)
    {
        if(head == null)
            return -1;

        if(head == a || head == b){
            return head.val;
        }

        int left = lca(head.left,a,b);
        int right = lca(head.right,a,b);

        if(left != -1 &&right!=-1){
            return head.val;
        }else if(left==-1&&right==-1){
            return -1;
        }else{
            return left==-1?right:left;
        }
    }

    public static void main(String[] args) {
        LCABinaryTree tree = new LCABinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(6);
        tree.root.right.left = new TreeNode(7);
        System.out.println(tree.findLCA(tree.root.left.left,tree.root.left.right));
    }

}
