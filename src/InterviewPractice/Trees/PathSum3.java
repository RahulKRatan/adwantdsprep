package InterviewPractice.Trees;


/*
The first function pathSum() recursively calls itself for every child Node of root, returning 0 when finding a null Node.
pathSum also calls pathSumFrom on its current Node. pathSumFrom recursively traverses the tree down,
subtracting the nodes value from the sum. Doing this, keeps a running total of the sum of the visited nodes.
If the node.val == sum that means the path from the original root to the current node, is a sum path.
Since we aren't required to keep any information on the path itself, we simply return 1 representing a valid path.

From a high level, pathSum() recursively visits each Node and pathSumFrom() recursively visits each child Node and
totals their values and checks that against the sum. Every node will be checked including all possible paths downward.
 Typical recursive DFS.

Space: O(n) due to recursion.
Time: O(n^2) in worst case (no branching); O(nlogn) in best case (balanced tree).
*/

public class PathSum3 {
    TreeNode node;
    public static int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        return pathFromSum(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
    }
    public static int pathFromSum(TreeNode node,int sum){
        if(node == null){
            return 0;
        }
        return (node.val == sum ? 1 : 0) + pathFromSum(node.left,sum-node.val) + pathFromSum(node.right,sum-node.val);
    }


    public static void main(String[] args) {
        PathSum3 tree = new PathSum3();
        tree.node = new TreeNode(10);
        tree.node.left = new TreeNode(5);
        tree.node.right = new TreeNode(-3);
        tree.node.left.left = new TreeNode(3);
        tree.node.left.right = new TreeNode(2);
        tree.node.left.left.left = new TreeNode(3);
        tree.node.left.left.right= new TreeNode(-2);
        tree.node.right.right = new TreeNode(11);
        System.out.println(pathSum(tree.node,8));
    }
}
