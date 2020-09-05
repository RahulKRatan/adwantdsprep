package InterviewPractice.DP;

/**
 * https://www.youtube.com/watch?v=86CQq3pKSUw&ab_channel=CSDojo
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class MaximumSubarray {

    public static int maxSubArray(int[] array) {
        int currentMax = Integer.MIN_VALUE;
        int totalMax =  Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++){
            currentMax = Math.max(currentMax, 0) + array[i];
            totalMax = Math.max(totalMax, currentMax);
        }
        return totalMax;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
