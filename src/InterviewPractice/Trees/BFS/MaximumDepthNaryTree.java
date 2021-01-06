package InterviewPractice.Trees.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthNaryTree {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;
        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i = 0; i < size; i++)
            {
                Node current = queue.poll();
                for(Node child: current.children) queue.offer(child);
            }

            height++;
        }
        return height;
    }
    public int maxDepthDFS(Node root) {
        if (root == null) return 0;
        int cur = 0;
        for (Node node : root.children) {
            cur = Math.max(cur, maxDepthDFS(node));
        }
        return 1 + cur;
    }
}
