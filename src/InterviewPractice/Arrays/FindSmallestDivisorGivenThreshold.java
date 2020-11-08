package InterviewPractice.Arrays;

/**
 * 
 */

public class FindSmallestDivisorGivenThreshold {
    public static int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = (int)1e6; //1e6 is 10 power 6 which is 1 million as mentioned in the problem.
        while (left < right) {
            int m = (left + right) / 2, sum = 0;
            for (int i : nums)
                sum += Math.ceil(i/m);
            if (sum > threshold)
                left = m + 1;
            else
                right = m;
        }
        return left;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,5,7,11};
        System.out.println(smallestDivisor(nums,11));
    }
}
