package Bootcamp.Arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The idea here is basically implement a String comparator to decide which String should come first during concatenation.
 * Because when you have 2 numbers (let's convert them into String), you'll face only 2 cases:
 * For example:
 *
 * String s1 = "9";
 * String s2 = "31";
 *
 * String case1 =  s1 + s2; // 931
 * String case2 = s2 + s1; // 319
 *
 * Apparently, case1 is greater than case2 in terms of value.
 * So, we should always put s1 in front of s2.
 *
 * In terms of Time and Space Complexity:
 * Let's assume:
 * the length of input array is n,
 * average length of Strings in s_num is k,
 * Then, compare 2 strings will take O(k).
 * Sorting will take O(nlgn)
 * Appending to StringBuilder takes O(n).
 * So total will be O(nklgnk) + O(n) = O(nklgnk).
 *
 * Space is pretty straight forward: O(n).
 *
 */
public class LargestNumber {

    public static String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return "";
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            list.add(Integer.toString(nums[i]));
        list.sort((s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        StringBuilder sb = new StringBuilder();
        for(String x:list) {
            sb.append(x);
        }
        //remove leading 0
        return sb.toString().replaceFirst("^0+(?!$)", "");
    }

    public static void main(String[] args) {
        int[] ints = new int[]{3,30,34,5,9};
        System.out.println(largestNumber(ints));
    }
}
