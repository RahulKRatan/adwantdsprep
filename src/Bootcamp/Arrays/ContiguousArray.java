package Bootcamp.Arrays;

import java.util.HashMap;

public class ContiguousArray {

    public static int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max=0;
        int count=0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count = count - 1;
            }else{
                count = count + 1;
            }

            if(map.containsKey(count)){
                max = Integer.max(max,i-map.get(count));
            }else{
                map.put(count,i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1};
        System.out.println(findMaxLength(nums));
    }

}
