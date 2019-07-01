package Bootcamp.Trees.Traversals;

import java.util.HashMap;

/**
 * Java program to print Postorder traversal from
 * given Inorder and Preorder traversals.
 * Time complexity: O(n)
 */

public class PostorderGivenInorderPreorder {

        static int preIndex = 0;
        void printPost(int[] in, int[] pre, int inStrt,
                       int inEnd, HashMap<Integer, Integer> hm)
        {
            if (inStrt > inEnd)
                return;

            // Find index of next item in preorder traversal in
            // inorder.
            int inIndex = hm.get(pre[preIndex++]);

            // traverse left tree
            printPost(in, pre, inStrt, inIndex - 1, hm);

            // traverse right tree
            printPost(in, pre, inIndex + 1, inEnd, hm);

            // print root node at the end of traversal
            System.out.print(in[inIndex] + " ");
        }

        void printPostMain(int[] in, int[] pre)
        {
            int n = pre.length;
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int i=0; i<n; i++)
                hm.put(in[i], i);

            printPost(in, pre, 0, n-1, hm);
        }

        // Driver code
        public static void main(String ars[])
        {
            int in[] = { 4, 2, 5, 1, 3, 6 };
            int pre[] = { 1, 2, 4, 5, 3, 6 };
            PostorderGivenInorderPreorder tree = new PostorderGivenInorderPreorder();
            tree.printPostMain(in, pre);
        }

}
