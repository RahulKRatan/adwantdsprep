package Bootcamp.Trees;

public class BalancedBSTFromSortedArray {
    static TreeNode1 build_balanced_bst(int[] a)
    {
        return balancedBST(a,0,a.length-1);
    }

    static TreeNode1 balancedBST(int[] a, int start, int end){
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode1 node = new TreeNode1(a[mid]);
        node.left_ptr = balancedBST(a,start,mid-1);
        node.right_ptr = balancedBST(a,mid+1,end);
        return node;
    }

    public static void main(String[] args) {
       int[] a = new int[]{8,10 ,12, 15, 16, 20, 25};
       TreeNode1 result = build_balanced_bst(a);
       System.out.println(result.val);
    }
}


class TreeNode1
{
    int val;
    TreeNode1 left_ptr;
    TreeNode1 right_ptr;

    TreeNode1(int _val)
    {
        val = _val;
        left_ptr = null;
        right_ptr = null;
    }
};