package InterviewPractice.Trees;

public class BalancedBSTFromSortedArray {
    static TreeNode build_balanced_bst(int[] a)
    {
        return balancedBST(a,0,a.length-1);
    }

    static TreeNode balancedBST(int[] a, int start, int end){
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(a[mid]);
        node.left = balancedBST(a,start,mid-1);
        node.right = balancedBST(a,mid+1,end);
        return node;
    }

    public static void main(String[] args) {
       int[] a = new int[]{8,10 ,12, 15, 16, 20, 25};
        TreeNode result = build_balanced_bst(a);
       System.out.println(result.val);
    }
}
