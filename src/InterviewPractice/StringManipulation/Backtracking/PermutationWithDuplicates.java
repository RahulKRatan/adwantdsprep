package InterviewPractice.StringManipulation.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=A3ge2mdQi4g&ab_channel=AmellPeralta
 */
public class PermutationWithDuplicates {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums); // sort important when duplicates are involved
        backtrack(list, new ArrayList<>(), nums,new boolean[nums.length]);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums,boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(used[i]) continue;
                //if(i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue; // element already exists, skip
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums,used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
                while (i+1 < nums.length && nums[i] == nums[i+1]){
                    ++i;
                }
            }
        }
    }
/*
The difficulty is to handle the duplicates.
With inputs as [1a, 1b, 2a],
If we don't handle the duplicates, the results would be: [1a, 1b, 2a], [1b, 1a, 2a]...,
so we must make sure 1a goes before 1b to avoid duplicates
By using nums[i-1]==nums[i] && !used[i-1], we can make sure that 1b cannot be choosed before 1a
 */

    public static void main(String[] args) {
        int[] nums = new int[]{3,3,0,3};
        List<List<Integer>> result = permute(nums);
        System.out.println(result);
    }
}
