package Bootcamp.Arrays;

import java.util.Arrays;

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

   // ** Moore voting algorithm
   public static int majorityElement2(int[] num) {

       int major=num[0], count = 1;
       for(int i=1; i<num.length;i++){
           if(count==0){
               count++;
               major=num[i];
           }else if(major==num[i]){
               count++;
           }else count--;

       }
       return major;
   }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement2(nums));
    }
}
