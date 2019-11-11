package Bootcamp.Trees;

import java.util.LinkedList;

/**
 * Time complexity : O(H+k), where HH is a tree height. This complexity is defined by the stack, which contains at least H+k elements, since before starting to pop out one has to go down to a leaf. This results in \mathcal{O}(\log N + k)O(logN+k) for the balanced tree and \mathcal{O}(N + k)O(N+k) for completely unbalanced tree with all the nodes in the left subtree.
 * Space complexity : O(H+k), the same as for time complexity, O(N+k) in the worst case, and O(logN+k) in the average case.
 *
 * Iterative form of inorder traversal
 *
 */
public class KSmallestElement {
    TreeNode root;
    static int kth_smallest_element(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }



    public static void main(String[] args) {
        KSmallestElement tree = new KSmallestElement();
        tree.root = new TreeNode(2);
        tree.root.left = new TreeNode(1);
        tree.root.right = new TreeNode(3);
        System.out.println(kth_smallest_element(tree.root,3));
    }
}
