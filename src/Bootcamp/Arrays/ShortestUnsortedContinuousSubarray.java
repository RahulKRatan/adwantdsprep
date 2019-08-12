package Bootcamp.Arrays;

/**
 * O(n) time two-pass solution
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/discuss/103066/Ideas-behind-the-O(n)-two-pass-and-one-pass-solutions
 * It turns out that the two boundary indices i and j can be found in linear time, if we take advantage of the following three properties:
 * nums[0, i - 1] and nums[j + 1, n - 1] are both sorted.
 * nums[i] != nums_sorted[i] and nums[j] != nums_sorted[j].
 * nums[i - 1] <= min and max <= nums[j + 1], where min and max are the minimum and maximum values of subarray nums[i, j].
 * The first and third properties guarantee that the subarray nums[0, i - 1] will be exactly the same as subarray nums_sorted[0, i - 1], and the subarray nums[j + 1, n - 1] exactly the same as nums_sorted[j + 1, n - 1], while the second property ensures that i will be the first index at which the two elements of nums and nums_sorted are different and j be the last such index.
 * Since we aim at the shortest subarrays, from the first property alone, we need to find the two longest sorted subarrays starting at index 0 and ending at index n - 1, respectively. Assume the two subarrays are nums[0, l] and nums[r, n - 1]. If there is overlapping between these two subarrays, i.e.l >= r, then the whole array is sorted so 0 will be returned. Otherwise, the input array is not sorted. However, we cannot say sorting nums[l, r] will leave the whole array sorted, because at this moment the third property may not be satisfied.
 * To guarantee the third property, assume min and max are the minimum and maximum values of subarray nums[l, r], then we need to decrease l as long as nums[l] > min, and increase r as long as nums[r] < max. After this is done, it can be shown that the second property will be met automatically, and nums[l + 1, r - 1] will be the shortest subarray we are looking for (that is, i = l + 1 and j = r - 1).
 * Finding the longest subarrays and the maximum and minimum values of the middle subarray takes one-pass. Ensuring the third property requires a second pass. Therefore we have this two-pass solution:
 */
public class ShortestUnsortedContinuousSubarray {

    public static int findUnsortedSubarray(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r && nums[l] <= nums[l + 1]) l++;

        if (l >= r) return 0;

        while (nums[r] >= nums[r - 1]) r--;

        // to handle duplicates.
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int k = l; k <= r; k++) {
            max = Math.max(max, nums[k]);
            min = Math.min(min, nums[k]);
        }

        while (l >= 0 && min < nums[l]) l--;
        while (r < nums.length && nums[r] < max) r++;

        return (r - l - 1);
    }

    public static void main(String[] args) {
    int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
    int[] nums2 = new int[]{1,3,2,2,2};
    //[1,3,2,2,2]
    //System.out.println(findUnsortedSubarray(nums));
        System.out.println(findUnsortedSubarray(nums2));
    }
}
