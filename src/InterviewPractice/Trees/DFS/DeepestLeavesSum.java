package InterviewPractice.Trees.DFS;

import InterviewPractice.Trees.TreeNode;

/**
 *  Time : O(N) & Space : O(1)
 */
public class DeepestLeavesSum {
    TreeNode node;
    static int sum = 0;
    static int maxDepth = 0;
    public static int deepestLeavesSum(TreeNode root) {
        //int maxDepth = maxDepth(root);
        findSum(root,1);
        return sum;
    }

   /* public static int maxDepth(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }*/

    public static void findSum(TreeNode root, int currDepth){
        if(root != null){
            if(currDepth > maxDepth){ // extra if clause if we ignore maxDepth method.
                maxDepth = currDepth;
                sum = 0;
            }
            if(currDepth == maxDepth){
                sum += root.val;
            }
            findSum(root.left,currDepth+1);
            findSum(root.right,currDepth+1);
        }
    }

    /** BFS solution O(N) for both space and time
     *
     * int deepestLeavesSum(TreeNode* root) {
     * 	int sum = 0, n;
     * 	queue<TreeNode*> q; // required for level-order traversal
     * 	q.push(root);
     * 	while(!q.empty()){
     * 		sum = 0, n = size(q); // reset sum when deeper level is reached and accumulate for that level
     * 		for(int i = 0; i < n; i++){
     * 			auto top = q.front(); q.pop();
     * 			sum += top -> val;
     * 			if(top -> left) q.push(top -> left);
     * 			if(top -> right) q.push(top -> right);
     *                }* 	}
     * 	return sum; // final value held by 'sum' will be sum of values of nodes at the deepest level
     * }
     *
     */

    public static void main(String[] args) {
        DeepestLeavesSum tree = new DeepestLeavesSum();
        tree.node = new TreeNode(1);
        tree.node.left = new TreeNode(2);
        tree.node.right = new TreeNode(3);
        tree.node.right.right = new TreeNode(6);
        tree.node.right.right.right = new TreeNode(8);
        tree.node.left.left = new TreeNode(4);
        tree.node.left.right = new TreeNode(5);
        tree.node.left.left.left = new TreeNode(7);
        System.out.println(deepestLeavesSum(tree.node));
    }
}
