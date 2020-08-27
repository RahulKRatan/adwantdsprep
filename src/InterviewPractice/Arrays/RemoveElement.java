package InterviewPractice.Arrays;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int i=0;
        int j=0;
        while(j<nums.length){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums,3));
    }
}
