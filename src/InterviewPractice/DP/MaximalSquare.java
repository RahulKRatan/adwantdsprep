package InterviewPractice.DP;

/**
 * Time Complexity: O(m*n) where m is number of rows and n is number of columns in the given matrix.
 * Auxiliary Space: O(m*n) where m is number of rows and n is number of columns in the given matrix.
 *
 * 1) Construct a sum matrix S[R][C] for the given M[R][C].
 *          If M[i][j] is 1 then
 *             S[i][j] = min(S[i][j-1], S[i-1][j], S[i-1][j-1]) + 1
 *          Else If M[i][j] is 0
 *                  S[i][j]=0
 * 2)Find the maximum entry in S[R][C]
 * 3)Using the value and coordinates of maximum entry in S[i],print
         sub-matrix of M[][]
 * https://leetcode.com/problems/maximal-square/solution/
 * https://www.youtube.com/watch?v=_Lf1looyJMU&t=2s&ab_channel=TusharRoy-CodingMadeSimples
 *
 */
public class MaximalSquare {

    public static int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsize = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsize = Math.max(maxsize, dp[i][j]);
                }
            }
        }
        return maxsize * maxsize;
    }

    public static void main(String[] args) {
        char[][] chars = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(chars));
    }
}
