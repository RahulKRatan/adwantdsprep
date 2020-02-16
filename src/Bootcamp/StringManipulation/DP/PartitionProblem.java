package Bootcamp.StringManipulation.DP;

public class PartitionProblem {

    public static boolean findPartition(int[] arr, int len){
        

        return false;
    }


    public static void main(String[] args) {
        int arr[] = {3, 1, 5, 9, 12};
        int n = arr.length;
        if (findPartition(arr, n)) {
            System.out.println("Can be divided into two subsets of equal sum");
        }
        else {
            System.out.println("Can not be divided into two subsets of equal sum");
        }
    }
}
