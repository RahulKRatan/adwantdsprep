package Bootcamp.Arrays;

public class SortColors {

    public static int[] sortColors(int[] nums) {
        int first = 0;
        int third = nums.length-1;
        for(int i=0;i<third;i++){
            
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        int[] result = sortColors(nums);
        System.out.println(result);
    }
}
