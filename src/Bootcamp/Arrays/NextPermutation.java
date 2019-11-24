package Bootcamp.Arrays;

/**
 * The steps to solve this problem:
 * 1) scan from right to left, find the first element that is less than its previous one.
 * 4 5 6 3 2 1
 *   |
 *   p
 * 2) scan from right to left, find the first element that is greater than p.
 *
 * 4 5 6 3 2 1
 *     |
 *     q
 * 3) swap p and q
 *
 * 4 5 6 3 2 1
 * swap
 * 4 6 5 3 2 1
 *
 * 4) reverse elements [p+1, nums.length]
 *
 * 4 6 1 2 3 5
 *
 * Time complexity : O(n). In worst case, only two scans of the whole array are needed.
 *
 * Space complexity : O(1). No extra space is used. In place replacements are done.
 */
public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        //find first decreasing digit
        int mark = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                mark = i - 1;
                break;
            }
        }

        // if the numbers are in descending order then no more to permutate.. just reverse the numbert
        if (mark == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int idx = nums.length-1;
        for (int i = nums.length-1; i >= mark+1; i--) {
            if (nums[i] > nums[mark]) {
                idx = i;
                break;
            }
        }

        swap(nums, mark, idx);

        reverse(nums, mark + 1, nums.length - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        nextPermutation(arr);
    }

}
