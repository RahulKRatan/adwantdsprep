package InterviewPractice.Arrays;

import java.util.HashMap;

public class ContinuousSubarraySum {

    public static boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum = sum % k; // instead of storing accumulated sum.. we can store remainders
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{23, 2, 4, 6, 7},6));
    }
}
