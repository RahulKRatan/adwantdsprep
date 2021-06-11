package InterviewPractice.Matrix;

/**
 * Search Space Reduction
 *
 * Intuition
 *
 * Because the rows and columns of the matrix are sorted (from left-to-right and top-to-bottom, respectively),
 * we can prune O(m) or O(n) elements when looking at any particular value.
 *
 * Algorithm
 *
 * First, we initialize a (row,col) pointer to the bottom-left of the matrix.[1] Then,
 * until we find target and return true (or the pointer points to a (row,col) that lies outside of the dimensions of the matrix),
 * we do the following: if the currently-pointed-to value is larger than target we can move one row "up". Otherwise, if the currently-pointed-to value is smaller than target,
 * we can move one column "right". It is not too tricky to see why doing this will never prune the correct answer; because the rows are sorted from left-to-right,
 * we know that every value to the right of the current value is larger. Therefore, if the current value is already larger than target,
 * we know that every value to its right will also be too large. A very similar argument can be made for the columns, so this manner of search will always find target in the matrix (if it is present).
 *
 * Time complexity : O(n+m)
 *
 * The key to the time complexity analysis is noticing that, on every iteration (during which we do not return true) either row or col is is decremented/incremented exactly once. Because row can only be decremented mm times and col can only be incremented nn times before causing the while loop to terminate, the loop cannot run for more than n+mn+m iterations. Because all other work is constant, the overall time complexity is linear in the sum of the dimensions of the matrix.
 *
 * Space complexity : O(1)
 *
 * Because this approach only manipulates a few pointers, its memory footprint is constant.
 */
public class Search2DMatrixII {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int x=matrix.length-1;
        int y=matrix[0].length-1;

        int i=x;
        int j=0;

        while(i>=0 && j<=y){
            if(target < matrix[i][j]){
                i--;
            }else if(target > matrix[i][j]){
                j++;
            }else{
                return true;
            }
        }

        return false;
    }

    /*  Brute force

     public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }
     */

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix(matrix,5));
    }


}
