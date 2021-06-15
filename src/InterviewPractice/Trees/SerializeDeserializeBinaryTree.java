package InterviewPractice.Trees;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// same solution for Serialize and deserialize for BST
// Time and space complexity is O(N)
public class SerializeDeserializeBinaryTree {
    TreeNode node;
    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    //Preorder traversal to covert tree into string
    private static void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }
    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }
    //preorder traversal to construct tree from string
    private static TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

    public static void main(String[] args) {
        SerializeDeserializeBinaryTree tree = new SerializeDeserializeBinaryTree();
        tree.node = new TreeNode(1);
        tree.node.left = new TreeNode(2);
        tree.node.right = new TreeNode(5);
        tree.node.left.left = new TreeNode(3);
        tree.node.left.right = new TreeNode(4);
        System.out.println(serialize(tree.node));
        TreeNode result = deserialize(serialize(tree.node));
        System.out.println(result);
    }

}
