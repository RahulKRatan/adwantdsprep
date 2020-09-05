package InterviewPractice.DP;

/**
 * https://www.youtube.com/watch?v=86CQq3pKSUw&ab_channel=CSDojo
 */
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
