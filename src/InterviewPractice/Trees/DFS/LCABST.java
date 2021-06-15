package InterviewPractice.Trees.DFS;

import InterviewPractice.Trees.TreeNode;

/**
 * Time Complexity: O(N), where N is the number of nodes in the BST. In the worst case we might be visiting all the nodes of the BST.
 *
 * Space Complexity: O(N). This is because the maximum amount of space utilized by the recursion stack would be NN since the height of a skewed BST could be NN.
 */
public class LCABST {
    TreeNode node;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parent = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if(pVal > parent && qVal > parent){
            return lowestCommonAncestor(root.right,p,q);
        }else if(pVal < parent && qVal < parent){
            return lowestCommonAncestor(root.left,p,q);
        }else {
            return root;
        }
    }

    /* Iterative
    
    Time Complexity : O(N)
    Space Complexity : O(1)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        // Start from the root node of the tree
        TreeNode node = root;

        // Traverse the tree
        while (node != null) {

            // Value of ancestor/parent node.
            int parentVal = node.val;

            if (pVal > parentVal && qVal > parentVal) {
                // If both p and q are greater than parent
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                // If both p and q are lesser than parent
                node = node.left;
            } else {
                // We have found the split point, i.e. the LCA node.
                return node;
            }
        }
        return null;
    }
}
     */
    public static void main(String[] args) {
        LCABST tree = new LCABST();
        tree.node = new TreeNode(6);
        tree.node.left = new TreeNode(2);
        tree.node.right = new TreeNode(8);
        tree.node.left.left = new TreeNode(0);
        tree.node.left.right = new TreeNode(4);
        tree.node.left.right.left = new TreeNode(3);
        tree.node.left.right.right = new TreeNode(5);
        tree.node.right.left = new TreeNode(7);
        tree.node.right.right = new TreeNode(9);
        System.out.println(lowestCommonAncestor(tree.node, tree.node.left.left, tree.node.right.left));
    }
}
