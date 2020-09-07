package InterviewPractice.DP;

/**
 * 91. Decode Ways
 * 70. Climbing Stairs
 * 509. Fibonacci Number
 *
 * https://leetcode.com/problems/unique-paths/discuss/405983/Easy-understand-Java-Solutions-with-Explanations-(DP-Top-down-Bottom-up-Linear-Space)
 *Time: O(MN)
 * Space: O(N) or O(M)
 */
public class UniquePaths {

    /*
    public int uniquePaths(int m, int n) {
  if (m == 0 || n == 0) {
    throw new IllegalArgumentException("m or n can't be 0");
  }
  return numPaths(m - 1, n - 1);
}

private int numPaths(int i, int j) {
  if (i == 0 || j == 0) { // includes the row 0 and col 0
    return 1;
  }
  return numPaths(i - 1, j) + numPaths(i, j - 1);
}

     */

    //DP solution

    /**
     * The assumptions are
     *
     * When (n==0||m==0) the function always returns 1 since the robot
     * can't go left or up.
     * For all other cells. The result = uniquePaths(m-1,n)+uniquePaths(m,n-1)
     * Therefore I populated the edges with 1 first and use DP to get the full 2-D array.
     *
     */
    public static int uniquePathsDP(int m, int n) {
        Integer[][] map = new Integer[m][n];
        for(int i = 0; i<m;i++){
            map[i][0] = 1;
        }
        for(int j= 0;j<n;j++){
            map[0][j]=1;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                map[i][j] = map[i-1][j]+map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }


    public static void main(String[] args) {
        int result = uniquePathsDP(3,2);
        System.out.println(result);
    }
}

/*
DP (Top-down with Memoization)

public int uniquePaths(int m, int n) {
  if (m == 0 || n == 0) {
    throw new IllegalArgumentException("m or n can't be 0");
  }
  int[][] mem = new int[m][n];
  for (int i = 0; i < m; ++i) { // init
    for (int j = 0; j < n; ++j) {
      mem[i][j] = -1;
    }
  }
  return numPaths(m - 1, n - 1, mem);
}

private int numPaths(int i, int j, int[][] mem) {
  if (i == 0 || j == 0) {
    return 1;
  }
  if (mem[i - 1][j] == -1) mem[i - 1][j] = numPaths(i - 1, j, mem);
  if (mem[i][j - 1] == -1) mem[i][j - 1] = numPaths(i, j - 1, mem);
  return mem[i - 1][j] + mem[i][j - 1];
}

 */