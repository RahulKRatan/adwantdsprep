package InterviewPractice.DP;

import java.util.HashMap;

/**
 * We will use HashMap. The key thing is to keep track of the sequence length and store that in the boundary points of the sequence.
 *  For example, as a result, for sequence {1, 2, 3, 4, 5}, map.get(1) and map.get(5) should both return 5.
 *
 * Whenever a new element n is inserted into the map, do two things:
 *
 * See if n - 1 and n + 1 exist in the map, and if so, it means there is an existing sequence next to n.
 * Variables left and right will be the length of those two sequences, while 0 means there is no sequence and n will be the boundary point later.
 * Store (left + right + 1) as the associated value to key n into the map.
 * Use left and right to locate the other end of the sequences to the left and right of n respectively, and replace the value with the new length.
 * Everything inside the for loop is O(1) so the total time is O(n).
 *  "1" -> "4"
 *  "2" -> "4"
 *  "3" -> "2"
 *  "100" -> "1"
 *  "4" -> "4"
 *  "200" -> "1"
 */
public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = (map.getOrDefault(n - 1,0));
                int right = (map.getOrDefault(n + 1,0));
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length
                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(ints));
    }
}
