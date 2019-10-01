package Bootcamp.StringManipulation.DP;

/**
 * Time Complexity: O(m*n) where m is number of rows and n is number of columns in the given matrix.
 * Auxiliary Space: O(m*n) where m is number of rows and n is number of columns in the given matrix.
 *
 * 1) Construct a sum matrix S[R][C] for the given M[R][C].
 *      a)    Copy first row and first columns as it is from M[][] to S[][]
 *      b)    For other entries, use following expressions to construct S[][]
 *          If M[i][j] is 1 then
 *             S[i][j] = min(S[i][j-1], S[i-1][j], S[i-1][j-1]) + 1
 *          Else If M[i][j] is 0
 *                  S[i][j]=0
 * 2)Find the maximum entry in S[R][C]
 * 3)Using the value and coordinates of maximum entry in S[i],print
         sub-matrix of M[][]
 *
 */
public class MaximalSquare {

    private static int min(int a,int b, int c){
        int l = Math.min(a, b);
        return Math.min(l, c);
    }

    public static int maximalSquare(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int result[][] = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i=0; i < matrix.length; i++){
            result[i][0] = Character.getNumericValue(matrix[i][0]);
            if (result[i][0] == 1)
            {
                max = 1;
            }
        }

        for(int i=0; i < matrix[0].length; i++){
            result[0][i] = Character.getNumericValue(matrix[0][i]);
            if (result[0][i] == 1)
            {
                max = 1;
            }

        }


        for(int i=1; i < matrix.length; i++){
            for(int j=1; j < matrix[i].length; j++){
                if(matrix[i][j] == '0'){
                    continue;
                }
                int t = min(result[i-1][j],result[i-1][j-1],result[i][j-1]);
                result[i][j] = (t+1);
                if(result[i][j] > max){
                    max = result[i][j];
                }
            }
        }
        return max*max;
    }

    public static void main(String[] args) {
        //char[][] chars = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] chars = new char[][]{};
        System.out.println(maximalSquare(chars));
    }
}
