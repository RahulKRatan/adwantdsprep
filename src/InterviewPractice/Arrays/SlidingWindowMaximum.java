package InterviewPractice.Arrays;


/**
 * For Example: A = [2,1,3,4,6,3,8,9,10,12,56], w=4
 *
 * partition the array in blocks of size w=4. The last block may have less then w.
 * 2, 1, 3, 4 | 6, 3, 8, 9 | 10, 12, 56|
 *
 * Traverse the list from start to end and calculate max_so_far. Reset max after each block boundary (of w elements).
 * left_max[] = 2, 2, 3, 4 | 6, 6, 8, 9 | 10, 12, 56
 *
 * Similarly calculate max in future by traversing from end to start.
 * right_max[] = 4, 4, 4, 4 | 9, 9, 9, 9 | 56, 56, 56
 *
 * now, sliding max at each position i in current window, sliding-max(i) = max{right_max(i), left_max(i+w-1)}
 * sliding_max = 4, 6, 6, 8, 9, 10, 12, 56
 * https://leetcode.com/problems/sliding-window-maximum/discuss/65881/O(n)-solution-in-Java-with-two-simple-pass-in-the-array
 *
 *
 * The algorithm is quite straightforward :
 *
 * Iterate along the array in the direction left->right and build an array left.
 *
 * Iterate along the array in the direction right->left and build an array right.
 *
 * Build an output array as max(right[i], left[i + k - 1]) for i in range (0, n - k + 1).
 *
 * Time complexity : O(N), since all we do is 3 passes along the array of length N.
 *
 * Space complexity : O(N) to keep left and right arrays of length N, and output array of length N - k + 1
 */
public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0){
            return new int[]{};
        }
        final int[] max_left = new int[nums.length];
        final int[] max_right = new int[nums.length];

        max_left[0] = nums[0];
        max_right[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            max_left[i] = (i % k == 0) ? nums[i] : Math.max(max_left[i - 1], nums[i]);

            final int j = nums.length - i - 1;
            max_right[j] = (j % k == 0) ? nums[j] : Math.max(max_right[j + 1], nums[j]);
        }

        final int[] sliding_max = new int[nums.length - k + 1];
        for (int i = 0, j = 0; i + k <= nums.length; i++) {
            sliding_max[j++] = Math.max(max_right[i], max_left[i + k - 1]);
        }

        return sliding_max;
    }

    /*
    The straightforward solution is to iterate over all sliding windows and find a maximum for each window.
    There are N - k + 1 sliding windows and there are k elements in each window, that results in a quite bad time complexity \mathcal{O}(N k)O(Nk).
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];

        int [] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++)
                max = Math.max(max, nums[j]);
            output[i] = max;
        }
        return output;
    }
     */

    public static void main(String[] args) {
        int[] ints = new int[]{1,3,-1,-3,5,3,6,7};
        int[] result = maxSlidingWindow(ints,3);
        System.out.println(result);
    }
}
