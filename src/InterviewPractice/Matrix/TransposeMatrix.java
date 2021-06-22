package InterviewPractice.Matrix;

public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[n][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] result = transpose(matrix);
        System.out.println(result);
    }
}
