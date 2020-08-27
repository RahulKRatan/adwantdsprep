package InterviewPractice.Arrays;

/**
 Time complexity : log(n)

 Space complexity : O(1)

 All work is done in place, so the overall memory usage is constant.
 */

public class FindFirstLastPositionofElementSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        int start = findPosition(nums, target, false);
        int end = findPosition(nums, target, true);// to check if this is the last index we are looking for
        return new int[]{start, end};
    }
    private static int findPosition(int[] A, int target, boolean right) {
        int start = 0, end = A.length-1, index = -1;
        while (start <= end) {
            int mid = (start + end)/2;
            if(right){
                if (A[mid] <= target) start = mid + 1; // = is important as it goes till last element
                else end = mid-1;
            } else{
                if (A[mid] < target) start = mid + 1;
                else end = mid-1;
            }
            if(A[mid] == target) index = mid; /** update index */
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int[] result = searchRange(nums,8);
        for (int res: result) {
            System.out.println(res);
        }
    }
}
