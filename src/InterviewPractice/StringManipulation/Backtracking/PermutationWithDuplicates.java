package InterviewPractice.StringManipulation.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue; // element already exists, skip
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums,used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3,3,0,3};
        List<List<Integer>> result = permute(nums);
        System.out.println(result);
    }
}
