package Bootcamp.StringManipulation;

public class FindPeakElement {

    static int findPeakElement(int[] nums) {
    int max = nums[0];
    int index = 0;
    for(int i=1;i<nums.length-1;i++){
        if(nums[i] > nums[i-1] && nums[i] > nums[i+1] && nums[i] > max){
            index = i;
            max = nums[i];
        }
    }
    if(nums[nums.length-1] > max){
        index = nums.length-1;
    }

    return index;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1,3,5,6,4};
        int result = findPeakElement(arr);
        System.out.println(result);
    }
}
