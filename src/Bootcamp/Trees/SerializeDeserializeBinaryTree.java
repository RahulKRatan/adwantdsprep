package Bootcamp.Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// same solution for Serialize and deserialize for BST
// Time and space complexity is O(N)
public class SerializeDeserializeBinaryTree {
    TreeNode node;
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        return serializeTree(root,"");
    }
    // Preorder traversal - DFS
    public static String serializeTree(TreeNode root, String s){
        if(root == null){
            s = s + "null,";
        } else {
            s = s+String.valueOf(root.val) + ",";
            s = serializeTree(root.left,s);
            s = serializeTree(root.right,s);
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(strings));
        return rDeserialize(list);
    }

    public static TreeNode rDeserialize(List<String> list){
    if(list.get(0).equals("null")){
        list.remove(0);
        return null;
    }
    TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
    list.remove(0);
    root.left = rDeserialize(list);
    root.right = rDeserialize(list);
    return root;
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
