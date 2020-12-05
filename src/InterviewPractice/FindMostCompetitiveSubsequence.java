package InterviewPractice;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Mono increasing stack - concept
 * **nums.length - i + stack.size() > k
 * Complexity
 * Time O(n)
 * Space O(k)
 *
 * More Good Stack Problems
 * Here are some problems that impressed me.
 * Good luck and have fun.
 *
 * Find the Most Competitive Subsequence
 * Constrained Subsequence Sum
 * Minimum Cost Tree From Leaf Values
 * Sum of Subarray Minimums
 * Online Stock Span
 * Score of Parentheses
 * Next Greater Element II
 * Next Greater Element I
 * Largest Rectangle in Histogram
 * Trapping Rain Water
 */
public class FindMostCompetitiveSubsequence {

    public static int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> stack = new LinkedList<>();
        int[] result = new int[k];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()] && nums.length - i + stack.size() > k) { //**nums.length - i + stack.size() > k -> if remaining element count + stack size is more than k then we can pop from the stack
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(i);
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = nums[stack.pop()];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,5,2,6};
        System.out.println(mostCompetitive(nums,2));
    }
}

