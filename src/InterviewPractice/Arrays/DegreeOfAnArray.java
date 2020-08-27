package InterviewPractice.Arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * An array that has degree d, must have some element x occur d times. If some subarray has the same degree, then some element x (that occured d times),
 * still occurs d times. The shortest such subarray would be from the first occurrence of x until the last occurrence.
 *
 * For each element in the given array, let's know left, the index of its first occurrence; and right, the index of its last occurrence.
 * For example, with nums = [1,2,3,2,5] we have left[2] = 1 and right[2] = 3.
 *
 * Then, for each element x that occurs the maximum number of times, right[x] - left[x] + 1 will be our candidate answer, and we'll take the minimum of those candidates.
 *
 * Time Complexity: O(N), where N is the length of nums. Every loop is through O(N) items with O(1) work inside the for-block.
 *
 * Space Complexity: O(N), the space used by left, right, and count.
 */
public class DegreeOfAnArray {

    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>(), // has the first index of an integer
                right = new HashMap<>(), // has the last index of an integer
                count = new HashMap<>(); // has the count/degree of each integer useful to check maximum degree

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (left.get(x) == null) left.put(x, i);
            right.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int ans = nums.length;
        int degree = Collections.max(count.values());
        for (int x: count.keySet()) {
            if (count.get(x) == degree) {
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 1};
        System.out.println(findShortestSubArray(nums));
    }
}
