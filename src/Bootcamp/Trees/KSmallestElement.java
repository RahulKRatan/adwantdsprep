package Bootcamp.Trees;

public class KSmallestElement {
    TreeNode root;
    static int kth_smallest_element(TreeNode root, int k) {
        

        return 0;
    }



    public static void main(String[] args) {
        KSmallestElement tree = new KSmallestElement();
        tree.root = new TreeNode(2);
        tree.root.left_ptr = new TreeNode(1);
        tree.root.right_ptr = new TreeNode(3);
        System.out.println(kth_smallest_element(tree.root,3));
    }
}



class TreeNode
{
    int val;
    TreeNode left_ptr;
    TreeNode right_ptr;

    TreeNode(int _val)
    {
        val = _val;
        left_ptr = null;
        right_ptr = null;
    }
};