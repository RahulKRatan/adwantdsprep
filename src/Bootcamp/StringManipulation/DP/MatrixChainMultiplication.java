package Bootcamp.StringManipulation.DP;

public class MatrixChainMultiplication {

    // Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
    public static int MatrixChainOrder(int p[], int i, int j)
    {

        return 0;
    }


    public static void main(String args[])
    {
        int arr[] = new int[] {1, 2, 3, 4, 3};
        int n = arr.length;

        System.out.println("Minimum number of multiplications is "+ MatrixChainOrder(arr, 1, n-1));

    }
}
