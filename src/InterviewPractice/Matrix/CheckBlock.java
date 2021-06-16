package InterviewPractice.Matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * Wayfair karat
 * You are working on a logic game made up of a series of puzzles. The first type of puzzle you settle on is "sub-Sudoku", a game where the player has to position the numbers 1..N on an NxN matrix.
 *
 * Your job is to write a function that, given an NxN matrix, returns true if every row and column contains the numbers 1..N
 */
public class CheckBlock {
    public static boolean checkBlock(int[][] f, int n) {
        int row = f[0].length;
        int column = row;
        int sum=0;
        //Typically the sum must be equal to 1 to N from row or col prospective
        sum = row*(row+1)/2;

        // Check all rows
        for (int i = 0 ; i < row ; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < row; j++) {
                rowSet.add(f[i][j]);
            }
            int rowSum=0;
            for(int s:rowSet){
                rowSum+=s;
            }
            if(sum!=rowSum)
                return false;
        }
        // Check all columns
        for (int i = 0 ; i < column ; i++) {
            Set<Integer> columnSet = new HashSet<>();
            for (int j = 0; j < row; j++) {
                columnSet.add(f[j][i]);
            }
            int colSum=0;
            for(int si:columnSet){
                colSum+=si;
            }
            if(sum!=colSum)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] f = {{1, 3, 2},
                {3, 1, 2},
                {2, 3, 1}};
        System.out.println("Result f : " + checkBlock(f, n));
        int[][] f1 = {{1, 2, 3},
                {3, 1, 2},
                {2, 3, 1}};
        System.out.println("Result f1 : " +checkBlock(f1, n));
        int[][] f2 = {{1, 2, 3},
                {3, 1, 2},
                {2, 3, 1}};
        System.out.println("Result f2 : " + checkBlock(f2, n));
        int[][] f3 = {{3, 2, 3, 2},
                {2, 3, 2, 3},
                {3, 2, 3, 2},
                {2, 3, 2, 3}};
        System.out.println("Result f3 : " + checkBlock(f3, n));
        int[][] f4 = {{1000, -1000, 6},
                {2, 3, 1},
                {3, 1, 2}};
        System.out.println("Result f4 : " + checkBlock(f4, n));
    }
}
