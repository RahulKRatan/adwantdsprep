package Bootcamp.Arrays;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int pos = 0;
        for(int num: nums){
            if(num !=0){
                nums[pos++] = num;
            }
        }
        while (pos < nums.length){
            nums[pos++] = 0;
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
    }

}
