package InterviewPractice.Matrix;


import java.util.LinkedList;
import java.util.Queue;
/*
Time Complexity:
If we use adjacency matrix : O(VE)
If we use adjacency list: O(E+V)
https://leetcode.com/problems/course-schedule/discuss/58669/Concise-JAVA-solutions-based-on-BFS-and-DFS-with-explanation
The basic idea is to use Topological algorithm: put NODE with 0 indegree into the queue, then make indegree of NODE's successor dereasing 1. Keep the above steps with BFS.
Finally, if each node' indegree equals 0, then it is validated DAG (Directed Acyclic Graph), which means the course schedule can be finished.
For your BFS code, I think the complexity is O(V*E). As you iterate through the edge list every time. It can be reduced to O(V+E) by converting the edge list into a adjacency list.

Pseudo code:
- Calculate indegrees of all the elements in the array ( 1,0 -> 0 and then 1 -> so indegree of 1 is incremented )
- Whichever element has indegree as 0 -> push it to the queue. These doesnt have dependencies and can be started first
- fetch element from queue -> whichever elements have this queue element dependency - decrement its indegree ; if its zero after decrement then add it to canFinishCount since it has no more dependencies and add it to the queue
- after entire loop is complete - check if canFinishCount is equal to numCourses ; else return false

BFS Solution ( Topological sorting )

 */
public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        if (numCourses == 0 || prerequisites.length == 0) return true;

        // Convert graph presentation from edges to indegree of adjacent list.
        int indegree[] = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) // Indegree - how many prerequisites are needed.
            indegree[prerequisites[i][0]]++;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                queue.add(i);

        // How many courses don't need prerequisites.
        int canFinishCount = queue.size();
        while (!queue.isEmpty()) {
            int prerequisite = queue.remove(); // Already finished this prerequisite course.
            for (int i = 0; i < prerequisites.length; i++)  {
                if (prerequisites[i][1] == prerequisite) {
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        canFinishCount++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return (canFinishCount == numCourses);
    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        System.out.println(canFinish(4,prerequisites));
    }
}
