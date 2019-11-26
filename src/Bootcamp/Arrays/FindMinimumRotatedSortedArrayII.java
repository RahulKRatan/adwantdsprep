package Bootcamp.Arrays;

/**
 * This is a follow-up problem of finding minimum element in rotated sorted array without duplicate elements.
 * We only need to add one more condition, which checks if the left-most element and the right-most element are equal.
 * If they are we can simply drop one of them. In my solution below, I drop the left element whenever the left-most
 * equals to the right-most.
 */
public class FindMinimumRotatedSortedArrayII {
    public static int findMin(int[] nums) {
        int i=0;
        int j=nums.length-1;

        while(i<=j){

            //handle cases like [3, 1, 3]
            while(nums[i]==nums[j] && i!=j){
                i++;
            }

            if(nums[i]<=nums[j]){
                return nums[i];
            }

            int m=(i+j)/2;
            if(nums[m]>=nums[i]){
                i=m+1;
            }else{
                j=m;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {2,2,2,0,1};
        System.out.println(findMin(nums));
    }
}
