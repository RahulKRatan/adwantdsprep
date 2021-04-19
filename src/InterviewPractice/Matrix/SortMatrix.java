package InterviewPractice.Matrix;

import java.util.Arrays;

/**
 * Time Complexity: O(n2logn).
 * Auxiliary Space: O(n2).
 *
 * Also O(MN) and O(1) solution
 */
public class SortMatrix {
    public static void sortMatrix(int[][] matrix, int n){
        // temporary matrix of size n^2
        int[] temp = new int[n * n];
        int k = 0;

        // copy the elements of matrix
        // one by one into temp[]
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                temp[k++] = matrix[i][j];

        // sort temp[]
        Arrays.sort(temp);

        // copy the elements of temp[]
        // one by one in mat[][]
        k = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = temp[k++];
    }
    /*
    For Accessing ith element of the matrix, the relation which can be defined as – Ith Element of the Matrix = Mat[ i / cols ][ i % cols ]
    The idea is to treat the 2D-Array as a 1D-Array to sort the matrix without using extra space.
    Find the number of rows(say rows) and columns(say cols) in the matrix by finding the length of the number of rows in the 2D-Array and the elements in each row in the Array.
Iterate over each element of the matrix from 0 to number of elements (rows * cols).
Find the approprite position of the element in the matrix using above formulae for each element.
Compare each element with the next element (For the last element in the row, next element will be next row first element) in the matrix and if the next element is the less then swap these elements.

Time Complexity: In the given approach, we are sorting the elements in the matrix by considering the elements in 1D-Array using Bubble sort, So the overall complexity will be O(N * M>)
Space Complexity: In the given approach no extra space is used, So the overall space complexity will be O(1)
     */
    public static void sortMatrixEfficient(int[][] matrix, int row,int col){
        // Number of elements in matrix
        int size = row * col;

        // Loop to sort the matrix
        // using Bubble Sort
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size - 1; j++)
            {

                // Condition to check
                // if the Adjacent elements
                //Accessing ith Element of the Matrix = Mat[ i / cols][i % cols]
                if (matrix[j/col][j % col] > matrix[(j + 1)/col][(j + 1) % col])
                {
                    // Swap if previous value is greater
                    int temp = matrix[j / col][j % col];
                    matrix[j / col][j % col] = matrix[(j + 1)
                            / col][(j + 1) % col];
                    matrix[(j + 1) / col][(j + 1) % col] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{4,5,6},{1,2,3},{7,8,9}};
        sortMatrix(matrix,matrix.length);
        sortMatrixEfficient(matrix,matrix.length,matrix[0].length);
    }
}
