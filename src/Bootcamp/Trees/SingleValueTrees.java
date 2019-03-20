package Bootcamp.Trees;

public class SingleValueTrees {
    Node5 root;
    Count ct = new Count();
    boolean  countSingleRec(Node5 node, Count c)
    {
        // Return false to indicate NULL
        if (node == null)
            return true;

        // Recursively count in left and right subtrees also
        boolean left = countSingleRec(node.left, c);
        boolean right = countSingleRec(node.right, c);

        // If any of the subtrees is not singly, then this
        // cannot be singly.
        if (left == false || right == false)
            return false;

        // If left subtree is singly and non-empty, but data
        // doesn't match
        if (node.left != null && node.data != node.left.data)
            return false;

        // Same for right subtree
        if (node.right != null && node.data != node.right.data)
            return false;

        // If none of the above conditions is true, then
        // tree rooted under root is single valued, increment
        // count and return true.
        c.count++;
        return true;
    }

    // This function mainly calls countSingleRec()
    // after initializing count as 0
    int countSingle()
    {
        return countSingle(root);
    }

    int countSingle(Node5 node)
    {
        // Recursive function to count
        countSingleRec(node, ct);
        return ct.count;
    }



    public static void main(String[] args) {
        SingleValueTrees tree = new SingleValueTrees();
        tree.root = new Node5(2);
        tree.root.left = new Node5(1);
        tree.root.right = new Node5(3);
        System.out.println("The count of single valued sub trees is : "
                + tree.countSingle());
    }
}

class Count
{
    int count = 0;
}

class Node5{
    int data;
    Node5 left;
    Node5 right;
    public Node5(int item)
    {
        data = item;
        left = right = null;
    }
}


