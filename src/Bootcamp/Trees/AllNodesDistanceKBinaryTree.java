package Bootcamp.Trees;

import java.util.*;


/**
 * The video to explain this code is here: https://www.youtube.com/watch?v=nPtARJ2cYrg
 * Time and Space - O(N)
 * Complexities
 * n = total amount of nodes in the binary tree
 * m = total edges
 * Time: O( n + m )
 * This is standard to Breadth First Search. We upper bound the time by the number of nodes we can visit and edges we can traverse (at maximum).
 * Space: O( n )
 * We have a hashtable upper bounded by n mappings, a mapping to each node's parent.
 *
 */
public class AllNodesDistanceKBinaryTree {
    TreeNode node;
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        Map<TreeNode, TreeNode> nodeToParentMap = new HashMap();
        populateNodeToParentMap(nodeToParentMap, root, null);

         /*
        Create the queue that we will use for the breadth first search.
        Add the start node to the queue
         */
        Queue<TreeNode> queue = new LinkedList();
        queue.add(target);
        /*
         The is an undirected graph now that we can go to and from nodes.
         Before we could only go down the tree.
         Therefore, we need a hashtable to keep track of nodes we have
         visited so that we do not go back and revisit what has already
         been processed and cause an infinite cycle
        */
        Set<TreeNode> seen = new HashSet();
        seen.add(target);

        int currentLayer = 0;

        while (!queue.isEmpty()) {
            if (currentLayer == K) {
                return extractLayerFromQueue(queue);
            }
            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null && !seen.contains(currentNode.left)) {
                    seen.add(currentNode.left);
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null && !seen.contains(currentNode.right)) {
                    seen.add(currentNode.right);
                    queue.offer(currentNode.right);
                }
                TreeNode parentOfCurrentNode = nodeToParentMap.get(currentNode);
                if (parentOfCurrentNode != null && !seen.contains(parentOfCurrentNode)) {
                    seen.add(parentOfCurrentNode);
                    queue.offer(parentOfCurrentNode);
                }

            }
            currentLayer++;

        }
            return new ArrayList<>();
        }

    /*
    When this recursion is done we will know all nodes' parents. The tree then
    can be treated and searched like any other graph
    */
    private static void populateNodeToParentMap(Map<TreeNode, TreeNode> nodeToParentMap, TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        nodeToParentMap.put(root, parent);
        populateNodeToParentMap(nodeToParentMap, root.left, root);
        populateNodeToParentMap(nodeToParentMap, root.right, root);
    }

    private static List<Integer> extractLayerFromQueue(Queue<TreeNode> queue) {
        List<Integer> extractedList = new ArrayList();
        for (TreeNode node: queue) {
            extractedList.add(node.val);
        }
        return extractedList;
    }

    public static void main(String[] args) {
        AllNodesDistanceKBinaryTree tree = new AllNodesDistanceKBinaryTree();
        tree.node = new TreeNode(3);
        tree.node.left = new TreeNode(5);
        tree.node.right = new TreeNode(1);
        tree.node.left.left = new TreeNode(6);
        tree.node.left.right = new TreeNode(2);
        tree.node.left.right.left = new TreeNode(7);
        tree.node.left.right.right = new TreeNode(4);
        tree.node.right.left = new TreeNode(0);
        tree.node.right.right = new TreeNode(8);
        List<Integer> result = distanceK(tree.node,tree.node.left,2);
        System.out.println(result);
    }
}
