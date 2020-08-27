package InterviewPractice.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfNarryTree {
//From any node, you can access all its children using node's property named children, which is an array of nodes.
    static int find_height(TreeNode root)
    {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;
        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i = 0; i < size; i++)
            {
                TreeNode current = queue.poll();
                //for(TreeNode child: current.children) queue.offer(child);
            }

            height++;
        }

        return height-1;
    }
}

//class TreeNode
//{
//    Vector<TreeNode> vec = new Vector<TreeNode>(0);
//    TreeNode()
//    {
//        children.clear();
//    }
//};
