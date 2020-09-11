package InterviewPractice.DP;

import InterviewPractice.StackQueues.LargestAreaInHistogram;

/**
 *Video link - https://youtu.be/2xvJ41-hsoE
 *  *
 *  * Given a 2D matrix of 0s and 1s. Find largest rectangle of all 1s
 *  * in this matrix.
 *  *
 *  * Maintain a temp array of same size as number of columns.
 *  * Copy first row to this temp array and find largest rectangular area
 *  * for histogram. Then keep adding elements of next row to this temp
 *  * array if they are not zero. If they are zero then put zero there.
 *  * Every time calculate max area in histogram.
 *  *
 *  * Time complexity - O(rows*cols)
 *  * Space complexity - O(cols) - if number of cols is way higher than rows
 *  * then do this process for rows and not columns.
 *  *
 *  * References:
 *  * http://www.careercup.com/question?id=6299074475065344
 *  https://www.youtube.com/watch?v=g8bSdXCG-lA&ab_channel=TusharRoy-CodingMadeSimple
 */
public class MaximalRectangle {

    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int temp[] = new int[matrix[0].length];
        int maxArea = 0;
        int area;
        LargestAreaInHistogram largestAreaInHistogram = new LargestAreaInHistogram();
        for(int i=0; i < matrix.length; i++){
            for(int j=0; j < temp.length; j++){
                if(matrix[i][j] == '0'){
                    temp[j] = 0;
                }else{
                    temp[j] += Character.getNumericValue(matrix[i][j]);
                }
            }
            area = largestAreaInHistogram.largestRectangleArea(temp);
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] chars = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle(chars));
    }
}
