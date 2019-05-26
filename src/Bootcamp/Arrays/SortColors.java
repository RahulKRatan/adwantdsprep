package Bootcamp.Arrays;

public class SortColors {

    public static int[] sortColors(int[] nums) {
        int first = 0;
        int third = nums.length-1;
        for(int i=0;i<=third;i++){
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[first];
                nums[first] = temp;
                first++;
            }else if(nums[i] == 2){
                int temp = nums[i];
                nums[i] = nums[third];
                nums[third] = temp;
                third--;
                i--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,1};
        int[] result = sortColors(nums);
        System.out.println(result);
    }
}
