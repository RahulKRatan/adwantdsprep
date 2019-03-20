package Bootcamp.Trees;



public class LCABinaryTree {
     Node3 root;

     int findLCA(Node3 n1, Node3 n2)
    {
        return lca(root, n1, n2);
    }

     int lca(Node3 head, Node3 a, Node3 b)
    {
        if(head == null)
            return -1;

        if(head == a || head == b){
            return head.data;
        }

        int left = lca(head.left,a,b);
        int right = lca(head.right,a,b);

        if(left != -1 &&right!=-1){
            return head.data;
        }else if(left==-1&&right==-1){
            return -1;
        }else{
            return left==-1?right:left;
        }
    }

    public static void main(String[] args) {
        LCABinaryTree tree = new LCABinaryTree();
        tree.root = new Node3(1);
        tree.root.left = new Node3(2);
        tree.root.right = new Node3(3);
        tree.root.left.left = new Node3(4);
        tree.root.left.right = new Node3(5);
        tree.root.right.right = new Node3(6);
        tree.root.right.left = new Node3(7);
        System.out.println(tree.findLCA(tree.root.left.left,tree.root.left.right));
    }

}


class Node3{
    int data;
    Node3 left;
    Node3 right;
    public Node3(int item)
    {
        data = item;
        left = right = null;
    }
}