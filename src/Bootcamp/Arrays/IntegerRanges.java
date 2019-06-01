package Bootcamp.Arrays;

import java.util.ArrayList;
import java.util.List;

public class IntegerRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for(int i = 0, j = 0; j< nums.length; j++){
            if(j+1 < nums.length && nums[j]+1 == nums[j+1]){
                continue;
            }
            if(i==j){
                result.add(nums[i]+"");
            }else {
                result.add(nums[i]+"->"+nums[j]);
            }
            i = j+1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));
    }
}
