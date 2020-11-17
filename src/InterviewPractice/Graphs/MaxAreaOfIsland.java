package InterviewPractice.Graphs;

/**
 * The idea is to count the area of each island using dfs.
 * During the dfs, we set the value of each point in the island to 0. The time complexity is O(mn).
 */
public class MaxAreaOfIsland {
    public static int maxAreaOfIsland(int[][] grid) {
        //initialize number of islands to zero
        int maxAreaOfIsland = 0;

        //iterate through every index of the grid
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) maxAreaOfIsland = Math.max(maxAreaOfIsland,dfsSink(grid, i, j));
            }
        }
        //return the total number of islands
        return maxAreaOfIsland;
    }

   public static int dfsSink(int[][] grid, int i, int j) {
        //check the bounds of i and j and if the current index is an island or not (1 or 0)
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        //set current index to 0
        grid[i][j] = 0;

        // sink all neighbors of current index
        return 1 + dfsSink(grid, i + 1, j)+ dfsSink(grid, i - 1, j)+ dfsSink(grid, i, j + 1)+ dfsSink(grid, i, j - 1);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
                                   {0,0,0,0,0,0,0,1,1,1,0,0,0},
                                   {0,1,1,0,1,0,0,0,0,0,0,0,0},
                                   {0,1,0,0,1,1,0,0,1,0,1,0,0},
                                   {0,1,0,0,1,1,0,0,1,1,1,0,0},
                                   {0,0,0,0,0,0,0,0,0,0,1,0,0},
                                   {0,0,0,0,0,0,0,1,1,1,0,0,0},
                                   {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid));
    }
}
