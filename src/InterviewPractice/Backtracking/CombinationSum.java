package InterviewPractice.Backtracking;


import java.util.ArrayList;
import java.util.List;

/**
Since we are using backtracking here,
 I think the time complexity would be exponential -> O(2^n)
 Time  O(2^n)
 Space O(2^n)
 */


public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,6,7};
        List<List<Integer>> res = combinationSum(nums,7);
        System.out.println(res);

    }
}
