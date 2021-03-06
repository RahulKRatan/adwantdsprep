package InterviewPractice.DP;

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
 * https://algorithmsandme.com/longest-increasing-subsequence-in-onlogn/
 */

public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] arr) {
        if(arr.length == 0){
            return 0;
        }
        int T[] = new int[arr.length];
       // int actualSolution[] = new int[arr.length];
        for(int i=0; i < arr.length; i++){
            T[i] = 1;
            //actualSolution[i] = i;
        }

        for(int i=1; i < arr.length; i++){
            for(int j=0; j < i; j++){
                if(arr[i] > arr[j]){
                        T[i] = Integer.max(T[i], T[j] + 1);
                        //set the actualSolution to point to guy before me
                        //actualSolution[i] = j;

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

       /* //lets print the actual solution
        int t;
        int newT = maxIndex;
        do{
            t = newT;
            System.out.print(arr[t] + " ");
            newT = actualSolution[t];
        }while(t != newT);
        System.out.println();*/

        return T[maxIndex];
    }

    public static void main(String[] args) {
        int[] ints = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(ints));
    }
}
/*

RECURSIVE WAY OF DOING IT

    public int longestSubsequenceRecursive(int arr[]){
        int maxLen = 0;
        for(int i=0; i < arr.length-1; i++){
            int len = longestSubsequenceRecursive(arr,i+1,arr[i]);
            if(len > maxLen){
                maxLen = len;
            }
        }
        return maxLen + 1;
    }

    private int longestSubsequenceRecursive(int arr[], int pos, int lastNum){
        if(pos == arr.length){
            return 0;
        }
        int t1 = 0;
        if(arr[pos] > lastNum){
            t1 = 1 + longestSubsequenceRecursive(arr, pos+1, arr[pos]);
        }
        int t2 = longestSubsequenceRecursive(arr, pos+1, lastNum);
        return Math.max(t1, t2);
    }

*/

/* O(nlogn) solution using binary search

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0)
        return 0;

    ArrayList<Integer> list = new ArrayList<>();

    for(int num: nums){
        if(list.size()==0 || num>list.get(list.size()-1)){
            list.add(num);
        }else{
            int i=0;
            int j=list.size()-1;

            while(i<j){
                int mid = (i+j)/2;
                if(list.get(mid) < num){
                    i=mid+1;
                }else{
                    j=mid;
                }
            }

            list.set(j, num);
        }
    }

    return list.size();
    }
}
 */