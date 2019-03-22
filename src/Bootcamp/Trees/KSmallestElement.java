package Bootcamp.Trees;

public class KSmallestElement {


    public static void main(String[] args) {
        KSmallestElement tree = new KSmallestElement();

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