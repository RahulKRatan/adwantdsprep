package InterviewPractice.Arrays;

/**
 *
 * Smart question & solution
 *
 * We can track each range's start and end when iterating over the ranges.
 * And in the final result array, adjust the values on the change points.
 *
 * The algorithm makes use of the above intuition to simply store changes at the borders of the update ranges (instead of processing the entire range). Finally a single post processing operation is carried out over the entire output array.
 *
 * The two steps that are required are as follows:
 *
 * For each update query (start, end, inc) on the array arr, we need to do only two operations:
 *
 * Update start boundary of the range:
 * arr_{start} = arr_{start} + inc
 *
 * Update just beyond the end boundary of the range:
 * arr_{end+1} = arr_{end+1} - inc
 *
 * Final Transformation. The cumulative sum of the entire array is taken (0 - based indexing)
 *
 * arr_i = arr_i + arr_{i-1} forall
 *
 *
 */
public class RangeAddition {

    public static int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        int k = updates.length;
        for (int i = 0; i < k; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int inc = updates[i][2];
            nums[start] += inc;
            if (end < length - 1) {
                nums[end + 1] -= inc;
            }
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }
        return nums;

    }

    public static void main(String[] args) {
        int[][] updates = new int[][]{{1,3,2},{2,4,3},{0,2,-2}};
        System.out.println(getModifiedArray(5,updates));
    }
}
