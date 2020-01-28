package Bootcamp.Arrays;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        for(int i = 1; i < n; ++i) {
            if (nums[i - 1] > 0){
                nums[i] += nums[i - 1];
            }
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }
}