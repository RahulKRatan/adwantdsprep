package Bootcamp.StringManipulation.DP;

/**
 *
 * Youtube link - https://youtu.be/CE2b_-XfVDk
 *
 * Find a subsequence in given array in which the subsequence's elements are
 * in sorted order, lowest to highest, and in which the subsequence is as long as possible
 *
 * Solution :
 * Dynamic Programming is used to solve this question. DP equation is
 * if(arr[i] > arr[j]) { T[i] = max(T[i], T[j] + 1 }
 *
 * Time complexity is O(n^2).
 * Space complexity is O(n)
 *
 * Reference
 * http://en.wikipedia.org/wiki/Longest_increasing_subsequence
 * http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
 */

public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] arr) {
        if(arr.length == 0){
            return 0;
        }
        int T[] = new int[arr.length];
        int actualSolution[] = new int[arr.length];
        for(int i=0; i < arr.length; i++){
            T[i] = 1;
            actualSolution[i] = i;
        }

        for(int i=1; i < arr.length; i++){
            for(int j=0; j < i; j++){
                if(arr[i] > arr[j]){
                        T[i] = Integer.max(T[i], T[j] + 1);
                        //set the actualSolution to point to guy before me
                        actualSolution[i] = j;

                }
            }
        }

        //find the index of max number in T
        int maxIndex = 0;
        for(int i=0; i < T.length; i++){
            if(T[i] > T[maxIndex]){
                maxIndex = i;
            }
        }

        //lets print the actual solution
        int t;
        int newT = maxIndex;
        do{
            t = newT;
            System.out.print(arr[t] + " ");
            newT = actualSolution[t];
        }while(t != newT);
        System.out.println();

        return T[maxIndex];
    }

    public static void main(String[] args) {
        int[] ints = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(ints));
    }
}
