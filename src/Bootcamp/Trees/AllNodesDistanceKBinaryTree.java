package Bootcamp.Trees;

import java.util.*;

public class AllNodesDistanceKBinaryTree {
    TreeNode node;
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        Map<TreeNode, TreeNode> nodeToParentMap = new HashMap();
        populateNodeToParentMap(nodeToParentMap, root, null);

        Queue<TreeNode> queue = new LinkedList();
        queue.add(target);

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
