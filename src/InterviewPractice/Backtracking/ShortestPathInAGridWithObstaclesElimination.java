package InterviewPractice.Backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Since this is shortest path - we will do it through BFS
 * BFS: For BFS, stop as soon as we reach the m-1,n-1 node and return the steps.
 * It's guaranteed to be the shortest path.
 * Maintain the state of visited node + obstaclesEliminated (i,j,k).
 *  BFS O(MNK) time | O(MNK) space
 *  https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/discuss/452009/Java-Straightforward-DFS-with-memoization-%2B-BFS
 */
public class ShortestPathInAGridWithObstaclesElimination {
    public static int shortestPath(int[][] grid, int k) {
        return bfs(grid, k);
    }
    static int[] directions = {0, 1, 0, -1, 0}; // 0,1 - right | 1,0 - down | 0,-1 - left | -1,0 - up
    private static int bfs(int[][] grid, int K) {
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,K});
        visited.add(0 + " " + 0 + " " + K);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] curr = queue.poll();
                int i = curr[0], j = curr[1], k = curr[2];
                if (i == grid.length - 1 && j == grid[0].length - 1)
                    return steps; // we reached shortest path
                for (int d = 1; d < directions.length; d++) {
                    int x = i + directions[d-1];
                    int y = j + directions[d];
                    if (isOutOfBounds(grid, x, y) || k < 0 || (grid[x][y] == 1 && k <= 0)) // outofbounds or we cant handle obstacle
                        continue;
                    if (grid[x][y] == 1 && visited.add(x + " " + y + " " + (k-1))) {
                        queue.offer(new int[]{x,y,k-1});
                    } else if (grid[x][y] == 0 && visited.add(x + " " + y + " " + k)) {
                        queue.offer(new int[]{x,y,k});
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private static boolean isOutOfBounds(int[][] grid, int x, int y) {
        return (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1);
    }
    public static void main(String[] args) {
        int[][] grid = new int[][]
                {{0,0,0},
                {1,1,0},
                {0,0,0},
                {0,1,1},
                {0,0,0}};
        System.out.println(shortestPath(grid,1));
    }
}
