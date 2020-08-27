package InterviewPractice.Trees;

public class PrintAllPaths {
    TreeNode root;
    void printPaths(TreeNode node)
    {
        int path[] = new int[1000];
        printPathsRecur(node, path, 0);
    }
    void printPathsRecur(TreeNode node, int path[], int pathLen)
    {
        if (node == null)
            return;

        /* append this node to the path array */
        path[pathLen] = node.val;
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
        tree.root = new TreeNode(2);
        tree.root.left = new TreeNode(1);
        tree.root.right = new TreeNode(3);
        tree.printPaths(tree.root);
    }


}
