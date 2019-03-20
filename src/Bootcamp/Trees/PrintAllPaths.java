package Bootcamp.Trees;

public class PrintAllPaths {
    Node6 root;
    void printPaths(Node6 node)
    {
        int path[] = new int[1000];
        printPathsRecur(node, path, 0);
    }
    void printPathsRecur(Node6 node, int path[], int pathLen)
    {
        if (node == null)
            return;

        /* append this node to the path array */
        path[pathLen] = node.data;
        pathLen++;

        /* it's a leaf, so print the path that led to here */
        if (node.left == null && node.right == null)
            printArray(path, pathLen);
        else
        {
            /* otherwise try both subtrees */
            printPathsRecur(node.left, path, pathLen);
            printPathsRecur(node.right, path, pathLen);
        }
    }

    /* Utility that prints out an array on a line */
    void printArray(int ints[], int len)
    {
        int i;
        for (i = 0; i < len; i++)
            System.out.print(ints[i] + " ");
            System.out.println("");
    }
    public static void main(String[] args) {
        PrintAllPaths tree = new PrintAllPaths();
        tree.root = new Node6(2);
        tree.root.left = new Node6(1);
        tree.root.right = new Node6(3);
        tree.printPaths(tree.root);
    }


}




class Node6{
    int data;
    Node6 left;
    Node6 right;
    public Node6(int item)
    {
        data = item;
        left = right = null;
    }
}