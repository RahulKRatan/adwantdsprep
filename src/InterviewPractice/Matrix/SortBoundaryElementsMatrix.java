package InterviewPractice.Matrix;

import java.util.Arrays;

public class SortBoundaryElementsMatrix {

    public static void sortBoundaryElements(int[][] matrix,int row,int col){
        int[] boundary = new int[row*col];
        int k=0;
        for(int i=0;i< row;i++)
        {
            for(int j=0;j< col;j++)
            {
                if(i==0 ||j==0||i==(row-1)||j==(col-1))
                {
                    boundary[k]=matrix[i][j];
                    k++;
                }
            }
        }
        Arrays.sort(boundary);

        int x=0;
        for(int i=0;i<col;i++) // right
            matrix[0][i]=boundary[x++];
        for(int i=1;i<col;i++) // down
            matrix[i][row-1]=boundary[x++];
        for(int i=col-2;i>=0;i--) //left
            matrix[col-1][i]=boundary[x++];
        for(int i=col-2;i>0;i--) //up
            matrix[i][0]=boundary[x++];

    System.out.println(matrix);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{4,5,6},{1,2,3},{7,8,9}};
        sortBoundaryElements(matrix,matrix.length,matrix[0].length);
    }
}
