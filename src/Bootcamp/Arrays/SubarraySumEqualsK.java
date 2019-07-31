package Bootcamp.Arrays;

import java.util.HashMap;

/**
 * Time complexity : O(n). The entire numsnums array is traversed only once.
 *
 * Space complexity : O(n). Hashmap mapmap can contain upto nn distinct entries in the worst case.
 */
public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap< >();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1};
        System.out.println(subarraySum(nums,2));
    }
}
