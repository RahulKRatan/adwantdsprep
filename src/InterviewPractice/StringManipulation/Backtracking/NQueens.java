package InterviewPractice.StringManipulation.Backtracking;


import java.util.ArrayList;
import java.util.LinkedList;
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
 */
public class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<>();
        dfs(board, 0, res);
        return res;
    }

    private static void dfs(char[][] board, int colIndex, List<List<String>> res) {
        if(colIndex == board.length) {
            res.add(construct(board));
            return;
        }

        for(int i = 0; i < board.length; i++) {
            if(validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, res);
                board[i][colIndex] = '.';
            }
        }
    }

    private static boolean validate(char[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < y; j++) {
                if(board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }

        return true;
    }

    private static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }


    public static void main(String args[]) {
        List<List<String>> result = solveNQueens(4);
        System.out.println(result);
    }


}
