package Bootcamp.StringManipulation.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public static List<List<Integer>> subsetRecurssion(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        recurssion(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public static List<List<Integer>> subsetBacktracking(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    //recurssion
    private static void recurssion(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
        result.add(path);
        for (int i = index; i < nums.length; i++) {
            List<Integer> p = new ArrayList<>(path);
            p.add(nums[i]);
            recurssion(nums, i + 1, p, result);
        }
    }

    // backtracking
    private static void backtrack(List<List<Integer>> result , List<Integer> tempList, int [] nums, int start){
        result.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> result = subsetRecurssion(nums);
        System.out.println(result);
        List<List<Integer>> result2 = subsetBacktracking(nums);
        System.out.println(result2);
    }
}
