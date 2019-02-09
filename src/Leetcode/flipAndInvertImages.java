package Leetcode;

public class flipAndInvertImages
{
    public static int[][] flipAndInvertImage(int[][] A) {
        for(int i=0;i<A.length;i--){
            horizontal(A[i]);
            invert(A[i]);
        }
        return A;
    }

    public static int[] horizontal(int[] A){
        int j=A.length-1;
        for(int i=0;i<A.length;i++){
            if(j>i){
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                j--;
            }
        }
        return A;
    }

    public static int[] invert(int[] A){
        for(int i=0;i<A.length;i++){
            if(A[i]==0){
                A[i] = 1;
            }
            else{
                A[i] = 0;
            }
        }
        return A;
    }

    public static void main(String[] args) {

        int[][] arrays = { {1,1,0},{1,0,1},{0,0,0} };
        int[][] result = flipAndInvertImage(arrays);
        System.out.println(result.length);
    }

}
