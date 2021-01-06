package InterviewPractice.Trees.DFS;

import java.util.List;

public class MaximumDepthNaryTree {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int cur = 0;
        for (Node node : root.children) {
            cur = Math.max(cur, maxDepth(node));
        }
        return 1 + cur;
    }
    /* BFS Solution
public int maxDepth(Node root) {
    if(root == null) return 0;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    int depth = 0;
    while(!queue.isEmpty())
    {
        int size = queue.size();
        for(int i = 0; i < size; i++)
        {
            Node current = queue.poll();
            for(Node child: current.children) queue.offer(child);
        }
        depth++;
    }
    return depth;
}*/
}
class Node {
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}