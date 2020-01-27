package Bootcamp.Arrays;

/**
 * Loop through the array, each time remember the max and min value for the previous product,
 * the most important thing is to update the max and min value: we have to compare among max * A[i],
 * min * A[i] as well as A[i], since this is product, a negative * negative could be positive.
 */
public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int max = nums[0], min = nums[0], totalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempMax = nums[i] * max;
            int tempMin = nums[i] * min;
            max = Math.max(Math.max(tempMax,tempMin), nums[i]);
            min = Math.min(Math.min(tempMax,tempMin), nums[i]);
            totalMax = Math.max(totalMax, max);
        }
        return totalMax;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,3,-4};
        System.out.println(maxProduct(nums));
    }
}
