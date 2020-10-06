package InterviewPractice.Arrays;

/**
 * Refer files folder for diagram
 * Time complexity: O(m * n), m = number of rows, n = number of columns.
 * Space complexity: O(1).
 *
 * you can just alternate d between 1 and -1 and add/subtract it.
 * http://fisherlei.blogspot.com/2017/07/leetcode-diagonal-traverse-solution.html
 *
 */
public class DiagonalTraverse {
    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;

        int[] result = new int[m * n];
        int row = 0, col = 0, d = 1;

        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][col];
            row -= d;
            col += d;

            if (row >= m) { row = m - 1; col += 2; d = -d;}
            if (col >= n) { col = n - 1; row += 2; d = -d;}
            if (row < 0)  { row = 0; d = -d;}
            if (col < 0)  { col = 0; d = -d;}
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(findDiagonalOrder(ints));
    }
}
