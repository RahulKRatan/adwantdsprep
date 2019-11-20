package Bootcamp.Arrays;

import java.util.ArrayList;
import java.util.List;


/**
 * Find the range between lower and first element in the array.
 * Find ranges between adjacent elements in the array.
 * Find the range between upper and last element in the array.
 */
public class MissingRanges {

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0){
            result.add(formRange(lower,upper));
            return result;
        }

        // 1st step
        if (nums[0] > lower){
            result.add(formRange(lower,nums[0]-1));
        }

        // 2nd step
        for (int i = 0; i < nums.length-1; i++){
            if (nums[i+1] != nums[i] && nums[i+1] > nums[i] +1) {
                result.add(formRange(nums[i]+1, nums[i+1]-1));
            }
        }

        // 3rd step
        if (nums[nums.length-1] < upper){
            result.add(formRange(nums[nums.length-1]+1, upper));
        }
        return result;
    }

    public static String formRange(int low, int high){
        return low == high ? String.valueOf(low) : (low + "->" + high);
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 3, 50, 75};
        System.out.println(findMissingRanges(nums,0,99));
    }
}
