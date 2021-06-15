package InterviewPractice.Trees;

import java.util.LinkedList;

/**
 * Time complexity : O(H+k), where H is a tree height. This complexity is defined by the stack, which contains at least H+k elements, since before starting to pop out one has to go down to a leaf. This results in O(logN+k) for the balanced tree
 * and O(N+k) for completely unbalanced tree with all the nodes in the left subtree.
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

/*
Time complexity : O(N) to build a traversal.
Space complexity : O(N) to keep an inorder traversal.

class Solution {
  public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
    if (root == null) return arr;
    inorder(root.left, arr);
    arr.add(root.val);
    inorder(root.right, arr);
    return arr;
  }

  public int kthSmallest(TreeNode root, int k) {
    ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
    return nums.get(k - 1);
  }
}
 */

    public static void main(String[] args) {
        KSmallestElement tree = new KSmallestElement();
        tree.root = new TreeNode(5);
        tree.root.left = new TreeNode(3);
        tree.root.left.left = new TreeNode(2);
        tree.root.left.right = new TreeNode(4);
        tree.root.right = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        System.out.println(kth_smallest_element(tree.root,3));
    }
}
