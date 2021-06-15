package InterviewPractice.Matrix;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * BFS is the only best choice here
 *
 * Time complexity : O(N).
 * Same as approach 1. Processing a cell is O(1), and each of the NN cells is processed at most once, giving a total of O(N).
 * Space complexity : O(N).
 * Same as approach 1. The visited set also requires O(N) space; in the worst case, it will hold the row and column of each of the N cells.
 *
 * DP doesn't work because you will not calculate all 8 paths before calculating a path. Let see 1,1 now all the 8 paths are valid but not all 8 paths are available to you. That's the difference between this and other DP problems.
 *
 * https://cs.stackexchange.com/questions/4914/why-cant-dfs-be-used-to-find-shortest-paths-in-unweighted-graphs
 *
 */
public class ShortestPathBinaryMatrix {
    private static final int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public static int shortestPathBinaryMatrix(int[][] grid) {
        // Firstly, we need to check that the start and target cells are open.
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }

        // Set up the BFS.
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 1}); // Put distance on the queue
        boolean[][] visited = new boolean[grid.length][grid[0].length]; // Used as visited set.
        visited[0][0] = true;

        // Carry out the BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            int row = cell[0];
            int col = cell[1];
            int distance = cell[2];
            // Check if this is the target cell.
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return distance;
            }
            for (int[] neighbour : getNeighbours(row, col, grid)) {
                int neighbourRow = neighbour[0];
                int neighbourCol = neighbour[1];
                if (visited[neighbourRow][neighbourCol]) {
                    continue;
                }
                visited[neighbourRow][neighbourCol] = true;
                queue.add(new int[]{neighbourRow, neighbourCol, distance + 1});
            }
        }

        // The target was unreachable.
        return -1;
    }

    private static List<int[]> getNeighbours(int row, int col, int[][] grid) {
        List<int[]> neighbours = new ArrayList<>();
        for (int i = 0; i < directions.length; i++) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];
            if (newRow < 0 || newCol < 0 || newRow >= grid.length
                    || newCol >= grid[0].length
                    || grid[newRow][newCol] != 0) {
                continue;
            }
            neighbours.add(new int[]{newRow, newCol});
        }
        return neighbours;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(matrix));
    }
}
