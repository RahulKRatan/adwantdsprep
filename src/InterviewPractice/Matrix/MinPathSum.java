package InterviewPractice.Matrix;

public class MinPathSum {

    /*
    So basically let's begin with recursion because it is easier to understand and code.
    When we think about this problem, we could use a top down approach.
    To get a path, we need to travel from grid[0][0] to grid[row - 1][col - 1].
    So let's set grid[0][0] as the basic case. This is when we jump out of recursion. On the other hand,
     grid[row - 1][col - 1] would be the starting point. We write a helper function to do the recursion work.
     At the starting point, this function returns (value of the end cell + value of the cell that has the less one).
     But we need to consider that things could happen that we reached the first row or column and we gotta make sure
     that we stay within the array index limit.
At last, when we reach grid[0][0], we are done!
     */
    public static int minPathSumRecursive(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        return min(grid, height - 1, width - 1);
    }
    public static int min(int[][]grid, int row, int col){

        if(row == 0 && col == 0) return grid[row][col]; // this is the exit of the recursion
        if(row == 0) return grid[row][col] + min(grid, row, col - 1); /** when we reach the first row, we could only move horizontally.*/
        if(col == 0) return grid[row][col] + min(grid, row - 1, col); /** when we reach the first column, we could only move vertically.*/
        return grid[row][col] + Math.min(min(grid, row - 1, col), min(grid, row, col - 1)); /** we want the min sum path so we pick the cell with the less value */

    }

    /*
    Now, let's upgrade this algorithm from recursion to DP since we don't wanna get stackoverflow for large inputs.
    In fact, there is nothing fancy about DP. It is simply that we store or cache the results of every
    single calculation so that we don't need to calculate the same thing again and again.
     The whole idea is almost the same. We just involve an array to store the values. Now let's see the code:
     */
    public static int minPathSumDP(int[][] grid) {

        int height = grid.length;
        int width = grid[0].length;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if(row == 0 && col == 0) grid[row][col] = grid[row][col];
                else if(row == 0 && col != 0) grid[row][col] = grid[row][col] + grid[row][col - 1];
                else if(col == 0 && row != 0) grid[row][col] = grid[row][col] + grid[row - 1][col];
                else grid[row][col] = grid[row][col] + Math.min(grid[row - 1][col], grid[row][col - 1]);
            }
        }
        return grid[height - 1][width - 1];
    }


    public static void main(String[] args) {
        int[][] values = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int result = minPathSumRecursive(values);
        System.out.println(result);
    }
}
