package Bootcamp.Trees;

public class KSmallestElement {
    TreeNode root;
    static int kth_smallest_element(TreeNode root, int k) {
        int count = countNodes(root.left_ptr);
        if(k <= count){
            return kth_smallest_element(root.left_ptr, k);
        }else if (k > count + 1) {
            return kth_smallest_element(root.right_ptr, k-1-count);
        }
        return root.val;
    }

    static int countNodes(TreeNode n) {
        if (n == null) return 0;

        return 1 + countNodes(n.left_ptr) + countNodes(n.right_ptr);
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