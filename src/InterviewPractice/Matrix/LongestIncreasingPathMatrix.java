package InterviewPractice.Matrix;

/**
 * To get max length of increasing sequences:
 *
 * Do DFS from every cell
 * Compare every 4 direction and skip cells that are out of boundary or smaller
 * Get matrix max from every cell's max
 * Use matrix[x][y] <= matrix[i][j] so we don't need a visited[m][n] array
 * The key is to cache the distance because it's highly possible to revisit a cell
 *
 * Time complexity : O(mn)
 * Space complexity : O(mn)
 *
 * without memoization - Time complexity : O(2^{m+n}) & Space complexity : O(mn)
 *
 */
public class LongestIncreasingPathMatrix {
    static int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    static int m;
    static int n;
    public static int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int[][] cache = new int[m][n];
        int result = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result = Math.max(result,DFS(matrix,i,j,cache));
            }
        }
        return result;
    }

    public static int DFS(int[][] matrix,int i, int j, int[][] cache){
        if(cache[i][j] != 0) return cache[i][j];
        for(int[] dir: dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x >= 0 && x < m && y >= 0 && y < n && matrix[i][j]< matrix[x][y]){
                cache[i][j] = Math.max(cache[i][j],DFS(matrix,x,y,cache));
            }
        }
        return ++cache[i][j];
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(longestIncreasingPath(matrix));
    }
}
