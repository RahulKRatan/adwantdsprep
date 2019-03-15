package Bootcamp.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckIfSumPossible {

    static boolean check_if_sum_possible(long[] arr, long k) {

        List<List<Long>> list = new ArrayList<>();
        Arrays.sort(arr);
        backtrack(list,new ArrayList<>(), arr, k, 0);
        if(list.isEmpty()) return false;
        return true;

    }
    static void backtrack(List<List<Long>> list,List<Long> tempList,long [] nums, long remain, int start){
        if(remain < 0) return ;
        else if(remain == 0){
            list.add(new ArrayList<>(tempList));
        }
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                if(nums[i]>0) {
                    backtrack(list, tempList, nums, remain - nums[i], i);
                }
                else {
                    backtrack(list, tempList, nums, remain + nums[i], i);
                }
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        long[] arr = new long[]{3,-2,-3,1};
        long k = 4;
        System.out.println(check_if_sum_possible(arr,k));
    }
}
