package Bootcamp.Trees.Traversals;

import Bootcamp.Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 Algorithm:
 There are basically two functions in this method. One is to print all nodes at a given level (printGivenLevel), and other is to print level order traversal of the tree (printLevelorder). printLevelorder makes use of printGivenLevel to print nodes at all levels one by one starting from root.

 /*Function to print level order traversal of tree
      printLevelorder(tree)
      for d = 1 to height(tree)
        printGivenLevel(tree, d);
 */
 /*Function to print all nodes at a given level
    printGivenLevel(tree, level)
      if tree is NULL then return;
      if level is 1, then
          print(tree->data);
      else if level greater than 1, then
        printGivenLevel(tree->left, level-1);
        printGivenLevel(tree->right, level-1);
 */
public class BFSTreeTraversal {
    // Root of the Binary Tree


    TreeNode root;

    public BFSTreeTraversal()
    {
        root = null;
    }

    /* function to print level order traversal of tree*/
    void printLevelOrder()
    {
        List<Integer> result = new ArrayList<>();

        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);
    }

    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node. Time complexity of height is O(N) */
    int height(TreeNode root)
    {
        if (root == null)
            return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1);
        }
    }

    /* Print nodes at the given level */
    void printGivenLevel (TreeNode root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.val + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        BFSTreeTraversal tree = new BFSTreeTraversal();
        tree.root= new TreeNode(1);
        tree.root.left= new TreeNode(2);
        tree.root.right= new TreeNode(3);
        tree.root.left.left= new TreeNode(4);
        tree.root.left.right= new TreeNode(5);

        System.out.println("Level order traversal/ BFS of binary tree is ");
        tree.printLevelOrder();
    }
}


/* Given a binary tree. Print its nodes in level order
     using array for implementing queue

void printLevelOrder()
{
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    while (!queue.isEmpty())
    {
        Node tempNode = queue.poll();
        System.out.print(tempNode.data + " ");

        Enqueue left child
        if (tempNode.left != null) {
            queue.add(tempNode.left);
        }

        /*Enqueue right child
        if (tempNode.right != null) {
            queue.add(tempNode.right);
        }
    }
}
 */
