package InterviewPractice.Trees;


/**
 *
 * Time complexity : O(logN). During the algorithm execution we go down the tree all the time - on the left or on the right, first to search the node to delete (\mathcal{O}(H_1)O(H
 *  ) time complexity as already discussed) and then to actually delete it.
 *   is a tree height from the root to the node to delete. Delete process takes \mathcal{O}(H2)
 *   is a tree height from the root to delete to the leafs. That in total results in \mathcal{O}(H_1 + H_2) = \mathcal{O}(H)O(H
 * time complexity, where HH is a tree height, equal to \log NlogN in the case of the balanced tree.
 * Space complexity : O(H) to keep the recursion stack, where HH is a tree height. H = \log NH=logN for the balanced tree.
 *
 * Algorithm
 *
 * If key > root.val then delete the node to delete is in the right subtree root.right = deleteNode(root.right, key).
 * If key < root.val then delete the node to delete is in the left subtree root.left = deleteNode(root.left, key).
 * If key == root.val then the node to delete is right here. Let's do it :
 * If the node is a leaf, the delete process is straightforward : root = null.
 * If the node is not a leaf and has the right child, then replace the node value by a successor value root.val = successor.val, and then recursively delete the successor in the right subtree root.right = deleteNode(root.right, root.val).
 * If the node is not a leaf and has only the left child, then replace the node value by a predecessor value root.val = predecessor.val, and then recursively delete the predecessor in the left subtree root.left = deleteNode(root.left, root.val).
 * Return root.
 */
public class DeleteNodeBST {
    TreeNode node;
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // delete from the right subtree
        if (key > root.val) root.right = deleteNode(root.right, key);
            // delete from the left subtree
        else if (key < root.val) root.left = deleteNode(root.left, key);
            // delete the current node
        else {
            // the node is a leaf
            if (root.left == null && root.right == null) root = null;
                // the node is not a leaf and has a right child
            else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
            // the node is not a leaf, has no right child, and has a left child
            else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    /*
        One step right and then always left
    */
    public static int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

    /*
        One step left and then always right
    */
    public static int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }


    public static void main(String[] args) {
    DeleteNodeBST tree = new DeleteNodeBST();
        tree.node = new TreeNode(5);
        tree.node.left = new TreeNode(3);
        tree.node.right = new TreeNode(6);
        tree.node.left.left = new TreeNode(2);
        tree.node.left.right = new TreeNode(4);
        tree.node.right.right = new TreeNode(7);
        TreeNode result = deleteNode(tree.node,3);
        System.out.println(result);
    }
}
