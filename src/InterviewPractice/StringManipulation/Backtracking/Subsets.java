package InterviewPractice.StringManipulation.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *  O(2 power n ) and
 *  space is O(N)
 *  https://labuladong.gitbook.io/algo-en/iii.-algorithmic-thinking/subset_permutation_combination
 *  https://github.com/labuladong/fucking-algorithm/blob/english/think_like_computer/DetailsaboutBacktracking.md
 */
public class Subsets {

    public static List<List<Integer>> subsetRecurssion(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recurssion(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public static List<List<Integer>> subsetBacktracking(int[] nums) {
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
    private static void backtrack(List<List<Integer>> result , List<Integer> current, int [] nums, int start){
        result.add(new ArrayList<>(current)); // we need to add a copy of current and not current as it will modify in recursion
        for(int i = start; i < nums.length; i++){
            current.add(nums[i]); //add
            backtrack(result, current, nums, i + 1); //explore
            current.remove(current.size() - 1); // remove - we remove it here as we first include an element and exclude an element to find subsets.
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
       // List<List<Integer>> result = subsetRecurssion(nums);
        //System.out.println(result);
        List<List<Integer>> result2 = subsetBacktracking(nums);
        System.out.println(result2);
    }
}
