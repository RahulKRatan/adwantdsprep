package Bootcamp.Trees;

public class IsBST {
    Node4 root;

    boolean isBST(Node4 root){
        return isBST(root,Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    boolean isBST(Node4 root,double min, double max)
    {
        if(root == null)
            return true;
        if(root.data < min || root.data > max){
            return false;
        }
        return isBST(root.left,min,root.data) && isBST(root.right,root.data,max);
    }

    public static void main(String[] args) {
        IsBST tree = new IsBST();
        tree.root = new Node4(2);
        tree.root.left = new Node4(1);
        tree.root.right = new Node4(3);
        System.out.println(tree.isBST(tree.root));
    }
}





class Node4{
    int data;
    Node4 left;
    Node4 right;
    public Node4(int item)
    {
        data = item;
        left = right = null;
    }
}