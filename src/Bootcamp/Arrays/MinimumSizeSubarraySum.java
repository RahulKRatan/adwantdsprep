package Bootcamp.Arrays;

public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int s, int[] nums) {
        int sum = 0, from = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {  // we have two pointers - from and i, forward form when sum >= s and capture min value
                min = Math.min(min, i - from + 1);
                sum -= nums[from++];
            }
        }
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,nums));
    }
}
