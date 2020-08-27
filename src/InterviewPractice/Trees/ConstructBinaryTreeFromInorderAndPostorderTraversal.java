package InterviewPractice.Trees;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i=0;i<inorder.length;++i)
            hm.put(inorder[i], i);
        return buildTreePostIn(0, inorder.length-1, postorder, 0, postorder.length-1,hm);
    }

    private static TreeNode buildTreePostIn(int inStart, int inEnd, int[] postOrder, int poStart, int peEnd, HashMap<Integer,Integer> hm){
        if (poStart>peEnd || inStart>inEnd) return null;
        TreeNode root = new TreeNode(postOrder[peEnd]);
        int rootIndex = hm.get(postOrder[peEnd]);
        //while from in order we can get the number of children in the left subtree ie. rootIndex-inStart
        root.left = buildTreePostIn( inStart, rootIndex-1, postOrder, poStart, poStart+rootIndex-inStart-1, hm);
        root.right = buildTreePostIn(rootIndex+1, inEnd, postOrder, poStart+rootIndex-inStart, peEnd-1, hm);
        return root;
    }

    public static void main(String[] args) {
        int[] postorder = new int[]{9,15,7,20,3};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode result = buildTree(inorder,postorder);
        System.out.println(result);
    }
}
