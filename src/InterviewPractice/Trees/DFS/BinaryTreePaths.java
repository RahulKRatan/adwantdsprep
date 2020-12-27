package InterviewPractice.Trees.DFS;

import InterviewPractice.Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * The time complexity for the problem should be O(n), since we are basically visiting each node in the tree.
 * Yet an interviewer might ask you for further optimization when he or she saw a string concatenation. A string concatenation is just too costly.
 * A StringBuilder can be used although a bit tricky since it is not immutable like string is.
 *
 * When using StringBuilder, We can just keep track of the length of the StringBuilder before we append anything to it before recursion and afterwards set the length back.
 * Another trick is when to append the "->", since we don't need the last arrow at the end of the string, we only append it before recurse to the next level of the tree. Hope the solution helps!
 *
 * String Builder solution if anyone is interested. Its important to note that since StringBuilder is an object, once it reaches the end,
 * it will not revert as we percolate up the recursive stack (it will if we used a String instead of StringBuilder). We must save the current iteration of the string during each recursive stack.
 *
 */
public class BinaryTreePaths {
    TreeNode node;
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        helper(root,result,new StringBuilder());
        return result;
    }

    public static void helper(TreeNode root,List<String> result,StringBuilder path){
        if(root == null){
            return;
        }
        int len = path.length();
        path.append(root.val);

        if(root.left == null && root.right == null){
            result.add(path.toString());
        }
        else {
            path.append("->");
            helper(root.left, result, path);
            helper(root.right, result, path);
        }
        path.setLength(len);
    }

    /*
public List<String> binaryTreePaths(TreeNode root) {
    ArrayList<String> res = new ArrayList<String>();
    DFS(root, "", res);
    return res;
}

public void DFS(TreeNode root, String solution, ArrayList<String> res) {
	if (root == null) return;
	if (root.left==null && root.right==null) res.add(solution + root.val);
	DFS(root.left, solution + root.val + "->", res);
	DFS(root.right, solution + root.val + "->", res);
}
     */

    public static void main(String[] args) {
        BinaryTreePaths tree = new BinaryTreePaths();
        tree.node=new TreeNode(1);
        tree.node.left = new TreeNode(2);
        tree.node.right = new TreeNode(3);
        tree.node.left.right = new TreeNode(5);
        List<String> result = binaryTreePaths(tree.node);
        System.out.println(result);
    }
}
