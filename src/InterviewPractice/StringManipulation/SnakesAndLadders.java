package InterviewPractice.StringManipulation;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *
 * Intuition
 *
 * As we are looking for a shortest path, a breadth-first search is ideal.
 * The main difficulty is to handle enumerating all possible moves from each square.
 *
 * Algorithm
 *
 * Suppose we are on a square with number s. We would like to know all final destinations with number s2 after making one move.
 * This requires knowing the coordinates get(s2) of square s2.
 * This is a small puzzle in itself: we know that the row changes every N squares, and so is only based on quot = (s2-1) / N;
 * also the column is only based on rem = (s2-1) % N and what row we are on (forwards or backwards.)
 *
 * From there, we perform a breadth first search, where the nodes are the square numbers s.
 *
 * Time Complexity: O(N^2) where N is the length of the board.
 * Space Complexity: O(N^2)
 *
 */
public class SnakesAndLadders {

    public static int snakesAndLadders(int[][] board) {
        int N = board.length;

        Map<Integer, Integer> dist = new HashMap();
        dist.put(1, 0);

        Queue<Integer> queue = new LinkedList();
        queue.add(1);

        while (!queue.isEmpty()) {
            int s = queue.remove();
            if (s == N*N) return dist.get(s);

            for (int s2 = s+1; s2 <= Math.min(s+6, N*N); ++s2) {
                int rc = get(s2, N);
                int r = rc / N, c = rc % N;
                int s2Final = board[r][c] == -1 ? s2 : board[r][c];
                if (!dist.containsKey(s2Final)) {
                    dist.put(s2Final, dist.get(s) + 1);
                    queue.add(s2Final);
                }
            }
        }
        return -1;
    }

    public static int get(int s, int N) {
        // Given a square num s, return board coordinates (r, c) as r*N + c
        int quot = (s-1) / N;
        int rem = (s-1) % N;
        int row = N - 1 - quot;
        int col = row % 2 != N % 2 ? rem : N - 1 - rem;
        return row * N + col;
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}};

        System.out.println(snakesAndLadders(board));

    }
}
