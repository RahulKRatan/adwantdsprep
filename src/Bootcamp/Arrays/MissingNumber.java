package Bootcamp.Arrays;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {

    // Time complexity : O(n) and Space complexity : O(n)
    public static int missingNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) numSet.add(num);

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }
    // Time complexity : O(n) and Space complexity : O(1) - Nice one
    public static int missingNumberGaussFormula(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{0,1};
        System.out.println(missingNumber(ints));
        System.out.println(missingNumberGaussFormula(ints));
    }
}
