package InterviewPractice.DP;

import java.util.Arrays;

public class FindTwoNonOverlappingSubArraysEachWithTargetSum {
    public static int minSumOfLengths(int[] arr, int target) {
        int[] dp = new int[arr.length]; //dp[i] := length of smallest subarray in range arr[0]...arr[i] with sum = target
        Arrays.fill(dp, Integer.MAX_VALUE);
        int result = Integer.MAX_VALUE;
        //sliding window
        int sum = 0; //sum of current window
        int left = 0;
        for(int right = 0; right < arr.length; right++) {
            //invite new element into RHS
            sum+=arr[right];
            //contract until valid
            while(left <= right && sum>target){
                sum-=arr[left];
                left++;
            }
            //if valid, process
            if(sum==target) {
                //current window arr[l]...a[r]
                int currWindowLength = right - left + 1;
                //want best from prev iterations, dp[l-1]
                int prevBest = (left==0) ? Integer.MAX_VALUE : dp[left-1];
                //process res
                if(prevBest != Integer.MAX_VALUE) {
                    result = Math.min(result, currWindowLength+prevBest);
                }
                //now process dp
                dp[right] = (right==0) ? currWindowLength : Math.min(currWindowLength, dp[right-1]);
            }
            else {
                //else not valid, inherit dp[prev iteration]
                dp[right] = (right==0) ? Integer.MAX_VALUE : dp[right-1];
            }
        }
        return (result==Integer.MAX_VALUE) ? -1 : result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,6,2,3,4};
        System.out.println(minSumOfLengths(arr,3));
    }
}
