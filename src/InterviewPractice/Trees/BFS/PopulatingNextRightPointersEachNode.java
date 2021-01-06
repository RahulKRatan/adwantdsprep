package InterviewPractice.Trees.BFS;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 *
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 */
public class PopulatingNextRightPointersEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        public Node() {
        }
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
        int length = queue.size();
        Node prev = null;

        for(int i=0;i<length;i++){
            Node temp = queue.poll();
            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
            if(prev != null){
                prev.next = temp;
            }
            prev = temp;
        }
        }
        return root;
    }
}
