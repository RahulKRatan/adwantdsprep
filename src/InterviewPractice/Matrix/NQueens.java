package InterviewPractice.Matrix;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given nxn board place n queen on this board so that they dont attack each other. One solution is to find
 * any placement of queens which do not attack each other. Other solution is to find all placements of queen
 * on the board.
 *
 * Time complexity O(n*n)
 * Space complexity O(n*n)
 * Also https://algorithms.tutorialhorizon.com/backtracking-n-queens-problem/
 * https://leetcode.com/problems/n-queens/discuss/19945/*Java*-When-you-are-familiar-with-backtracking-you'll-find-this-solution-straightforward-(5ms-beats-84)
 * https://github.com/labuladong/fucking-algorithm/blob/english/think_like_computer/DetailsaboutBacktracking.md
 * https://www.youtube.com/watch?v=xouin83ebxE&ab_channel=TusharRoy-CodingMadeSimple
 */
public class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if(n<1) return result;
        char[][] board = new char[n][n];
        for(char[] row : board) {
            for(int j=0; j<n; j++) {
                row[j] = '.';
            }
        }
        solve(board, n, 0, result);
        return result;
    }
    // Path:The rows smaller than row in the board have been successfully placed the queens
    // Seletion List: all columns in 'rowth' row are queen's seletions
    // End condition: row meets the last line of board(n)
    private static void solve(char[][] board, int N, int row, List<List<String>> res) {
        if(row==N) { // done soving, simply add the board into the result
            List<String> list = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                list.add(String.valueOf(board[i]));
            }
            res.add(list);
        }
        for(int col=0; col<N; col++) {
            if(!isSafe(board,row, col)) continue;
            board[row][col] = 'Q'; // greedy
            solve(board, N, row+1, res);
            board[row][col] = '.'; // backtrack
        }
    }

    private static boolean isSafe(char[][] board,int row, int col) {

        int n = board.length;
        // Check if share the same column
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q')
                return false;
        }

        // Check if share the same right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        // Check if share the same left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    public static void main(String args[]) {
        List<List<String>> result = solveNQueens(4);
        System.out.println(result);
    }
}
