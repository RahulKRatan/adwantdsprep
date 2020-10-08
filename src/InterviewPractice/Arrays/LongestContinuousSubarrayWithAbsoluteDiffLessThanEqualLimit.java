package InterviewPractice.Arrays;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/discuss/609771/JavaC%2B%2BPython-Deques-O(N)
 *
 * The lazy update using if instead of while is brilliant.
 * Once you reach a new better interval, you just keep the current best interval between i and j and keep sliding,
 * even when it slides to a window that failed the limit requirement. Later, when it slides to a better interval,
 * no pop happens and i won't increase but j will increase and you get a new better interval. Finally, it slides to the end of the input vector, and j - i is exactly the answer we need.
 *
 * Use one tree map can easily get the maximum and the minimum at the same time.
 * In java, we can use TreeMap to count elements.
 * In cpp, it suports multi treeset, that's even better.
 *
 * Time O(NogN)
 * Space O(N)
 *
 * https://www.youtube.com/watch?v=LDFZm4iB7tA&feature=youtu.be&ab_channel=LeadCoding
 *
 */
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanEqualLimit {

    public static int longestSubarray(int[] nums, int limit) {
        int i = 0, j;
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (j = 0; j < nums.length; j++) {
            m.put(nums[j], 1 + m.getOrDefault(nums[j], 0));
            if (m.lastEntry().getKey() - m.firstEntry().getKey() > limit) {
                m.put(nums[i], m.get(nums[i]) - 1);
                if (m.get(nums[i]) == 0)
                    m.remove(nums[i]);
                i++;
            }
        }
        return j - i;
    }

    /*
        O(N) & O(N)
     */
    public static int longestSubarray2(int[] A, int limit) {
        Deque<Integer> maxd = new ArrayDeque<>();
        Deque<Integer> mind = new ArrayDeque<>();
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            while (!maxd.isEmpty() && A[j] > maxd.peekLast()) maxd.pollLast(); // decreasing order of numbers i.e top element is highest
            while (!mind.isEmpty() && A[j] < mind.peekLast()) mind.pollLast(); // increasing order of numbers i.e top element is lowest
            maxd.add(A[j]);
            mind.add(A[j]);
            if (maxd.peek() - mind.peek() > limit) { //similar to what we did in treemap
                if (maxd.peek() == A[i]) maxd.poll();
                if (mind.peek() == A[i]) mind.poll();
                ++i;
            }
        }
        return j - i;
    }


    public static void main(String[] args) {
     int[] nums = new int[]{4,2,2,2,4,4,2,2};
     System.out.println(longestSubarray(nums,0));
     System.out.println(longestSubarray2(nums,0));
    }
}





