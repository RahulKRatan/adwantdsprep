package InterviewPractice.Arrays;


/* Rotate clockwise
SwapRows and Transpose

Rotate anti-clockwise
Transpose and SwapRows

 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        swapRows(matrix);
        transpose(matrix);
    }
    private void swapRows(int[][] matrix) {
        int lo = 0;
        int hi = matrix.length - 1;
        while(lo < hi) {
            int[] temp = matrix[lo];
            matrix[lo++] = matrix[hi];
            matrix[hi--] = temp;
        }
    }
    private void transpose(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
