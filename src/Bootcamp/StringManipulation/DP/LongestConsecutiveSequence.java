package Bootcamp.StringManipulation.DP;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        int longest = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0;i < nums.length;i++){
            // if there is no duplicates, these two lines can be commented
            if(map.containsKey(nums[i])) continue;
            map.put(nums[i],1);

            int end = nums[i];
            int begin = nums[i];
            if(map.containsKey(nums[i]+1))
                end = nums[i] + map.get(nums[i]+1);
            if(map.containsKey(nums[i]-1))
                begin = nums[i] - map.get(nums[i]-1);
            longest = Math.max(longest, end-begin+1);
            map.put(end, end-begin+1);
            map.put(begin, end-begin+1);
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(ints));
    }
}
