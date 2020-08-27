package InterviewPractice.Trees;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Pick the first preorder element as a root root = new TreeNode(preorder[0]) and push it into stack.
 *
 * Use for loop to iterate along the elements of preorder array :
 *
 * Pick the last element of the stack as a parent node, and the the current element of preorder as a child node.
 *
 * Adjust the parent node : pop out of stack all elements with the value smaller than the child value. Change the parent node at each pop node = stack.pop().
 *
 * If node.val < child.val - put the child as a right child of the node : node.right = child.
 *
 * Else - as a left child : node.left = child.
 *
 * Push child node into the stack.
 *
 * Return root.
 */
public class ConstructBSTfromPreorderTraversal {

    public static TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        if (n == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);

        for (int i = 1; i < n; i++) {
            // take the last element of the deque as a parent
            // and create a child from the next preorder element
            TreeNode node = deque.peek();
            TreeNode child = new TreeNode(preorder[i]);
            // adjust the parent
            while (!deque.isEmpty() && deque.peek().val < child.val)
                node = deque.pop();

            // follow BST logic to create a parent-child link
            if (node.val < child.val) node.right = child;
            else node.left = child;
            // add the child into deque
            deque.push(child);
        }
        return root;
    }

}
